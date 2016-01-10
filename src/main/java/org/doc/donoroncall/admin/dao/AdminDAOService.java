package org.doc.donoroncall.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.doc.core.api.registration.info.RegistrationInfo;
import org.doc.core.util.db.ConnectionProvider;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminDAOService extends ConnectionProvider implements AdminDAOHandler{
		
	@Override
	public List<RegistrationInfo> getRegUserList() {
		RegistrationInfo regInfo;
		List<RegistrationInfo> regList = new ArrayList<RegistrationInfo>();
		String query = "select * from doc.user";
		ResultSet rs = getResult(query);
		try {
			while(rs.next()){			
				regInfo = new RegistrationInfo();
				regInfo.setName(rs.getString("username"));
				regInfo.setPassWord(rs.getString("password"));
				regInfo.setName(rs.getString("name"));
				regInfo.setBloodGroup(rs.getString("blood_group"));
				regInfo.setType(rs.getString("type"));
				regInfo.setDob(rs.getDate("dob").toString());
				regInfo.setAuthorized(rs.getString("authorized"));
				regList.add(regInfo);					
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regList;
	}

	@Override
	public String authorizeUser(String userName) {
		String query = "update user set authorized='yes' where username= ?";
		Connection con = getConnection();
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, userName);
			int retval = executeUpdate(st);
		    if(retval>0){
		    	String userQuery = "select * from doc.user where username= ?";
		    	PreparedStatement st1 = con.prepareStatement(userQuery);
				st1.setString(1, userName);
		    	ResultSet rs1 = getResult(st1);
		    	if(rs1!=null){
			    	String passWord="";
			    	System.out.println("Password ........   "+passWord);			    	
					try {
						while(rs1.next()){
							passWord = rs1.getString("password");
						}
						System.out.println("Password ........   "+passWord);
				    	if(passWord!=null){
				    		System.out.println("Password ........   Internal  ......   "+passWord);
				    		String loginQuery = "insert into doc.login_auth (`username`,`password`) VALUES (?,?)";
						    PreparedStatement st2 = con.prepareStatement(loginQuery);
						    st2.setString(1, userName);
						    st2.setString(2, passWord);
						    retval = executeUpdate(st2);
						    if(retval>0){
						    	return "success";
						    }else{
						    	return "fail";
						    }
				    	}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			    	
		    	}else{
		    		return "fail";
		    	}
		    }else{
		    	return "fail";
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String acceptRequest(String userName) {
		String query = "update doc.donor set verified='yes' where user_name= ?";
		Connection con = getConnection();
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, userName);
			int retval = executeUpdate(st);
		    if(retval==1){		    	
		    	return "success";
		    }else{
		    	return "fail";
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

}

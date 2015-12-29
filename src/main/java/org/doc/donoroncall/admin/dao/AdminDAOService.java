package org.doc.donoroncall.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.doc.core.api.registration.info.RegistrationInfo;
import org.doc.core.util.DocMailingProcessor;
import org.doc.core.util.db.ConnectionProvider;
import org.springframework.stereotype.Service;

@Service
public class AdminDAOService extends ConnectionProvider implements AdminDAOHandler{
		
	@Override
	public List<RegistrationInfo> getRegUserList() {
		RegistrationInfo regInfo;
		List<RegistrationInfo> regList = new ArrayList<RegistrationInfo>();
		String query = "select * from user";
		ResultSet rs = getResult(query);
		while(rs!=null){
			try {
				regInfo = new RegistrationInfo();
				regInfo.setName(rs.getString("username"));
				regInfo.setPassWord(rs.getString("password"));
				regInfo.setName(rs.getString("name"));
				regInfo.setBloodGroup(rs.getNString("blood_group"));
				regInfo.setType(rs.getString("type"));
				regInfo.setDob(rs.getNString("dob"));
				regInfo.setAuthorized(rs.getString("authorized"));
				regList.add(regInfo);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		    if(retval==1){		    	
		    	return "success";
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
		return null;
	}

	@Override
	public String acceptRequest(String userName) {
		String query = "update user set verified='yes' where username= ?";
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
		return null;
	}

}

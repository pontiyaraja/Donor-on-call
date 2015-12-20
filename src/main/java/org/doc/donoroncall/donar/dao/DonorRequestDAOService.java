/**
 * 
 */
package org.doc.donoroncall.donar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.doc.core.util.db.ConnectionProvider;
import org.doc.donoroncall.donar.DonorRequesterInfo;
import org.springframework.stereotype.Service;

/**
 * @author pandiyaraja
 * 
 */
@Service
public class DonorRequestDAOService extends ConnectionProvider implements DonorRequestDAOHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.doc.donoroncall.donar.dao.BloodRequestDAOHandler#requestBloodDao(
	 * org.doc.donoroncall.donar.BloodRequesterInfo)
	 */
	@Override
	public String donorRequestDao(DonorRequesterInfo drInfo) {
		int retval=0;
		try {
			String query = "INSERT INTO doc.donor (" + "`user_name`,"    + "`blood_group`,"    + "`hospital_name`,"    + "`physician_name`,"    + "`patient`,"    + "`purpose`,"    + "unit," +"how_soon," +"`verified` ) VALUES ("
				    + "?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection con = getConnection();
		    PreparedStatement st = con.prepareStatement(query);
		    st.setString(1, drInfo.getUserName());
		    st.setString(2, drInfo.getBloodGroup());
		    st.setString(3, drInfo.getHospitalName());
		    st.setString(4, drInfo.getPhysicianName());
		    st.setString(5, drInfo.getPatient());
		    st.setString(6, drInfo.getPurpose());
		    st.setInt(7, drInfo.getUnit());
		    st.setInt(8, drInfo.getHowSoon());
		    st.setString(9, "no");
		    
		    retval = insertData(st);
		    con.close();
		    st.close();
		    if(retval==1){
		    	return "success";
		    }else{
		    	return "fail";
		    }
		  } 
		  catch (Exception se)
		  {
		    se.printStackTrace();
		    return "fail";
		  }
	}

}

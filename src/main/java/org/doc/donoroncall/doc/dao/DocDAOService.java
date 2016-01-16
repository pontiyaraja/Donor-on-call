/**
 * 
 */
package org.doc.donoroncall.doc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.doc.core.util.db.ConnectionProvider;
import org.doc.donoroncall.doc.info.DocDonorInfo;
import org.springframework.stereotype.Service;

/**
 * @author Pandiyaraja
 *
 */
@Service
public class DocDAOService extends ConnectionProvider implements DocDAOHandler{

	@Override
	public List<DocDonorInfo> getAllDonors() {

		DocDonorInfo dInfo;
		List<DocDonorInfo> donorsList = new ArrayList<DocDonorInfo>();
		String query = "select * from doc.donor";
		ResultSet rs = getResult(query);
		try {
			while(rs.next()){			
				dInfo = new DocDonorInfo();
				dInfo.setUserName(rs.getString("user_name"));
				dInfo.setLocation(rs.getString("location"));
				dInfo.setLastDonatedDate(rs.getString("lastdonated_date"));
				dInfo.setBloodGroup(rs.getString("blood_group"));				
				donorsList.add(dInfo);					
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donorsList;
	}

	@Override
	public List<DocDonorInfo> getDonorsforRecipient(DocDonorInfo dDInfo) {
		DocDonorInfo dInfo;
		List<DocDonorInfo> donorsList = new ArrayList<DocDonorInfo>();
		String query = "select * from doc.donor where location = ? AND blood_group = ?";
		Connection con = getConnection();		 
		ResultSet rs = getResult(query);
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, dDInfo.getLocation());
			st.setString(2, dDInfo.getLocation());
			getResult(st);
			while(rs.next()){			
				dInfo = new DocDonorInfo();
				dInfo.setUserName(rs.getString("user_name"));
				dInfo.setLocation(rs.getString("location"));
				dInfo.setLastDonatedDate(rs.getString("lastdonated_date"));
				dInfo.setBloodGroup(rs.getString("blood_group"));				
				donorsList.add(dInfo);					
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donorsList;
	}

}

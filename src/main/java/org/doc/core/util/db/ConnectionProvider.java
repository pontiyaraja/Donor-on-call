/**
 * 
 */
package org.doc.core.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.doc.core.util.Constants.*;

/**
 * @author pandiyaraja
 *
 */
public class ConnectionProvider {
	public synchronized Connection getConnection(){
		Connection con=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sonoo","root","root"); 
		}catch(Exception e){ 
			 e.printStackTrace();
		}
		return con;
	}
	public synchronized ResultSet getResult(String query){
		Connection conn = getConnection();
		if(conn!=null){
			Statement stmt=null;
			try {
				stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				if(rs!=null){
					return rs;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				if(stmt!=null){
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}

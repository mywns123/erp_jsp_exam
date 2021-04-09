package erp_jsp_exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilTest {

	public static Connection getConnection() {		
		Connection con = null;
		try{
			String url = "jdbc:mysql://localhost:3306/erp_jsp_exam?useSSL=false";
			String id="ERP_JSP_EXAM";
			String password = "rootroot";				
			con = DriverManager.getConnection(url,id,password);
		}catch (SQLException e) {
			e.printStackTrace();
		}			
		return con;
	}
}

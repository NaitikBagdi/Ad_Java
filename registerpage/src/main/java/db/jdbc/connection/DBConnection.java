package db.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/loginpage"; 
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	public static Connection getConnection() {
		Connection con=null;
		
		//Driver Load
		try {
			Class.forName(jdbcDriver);
			 con = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		} catch (ClassNotFoundException | SQLException s) {
			s.printStackTrace();
			
		}
		return con;
		
	}

}

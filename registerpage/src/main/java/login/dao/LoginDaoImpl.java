package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.jdbc.connection.DBConnection;
import registerpage.dto.UserRegistrationDTO;

public class LoginDaoImpl implements LoginDao{

	public boolean validate(UserRegistrationDTO urd) {
		boolean result= false;
		
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * from registration where fname=? and password=?");
			
			ps.setString(1, urd.getFname());
			ps.setString(2, urd.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			result = rs.next();
		} catch (SQLException e) {
			e.getMessage();
		}
		return result;
		
	}
}

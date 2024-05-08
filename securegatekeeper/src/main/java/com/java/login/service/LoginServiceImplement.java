package com.java.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.registration.model.RegistrationDto;
import com.java.util.DataBaseConnection;

public class LoginServiceImplement implements LoginService {

	@Override
	public boolean vaildation(RegistrationDto registration) {
		boolean result = false;
		String sqlQuery = "SELECT username, password FROM registration where username = ? AND password = ? ";
		try {
			Connection con = DataBaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, registration.getUserName());
			ps.setString(2, registration.getPassword());
			ResultSet rs = ps.executeQuery();
			result = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
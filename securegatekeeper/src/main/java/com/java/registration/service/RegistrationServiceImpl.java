package com.java.registration.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.registration.model.RegistrationDto;
import com.java.util.DataBaseConnection;

public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public int saveRegistration(RegistrationDto registration) {
		int record = 0;
		Connection con = DataBaseConnection.getConnection();
		String insertQuery = "INSERT INTO registration (username, email, password, confirm_password) value(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, registration.getUserName());
			ps.setString(2, registration.getEmail());
			ps.setString(3, registration.getPassword());
			ps.setString(4, registration.getConfirmPassword());
			record = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
}
package registerpage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.jdbc.connection.DBConnection;
import registerpage.dto.UserRegistrationDTO;

public class RegistrationDaoImpl implements RegistrationDAO {

	@Override
	public int saveRegistration(UserRegistrationDTO urt) {
		Connection con = DBConnection.getConnection();

		int i = 0;
		try {
			PreparedStatement prs = con.prepareStatement(
					"insert into registration(`fname` , `lname` , `email` ,`password` , `gender` ,`city` , `comment`)"
							+ " values(?,?,?,?,?,?,?)");
			prs.setString(1, urt.getFname());
			prs.setString(2, urt.getLname());
			prs.setString(3, urt.getEmail());
			prs.setString(4, urt.getPassword());
			prs.setString(5, urt.getGender());
			prs.setString(6, urt.getCity());
			prs.setString(7, urt.getComment());

			i = prs.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception Occurse : " + e.getMessage());
		}

		return i;
	}

	@Override
	public int editRegistration(long rid) {
		int count = 0;

		return count;
	}

	@Override
	public int deleteRegistration(long rid) {

		return 0;
	}

	@Override
	public List<UserRegistrationDTO> getAllRegistration() {

		List<UserRegistrationDTO> listdto = new ArrayList<UserRegistrationDTO>();

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select registration_id,fname,lname,email,password,email,gender,city,comment from registration");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserRegistrationDTO urd = new UserRegistrationDTO();
				urd.setId(rs.getInt("registration_id"));
				urd.setFname(rs.getString("fname"));
				urd.setLname(rs.getString("lname"));
				urd.setEmail(rs.getString("email"));
				urd.setPassword(rs.getString("password"));
				urd.setEmail(rs.getString("email"));
				urd.setGender(rs.getString("gender"));
				urd.setCity(rs.getString("city"));
				urd.setComment(rs.getString("comment"));

				listdto.add(urd);
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		return listdto;
	}

	@Override
	public UserRegistrationDTO getRegistration(long rid) {

		return null;
	}

}

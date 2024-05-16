package service.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.Empty;

import model.Employee;
import service.EmployeeService;
import util.DataBaseConnection;

public class EmployeeServiceImpl extends HttpServlet implements EmployeeService {

	private static final long serialVersionUID = 1L;
	Connection connnection = DataBaseConnection.getConnection();
	RequestDispatcher rd;
	private String query;

	@Override
	public void userRegistraion(HttpServletRequest request, HttpServletResponse response, Employee employee) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String contactNumber = request.getParameter("contactnumber");
		String address = request.getParameter("address");

		boolean isNull = (firstName == null || lastName == null || userName == null || password == null
				|| contactNumber == null || address == null);

		// Set values in the employee object
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUserName(userName);
		employee.setPassword(password);
		employee.setContactNumber(contactNumber);
		employee.setAddress(address);
		PrintWriter out = null;
		try {
			boolean value = checkUserExist(employee) || checkPhoneNumberExist(employee);
			System.out.println(value);
			if (value) {
				response.setContentType("text/html");
				out = response.getWriter();
				System.out.println("check user and password");
				out.print("exist");
				return;
			}
			if (!isNull) {
				try {
					if (saveRegistraion(employee) == 1) {
						out = response.getWriter();
						System.out.println("saveRegistraion method");
						out.print("success");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkPhoneNumberExist(Employee employee) {
		boolean result = false;
		query = "Select contact_number from employee_registration where contact_number = ?";
		try {
			PreparedStatement ps = connnection.prepareStatement(query);
			ps.setString(1, employee.getContactNumber());
			ResultSet rs = ps.executeQuery();
			result = rs.next();
			System.out.println("Phone number return:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean checkUserExist(Employee employee) {
		boolean result = false;
		query = "Select username from employee_registration where username = ?";
		try {
			PreparedStatement ps = connnection.prepareStatement(query);
			ps.setString(1, employee.getUserName());
			ResultSet rs = ps.executeQuery();
			result = rs.next();
			System.out.println("Username return:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int saveRegistraion(Employee employee) {
		int result = 0;
		query = "Insert into employee_registration (first_name, last_name, username, password, contact_number, address)"
				+ " value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connnection.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getUserName());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getContactNumber());
			ps.setString(6, employee.getAddress());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<Employee> registrationList(HttpServletRequest request, HttpServletResponse response) {
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("registration List");
		query = "Select * from employee_registration";
		try {
			PreparedStatement ps = connnection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setUserName(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setContactNumber(rs.getString("contact_number"));
				employee.setAddress(rs.getString("address"));
				list.add(employee);
			}
			request.setAttribute("employeeList", list);
			// Forward the request to the JSP file
			System.out.println("upper dispatcher");
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrationlist.jsp");
			dispatcher.forward(request, response);
			System.out.println("lower dispatcher");
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}


}
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
		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setUserName(request.getParameter("userName"));
		employee.setPassword(request.getParameter("password"));
		employee.setContactNumber(request.getParameter("contactNumber"));
		employee.setAddress(request.getParameter("address"));
		try {
			if (checkPhoneNumberExist(employee)) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:red'>PhoneNumber is alredy exist Try another username</h3>");
				System.out.println("PhoneNumber is alredy exist Try another username");
				rd = request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
			} else if (checkUserExist(employee)) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:red'>User name is alredy exist Try another username</h3>");
				System.out.println("User name is alredy exist Try another username");
				rd = request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
			} else if (saveRegistraion(employee) == 1) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:green'>Registration successful</h3>");
				System.out.println("Registration successful");
				registrationList(request, response);
			}
		} catch (IOException | ServletException e) {
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
			System.out.println(result);
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
			System.out.println(result);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrationlist.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;
import service.serviceImpl.EmployeeServiceImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee employee = new Employee();
	EmployeeService service = new EmployeeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("registration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		service.userRegistraionValidation(request, response, employee);
		service.userRegistraion(request, response, employee);
		/*
		 * System.out.println("dopost"); PrintWriter out = response.getWriter(); String
		 * username = request.getParameter("username"); System.out.println(username);
		 * try { if (username.equals("admin")) { out.print("exist"); } } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}

}

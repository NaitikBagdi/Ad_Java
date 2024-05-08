package com.java.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.login.service.LoginService;
import com.java.login.service.LoginServiceImplement;
import com.java.registration.model.RegistrationDto;
import com.java.registration.service.RegistrationService;
import com.java.registration.service.RegistrationServiceImpl;

@WebServlet("/register")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	LoginService loginService = new LoginServiceImplement();
	RegistrationService registrationService = new RegistrationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("register.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			PrintWriter out = resp.getWriter();
			HttpSession session = req.getSession();
		try {
			RegistrationDto registration = new RegistrationDto();
			registration.setUserName(req.getParameter("username"));
			registration.setEmail(req.getParameter("email"));
			registration.setPassword(req.getParameter("password"));
			registration.setConfirmPassword(req.getParameter("confirmPassword"));

			if (loginService.vaildation(registration)) {
				System.out.println("aaa");
				session.setAttribute("errorMessage", "The username already exists. Please try another username.");
				resp.sendRedirect("register.jsp");
				return;
			}

			int result = registrationService.saveRegistration(registration);
			if (result == 1) {
				out.print("Successful");
				resp.sendRedirect("login.jsp");
			} else {
				out.print("unsuccessful");
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

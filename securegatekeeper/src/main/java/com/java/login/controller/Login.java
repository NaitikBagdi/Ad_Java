package com.java.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.login.service.LoginService;
import com.java.login.service.LoginServiceImplement;
import com.java.registration.model.RegistrationDto;
import com.java.util.DataBaseConnection;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService login = new LoginServiceImplement();

		RegistrationDto registration = new RegistrationDto();

		PrintWriter out = response.getWriter();

		registration.setUserName(request.getParameter("username"));
		registration.setPassword(request.getParameter("password"));

		if (login.vaildation(registration) ) {
			HttpSession session  = request.getSession();
			session.setAttribute("username", registration.getUserName());
			session.setMaxInactiveInterval(30 * 60);

			Cookie userCookie = new Cookie("username", registration.getUserName());
			userCookie.setMaxAge(30 * 60);
			response.addCookie(userCookie);
			System.out.println("validation sucessful");
			request.getRequestDispatcher("list.jsp").forward(request, response);;
		} else {
			response.setContentType("text/html");
			out.print("<h3 align = center style='color:Red'> Username and password don't match try again!</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
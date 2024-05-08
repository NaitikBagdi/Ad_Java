package login.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.service.LoginService;
import login.service.LoginServiceImpl;
import registerpage.dto.UserRegistrationDTO;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = 9137388263816915368L;
	LoginService loginService = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		authenicate(req, resp);
	}

	private void authenicate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRegistrationDTO urd = new UserRegistrationDTO();

		urd.setFname(req.getParameter("fname"));
		urd.setPassword(req.getParameter("password"));

		if (loginService.validate(urd)) {

			HttpSession session  = req.getSession();
			session.setAttribute("fname", urd.getFname());
			session.setMaxInactiveInterval(30 * 60);
			
			Cookie userCookie = new Cookie("fname", urd.getFname());
			userCookie.setMaxAge(30 * 60);
			resp.addCookie(userCookie);
			
			resp.sendRedirect("todo");
		}else {
			req.setAttribute("INVALID", "Invalid Username and Password ");
			RequestDispatcher rd =  req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
			rd.forward(req, resp);
		}
	}

}

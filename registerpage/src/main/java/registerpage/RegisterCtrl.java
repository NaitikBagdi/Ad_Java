package registerpage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.service.LoginService;
import login.service.LoginServiceImpl;
import registerpage.dto.UserRegistrationDTO;
import registerpage.service.RegistrationService;
import registerpage.service.RegistrationServiceImpl;

@WebServlet("/register")
public class RegisterCtrl extends HttpServlet {

	private static final long serialVersionUID = -4125976332257771094L;

	private RegistrationService rs = new RegistrationServiceImpl();
	private LoginService loginservice = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("register.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd;
		int i = saveRegistration(req ,resp);
		if (i > 0) {
			req.setAttribute("Successfull", "Registration Successfull");
			rd = req.getRequestDispatcher("register.jsp");
		} else {
			req.setAttribute("INVALID", "Registration UnSuccessfull Try Again!!");
			rd = req.getRequestDispatcher("register.jsp");
		}
		rd.forward(req, resp);

	}

	private int saveRegistration(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

		UserRegistrationDTO urt = new UserRegistrationDTO();

		urt.setFname(req.getParameter("fname"));
		urt.setLname(req.getParameter("lname"));
		urt.setEmail(req.getParameter("email"));
		urt.setPassword(req.getParameter("password"));
		urt.setGender(req.getParameter("gender"));
		urt.setCity(req.getParameter("city"));
		urt.setComment(req.getParameter("comment"));
		
		if(loginservice.validate(urt)) {
			req.setAttribute("registervalidate", "This Name of user are exicst try another username and password .....!! ");
			RequestDispatcher rd=  req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}
		 
		/*
		 * String username = req.getParameter("name"); String email =
		 * req.getParameter("email"); String password = req.getParameter("password");
		 * String gender = req.getParameter("gender"); String city =
		 * req.getParameter("city"); String comment = req.getParameter("comment");
		 */

		return rs.saveRegistration(urt);

	}

	/*
	 * private List<UserRegistrationDTO> getAllRegistration(HttpServletRequest req,
	 * HttpServletResponse resp) throws ServletException, IOException {
	 * 
	 * return rs.getAllRegistration();
	 * 
	 * }
	 */

}

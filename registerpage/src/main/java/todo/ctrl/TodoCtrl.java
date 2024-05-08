package todo.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registerpage.dto.UserRegistrationDTO;
import registerpage.service.RegistrationService;
import registerpage.service.RegistrationServiceImpl;

@WebServlet("/")
public class TodoCtrl extends HttpServlet {

	private static final long serialVersionUID = 4966540027970148074L;

	private RegistrationService rs = new RegistrationServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		if (req.getSession(false) != null) {

			switch (action) {

			case "/todo":
				ListTodo(req, resp);
				break;
			
			case "/delete":
			
			break;
			
			case "/update":
			
			break;
			}
		}

	private void ListTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserRegistrationDTO> listurd = rs.getAllRegistration();
		request.setAttribute("registrationList", listurd);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	
	private int 
}

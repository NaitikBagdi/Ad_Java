package practise_crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import practise_crud.model.User;
import practise_crud.service.UserServie;

@Controller
public class UserController {

	@Autowired
	private UserServie userServie;

	@RequestMapping("/")
	public String home(Model model) {
		List<User> userList = userServie.getList();
		model.addAttribute("users", userList);
		return "index";
	}

	@RequestMapping(value = "/handle-user", method = RequestMethod.POST)
	public RedirectView handleUser(@ModelAttribute User user, HttpServletRequest request) {
		System.out.println(user);
		userServie.saveUser(user);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/save-user")
	public String saveCustomer(Model model) {
		model.addAttribute("title", "Add product");
		return "add_user";
	}

}

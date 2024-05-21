package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Student;
import service.StudentService;

@Controller
public class SpringController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/form")
    public String showForm() {
        return "index";
    }

	@RequestMapping("/add")
    public String addStudent(@RequestParam("name") String name, 
            				  @RequestParam("address") String address, 
            				  @RequestParam("pincode") int pincode,
            				  Model model) {
		Student student = new Student(name, address, pincode);
        studentService.saveStudent(student);
        model.addAttribute("student", student);

        return "result";
    }
}

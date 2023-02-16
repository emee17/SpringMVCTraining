package com.codejango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejango.model.Student;
import com.codejango.studentservice.StudentService;

@Controller
@RequestMapping("/student")//http://localhost:8080/SpringMVCTraining/student
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("")
	public ModelAndView saveStudent(@ModelAttribute("student") Student student, ModelAndView mv) {
		
		studentService.save(student);
		
		
		mv.setViewName("home.jsp");
		
		return mv;
	}

}

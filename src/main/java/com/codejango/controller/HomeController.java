package com.codejango.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejango.model.Student;
import com.codejango.studentservice.StudentService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//http://localhost:8080/
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public ModelAndView home(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		List<Student> studentList = studentService.findAll();
		
		mv.addObject("studentList", studentList);
		
		mv.setViewName("home.jsp");
		
		return mv;
	}
	
	
	@GetMapping("login")
	public ModelAndView login(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	@GetMapping("register")
	public ModelAndView registerPage(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("register.jsp");
		
		return mv;
	}
	
	
	
	
	
	
	

}

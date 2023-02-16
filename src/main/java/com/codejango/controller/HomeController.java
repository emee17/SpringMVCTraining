package com.codejango.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejango.model.Student;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//http://localhost:8080/
	
	
	@GetMapping("")
	public ModelAndView home(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home.jsp");
		
		Student student = new Student();
		student.setId(1);
		student.setAge(25);
		student.setName("Bruce");
		
		mv.addObject("message", "Welcome to the Home");
		mv.addObject("student", student);
		
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

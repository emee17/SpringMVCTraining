package com.codejango.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//http://localhost:8080/
	
	
	@GetMapping("")
	public ModelAndView home(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home.jsp");
		mv.addObject("message", "Welcome to the Home");
		
		return mv;
	}
	
	
	@GetMapping("login")
	public ModelAndView login(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	
	
	
	

}

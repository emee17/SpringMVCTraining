package com.codejango.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codejango.model.Student;
import com.codejango.studentservice.StudentService;

@Controller
@RequestMapping("")
public class HomeController {
	
	//http://localhost:8080/
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public ModelAndView home(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		List<Student> studentList = studentService.findAll();
		
		mv.addObject("studentList", studentList);
		
		mv.setViewName("home.jsp");
		
		return mv;
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView registerPage(ModelAndView mv,
			HttpServletRequest request) {
		
		//ModelAndView mv = new ModelAndView();
//		final String loggedInUser = (String) request.getAttribute("loggedInUser");
//		if(loggedInUser == null) {
//			mv.addObject("error_message","Please login to continue");
//			mv.setViewName("login.jsp");
//			return mv;
//		}
//		
		mv.addObject("student", new Student());
		mv.setViewName("register.jsp");
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editPage(@PathVariable int id, ModelAndView mv,
			HttpServletRequest request) {
		
		//ModelAndView mv = new ModelAndView();
//		final String loggedInUser = (String) request.getAttribute("loggedInUser");
//		if(loggedInUser == null) {
//			mv.addObject("error_message","Please login to continue");
//			mv.setViewName("/login.jsp");
//			return mv;
//		}
		
		Student student = studentService.findByID(id);
		
		mv.addObject("student", student);
		mv.setViewName("/register.jsp");
		
		return mv;
	}
	
	@PostMapping("/logintoapp")
	public String loginToApp(@ModelAttribute("student") Student student, Model mv) {
		
		
		boolean isPresent = studentService.findByEmailAndPassword(student);
		
		if(!isPresent) {
//			mv.addObject("error_message","username or password is incorrect");
//			mv.setViewName("/login.jsp");
//			return mv;
			
			mv.addAttribute("error_message","username or password is incorrect");
			
			return "/login.jsp";
		}else {
			
			//return "/home.jsp";
			//mv.setViewName("/home.jsp");
			//return mv;
			
			List<Student> studentList = studentService.findAll();
			
			mv.addAttribute("studentList", studentList);
			
			return "/home.jsp";
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/login")
//	public ModelAndView authenticate(@ModelAttribute("student") Student student, 
//			ModelAndView mv,
//			HttpServletRequest request) {
//		
//		//ModelAndView mv = new ModelAndView();
//		
//		boolean validated = studentService.findByEmailAndPassword(student);
//		if(!validated) {
//			
//			mv.addObject("error_message","username or password is incorrect");
//			mv.setViewName("login.jsp");
//			return mv;
//		}
//		
//		System.out.println("login post");
//		request.setAttribute("loggedInUser", student.getEmail());
//
//		List<Student> studentList = studentService.findAll();
//		
//		mv.addObject("studentList", studentList);
//		
//		mv.setViewName("/home.jsp");
//		
//		return mv;
//	}
	
	
	
	
	
	
	

}

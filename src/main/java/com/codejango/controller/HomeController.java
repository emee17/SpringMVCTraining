package com.codejango.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		
		if(email== null) {
			
			mv.addObject("error_message", "Oops your are not logged in. Please login 1st");
			mv.setViewName("/login.jsp");
			return mv;
		}else {
			mv.addObject("student", new Student());
			mv.setViewName("register.jsp");
			
			return mv;
		}
		
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
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		
		if(email == null ) {
			mv.addObject("error_message", "Oops your are not logged in. Please login 1st");
			mv.setViewName("/login.jsp");
			
			return mv;
		}else {
			Student student = studentService.findByID(id);
			
			mv.addObject("student", student);
			mv.setViewName("/register.jsp");
			
			return mv;
		}
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv) {
		
		//ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	@PostMapping("/logintoapp")// end point / method / API
	public String loginToApp(@ModelAttribute("student") Student student, Model mv, HttpServletRequest request) {
		
		
		boolean isPresent = studentService.findByEmailAndPassword(student);
		
		if(isPresent) {
			//return "/home.jsp";
			//mv.setViewName("/home.jsp");
			//return mv;
			
			HttpSession session = request.getSession();
			
			session.setAttribute("email", student.getEmail());
			
			
			
			List<Student> studentList = studentService.findAll();
			
			mv.addAttribute("studentList", studentList);
			mv.addAttribute("email", student.getEmail());
			
			return "/home.jsp";
//			
		}else {
			
//			mv.setViewName("/login.jsp");
//			return mv;
			
			mv.addAttribute("error_message","username or password is incorrect");
			
			return "/login.jsp";
			
		}
		
		
	}
	
	@GetMapping("/logout")
	public ModelAndView logout ( ModelAndView mv ,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		List<Student> studentList = studentService.findAll();
		
		mv.addObject("studentList", studentList);
		
		mv.setViewName("/home.jsp");
		
		return mv;
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

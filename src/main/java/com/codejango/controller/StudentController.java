package com.codejango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejango.model.Student;
import com.codejango.studentservice.StudentService;

@Controller
@RequestMapping("/student")//http://localhost:8080/SpringMVCTraining/student/test
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("")
	public String saveStudent(@ModelAttribute("student") Student student, ModelAndView mv) {
		
		studentService.save(student);
		
		
		//mv.setViewName("home.jsp");
		
		
		//mv.setViewName("redirect:/");//localhost:8080/SpringMVCTraining/
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		// There are two types of value which come from URL
		// 1 Path Variable http://localhost:8080/SpringMVCTraining/student/delete/4
		// 2 RequestParam http://localhost:8080/SpringMVCTraining/student/delete/4?name=Ravi&age=25
		
		studentService.deleteByID(id);
		
		return "redirect:/";
	}
	
	

}

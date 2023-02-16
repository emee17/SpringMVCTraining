package com.codejango.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejango.model.Student;
import com.codejango.studentrepository.StudentRepository;

@Service //@Component
public class StudentService {

	// Service class are used to write business logic 
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		
		//logic
		
		
		studentRepository.save(student);
	}
}

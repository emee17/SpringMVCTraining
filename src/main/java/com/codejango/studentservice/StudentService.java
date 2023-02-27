package com.codejango.studentservice;

import java.util.List;

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
	
	public List<Student> findAll() {
		
		//logic
		List<Student> studentList = studentRepository.findAll();
		
		//return studentRepository.findAll();
		return studentList;
	}
	
	public void deleteByID(int id) {
		studentRepository.deleteByID(id);
	}

	public Student findByID(int id) {
		
		return studentRepository.findByID(id);
	}

	public List<Student> searchByName(String name) {
		
		List<Student> studentList = studentRepository.searchByName(name);
		
		return studentList;
	}

	public boolean findByEmailAndPassword(Student student) {
		
		return studentRepository.findByEmailAndPassword(student);
	}

	
	
	
	
	
	
	
	
	
	
//	public List<Student> searchByName(String name) {
//		
//		return studentRepository.searchByName(name);
//		
//	}
}

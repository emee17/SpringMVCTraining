package com.codejango.studentrepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codejango.model.Student;

@Repository
@Transactional
public class StudentRepository {

	
	@PersistenceContext  //Autowired
	private EntityManager entityManager;
	
	public void save(Student student) {
		
		entityManager.persist(student);
	}
}

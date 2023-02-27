package com.codejango.studentrepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codejango.model.Student;
import com.mysql.cj.xdevapi.SessionFactory;

@Repository
@Transactional
public class StudentRepository {

	
	@PersistenceContext  //Autowired
	private EntityManager entityManager;
	
	
	
	public void save(Student student) {
		
		System.out.println("Student before save : "+student);
		entityManager.merge(student);
		
		
		
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//		try {
//			entityManager.persist(student);
//		} catch (Exception e) {
//			transaction.rollback();
//		}
//		
//		transaction.commit();
		
		System.out.println("Student after save : "+student);
	}
	
	
	public List<Student> findAll() {
		
		Query query = entityManager.createQuery("FROM Student s");//Select * from Student
		
		List<Student> studentList = query.getResultList();
		
		
		return studentList;
	}
	
	
	public void deleteByID(int id) {
		
		Student student = entityManager.find(Student.class, id);//71
		
		System.out.println(student);
		
		if(student != null) {			
			entityManager.remove(student);
		}
		
		
	}


	public Student findByID(int id) {
		
		return entityManager.find(Student.class, id);
	}


	public List<Student> searchByName(String name) {
		
		Query query = entityManager.createQuery("From Student s where s.name like '%' || :name || '%'");
		
		query.setParameter("name", name);
		
		List<Student> studentList = query.getResultList();
		
		return studentList;
	}


	public boolean findByEmailAndPassword(Student student) {

		Query query = entityManager.createQuery("From Student s where s.email = :email and password =:password ");
		
		query.setParameter("email", student.getEmail());
		query.setParameter("password", student.getPassword());
		
		Student studentDb;
		try {
			studentDb = (Student) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		System.out.println("login : "+ studentDb);
		
		if(studentDb != null) {
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public List<Student> searchByName(String name) {
//
//		Query query = entityManager.createQuery("FROM Student s where s.name like '%'|| :name || '%' ");
//		//Query query = entityManager.createQuery("FROM Student s where s.name like :name");
//		
//		//query.setParameter("name", "%"+name+"%");
//		query.setParameter("name", name);
//		
//		List<Student> studentList = query.getResultList();
//		
//		return studentList;
//	}
}

package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.entities.Course;
import net.xeric.entities.Student;

import org.apache.tapestry5.annotations.Property;

public class ListStudentsAndCourses {
	
	@PersistenceContext
	EntityManager em;
	
	@Property
	Student student;
	
	@Property
	Course course;
	
	public List<Student> getAllStudents() {
		return em.createQuery("SELECT e FROM Student e", Student.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}

}

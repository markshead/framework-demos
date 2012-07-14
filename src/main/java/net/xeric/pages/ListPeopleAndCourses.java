package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.entities.Course;
import net.xeric.entities.Person;

import org.apache.tapestry5.annotations.Property;

public class ListPeopleAndCourses {
	
	@PersistenceContext
	EntityManager em;
	
	@Property
	Person person;
	
	@Property
	Course course;
	
	public List<Person> getAllPeople() {
		return em.createQuery("SELECT e FROM Person e", Person.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}

}

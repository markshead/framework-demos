package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.encoders.PersonEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Person;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;

public class PeopleCourses {
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	SelectModelFactory selectModelFactory;
	
	@Property
	private Person person; 
	
	@Property
	private Course course;
	
	@Persist
	@Property
	private Person selectedPerson;
	
	@CommitAfter
	public void onSubmitFromAddPerson() {
		em.persist(person);
	}
	
	@CommitAfter
	public void onSubmitFromAddCourse() {
		em.persist(course);
	}
	
	public List<Person> getAllPeople() {
		return em.createQuery("SELECT e FROM Person e", Person.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}
	
	public SelectModel getPersonModel() {
		return selectModelFactory.create(getAllPeople(), "firstName");
	}
	
	public PersonEncoder getPersonEncoder() {
		return new PersonEncoder(em);
	}

}

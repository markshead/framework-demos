package net.xeric.pages;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.encoders.CourseEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Person;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;

public class ManageEnrollment {
	
	@PersistenceContext
	EntityManager em;
	
	@Property
	Person person;
	
	@Property
	Course course;
	
	@Persist
	@Property
	Person personToUpdate;
	
	
	@Inject
	SelectModelFactory selectModelFactory;
	
	public void onManage(Person person) {
		personToUpdate = person;
		if(personToUpdate.getEnrolledCourses() == null) {
			personToUpdate.setEnrolledCourses(new ArrayList<Course>());
		}
	}
	
	@CommitAfter
	public void onSuccessFromManageClasses() {
		System.out.println("onSuccessFromManageClasses");
		System.out.println("Person to update: " + personToUpdate.getId());
		em.merge(personToUpdate);
		personToUpdate = null;
	}
	
	public SelectModel getCourseModel() {
		return selectModelFactory.create(getAllCourses(), "name");
	}
	
	public CourseEncoder getCourseEncoder() {
		return new CourseEncoder(em);
	}
	
	public List<Person> getAllPeople() {
		return em.createQuery("SELECT e FROM Person e", Person.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}


}

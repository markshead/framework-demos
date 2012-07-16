package net.xeric.pages;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.encoders.CourseEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Student;

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
	Student student;
	
	@Property
	Course course;
	
	@Persist
	@Property
	Student studentToUpdate;
	
	
	@Inject
	SelectModelFactory selectModelFactory;
	
	public void onManage(Student student) {
		studentToUpdate = student;
	}
	
	@CommitAfter
	public void onSuccessFromManageClasses() {
		em.merge(studentToUpdate);
		
		studentToUpdate = null;
	}
	
	public SelectModel getCourseModel() {
		return selectModelFactory.create(getAllCourses(), "name");
	}
	
	public CourseEncoder getCourseEncoder() {
		return new CourseEncoder(em);
	}
	
	public List<Student> getAllStudents() {
		return em.createQuery("SELECT e FROM Student e", Student.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}


}

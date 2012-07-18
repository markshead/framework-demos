package net.xeric.pages;

import net.xeric.encoders.CourseEncoder;
import net.xeric.encoders.StudentEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Student;
import net.xeric.libs.tap5.sourcecode.annotations.ShowSourceCode;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ShowSourceCode
public class AddStudentsAndCourses {
	
	@PersistenceContext
	EntityManager em;
	
	@Property
	private Student student; 
	
	@Property
	private Course course;
	
	@Persist
	@Property
	private Student selectedPerson;
	
	@CommitAfter
	public void onSubmitFromAddStudent() {
		em.persist(student);
	}
	
	@CommitAfter
	public void onSubmitFromAddCourse() {
		em.persist(course);
	}
	
	public List<Student> getAllPeople() {
		return em.createQuery("SELECT e FROM Person e", Student.class).getResultList();
	}
	
	public List<Course> getAllCourses() {
		return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

	}


}

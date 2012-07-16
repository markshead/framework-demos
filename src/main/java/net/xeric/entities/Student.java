package net.xeric.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;

@Entity
public class Student {
	private String firstName;
	private String lastName;
	@ManyToMany
	private List<Course> enrolledCourses = CollectionFactory.newList();
	@Id
	@NonVisual
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	 @Override
	    public boolean equals(Object other) {
	        if (this == other) {
	            return true;
	        }

	        if (other == null || !(other instanceof Student)) {
	            return false;
	        }

	        Student student = (Student) other;

	        return !(id != null ? !id.equals(student.id) : student.id != null);

	    }

	    @Override
	    public int hashCode() {
	        return id != null ? id.hashCode() : 0;
	    }
}

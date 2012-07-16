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
public class Course {
	
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
	private String name;
	
	@ManyToMany
	private List<Student> peopleEnrolled = CollectionFactory.newList();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getPeopleEnrolled() {
		return peopleEnrolled;
	}
	public void setPeopleEnrolled(List<Student> peopleEnrolled) {
		this.peopleEnrolled = peopleEnrolled;
	}
	
	 @Override
	    public boolean equals(Object other) {
	        if (this == other) {
	            return true;
	        }

	        if (other == null || !(other instanceof Course)) {
	            return false;
	        }

	        Course course = (Course) other;

	        return !(id != null ? !id.equals(course.id) : course.id != null);

	    }

	    @Override
	    public int hashCode() {
	        return id != null ? id.hashCode() : 0;
	    }
	
}

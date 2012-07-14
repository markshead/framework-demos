package net.xeric.entities;

import java.util.List;

import javax.persistence.Entity;
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
	private List<Person> peopleEnrolled = CollectionFactory.newList();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getPeopleEnrolled() {
		return peopleEnrolled;
	}
	public void setPeopleEnrolled(List<Person> peopleEnrolled) {
		this.peopleEnrolled = peopleEnrolled;
	}
}

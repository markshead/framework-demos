package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.entities.Student;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

public class About
{
	@Property
	Student student;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@CommitAfter
	public void onActivate() {
		Student p = new Student();
		p.setFirstName("Bob");
		p.setLastName("Smith");
		entityManager.persist(p);
	}
	
	public List<Student> getPeopleList() {
		//return entityManager.createQuery("SELECT e FROM Person e").getResultList();
		return entityManager.createQuery("SELECT e FROM Person e", Student.class).getResultList();
		//return entityManager.f
	}

}

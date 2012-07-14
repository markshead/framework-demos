package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.entities.Person;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

public class About
{
	@Property
	Person person;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@CommitAfter
	public void onActivate() {
		Person p = new Person();
		p.setFirstName("Bob");
		p.setLastName("Smith");
		entityManager.persist(p);
	}
	
	public List<Person> getPeopleList() {
		//return entityManager.createQuery("SELECT e FROM Person e").getResultList();
		return entityManager.createQuery("SELECT e FROM Person e", Person.class).getResultList();
		//return entityManager.f
	}

}

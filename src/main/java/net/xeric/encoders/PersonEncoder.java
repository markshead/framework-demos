package net.xeric.encoders;

import javax.persistence.EntityManager;

import net.xeric.entities.Person;

import org.apache.tapestry5.ValueEncoder;

public class PersonEncoder implements ValueEncoder<Person>{

	EntityManager em;
	
	public PersonEncoder(EntityManager em) {
		this.em = em;
	}
	
	public String toClient(Person person) {
		return person.getId().toString();
	}

	public Person toValue(String id) {
		return em.find(Person.class, Long.parseLong(id));
	}

}

package net.xeric.encoders;

import javax.persistence.EntityManager;

import net.xeric.entities.Student;

import org.apache.tapestry5.ValueEncoder;

public class StudentEncoder implements ValueEncoder<Student>{

	EntityManager em;
	
	public StudentEncoder(EntityManager em) {
		this.em = em;
	}
	
	public String toClient(Student student) {
		return student.getId().toString();
	}

	public Student toValue(String id) {
		return em.find(Student.class, Long.parseLong(id));
	}

}

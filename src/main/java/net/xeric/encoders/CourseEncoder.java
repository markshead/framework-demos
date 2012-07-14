package net.xeric.encoders;

import javax.persistence.EntityManager;

import net.xeric.entities.Course;

import org.apache.tapestry5.ValueEncoder;

public class CourseEncoder implements ValueEncoder<Course> {
	EntityManager em;
	
	public CourseEncoder(EntityManager em) {
		this.em = em;
	}
	
	public String toClient(Course course) {
		return course.getId().toString();
	}

	public Course toValue(String id) {
		return em.find(Course.class, Long.parseLong(id));
	}
}

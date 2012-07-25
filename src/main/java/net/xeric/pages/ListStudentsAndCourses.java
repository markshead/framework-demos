package net.xeric.pages;

import net.xeric.entities.Course;
import net.xeric.entities.Student;
import net.xeric.libs.tap5.sourcecode.annotations.ShowSourceCode;
import org.apache.tapestry5.annotations.Property;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ShowSourceCode
public class ListStudentsAndCourses {

    @PersistenceContext
    EntityManager em;

    @Property
    Student student;

    @Property
    Course course;

    public List<Student> getAllStudents() {
        return em.createQuery("SELECT e FROM Student e", Student.class).getResultList();
    }

    public List<Course> getAllCourses() {
        return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();
    }
}

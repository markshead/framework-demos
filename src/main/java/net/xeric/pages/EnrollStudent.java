package net.xeric.pages;

import net.xeric.entities.Course;
import net.xeric.entities.Student;
import net.xeric.libs.tap5.sourcecode.annotations.ShowSourceCode;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ShowSourceCode
public class EnrollStudent {

    @PersistenceContext
    EntityManager em;

    @Property
    Student student;

    @Property
    Course course;

    public void onActivate(Student student) {
        this.student = student;
    }

    public Student onPassivate() {
        return student;
    }

    @CommitAfter
    public void onRemoveCourse(Course course) {
        student.getEnrolledCourses().remove(course);
        course.getStudentsEnrolled().remove(student);
        em.persist(student);
    }

    @CommitAfter
    public void onAddCourse(Course course) {
        student.getEnrolledCourses().add(course);
        course.getStudentsEnrolled().add(student);
    }

    public List<Course> getAvailableCourses() {
        List<Course> courses = em.createQuery("SELECT e FROM Course e", Course.class).getResultList();
        courses.removeAll(student.getEnrolledCourses());
        return courses;


    }

}

package net.xeric.entities;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @NonVisual
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Validate("required")
    private String firstName;
    
    @Validate("required")
    private String lastName;

    @ManyToMany
    private Set<Course> enrolledCourses = CollectionFactory.newSet();

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

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
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

    public void enroll(Course course) {
        enrolledCourses.add(course);
        course.getStudentsEnrolled().add(this);
    }
}

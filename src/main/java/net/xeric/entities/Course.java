package net.xeric.entities;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Course {

    @Id
    @NonVisual
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<Person> peopleEnrolled = CollectionFactory.newSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPeopleEnrolled() {
        return peopleEnrolled;
    }

    public void setPeopleEnrolled(Set<Person> peopleEnrolled) {
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

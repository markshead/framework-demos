package net.xeric.pages;

import net.xeric.entities.Course;
import net.xeric.entities.Student;
import net.xeric.libs.tap5.sourcecode.annotations.ShowSourceCode;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ShowSourceCode
public class AddStudentsAndCourses {

    @PersistenceContext
    EntityManager em;

    @Property
    private Student student;

    @Property
    private Course course;

    @Persist
    @Property
    private Student selectedPerson;

    @CommitAfter
    public void onSubmitFromAddStudent() {
        em.persist(student);
    }

    @CommitAfter
    public void onSubmitFromAddCourse() {
        em.persist(course);
    }


}

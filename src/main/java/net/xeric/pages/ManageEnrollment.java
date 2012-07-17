package net.xeric.pages;

import net.xeric.encoders.CourseEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Person;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ManageEnrollment {

    @PersistenceContext
    private EntityManager em;

    @Property
    private Person person;

    @Property
    private Course course;

    @Persist
    @Property
    private Person personToUpdate;

    @Property
    private List<Course> courses;

    @Inject
    private SelectModelFactory selectModelFactory;

    public void onManage(Person person) {
        personToUpdate = person;
    }

    void onPrepare(){
        courses = CollectionFactory.newList();
        courses.addAll(personToUpdate.getEnrolledCourses());
    }

    @CommitAfter
    public void onSuccessFromManageClasses() {
        for(Course course: courses){
            personToUpdate.enroll(course);
        }

        em.merge(personToUpdate);
        personToUpdate = null;
    }

    public SelectModel getCourseModel() {
        return selectModelFactory.create(getAllCourses(), "name");
    }

    public ValueEncoder<Course> getCourseEncoder(){
        return new CourseEncoder(em);
    }

    public List<Person> getAllPeople() {
        return em.createQuery("SELECT e FROM Person e", Person.class).getResultList();
    }

    public List<Course> getAllCourses() {
        return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

    }


}

package net.xeric.pages;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xeric.encoders.CourseEncoder;
import net.xeric.entities.Course;
import net.xeric.entities.Student;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.services.SelectModelFactory;

public class ManageEnrollment {

    @PersistenceContext
    private EntityManager em;

    @Property
    private Student student;

    @Property
    private Course course;

    @Persist
    @Property
    private Student studentToUpdate;

    @Property
    private List<Course> courses;

    @Inject
    private SelectModelFactory selectModelFactory;

    public void onManage(Student student) {
       studentToUpdate = student;
    }

    void onPrepare(){
        courses = CollectionFactory.newList();
        courses.addAll(studentToUpdate.getEnrolledCourses());
    }

    @CommitAfter
    public void onSuccessFromManageClasses() {
        for(Course course: courses){
            studentToUpdate.enroll(course);
        }

        em.merge(studentToUpdate);
        studentToUpdate = null;
    }

    public SelectModel getCourseModel() {
        return selectModelFactory.create(getAllCourses(), "name");
    }

    public ValueEncoder<Course> getCourseEncoder(){
        return new CourseEncoder(em);
    }

	public List<Student> getAllStudents() {
		return em.createQuery("SELECT e FROM Student e", Student.class).getResultList();
    }

    public List<Course> getAllCourses() {
        return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();

    }


}

package net.xeric.jpademo.springmvc.services;

import net.xeric.jpademo.springmvc.entities.Course;
import net.xeric.jpademo.springmvc.entities.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }


    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void addCoursesToStudent(Student student, Set<Course> courses) {
        for (Course course : courses) {
            student.enroll(course);
        }

        saveStudent(student);
    }

    @Override
    public List<Student> listStudents() {
        CriteriaQuery<Student> query = getCriteriaBuilder().createQuery(Student.class);
        query.from(Student.class);
        return entityManager.createQuery(query).getResultList();
    }

    private CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }

    @Override
    public List<Course> listCourses() {
        CriteriaQuery<Course> query = getCriteriaBuilder().createQuery(Course.class);
        query.from(Course.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Student getStudent(long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public Course getCourse(long courseId) {
        return entityManager.find(Course.class, courseId);
    }

}

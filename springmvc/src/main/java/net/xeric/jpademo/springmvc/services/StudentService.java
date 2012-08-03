package net.xeric.jpademo.springmvc.services;

import net.xeric.jpademo.springmvc.entities.Course;
import net.xeric.jpademo.springmvc.entities.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface StudentService {

    @Transactional
    void saveStudent(Student student);

    @Transactional
    void saveCourse(Course course);

    @Transactional
    void addCoursesToStudent(Student student, Set<Course> courses);

    @Transactional(readOnly = true)
    List<Student> listStudents();

    @Transactional(readOnly = true)
    List<Course> listCourses();

    Student getStudent(long studentId);

    Course getCourse(long courseId);
}

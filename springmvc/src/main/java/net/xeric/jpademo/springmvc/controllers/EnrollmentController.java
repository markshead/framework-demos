package net.xeric.jpademo.springmvc.controllers;

import net.xeric.jpademo.springmvc.entities.Course;
import net.xeric.jpademo.springmvc.entities.Student;
import net.xeric.jpademo.springmvc.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/{studentId}")
    public String showEnrollments(
            Model model,
            @PathVariable("studentId")
            long studentId) {

        Student student = studentService.getStudent(studentId);
        model.addAttribute("student", student);

        List<Course> coursesList = studentService.listCourses();
        coursesList.removeAll(student.getEnrolledCourses());

        model.addAttribute("coursesList", coursesList);
        return "enrollment";
    }


    @RequestMapping("/enroll/{studentId}/{courseId}")
    public String enroll(
            Model model,
            @PathVariable("studentId")
            long studentId,
            @PathVariable("courseId")
            long courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = studentService.getCourse(courseId);

        student.enroll(course);
        studentService.saveStudent(student);

        return showEnrollments(model, studentId);
    }

    @RequestMapping("/cancel/{studentId}/{courseId}")
    public String cancel(
            Model model,
            @PathVariable("studentId")
            long studentId,
            @PathVariable("courseId")
            long courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = studentService.getCourse(courseId);

        student.getEnrolledCourses().remove(course);
        studentService.saveStudent(student);

        return showEnrollments(model, studentId);
    }

}

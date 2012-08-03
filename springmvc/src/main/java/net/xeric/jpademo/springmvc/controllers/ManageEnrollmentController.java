package net.xeric.jpademo.springmvc.controllers;

import net.xeric.jpademo.springmvc.entities.Course;
import net.xeric.jpademo.springmvc.entities.Student;
import net.xeric.jpademo.springmvc.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/manage-enrollments")
public class ManageEnrollmentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.listStudents());
        return "manage";
    }

    @RequestMapping("/{studentId}")
    public String listStudentsAndShowForm(Model model,
            @PathVariable("studentId")
            long studentId) {
        Student student = studentService.getStudent(studentId);
        model.addAttribute("coursesList", studentService.listCourses());
        model.addAttribute("student", student);
        return listStudents(model);
    }

    @RequestMapping(value = "/enroll/{studentId}", method = RequestMethod.POST)
    public String enrollStudents(Model model,
            @PathVariable("studentId")
            long studentId,
            @RequestParam("enrolledCourses")
            long[] courseIds) {
        Student student = studentService.getStudent(studentId);
        if(student != null){
            for(long courseId : courseIds){
                Course course = studentService.getCourse(courseId);
                if(!student.getEnrolledCourses().contains(course)){
                    student.enroll(course);
                }
            }
            studentService.saveStudent(student);
        }

        return listStudentsAndShowForm(model, student.getId());
    }

}

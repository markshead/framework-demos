package net.xeric.jpademo.springmvc.controllers;

import net.xeric.jpademo.springmvc.entities.Course;
import net.xeric.jpademo.springmvc.entities.Student;
import net.xeric.jpademo.springmvc.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AddStudentAndCourseController {

    @Resource
    private StudentService studentService;

    private static final String VIEW = "add";

    @RequestMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("course", new Course());
        return VIEW;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String createStudent(
            Model model,
            @ModelAttribute("student")
            @Valid
            Student student,
            BindingResult result) {

        if (!result.hasErrors()) {
            studentService.saveStudent(student);
            model.addAttribute("student", new Student());
        }

        model.addAttribute("course", new Course());
        return VIEW;
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public String createCourse(
            Model model,
            @ModelAttribute("course")
            @Valid
            Course course,
            BindingResult result) {

        if (!result.hasErrors()) {
            studentService.saveCourse(course);
            model.addAttribute("course", new Course());
        }

        model.addAttribute("student", new Student());
        return VIEW;
    }
}

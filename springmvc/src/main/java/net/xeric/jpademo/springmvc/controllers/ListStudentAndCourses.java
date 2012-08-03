package net.xeric.jpademo.springmvc.controllers;

import net.xeric.jpademo.springmvc.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/list")
public class ListStudentAndCourses {

    @Resource
    private StudentService studentService;

    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("students", studentService.listStudents());
        model.addAttribute("courses", studentService.listCourses());
        return "list";
    }

}

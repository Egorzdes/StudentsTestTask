package com.students.test_students.controller;

import com.students.test_students.model.Student;
import com.students.test_students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("main");
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.addObject("newstudent", new Student());
        return modelAndView;
    }


    @PostMapping()
    public ModelAndView newPage(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        studentService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }


}
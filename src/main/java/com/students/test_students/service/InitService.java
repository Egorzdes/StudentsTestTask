package com.students.test_students.service;

import com.students.test_students.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Date;

@Component
public class InitService {
    private final StudentService studentService;

    public InitService(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostConstruct
    public void Init() {
        Student student1 = new Student("egor","zdes","ionov", Date.from(Instant.ofEpochSecond(01-01-1970)),"P304");
        studentService.save(student1);
        Student student2 = new Student("egor2","zdes2","ionov2", Date.from(Instant.ofEpochSecond(01-01-1970)),"P304");
        studentService.save(student2);

    }
}

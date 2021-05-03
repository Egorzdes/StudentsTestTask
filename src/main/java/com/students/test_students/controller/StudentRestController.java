package com.students.test_students.controller;

import com.students.test_students.model.Student;
import com.students.test_students.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }


    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        System.out.println(id);

        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        studentService.deleteById(id);
        return "Student with ID = " + id + " was deleted";
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.save(student);

        return ResponseEntity.ok().body(student);

    }


}
/*
запросы для postman:

метод POST:
http://localhost:8080/api/create
{
    "id": 2,
    "firstName": "sdd",
    "lastName": "dsd",
    "middleName": "dsd",
    "dateOfBirth": "1970-01-01",
    "groupNumber": "poe4"
}
метод DELETE:
http://localhost:8080/api/delete/?
 */


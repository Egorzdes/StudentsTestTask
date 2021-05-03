package com.students.test_students.service;

import com.students.test_students.model.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> findById(Long id);

    void save(Student student);

    void deleteById(Long id);

    Iterable<Student> getAllStudents();
}

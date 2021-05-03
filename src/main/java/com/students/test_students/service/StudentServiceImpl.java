package com.students.test_students.service;

import com.students.test_students.model.Student;
import com.students.test_students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Метод находит студента по его id
     * @param -id
     */
    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Метод сохраняет нового студента
     * @param -student
     */
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    /**
     * Метод удаляет существующего студента по id
     * @param -id
     */
    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
    /**
     * Метод возвращает всех существующих студентов
     * @param - null
     */
    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

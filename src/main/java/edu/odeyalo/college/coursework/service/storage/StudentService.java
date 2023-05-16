package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    Student findById(Long id) throws StudentNotFoundException;

    List<Student> findAll();

    Student save(Student student);

    void update(Student student) throws StudentNotFoundException;

    void deleteById(Long id);
}

package edu.odeyalo.college.coursework.service.storage.impl;


import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.exception.StudentNotFoundException;
import edu.odeyalo.college.coursework.repository.StudentRepository;
import edu.odeyalo.college.coursework.service.storage.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryStudentService implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public RepositoryStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        // Update the faculty and the group with a newly created student
        student.getFaculty().addStudent(student);
        student.getGroup().addStudent(student);
        return studentRepository.save(student);
    }

    @Override
    public void update(Student student) throws StudentNotFoundException {
        Long id = student.getId();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}


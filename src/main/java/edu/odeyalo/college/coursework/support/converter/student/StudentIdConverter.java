package edu.odeyalo.college.coursework.support.converter.student;

import edu.odeyalo.college.coursework.dto.student.StudentId;
import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.repository.StudentRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StudentIdConverter {

    @Autowired
    private StudentRepository studentRepository;

    public Student toStudent(StudentId studentId) {
        if (studentId.getId() == null) {
            return null;
        }
        return studentRepository.findById(studentId.getId())
                .orElse(null);
    }

    public abstract StudentId toStudentId(Student student);

    public abstract StudentId toStudentId(Long id);
}

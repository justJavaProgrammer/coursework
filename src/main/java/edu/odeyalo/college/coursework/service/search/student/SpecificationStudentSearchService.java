package edu.odeyalo.college.coursework.service.search.student;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.repository.StudentRepository;
import edu.odeyalo.college.coursework.service.search.support.student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificationStudentSearchService implements StudentSearchService {
    private final StudentRepository studentRepository;

    @Autowired
    public SpecificationStudentSearchService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentSearchResult searchStudents(StudentSearchRequest request, Pageable pageable) {

        Specification<Student> spec = Specification
                .where(new StudentWithFacultySpecification(request.getFacultyId()))
                .and(new StudentWithNameSpecification(request.getName()))
                .and(new StudentWithSurnameSpecification(request.getSurname()))
                .and(new StudentWithPatronymicSpecification(request.getPatronymic()))
                .and(new StudentWithGroupSpecification(request.getGroupId()));

        List<Student> result = studentRepository.findAll(spec);

        return StudentSearchResult.of(result);
    }

    @Override
    public StudentSearchResult findAll(Pageable pageable) {
        Page<Student> result = studentRepository.findAll(pageable);
        return new StudentSearchResult(result.stream().toList());
    }
}

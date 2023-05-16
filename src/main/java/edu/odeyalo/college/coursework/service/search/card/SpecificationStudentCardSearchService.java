package edu.odeyalo.college.coursework.service.search.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.repository.StudentCardRepository;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchRequest;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchResult;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchService;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchRequest;
import edu.odeyalo.college.coursework.service.search.support.card.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificationStudentCardSearchService implements StudentCardSearchService {
    private final StudentCardRepository studentCardRepository;

    public SpecificationStudentCardSearchService(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    @Override
    public StudentCardSearchResult findAll(Pageable pageable) {
        Page<StudentCard> result = studentCardRepository.findAll(pageable);
        return new StudentCardSearchResult(result.stream().toList());
    }

    @Override
    public StudentCardSearchResult searchStudents(StudentCardSearchRequest searchRequest, Pageable pageable) {
        StudentSearchRequest student = searchRequest.getStudent();

        Specification<StudentCard> spec = Specification
                .where(new StudentCardWithDormitoryIdSpecification(searchRequest.getDormitoryId()))
                .and(new StudentCardWithDormitoryNumberSpecification(searchRequest.getDormitoryNumber()))
                .and(new StudentCardWithNameSpecification(student.getName()))
                .and(new StudentCardWithSurnameSpecification(student.getSurname()))
                .and(new StudentCardWithPatronymicSpecification(student.getPatronymic()))
                .and(new StudentCardWithFacultyIdSpecification(searchRequest.getFacultyId()))
                .and(new StudentCardWithRoomNumberSpecification(searchRequest.getRoomNumber()));

        Page<StudentCard> result = studentCardRepository.findAll(spec, pageable);
        return new StudentCardSearchResult(result.stream().toList());
    }
}

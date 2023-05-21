package edu.odeyalo.college.coursework.support.validation.card;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.repository.StudentCardRepository;
import edu.odeyalo.college.coursework.support.validation.ValidationResult;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentAlreadyHasStudentCardValidationStep implements StudentCardValidationStep {
    private final StudentCardRepository repository;

    public StudentAlreadyHasStudentCardValidationStep(StudentCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public ValidationResult validate(StudentCard studentCard) {
        Student student = studentCard.getStudent();
        if (student == null) {
            return new ValidationResult(true, "Student does not have student card");
        }
        Optional<StudentCard> optional = repository.findStudentCardByStudentId(student.getId());
        return optional.isPresent() ?
                new ValidationResult(false, "Student already has student card!")
                :
                new ValidationResult(true, "Student does not have student card");
    }
}

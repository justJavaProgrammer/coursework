package edu.odeyalo.college.coursework.support.validation.card;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.validation.ValidationResult;
import org.springframework.stereotype.Component;

@Component
public class StudentIsPresentStudentCardValidationStep implements StudentCardValidationStep {

    @Override
    public ValidationResult validate(StudentCard studentCard) {
        Student student = studentCard.getStudent();
        if (student == null) {
            return new ValidationResult(false, "The student is not presented!");
        }
        return new ValidationResult(true, "Student is present!");
    }
}

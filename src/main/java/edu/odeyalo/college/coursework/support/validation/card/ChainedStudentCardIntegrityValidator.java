package edu.odeyalo.college.coursework.support.validation.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.validation.ValidationResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChainedStudentCardIntegrityValidator implements StudentCardIntegrityValidator {
    private final List<StudentCardValidationStep> steps;

    public ChainedStudentCardIntegrityValidator(List<StudentCardValidationStep> steps) {
        this.steps = steps;
    }

    @Override
    public ValidationResult validate(StudentCard card) {
        for (StudentCardValidationStep step : steps) {
            ValidationResult result = step.validate(card);
            if (!result.success()) {
                return result;
            }
        }
        return new ValidationResult(true, "Valid");
    }
}

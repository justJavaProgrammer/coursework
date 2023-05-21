package edu.odeyalo.college.coursework.support.validation.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.validation.ValidationResult;
import org.springframework.stereotype.Component;

@Component
public class DormitoryIsPresentStudentCardValidationStep implements StudentCardValidationStep {

    @Override
    public ValidationResult validate(StudentCard studentCard) {
        if (studentCard.getDormitory() == null) {
            return new ValidationResult(false, "Dormitory is invalid!");
        }
        return new ValidationResult(true, "Dormitory is presented!");
    }
}

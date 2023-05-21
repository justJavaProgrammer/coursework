package edu.odeyalo.college.coursework.support.validation.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.validation.ValidationResult;

public interface StudentCardValidationStep {

    ValidationResult validate(StudentCard studentCard);

}

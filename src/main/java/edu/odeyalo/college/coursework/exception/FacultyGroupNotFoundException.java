package edu.odeyalo.college.coursework.exception;

public class FacultyGroupNotFoundException extends NotFoundException {
    public FacultyGroupNotFoundException(String message) {
        super(message);
    }

    public FacultyGroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package edu.odeyalo.college.coursework.exception;

public class FacultyNotFoundException extends NotFoundException {
    public FacultyNotFoundException(String message) {
        super(message);
    }

    public FacultyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

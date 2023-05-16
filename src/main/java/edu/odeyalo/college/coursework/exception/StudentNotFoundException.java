package edu.odeyalo.college.coursework.exception;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

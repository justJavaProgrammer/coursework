package edu.odeyalo.college.coursework.exception;

public class StudentCardNotFoundException extends NotFoundException {
    public StudentCardNotFoundException(String message) {
        super(message);
    }

    public StudentCardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

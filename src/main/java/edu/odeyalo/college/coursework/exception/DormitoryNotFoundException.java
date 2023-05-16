package edu.odeyalo.college.coursework.exception;

public class DormitoryNotFoundException extends NotFoundException {
    public DormitoryNotFoundException(String message) {
        super(message);
    }

    public DormitoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package edu.odeyalo.college.coursework.exception;

public class AddressNotFoundException extends NotFoundException {

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

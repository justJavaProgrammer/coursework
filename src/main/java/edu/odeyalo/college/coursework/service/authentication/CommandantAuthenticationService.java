package edu.odeyalo.college.coursework.service.authentication;

public interface CommandantAuthenticationService {
    CommandantAuthenticationResult authenticate(String username, String password);
}

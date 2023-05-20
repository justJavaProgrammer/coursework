package edu.odeyalo.college.coursework.support.jwt;

public interface JwtTokenValidator {

    boolean isValid(String jwtToken);

}

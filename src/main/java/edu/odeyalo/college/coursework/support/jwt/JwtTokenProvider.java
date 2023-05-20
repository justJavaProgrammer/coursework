package edu.odeyalo.college.coursework.support.jwt;

import java.util.Map;

public interface JwtTokenProvider extends JwtTokenGenerator, JwtTokenValidator {

    Object getBody(String token);

    Map<String, Object> getClaims(String token);

}

package edu.odeyalo.college.coursework.support.jwt;

import edu.odeyalo.college.coursework.support.security.IdAwareUserDetails;

public interface JwtTokenGenerator {

    String generateJwtToken(IdAwareUserDetails userDetails);
}

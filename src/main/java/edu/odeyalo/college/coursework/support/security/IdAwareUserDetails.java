package edu.odeyalo.college.coursework.support.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * An extension for UserDetails to add access to ID
 */
public interface IdAwareUserDetails extends UserDetails {

    String getId();

}

package edu.odeyalo.college.coursework.service.authentication;

import edu.odeyalo.college.coursework.support.security.CommandantUserDetailsWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CommandantUserDetailsService extends UserDetailsService {

    @Override
    CommandantUserDetailsWrapper loadUserByUsername(String username) throws UsernameNotFoundException;
}

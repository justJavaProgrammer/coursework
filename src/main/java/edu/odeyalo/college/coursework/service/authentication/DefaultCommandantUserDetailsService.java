package edu.odeyalo.college.coursework.service.authentication;

import edu.odeyalo.college.coursework.entity.CommandantCredentials;
import edu.odeyalo.college.coursework.repository.CommandantCredentialsRepository;
import edu.odeyalo.college.coursework.support.security.CommandantUserDetailsWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DefaultCommandantUserDetailsService implements CommandantUserDetailsService {
    private final CommandantCredentialsRepository repository;

    public DefaultCommandantUserDetailsService(CommandantCredentialsRepository repository) {
        this.repository = repository;
    }

    @Override
    public CommandantUserDetailsWrapper loadUserByUsername(String username) throws UsernameNotFoundException {
        CommandantCredentials credentials = repository.findCommandantCredentialsByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Commandant not found for name: " + username));

        return new CommandantUserDetailsWrapper(credentials);
    }
}

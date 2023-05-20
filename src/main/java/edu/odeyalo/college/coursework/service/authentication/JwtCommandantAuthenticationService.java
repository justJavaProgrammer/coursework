package edu.odeyalo.college.coursework.service.authentication;

import edu.odeyalo.college.coursework.support.jwt.JwtTokenGenerator;
import edu.odeyalo.college.coursework.support.security.CommandantUserDetailsWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtCommandantAuthenticationService implements CommandantAuthenticationService {
    private final CommandantUserDetailsService userDetailsService;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final PasswordEncoder encoder;

    public JwtCommandantAuthenticationService(CommandantUserDetailsService userDetailsService, JwtTokenGenerator jwtTokenGenerator, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.encoder = encoder;
    }

    @Override
    public CommandantAuthenticationResult authenticate(String username, String password) {
        CommandantUserDetailsWrapper userDetails = userDetailsService.loadUserByUsername(username);
        boolean matches = encoder.matches(password, userDetails.getPassword());
        if (!matches) {
            return null;
        }
        String token = jwtTokenGenerator.generateJwtToken(userDetails);
        return new CommandantAuthenticationResult(CommandantAuthenticationResult.JWT,
                userDetails.getCommandant(),
                Map.of("token", token));
    }
}

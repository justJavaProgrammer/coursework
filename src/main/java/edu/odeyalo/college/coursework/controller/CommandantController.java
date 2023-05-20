package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.LoginCredentials;
import edu.odeyalo.college.coursework.service.authentication.CommandantAuthenticationResult;
import edu.odeyalo.college.coursework.service.authentication.CommandantAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/commandant")
public class CommandantController {
    private final CommandantAuthenticationService authenticationService;

    public CommandantController(CommandantAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCredentials creds) {
        CommandantAuthenticationResult result = authenticationService.authenticate(creds.getUsername(), creds.getPassword());
        Map<String, Object> body =  Map.of(
                "type", result.getAuthenticationType(),
                "body", result.getBody()
        );
        return ResponseEntity.ok(body);
    }
}

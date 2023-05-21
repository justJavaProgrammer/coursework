package edu.odeyalo.college.coursework;

import edu.odeyalo.college.coursework.entity.Commandant;
import edu.odeyalo.college.coursework.entity.CommandantCredentials;
import edu.odeyalo.college.coursework.repository.CommandantCredentialsRepository;
import edu.odeyalo.college.coursework.repository.CommandantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CourseworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseworkApplication.class, args);
    }

//@Bean
    public ApplicationRunner runner(CommandantRepository commandantRepository,
                                    CommandantCredentialsRepository commandantCredentialsRepository,
                                    PasswordEncoder encoder) {
        return (args) -> {
            Commandant commandant = Commandant.builder()
                    .name("name")
                    .patronymic("patronymic")
                    .surname("surname")
                    .phoneNumber("phone")
                    .build();
            commandant = commandantRepository.save(commandant);

            CommandantCredentials credentials = CommandantCredentials.builder()
                    .username("commandant")
                    .password(encoder.encode("superpassword"))
                    .commandant(commandant)
                    .build();

            commandantCredentialsRepository.save(credentials);
        };
    }
}

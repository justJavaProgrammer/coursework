package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.CommandantCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandantCredentialsRepository extends JpaRepository<CommandantCredentials, Long> {

    Optional<CommandantCredentials> findCommandantCredentialsByUsername(String username);

    Optional<CommandantCredentials> findCommandantCredentialsByUsernameAndPassword(String username, String password);
}

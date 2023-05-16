package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.Commandant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandantRepository extends JpaRepository<Commandant, Long> {
}

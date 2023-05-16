package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard, Long>,
        JpaSpecificationExecutor<StudentCard> {
}
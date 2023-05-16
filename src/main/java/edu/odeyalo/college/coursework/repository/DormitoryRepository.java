package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
}
package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long>, JpaSpecificationExecutor<Dormitory> {

    Optional<Dormitory> findDormitoryByDormitoryNumber(String number);

}
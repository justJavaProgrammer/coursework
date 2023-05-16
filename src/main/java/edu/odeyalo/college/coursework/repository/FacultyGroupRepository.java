package edu.odeyalo.college.coursework.repository;

import edu.odeyalo.college.coursework.entity.FacultyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyGroupRepository extends JpaRepository<FacultyGroup, Long> {

    FacultyGroup findFacultyGroupByStudentsId(Long id);

}
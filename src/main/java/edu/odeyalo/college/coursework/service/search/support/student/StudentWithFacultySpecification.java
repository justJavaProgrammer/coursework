package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithFacultySpecification implements Specification<Student> {
    private final Long facultyId;

    public StudentWithFacultySpecification(Long facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (facultyId == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("faculty").get("id");
        return cb.equal(objectPath, facultyId);
    }
}

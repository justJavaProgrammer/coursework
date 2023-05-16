package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithFacultySpecification implements Specification<StudentCard> {
    private final Long facultyId;

    public StudentCardWithFacultySpecification(Long facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (facultyId == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("student").get("faculty").get("id");
        return cb.equal(objectPath, facultyId);
    }
}

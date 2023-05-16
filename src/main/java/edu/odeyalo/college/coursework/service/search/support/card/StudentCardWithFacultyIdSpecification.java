package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithFacultyIdSpecification implements Specification<StudentCard> {
    private final Long facultyId;

    public StudentCardWithFacultyIdSpecification(Long facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (facultyId == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("student").get("faculty").get("id"), facultyId);
    }
}

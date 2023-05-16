package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithSurnameSpecification implements Specification<StudentCard> {
    private final String surname;

    public StudentCardWithSurnameSpecification(String surname) {
        this.surname = surname;
    }


    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (surname == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(cb.lower(root.get("student").get("surname")), surname.toLowerCase());
    }
}

package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithSurnameSpecification implements Specification<Student> {
    private final String surname;

    public StudentWithSurnameSpecification(String surname) {
        this.surname = surname;
    }


    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (surname == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(cb.lower(root.get("surname")), surname.toLowerCase());
    }
}

package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithNameSpecification implements Specification<Student> {
    private final String name;

    public StudentWithNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (name == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("name"), name);
    }
}

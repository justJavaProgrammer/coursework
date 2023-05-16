package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithPatronymicSpecification implements Specification<Student> {
    private final String patronymic;

    public StudentWithPatronymicSpecification(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (patronymic == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("patronymic"), patronymic);
    }
}

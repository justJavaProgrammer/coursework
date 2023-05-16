package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithDormitoryIdSpecification implements Specification<StudentCard> {
    private final Long dormitoryId;

    public StudentCardWithDormitoryIdSpecification(Long dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (dormitoryId == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("dormitory").get("id"), dormitoryId);
    }
}

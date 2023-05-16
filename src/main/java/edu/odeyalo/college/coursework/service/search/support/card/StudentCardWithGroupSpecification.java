package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithGroupSpecification implements Specification<StudentCard> {
    private final Long groupId;

    public StudentCardWithGroupSpecification(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (groupId == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("student").get("group").get("id");
        return cb.equal(objectPath, groupId);
    }
}

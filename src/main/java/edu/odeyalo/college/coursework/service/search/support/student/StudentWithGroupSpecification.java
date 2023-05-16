package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithGroupSpecification implements Specification<Student> {
    private final Long groupId;

    public StudentWithGroupSpecification(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (groupId == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("group").get("id");
        return cb.equal(objectPath, groupId);
    }
}

package edu.odeyalo.college.coursework.service.search.support.dormitory;

import edu.odeyalo.college.coursework.entity.Dormitory;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class DormitoryWithPhoneNumberSpecification implements Specification<Dormitory> {
    private final String phoneNumber;

    public DormitoryWithPhoneNumberSpecification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Predicate toPredicate(Root<Dormitory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (phoneNumber == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("phoneNumber");
        return cb.equal(objectPath, phoneNumber);
    }
}

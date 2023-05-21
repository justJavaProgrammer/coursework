package edu.odeyalo.college.coursework.service.search.support.dormitory;

import edu.odeyalo.college.coursework.entity.Dormitory;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class DormitoryWithDormitoryNumberSpecification implements Specification<Dormitory> {
    private final String dormitoryNumber;

    public DormitoryWithDormitoryNumberSpecification(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    @Override
    public Predicate toPredicate(Root<Dormitory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (dormitoryNumber == null) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> objectPath = root.get("dormitoryNumber");
        return cb.equal(objectPath, dormitoryNumber);
    }
}

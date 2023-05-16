package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithDormitoryNumberSpecification implements Specification<StudentCard> {
    private final String dormitoryNumber;

    public StudentCardWithDormitoryNumberSpecification(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (dormitoryNumber == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("dormitory").get("dormitoryNumber"), dormitoryNumber);
    }
}

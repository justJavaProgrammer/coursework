package edu.odeyalo.college.coursework.service.search.support.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentCardWithRoomNumberSpecification implements Specification<StudentCard> {
    private final String roomNumber;

    public StudentCardWithRoomNumberSpecification(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public Predicate toPredicate(Root<StudentCard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (roomNumber == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("roomNumber"), roomNumber);
    }
}

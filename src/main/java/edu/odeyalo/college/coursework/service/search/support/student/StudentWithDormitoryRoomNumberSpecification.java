package edu.odeyalo.college.coursework.service.search.support.student;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.entity.StudentCard;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentWithDormitoryRoomNumberSpecification implements Specification<Student> {
    private final String roomNumber;

    public StudentWithDormitoryRoomNumberSpecification(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (roomNumber == null) {
            return cb.isTrue(cb.literal(true));
        }
        Subquery<Long> subquery = query.subquery(Long.class);
        Root<StudentCard> cardRoot = subquery.from(StudentCard.class);
        subquery.select(cardRoot.get("student").get("id"))
                .where(cb.equal(cardRoot.get("roomNumber"), roomNumber));
        return cb.in(root.get("id")).value(subquery);
    }
}

package edu.odeyalo.college.coursework.service.search.support.dormitory;

import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.service.search.address.AddressSearchRequest;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class DormitoryWithAddressSpecification implements Specification<Dormitory> {
    private final AddressSearchRequest request;

    public DormitoryWithAddressSpecification(AddressSearchRequest request) {
        this.request = request;
    }

    @Override
    public Predicate toPredicate(Root<Dormitory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (request == null || request.isEmpty()) {
            return cb.isTrue(cb.literal(true));
        }
        Path<Object> addressPath = root.get("address");
        return cb.or(
                cb.equal(addressPath.get("country"), request.getCountry()),
                cb.equal(addressPath.get("state"), request.getState()),
                cb.equal(addressPath.get("street"), request.getStreet()),
                cb.equal(addressPath.get("zipCode"), request.getZipCode())
        );
    }
}

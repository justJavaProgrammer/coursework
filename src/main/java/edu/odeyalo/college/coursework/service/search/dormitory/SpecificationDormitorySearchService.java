package edu.odeyalo.college.coursework.service.search.dormitory;

import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.repository.DormitoryRepository;
import edu.odeyalo.college.coursework.service.search.support.dormitory.DormitoryWithAddressSpecification;
import edu.odeyalo.college.coursework.service.search.support.dormitory.DormitoryWithDormitoryNumberSpecification;
import edu.odeyalo.college.coursework.service.search.support.dormitory.DormitoryWithPhoneNumberSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationDormitorySearchService implements DormitorySearchService {
    private final DormitoryRepository dormitoryRepository;

    public SpecificationDormitorySearchService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    @Override
    public DormitorySearchResult findAll(Pageable pageable) {
        Page<Dormitory> all = dormitoryRepository.findAll(pageable);
        return new DormitorySearchResult(all.toList());
    }

    @Override
    public DormitorySearchResult searchDormitories(DormitorySearchRequest searchRequest, Pageable pageable) {
        Specification<Dormitory> spec = Specification.where(new DormitoryWithDormitoryNumberSpecification(searchRequest.getDormitoryNumber()))
                .and(new DormitoryWithPhoneNumberSpecification(searchRequest.getPhoneNumber()))
                .and(new DormitoryWithAddressSpecification(searchRequest.getAddress()));
        Page<Dormitory> result = dormitoryRepository.findAll(spec, pageable);
        return new DormitorySearchResult(result.toList());
    }
}

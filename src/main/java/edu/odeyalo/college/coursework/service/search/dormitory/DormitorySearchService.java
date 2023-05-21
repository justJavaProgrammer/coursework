package edu.odeyalo.college.coursework.service.search.dormitory;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import edu.odeyalo.college.coursework.service.search.SearchService;
import org.springframework.data.domain.Pageable;

public interface DormitorySearchService extends SearchService<DormitorySearchResult> {

    @Override
    default DormitorySearchResult search(SearchRequest searchRequest, Pageable pageable) {
        if (!(searchRequest instanceof DormitorySearchRequest)) {
            throw new IllegalArgumentException("DormitorySearchService supports only DormitorySearchResult");
        }
        return searchDormitories((DormitorySearchRequest) searchRequest, pageable);
    }

    DormitorySearchResult searchDormitories(DormitorySearchRequest searchRequest, Pageable pageable);
}

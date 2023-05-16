package edu.odeyalo.college.coursework.service.search.card;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import edu.odeyalo.college.coursework.service.search.SearchService;
import org.springframework.data.domain.Pageable;

public interface StudentCardSearchService extends SearchService<StudentCardSearchResult> {

    @Override
    default StudentCardSearchResult search(SearchRequest searchRequest, Pageable pageable) {
        if (!(searchRequest instanceof StudentCardSearchRequest)) {
            throw new IllegalArgumentException("StudentCardSearchService supports only StudentCardSearchRequest");
        }
        return searchStudents((StudentCardSearchRequest) searchRequest, pageable);
    }

    StudentCardSearchResult searchStudents(StudentCardSearchRequest searchRequest, Pageable pageable);
}

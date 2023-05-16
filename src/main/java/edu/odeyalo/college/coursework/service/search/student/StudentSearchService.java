package edu.odeyalo.college.coursework.service.search.student;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import edu.odeyalo.college.coursework.service.search.SearchService;
import org.springframework.data.domain.Pageable;


public interface StudentSearchService extends SearchService<StudentSearchResult> {

    @Override
    default StudentSearchResult search(SearchRequest searchRequest, Pageable pageable) {
        if (!(searchRequest instanceof StudentSearchRequest)) {
            throw new IllegalArgumentException("StudentSearchService supports only StudentSearchRequest");
        }
        return searchStudents((StudentSearchRequest) searchRequest, pageable);
    }

    StudentSearchResult searchStudents(StudentSearchRequest request, Pageable pageable);
}

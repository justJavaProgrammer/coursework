package edu.odeyalo.college.coursework.service.search;


import org.springframework.data.domain.Pageable;

public interface SearchService<T extends SearchResult<?>> {

    T findAll(Pageable pageable);

    /**
     * Search something by search request with Pageable support
     * @param searchRequest - search information
     * @param pageable - pageable to add limitations and sorting
     * @return - search result, never null
     * @throws IllegalArgumentException - if the searchRequest is not supported by implementation
     */
    T search(SearchRequest searchRequest, Pageable pageable);
}

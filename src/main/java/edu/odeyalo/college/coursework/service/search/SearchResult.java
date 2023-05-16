package edu.odeyalo.college.coursework.service.search;

import java.util.List;

/**
 * interface for all search results
 */
public interface SearchResult<T> {

    List<T> getResult();

    /**
     * @return Size of the result
     */
    int size();

}

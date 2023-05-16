package edu.odeyalo.college.coursework.service.search;

import org.springframework.util.Assert;

import java.util.List;

public abstract class AbstractSearchResult<T> implements SearchResult<T> {
    private final List<T> results;
    private final int size;

    public AbstractSearchResult(List<T> results) {
        Assert.notNull(results, "Search result must be not null");
        this.results = results;
        this.size = results.size();
    }

    @Override
    public List<T> getResult() {
        return results;
    }

    @Override
    public int size() {
        return size;
    }
}

package edu.odeyalo.college.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.Assert;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponse {
    private final List<?> result;
    private final long count;

    public SearchResponse(List<?> result) {
        Assert.notNull(result, "Result must be not null");
        this.result = result;
        this.count = result.size();
    }
}

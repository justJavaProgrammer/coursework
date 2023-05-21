package edu.odeyalo.college.coursework.service.search.dormitory;

import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.service.search.AbstractSearchResult;

import java.util.List;

public class DormitorySearchResult extends AbstractSearchResult<Dormitory> {

    public DormitorySearchResult(List<Dormitory> results) {
        super(results);
    }
}

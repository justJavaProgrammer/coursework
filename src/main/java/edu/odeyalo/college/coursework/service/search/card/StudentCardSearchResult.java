package edu.odeyalo.college.coursework.service.search.card;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.service.search.AbstractSearchResult;

import java.util.List;

public class StudentCardSearchResult extends AbstractSearchResult<StudentCard> {

    public StudentCardSearchResult(List<StudentCard> results) {
        super(results);
    }
}

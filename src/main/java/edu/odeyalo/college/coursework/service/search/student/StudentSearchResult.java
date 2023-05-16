package edu.odeyalo.college.coursework.service.search.student;

import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.service.search.AbstractSearchResult;

import java.util.List;

public class StudentSearchResult extends AbstractSearchResult<Student> {

    public StudentSearchResult(List<Student> students) {
        super(students);
    }

    public static StudentSearchResult of(List<Student> students) {
        return new StudentSearchResult(students);
    }
}

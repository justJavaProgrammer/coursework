package edu.odeyalo.college.coursework.service.search.card;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCardSearchRequest implements SearchRequest {
    private StudentSearchRequest student;
    private Long dormitoryId;
    private Long facultyId;
    private String dormitoryNumber;
    private String roomNumber;
}

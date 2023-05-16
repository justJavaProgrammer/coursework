package edu.odeyalo.college.coursework.service.search.student;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchRequest implements SearchRequest {
    private String name;
    private String surname;
    private String patronymic;
    private Long facultyId;
    private Long groupId;
}
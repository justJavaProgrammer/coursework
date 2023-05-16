package edu.odeyalo.college.coursework.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GenericFacultyInfo {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("faculty_name")
    private String facultyName;
    @JsonProperty("faculty_code")
    private String facultyCode;
    @JsonProperty("deanery_phone")
    private String deaneryPhone;
}

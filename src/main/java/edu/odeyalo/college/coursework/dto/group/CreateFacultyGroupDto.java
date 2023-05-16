package edu.odeyalo.college.coursework.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.faculty.FacultyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFacultyGroupDto {
    @JsonProperty("cipher")
    private String cipher;
    @JsonProperty("group_code")
    private String groupCode;
    @JsonProperty("faculty")
    private FacultyId facultyId;
}

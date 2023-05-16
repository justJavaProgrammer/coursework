package edu.odeyalo.college.coursework.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.faculty.FacultyId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class FacultyGroupDTO extends GenericFacultyGroupInfo {
    @JsonProperty("faculty_id")
    private FacultyId facultyId;
}

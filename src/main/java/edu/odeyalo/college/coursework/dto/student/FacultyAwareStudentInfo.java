package edu.odeyalo.college.coursework.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.faculty.GenericFacultyInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class FacultyAwareStudentInfo extends GenericStudentInfo {
    @JsonProperty("faculty")
    private GenericFacultyInfo facultyInfo;

    protected FacultyAwareStudentInfo(GenericStudentInfoBuilder<?, ?> b) {
        super(b);
    }
}

package edu.odeyalo.college.coursework.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.group.FacultyGroupDTO;
import edu.odeyalo.college.coursework.dto.student.GenericStudentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
public class FullFacultyDTO extends GenericFacultyInfo {
    @JsonProperty("groups")
    private List<FacultyGroupDTO> groups;
    @JsonProperty("students")
    private List<GenericStudentInfo> students;

    public FullFacultyDTO() {
        this.groups = new ArrayList<>();
        this.students = new ArrayList<>();
    }
}

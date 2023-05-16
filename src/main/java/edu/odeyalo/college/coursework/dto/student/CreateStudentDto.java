package edu.odeyalo.college.coursework.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDto extends GenericStudentInfo {
    @JsonProperty("faculty_group_id")
    private Long groupId;

    protected CreateStudentDto(GenericStudentInfoBuilder<?, ?> b) {
        super(b);
    }
}

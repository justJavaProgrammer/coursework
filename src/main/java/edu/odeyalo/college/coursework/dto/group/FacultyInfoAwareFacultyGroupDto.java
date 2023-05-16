package edu.odeyalo.college.coursework.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.faculty.GenericFacultyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//todo: Create converters
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyInfoAwareFacultyGroupDto extends GenericFacultyGroupInfo {
    @JsonProperty("faculty")
    private GenericFacultyInfo genericFacultyInfo;

    protected FacultyInfoAwareFacultyGroupDto(GenericFacultyGroupInfoBuilder<?, ?> b) {
        super(b);
    }

}

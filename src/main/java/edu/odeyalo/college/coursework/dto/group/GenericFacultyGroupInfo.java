package edu.odeyalo.college.coursework.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class GenericFacultyGroupInfo {
    @JsonProperty("id")
    protected Long id;
    @JsonProperty("cipher")
    protected String cipher;
    @JsonProperty("group_code")
    protected String groupCode;
}

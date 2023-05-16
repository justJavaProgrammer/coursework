package edu.odeyalo.college.coursework.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentId {
    @JsonProperty("id")
    private Long id;
}

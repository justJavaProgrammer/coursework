package edu.odeyalo.college.coursework.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GenericStudentInfo {
    @JsonProperty("id")
    protected Long id;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("surname")
    protected String surname;
    @JsonProperty("patronymic")
    protected String patronymic;
    @JsonProperty("birthdate")
    protected LocalDate birthdate;
}

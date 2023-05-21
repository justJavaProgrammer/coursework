package edu.odeyalo.college.coursework.dto.dormitory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryNumber {
    @JsonProperty("number")
    private String number;
}

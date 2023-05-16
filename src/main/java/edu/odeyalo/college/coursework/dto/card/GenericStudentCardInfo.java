package edu.odeyalo.college.coursework.dto.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.dormitory.GenericDormitoryInfo;
import edu.odeyalo.college.coursework.dto.student.GenericStudentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericStudentCardInfo {
    @JsonProperty("student")
    private GenericStudentInfo studentInfo;
    @JsonProperty("dormitory")
    private GenericDormitoryInfo dormitoryInfo;
    @JsonProperty("room_number")
    private String roomNumber;
}

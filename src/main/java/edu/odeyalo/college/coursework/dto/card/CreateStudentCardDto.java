package edu.odeyalo.college.coursework.dto.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.address.AddressDto;
import edu.odeyalo.college.coursework.dto.dormitory.DormitoryId;
import edu.odeyalo.college.coursework.dto.student.StudentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentCardDto {
    @JsonProperty("student")
    private StudentId studentId;
    @JsonProperty("address")
    private AddressDto address;
    @JsonProperty("dormitory")
    private DormitoryId dormitoryId;
    @JsonProperty("room_number")
    private String roomNumber;
}

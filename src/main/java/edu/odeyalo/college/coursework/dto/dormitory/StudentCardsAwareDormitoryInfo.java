package edu.odeyalo.college.coursework.dto.dormitory;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.address.AddressDto;
import edu.odeyalo.college.coursework.dto.card.GenericStudentCardInfo;
import edu.odeyalo.college.coursework.dto.card.SimpleStudentCardInfo;
import edu.odeyalo.college.coursework.dto.student.GenericStudentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class StudentCardsAwareDormitoryInfo extends GenericDormitoryInfo {
    @JsonProperty("student_cards")
    private List<SimpleStudentCardInfo> cards;

    public StudentCardsAwareDormitoryInfo(String dormitoryNumber, AddressDto addressDto, String phoneNumber, List<SimpleStudentCardInfo> cards) {
        super(dormitoryNumber, addressDto, phoneNumber);
        this.cards = cards;
    }
}

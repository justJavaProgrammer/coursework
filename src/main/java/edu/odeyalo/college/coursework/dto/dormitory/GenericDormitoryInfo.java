package edu.odeyalo.college.coursework.dto.dormitory;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.address.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericDormitoryInfo {
    @JsonProperty("dormitory_number")
    protected String dormitoryNumber;
    @JsonProperty("address")
    protected AddressDto addressDto;
    @JsonProperty("phone_number")
    protected String phoneNumber;
}

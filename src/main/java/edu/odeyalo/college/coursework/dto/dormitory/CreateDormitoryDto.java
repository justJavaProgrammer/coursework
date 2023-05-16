package edu.odeyalo.college.coursework.dto.dormitory;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.address.AddressDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class CreateDormitoryDto {
    @JsonProperty("dormitory")
    @NotBlank
    @NotNull(message = "dormitory number is mandatory")
    private String dormitoryNumber;
    @JsonProperty("address")
    private AddressDto addressDto;
    @JsonProperty("phone_number")
    private String phoneNumber;
}

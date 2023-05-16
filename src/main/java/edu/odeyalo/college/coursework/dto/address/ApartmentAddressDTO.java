package edu.odeyalo.college.coursework.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentAddressDTO extends AddressDto {
    @NotBlank(message = "The apartment number  is mandatory")
    @JsonProperty("apartment_number")
    private String apartmentNumber;
    @NotBlank(message = "The entrance is mandatory")
    @JsonProperty("entrance")
    private String entrance;
}

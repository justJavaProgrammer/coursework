package edu.odeyalo.college.coursework.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuildingAddressDto extends AddressDto {
    /**
     * Number of the building
     */
    @NotBlank(message = "Building number is mandatory!")
    @JsonProperty("building_number")
    private String number;

    public BuildingAddressDto(String street, String country, String zipCode, String state) {
        super(street, country, zipCode, state);
    }

    public BuildingAddressDto() {
    }

    protected BuildingAddressDto(AddressDtoBuilder<?, ?> b) {
        super(b);
    }
}

package edu.odeyalo.college.coursework.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ApartmentAddressDTO.class, name = "apartment"),
        @JsonSubTypes.Type(value = HouseAddressDTO.class, name = "house"),
        @JsonSubTypes.Type(value = BuildingAddressDto.class, name = "building")
})
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "The street name is mandatory")
    protected String street;
    @NotBlank(message = "The country name is mandatory")
    protected String country;
    @NotBlank(message = "Zip code is mandatory")
    @JsonProperty("zip_code")
    protected String zipCode;
    @NotBlank(message = "The state is mandatory")
    protected String state;
}

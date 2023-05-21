package edu.odeyalo.college.coursework.service.search.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentAddressSearchRequest extends AddressSearchRequest {
    private String apartmentNumber;
    private String entrance;
}

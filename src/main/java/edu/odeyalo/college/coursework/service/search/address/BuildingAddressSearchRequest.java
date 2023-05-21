package edu.odeyalo.college.coursework.service.search.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class BuildingAddressSearchRequest extends AddressSearchRequest {
    private String number;

    protected BuildingAddressSearchRequest(AddressSearchRequestBuilder<?, ?> b) {
        super(b);
    }
}

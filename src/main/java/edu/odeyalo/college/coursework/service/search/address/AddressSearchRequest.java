package edu.odeyalo.college.coursework.service.search.address;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AddressSearchRequest implements SearchRequest {
    protected String street;
    protected String country;
    protected String zipCode;
    protected String state;

    public boolean isEmpty() {
        return (street == null || street.isEmpty())
                && (state == null || state.isEmpty())
                && (country == null || country.isEmpty())
                && (zipCode == null || zipCode.isEmpty());
    }
}

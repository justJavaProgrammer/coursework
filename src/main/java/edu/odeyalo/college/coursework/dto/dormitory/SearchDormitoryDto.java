package edu.odeyalo.college.coursework.dto.dormitory;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.dto.address.AddressDto;
import edu.odeyalo.college.coursework.service.search.address.AddressSearchRequest;
import edu.odeyalo.college.coursework.service.search.dormitory.DormitorySearchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDormitoryDto {
    @JsonProperty("dormitory_number")
    private String dormitoryNumber;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("address")
    private AddressDto address;

    public DormitorySearchRequest toSearchRequest() {
        AddressSearchRequest request = null;
        if (address != null) {
            request = new AddressSearchRequest(address.getStreet(), address.getCountry(), address.getZipCode(), address.getState());
        }
        return new DormitorySearchRequest(dormitoryNumber, phoneNumber, request);
    }
}

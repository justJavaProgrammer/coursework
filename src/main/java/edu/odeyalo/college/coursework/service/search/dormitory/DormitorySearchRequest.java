package edu.odeyalo.college.coursework.service.search.dormitory;

import edu.odeyalo.college.coursework.service.search.SearchRequest;
import edu.odeyalo.college.coursework.service.search.address.AddressSearchRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DormitorySearchRequest implements SearchRequest {
    private String dormitoryNumber;
    private String phoneNumber;
    private AddressSearchRequest address;
}

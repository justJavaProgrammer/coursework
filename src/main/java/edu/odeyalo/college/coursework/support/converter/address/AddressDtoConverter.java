package edu.odeyalo.college.coursework.support.converter.address;

import edu.odeyalo.college.coursework.dto.address.AddressDto;
import edu.odeyalo.college.coursework.entity.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface AddressDtoConverter {

    AddressDto toDto(Address address);

    Address fromDto(AddressDto dto);

}

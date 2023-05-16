package edu.odeyalo.college.coursework.support.converter.dormitory;

import edu.odeyalo.college.coursework.dto.dormitory.CreateDormitoryDto;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.support.converter.address.AddressDtoConverter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = AddressDtoConverter.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface CreateDormitoryDtoConverter {

    CreateDormitoryDto toDto(Dormitory dormitory);

    @Mapping(source = "addressDto", target = "address")
    Dormitory fromDto(CreateDormitoryDto dto);

}

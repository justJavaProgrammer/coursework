package edu.odeyalo.college.coursework.support.converter.dormitory;

import edu.odeyalo.college.coursework.dto.dormitory.StudentCardsAwareDormitoryInfo;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.support.converter.address.AddressDtoConverter;
import edu.odeyalo.college.coursework.support.converter.card.SimpleStudentCardInfoConverter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AddressDtoConverter.class, SimpleStudentCardInfoConverter.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface StudentCardsAwareDormitoryInfoConverter {

    @Mapping(source = "address", target = "addressDto")
    @Mapping(source = "studentCards", target = "cards")
    StudentCardsAwareDormitoryInfo toInfo(Dormitory dormitory);

}

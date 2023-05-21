package edu.odeyalo.college.coursework.support.converter.card;

import edu.odeyalo.college.coursework.dto.card.CreateStudentCardDto;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.converter.address.AddressDtoConverter;
import edu.odeyalo.college.coursework.support.converter.dormitory.DormitoryIdConverter;
import edu.odeyalo.college.coursework.support.converter.dormitory.DormitoryNumberConverter;
import edu.odeyalo.college.coursework.support.converter.student.StudentIdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DormitoryNumberConverter.class, AddressDtoConverter.class, StudentIdConverter.class},
        componentModel = "spring")
public interface CreateStudentCardDtoConverter {

    @Mapping(source = "student", target = "studentId")
    @Mapping(source = "dormitory", target = "dormitoryId")
    @Mapping(source = "parentsAddress", target = "address")
    CreateStudentCardDto toDto(StudentCard student);

    @Mapping(source = "studentId", target = "student")
    @Mapping(source = "dormitoryId", target = "dormitory")
    @Mapping(source = "address", target = "parentsAddress")
    StudentCard toStudentCard(CreateStudentCardDto dto);
}

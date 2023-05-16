package edu.odeyalo.college.coursework.support.converter.card;

import edu.odeyalo.college.coursework.dto.card.GenericStudentCardInfo;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.converter.dormitory.GenericDormitoryInfoConverter;
import edu.odeyalo.college.coursework.support.converter.student.GenericStudentInfoConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {GenericStudentInfoConverter.class, GenericDormitoryInfoConverter.class},
        componentModel = "spring")
public interface GenericStudentCardInfoConverter {

    @Mapping(target = "studentInfo", source = "student")
    @Mapping(target = "dormitoryInfo", source = "dormitory")
    GenericStudentCardInfo toInfo(StudentCard card);

    @Mapping(target = "dormitory", source = "dormitoryInfo")
    @Mapping(target = "student", source = "studentInfo")
    StudentCard toStudentCard(GenericStudentCardInfo info);
}

package edu.odeyalo.college.coursework.support.converter.card;

import edu.odeyalo.college.coursework.dto.card.SimpleStudentCardInfo;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.support.converter.dormitory.GenericDormitoryInfoConverter;
import edu.odeyalo.college.coursework.support.converter.student.GenericStudentInfoConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {GenericStudentInfoConverter.class, GenericDormitoryInfoConverter.class},
        componentModel = "spring")
public interface SimpleStudentCardInfoConverter {

    @Mapping(source = "student", target = "studentInfo")
    SimpleStudentCardInfo toInfo(StudentCard studentCard);
}

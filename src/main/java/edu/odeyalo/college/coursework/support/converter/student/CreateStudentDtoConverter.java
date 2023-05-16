package edu.odeyalo.college.coursework.support.converter.student;

import edu.odeyalo.college.coursework.dto.student.CreateStudentDto;
import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.support.converter.group.FacultyGroupIdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FacultyGroupIdConverter.class, componentModel = "spring")
public interface CreateStudentDtoConverter {

    CreateStudentDto toDto(Student student);

    @Mapping(source = "groupId", target = "group")
    Student fromDto(CreateStudentDto studentDto);
}

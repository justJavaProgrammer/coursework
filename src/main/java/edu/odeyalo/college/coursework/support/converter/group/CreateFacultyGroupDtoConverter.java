package edu.odeyalo.college.coursework.support.converter.group;

import edu.odeyalo.college.coursework.dto.group.CreateFacultyGroupDto;
import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.support.converter.faculty.FacultyIdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FacultyIdConverter.class, componentModel = "spring")
public interface CreateFacultyGroupDtoConverter {

    @Mapping(source = "facultyId", target = "faculty")
    FacultyGroup toFacultyGroup(CreateFacultyGroupDto dto);

    @Mapping(target = "facultyId", source = "faculty.id")
    CreateFacultyGroupDto toDto(FacultyGroup facultyGroup);

}

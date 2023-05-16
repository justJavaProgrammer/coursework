package edu.odeyalo.college.coursework.support.converter.group;

import edu.odeyalo.college.coursework.dto.group.FacultyInfoAwareFacultyGroupDto;
import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.support.converter.faculty.GenericFacultyInfoConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = GenericFacultyInfoConverter.class, componentModel = "spring")
public interface FacultyInfoAwareFacultyGroupDtoConverter {

    @Mapping(source = "faculty", target = "genericFacultyInfo")
    FacultyInfoAwareFacultyGroupDto toDto(FacultyGroup facultyGroup);
}

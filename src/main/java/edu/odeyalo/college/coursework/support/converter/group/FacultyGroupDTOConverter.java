package edu.odeyalo.college.coursework.support.converter.group;

import edu.odeyalo.college.coursework.dto.group.FacultyGroupDTO;
import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.support.converter.faculty.FacultyIdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FacultyIdConverter.class, componentModel = "spring")
public interface FacultyGroupDTOConverter {

    FacultyGroup toFacultyGroup(FacultyGroupDTO dto);

    @Mapping(source = "id", target = "facultyId")
    FacultyGroupDTO toDto(FacultyGroup facultyGroup);
}

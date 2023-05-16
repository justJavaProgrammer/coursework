package edu.odeyalo.college.coursework.support.converter.faculty;

import edu.odeyalo.college.coursework.dto.faculty.FullFacultyDTO;
import edu.odeyalo.college.coursework.entity.Faculty;
import edu.odeyalo.college.coursework.support.converter.group.FacultyGroupDTOConverter;
import org.mapstruct.Mapper;

@Mapper(uses = FacultyGroupDTOConverter.class, componentModel = "spring")
public interface FacultyDTOConverter {

    Faculty toFaculty(FullFacultyDTO fullFacultyDTO);

    FullFacultyDTO toDto(Faculty faculty);
}

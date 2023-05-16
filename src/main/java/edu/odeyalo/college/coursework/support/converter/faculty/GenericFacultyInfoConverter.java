package edu.odeyalo.college.coursework.support.converter.faculty;

import edu.odeyalo.college.coursework.dto.faculty.GenericFacultyInfo;
import edu.odeyalo.college.coursework.entity.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericFacultyInfoConverter {

    GenericFacultyInfo toInfo(Faculty faculty);

    Faculty toFaculty(GenericFacultyInfo info);

}

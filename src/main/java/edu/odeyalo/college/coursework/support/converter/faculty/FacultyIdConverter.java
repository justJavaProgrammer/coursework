package edu.odeyalo.college.coursework.support.converter.faculty;

import edu.odeyalo.college.coursework.dto.faculty.FacultyId;
import edu.odeyalo.college.coursework.entity.Faculty;
import edu.odeyalo.college.coursework.exception.FacultyNotFoundException;
import edu.odeyalo.college.coursework.service.storage.FacultyService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FacultyIdConverter {

    @Autowired
    private FacultyService facultyService;

    public Faculty toFaculty(FacultyId facultyId) throws FacultyNotFoundException {
        return facultyService.getFacultyById(facultyId.getId());
    }

    @Mapping(target = "id", source = "id")
    public abstract FacultyId toDto(Faculty faculty);

    public abstract FacultyId toDto(Long id);
}

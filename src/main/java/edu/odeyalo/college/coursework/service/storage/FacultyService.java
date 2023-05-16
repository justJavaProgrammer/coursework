package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.Faculty;
import edu.odeyalo.college.coursework.exception.FacultyNotFoundException;

import java.util.List;

public interface FacultyService {
    Faculty getFacultyById(Long id) throws FacultyNotFoundException;

    List<Faculty> getAllFaculties();

    Faculty createFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty) throws FacultyNotFoundException;

    void deleteFaculty(Long id);
}

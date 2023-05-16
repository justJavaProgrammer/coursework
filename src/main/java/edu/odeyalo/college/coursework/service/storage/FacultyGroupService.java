package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.exception.FacultyGroupNotFoundException;

import java.util.List;

public interface FacultyGroupService {

    FacultyGroup getFacultyGroupById(Long id) throws FacultyGroupNotFoundException;

    List<FacultyGroup> getAllFacultyGroups();

    FacultyGroup createFacultyGroup(FacultyGroup facultyGroup);

    void updateFacultyGroup(Long id, FacultyGroup facultyGroup) throws FacultyGroupNotFoundException;

    void deleteFacultyGroup(Long id);
}

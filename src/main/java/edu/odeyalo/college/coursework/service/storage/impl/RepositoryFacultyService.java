package edu.odeyalo.college.coursework.service.storage.impl;

import edu.odeyalo.college.coursework.entity.Faculty;
import edu.odeyalo.college.coursework.exception.FacultyNotFoundException;
import edu.odeyalo.college.coursework.repository.FacultyRepository;
import edu.odeyalo.college.coursework.service.storage.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryFacultyService implements FacultyService {

    private final FacultyRepository facultyRepository;

    public RepositoryFacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty getFacultyById(Long id) throws FacultyNotFoundException {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty not found for id: " + id));
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) throws FacultyNotFoundException {
        Long id = faculty.getId();
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        if (facultyOptional.isEmpty()) {
            throw new FacultyNotFoundException("Faculty not found for id: " + id);
        }
        faculty.setId(id);
        facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}

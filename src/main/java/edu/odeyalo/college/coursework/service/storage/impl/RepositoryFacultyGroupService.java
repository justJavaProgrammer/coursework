package edu.odeyalo.college.coursework.service.storage.impl;

import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.exception.FacultyGroupNotFoundException;
import edu.odeyalo.college.coursework.repository.FacultyGroupRepository;
import edu.odeyalo.college.coursework.service.storage.FacultyGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryFacultyGroupService implements FacultyGroupService {


    private final FacultyGroupRepository facultyGroupRepository;

    public RepositoryFacultyGroupService(FacultyGroupRepository facultyGroupRepository) {
        this.facultyGroupRepository = facultyGroupRepository;
    }

    @Override
    public FacultyGroup getFacultyGroupById(Long id) throws FacultyGroupNotFoundException {
        return facultyGroupRepository.findById(id)
                .orElseThrow(() -> new FacultyGroupNotFoundException("Faculty group not found for id: " + id));
    }

    @Override
    public List<FacultyGroup> getAllFacultyGroups() {
        return facultyGroupRepository.findAll();
    }

    @Override
    public FacultyGroup createFacultyGroup(FacultyGroup facultyGroup) {
        return facultyGroupRepository.save(facultyGroup);
    }

    @Override
    public void updateFacultyGroup(Long id, FacultyGroup facultyGroup) throws FacultyGroupNotFoundException {
        Optional<FacultyGroup> facultyGroupOptional = facultyGroupRepository.findById(id);
        if (facultyGroupOptional.isEmpty()) {
            throw new FacultyGroupNotFoundException("Faculty group not found for id: " + id);
        }
        facultyGroup.setId(id);
        facultyGroupRepository.save(facultyGroup);
    }

    @Override
    public void deleteFacultyGroup(Long id) {
        facultyGroupRepository.deleteById(id);
    }
}

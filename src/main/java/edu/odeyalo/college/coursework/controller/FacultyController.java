package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.faculty.FullFacultyDTO;
import edu.odeyalo.college.coursework.dto.faculty.FacultySavedDto;
import edu.odeyalo.college.coursework.entity.Faculty;
import edu.odeyalo.college.coursework.exception.FacultyNotFoundException;
import edu.odeyalo.college.coursework.repository.FacultyRepository;
import edu.odeyalo.college.coursework.service.storage.FacultyService;
import edu.odeyalo.college.coursework.support.converter.faculty.FacultyDTOConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private final FacultyRepository facultyRepository;
    private final FacultyDTOConverter converter;
    private final FacultyService facultyService;

    public FacultyController(FacultyRepository facultyRepository, FacultyDTOConverter converter, FacultyService facultyService) {
        this.facultyRepository = facultyRepository;
        this.converter = converter;
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<?> getByID(@RequestParam Long id) throws FacultyNotFoundException {
        Faculty facultyById = facultyService.getFacultyById(id);
        return ResponseEntity.ok(converter.toDto(facultyById));
    }

    @GetMapping("/all")
    public ResponseEntity<?> fetchAll(Pageable pageable) {
        Page<Faculty> faculties = facultyRepository.findAll(pageable);

        List<FullFacultyDTO> response = faculties.stream().map(converter::toDto).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<FacultySavedDto> createFaculty(@RequestBody FullFacultyDTO dto) {
        Faculty faculty = facultyService.createFaculty(converter.toFaculty(dto));
        return ResponseEntity.ok(FacultySavedDto.saved(faculty));
    }
}

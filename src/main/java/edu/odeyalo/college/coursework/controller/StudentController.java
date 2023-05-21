package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.SearchResponse;
import edu.odeyalo.college.coursework.dto.student.CreateStudentDto;
import edu.odeyalo.college.coursework.dto.student.FacultyAwareStudentInfo;
import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.exception.StudentNotFoundException;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchRequest;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchResult;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchService;
import edu.odeyalo.college.coursework.service.storage.StudentService;
import edu.odeyalo.college.coursework.support.converter.student.CreateStudentDtoConverter;
import edu.odeyalo.college.coursework.support.converter.student.FacultyAwareStudentInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentSearchService studentSearchService;
    private final CreateStudentDtoConverter createStudentDtoConverter;
    private final FacultyAwareStudentInfoConverter facultyAwareStudentInfoConverter;

    @Autowired
    public StudentController(StudentSearchService studentSearchService, StudentService studentService, CreateStudentDtoConverter createStudentDtoConverter, FacultyAwareStudentInfoConverter facultyAwareStudentInfoConverter) {
        this.studentSearchService = studentSearchService;
        this.studentService = studentService;
        this.createStudentDtoConverter = createStudentDtoConverter;
        this.facultyAwareStudentInfoConverter = facultyAwareStudentInfoConverter;
    }


    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) throws StudentNotFoundException {
        Student student = studentService.findById(id);
        FacultyAwareStudentInfo info = facultyAwareStudentInfoConverter.toInfo(student);
        return ResponseEntity.ok(info);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(Pageable pageable) {
        List<FacultyAwareStudentInfo> info = studentSearchService.findAll(pageable)
                .getResult()
                .stream().map(facultyAwareStudentInfoConverter::toInfo)
                .toList();
        return ResponseEntity.ok(new SearchResponse(info));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody CreateStudentDto dto) {
        Student student = createStudentDtoConverter.fromDto(dto);

        student.setFaculty(student.getGroup().getFaculty());

        student = studentService.save(student);

        FacultyAwareStudentInfo body = facultyAwareStudentInfoConverter.toInfo(student);

        return ResponseEntity.ok(body);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "faculty_id", required = false) Long facultyId,
            @RequestParam(name = "group_id", required = false) Long groupId,
            Pageable pageable) {

        StudentSearchRequest searchRequest = StudentSearchRequest.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .facultyId(facultyId)
                .groupId(groupId)
                .build();

        StudentSearchResult result = studentSearchService.searchStudents(searchRequest, pageable);

        List<FacultyAwareStudentInfo> body = result.getResult().stream().map(facultyAwareStudentInfoConverter::toInfo).toList();

        return ResponseEntity.ok(new SearchResponse(body));
    }
}

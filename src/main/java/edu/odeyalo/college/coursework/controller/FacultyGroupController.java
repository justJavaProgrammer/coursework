package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.group.CreateFacultyGroupDto;
import edu.odeyalo.college.coursework.dto.group.FacultyInfoAwareFacultyGroupDto;
import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.exception.FacultyGroupNotFoundException;
import edu.odeyalo.college.coursework.service.storage.FacultyGroupService;
import edu.odeyalo.college.coursework.support.converter.group.CreateFacultyGroupDtoConverter;
import edu.odeyalo.college.coursework.support.converter.group.FacultyInfoAwareFacultyGroupDtoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class FacultyGroupController {

    private final FacultyGroupService groupService;

    private final CreateFacultyGroupDtoConverter converter;

    private final FacultyInfoAwareFacultyGroupDtoConverter facultyInfoAwareFacultyGroupDtoConverter;

    public FacultyGroupController(
            FacultyGroupService groupService, CreateFacultyGroupDtoConverter converter,
            FacultyInfoAwareFacultyGroupDtoConverter facultyInfoAwareFacultyGroupDtoConverter) {
        this.groupService = groupService;
        this.converter = converter;
        this.facultyInfoAwareFacultyGroupDtoConverter = facultyInfoAwareFacultyGroupDtoConverter;
    }

    @GetMapping()
    public ResponseEntity<?> getById(@RequestParam Long id) throws FacultyGroupNotFoundException {
        FacultyGroup group = groupService.getFacultyGroupById(id);
        FacultyInfoAwareFacultyGroupDto dto = facultyInfoAwareFacultyGroupDtoConverter.toDto(group);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<FacultyGroup> groups = groupService.getAllFacultyGroups();
        List<CreateFacultyGroupDto> dto = groups.stream().map(converter::toDto).toList();
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createFacultyGroup(@RequestBody CreateFacultyGroupDto dto) {
        FacultyGroup facultyGroup = converter.toFacultyGroup(dto);

        facultyGroup.getFaculty().addGroup(facultyGroup);

        groupService.createFacultyGroup(facultyGroup);

        FacultyInfoAwareFacultyGroupDto body = facultyInfoAwareFacultyGroupDtoConverter.toDto(facultyGroup);

        return ResponseEntity.ok(body);
    }
}

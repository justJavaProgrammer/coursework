package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.dormitory.CreateDormitoryDto;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.exception.DormitoryNotFoundException;
import edu.odeyalo.college.coursework.service.storage.DormitoryService;
import edu.odeyalo.college.coursework.support.converter.dormitory.CreateDormitoryDtoConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {

    private final CreateDormitoryDtoConverter converter;
    private final DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService, CreateDormitoryDtoConverter converter) {
        this.dormitoryService = dormitoryService;
        this.converter = converter;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchDormitory() {

        return null;
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) throws DormitoryNotFoundException {
        Dormitory dormitory = dormitoryService.getDormitoryById(id);
        return ResponseEntity.ok(dormitory);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(Pageable pageable) {
        List<Dormitory> dormitories = dormitoryService.getAllDormitories();
        return ResponseEntity.ok(dormitories);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDormitory(@Valid @RequestBody CreateDormitoryDto dto) {
        Dormitory dormitory = converter.fromDto(dto);
        dormitoryService.saveDormitory(dormitory);
        return ResponseEntity.ok(dormitory);
    }
}

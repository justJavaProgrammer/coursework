package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.dormitory.CreateDormitoryDto;
import edu.odeyalo.college.coursework.dto.dormitory.SearchDormitoryDto;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.exception.DormitoryNotFoundException;
import edu.odeyalo.college.coursework.service.search.dormitory.DormitorySearchRequest;
import edu.odeyalo.college.coursework.service.search.dormitory.DormitorySearchResult;
import edu.odeyalo.college.coursework.service.search.dormitory.DormitorySearchService;
import edu.odeyalo.college.coursework.service.storage.DormitoryService;
import edu.odeyalo.college.coursework.support.converter.card.GenericStudentCardInfoConverter;
import edu.odeyalo.college.coursework.support.converter.dormitory.CreateDormitoryDtoConverter;
import edu.odeyalo.college.coursework.support.converter.dormitory.StudentCardsAwareDormitoryInfoConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {

    private final CreateDormitoryDtoConverter converter;
    private final DormitoryService dormitoryService;
    private final DormitorySearchService dormitorySearchService;
    private final GenericStudentCardInfoConverter genericStudentCardInfoConverter;
    private final StudentCardsAwareDormitoryInfoConverter studentCardsAwareDormitoryInfoConverter;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService, CreateDormitoryDtoConverter converter, DormitorySearchService dormitorySearchService,
                               GenericStudentCardInfoConverter genericStudentCardInfoConverter,
                               StudentCardsAwareDormitoryInfoConverter studentCardsAwareDormitoryInfoConverter) {
        this.dormitoryService = dormitoryService;
        this.converter = converter;
        this.dormitorySearchService = dormitorySearchService;
        this.genericStudentCardInfoConverter = genericStudentCardInfoConverter;
        this.studentCardsAwareDormitoryInfoConverter = studentCardsAwareDormitoryInfoConverter;
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchDormitory(@RequestBody SearchDormitoryDto dormitorySearch, Pageable pageable) {
        DormitorySearchResult dormitories = dormitorySearchService.searchDormitories(dormitorySearch.toSearchRequest(), pageable);
        Map<String, Object> body = Map.of("count", dormitories.size(),
                "result", dormitories.getResult().stream().map(studentCardsAwareDormitoryInfoConverter::toInfo).toList());

        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) throws DormitoryNotFoundException {
        Dormitory dormitory = dormitoryService.getDormitoryById(id);
        return ResponseEntity.ok(dormitory);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(Pageable pageable) {
        DormitorySearchResult dormitories = dormitorySearchService.findAll(pageable);
        Map<String, Object> body = Map.of("count", dormitories.size(),
                "result", dormitories.getResult().stream().map(studentCardsAwareDormitoryInfoConverter::toInfo).toList());

        return ResponseEntity.ok(body);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDormitory(@Valid @RequestBody CreateDormitoryDto dto) {
        Dormitory dormitory = converter.fromDto(dto);
        dormitoryService.saveDormitory(dormitory);
        return ResponseEntity.ok(dormitory);
    }
}

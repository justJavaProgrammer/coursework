package edu.odeyalo.college.coursework.controller;

import edu.odeyalo.college.coursework.dto.SearchResponse;
import edu.odeyalo.college.coursework.dto.card.CreateStudentCardDto;
import edu.odeyalo.college.coursework.dto.card.GenericStudentCardInfo;
import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.exception.StudentCardNotFoundException;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchRequest;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchResult;
import edu.odeyalo.college.coursework.service.search.card.StudentCardSearchService;
import edu.odeyalo.college.coursework.service.search.student.StudentSearchRequest;
import edu.odeyalo.college.coursework.service.storage.StudentCardService;
import edu.odeyalo.college.coursework.support.converter.card.CreateStudentCardDtoConverter;
import edu.odeyalo.college.coursework.support.converter.card.GenericStudentCardInfoConverter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:
 * Мінімальний набір функціональних задач ІС :
 * Save everything to DB
 * 1. Видати список студентів потрібного факультету з указівкою номера
 *  * гуртожитку.
 * 2. Видати список гуртожитків з адресами
 * 3. .Видати кількість студентів, що мешкають у гуртожитку по кожному
 * факультеті.
 * 4. Показати студентів, яки проживають у обраном гуртожитку за
 * обраним номіром кімнати.
 */

@RestController
@RequestMapping("/cards")
public class StudentCardController {
    private final StudentCardService service;
    private final StudentCardSearchService studentCardSearchService;
    private final CreateStudentCardDtoConverter converter;
    private final GenericStudentCardInfoConverter genericStudentCardInfoConverter;

    public StudentCardController(StudentCardService service, StudentCardSearchService studentCardSearchService, CreateStudentCardDtoConverter converter, GenericStudentCardInfoConverter genericStudentCardInfoConverter) {
        this.service = service;
        this.studentCardSearchService = studentCardSearchService;
        this.converter = converter;
        this.genericStudentCardInfoConverter = genericStudentCardInfoConverter;
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(name = "dormitory_id", required = false) Long dormitoryId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "group_id", required = false) Long groupId,
            @RequestParam(name = "faculty_id", required = false) Long facultyId,
            @RequestParam(name = "dormitory_number", required = false) String dormitoryNumber,
            @RequestParam(name = "room_number", required = false) String roomNumber,
            Pageable pageable
    ) {

        StudentSearchRequest student = StudentSearchRequest.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .facultyId(facultyId)
                .groupId(groupId)
                .build();

        StudentCardSearchRequest request = new StudentCardSearchRequest(student, dormitoryId, facultyId, dormitoryNumber, roomNumber);

        StudentCardSearchResult result = studentCardSearchService.search(request, pageable);


        List<GenericStudentCardInfo> body = result.getResult().stream()
                .map(genericStudentCardInfoConverter::toInfo)
                .toList();

        return ResponseEntity.ok(new SearchResponse(body));
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) throws StudentCardNotFoundException {
        GenericStudentCardInfo cardInfo = genericStudentCardInfoConverter.toInfo(service.getStudentCardById(id));
        return ResponseEntity.ok(cardInfo);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<GenericStudentCardInfo> info = service.getAllStudentCards().stream().map(genericStudentCardInfoConverter::toInfo).toList();
        return ResponseEntity.ok(info);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<?> saveStudentCard(@RequestBody CreateStudentCardDto dto) {
        StudentCard card = converter.toStudentCard(dto);
        StudentCard studentCard = service.createStudentCard(card);

        return ResponseEntity.ok(genericStudentCardInfoConverter.toInfo(studentCard));
    }
}

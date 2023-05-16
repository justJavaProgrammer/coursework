package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.exception.StudentCardNotFoundException;

import java.util.List;

public interface StudentCardService {
    StudentCard getStudentCardById(Long id) throws StudentCardNotFoundException;

    List<StudentCard> getAllStudentCards();

    StudentCard createStudentCard(StudentCard studentCard);

    void updateStudentCard(StudentCard studentCard) throws StudentCardNotFoundException;

    void deleteStudentCard(Long id);
}

package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.exception.DormitoryNotFoundException;

import java.util.List;

public interface DormitoryService {
    Dormitory getDormitoryById(Long id) throws DormitoryNotFoundException;

    List<Dormitory> getAllDormitories();

    void saveDormitory(Dormitory dormitory);

    void updateDormitory(Dormitory dormitory) throws DormitoryNotFoundException;

    void deleteDormitory(Long id) throws DormitoryNotFoundException;
}

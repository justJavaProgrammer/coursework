package edu.odeyalo.college.coursework.support.converter.dormitory;

import edu.odeyalo.college.coursework.dto.dormitory.DormitoryNumber;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.repository.DormitoryRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DormitoryNumberConverter {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    public Dormitory toDormitory(DormitoryNumber number) {
        if (number.getNumber() == null) {
            return null;
        }
        return dormitoryRepository.findDormitoryByDormitoryNumber(number.getNumber())
                .orElse(null);
    }
}
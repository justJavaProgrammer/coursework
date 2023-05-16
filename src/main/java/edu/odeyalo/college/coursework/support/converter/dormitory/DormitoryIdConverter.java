package edu.odeyalo.college.coursework.support.converter.dormitory;

import edu.odeyalo.college.coursework.dto.dormitory.DormitoryId;
import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.repository.DormitoryRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DormitoryIdConverter {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    public Dormitory toDormitory(DormitoryId dormitoryId) {
        return dormitoryRepository.findById(dormitoryId.getId())
                .orElse(null);
    }
}

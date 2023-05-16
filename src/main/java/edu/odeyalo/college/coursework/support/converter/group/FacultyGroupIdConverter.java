package edu.odeyalo.college.coursework.support.converter.group;

import edu.odeyalo.college.coursework.dto.group.FacultyGroupId;
import edu.odeyalo.college.coursework.entity.FacultyGroup;
import edu.odeyalo.college.coursework.service.storage.FacultyGroupService;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class FacultyGroupIdConverter {

    @Autowired
    private FacultyGroupService groupService;

    @SneakyThrows
    public FacultyGroup toEntity(FacultyGroupId groupId) {
        Long id = groupId.getId();
        return groupService.getFacultyGroupById(id);
    }

    @Mapping(source = "id", target = "id")
    public abstract FacultyGroupId toWrapper(FacultyGroup facultyGroup);

    public abstract FacultyGroupId toWrapper(Long id);
}

package edu.odeyalo.college.coursework.support.converter.student;

import edu.odeyalo.college.coursework.dto.student.FacultyAwareStudentInfo;
import edu.odeyalo.college.coursework.entity.Student;
import edu.odeyalo.college.coursework.support.converter.faculty.GenericFacultyInfoConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = GenericFacultyInfoConverter.class, componentModel = "spring")
public interface FacultiyAwareStudentInfoConverter {

    @Mapping(source = "group.faculty", target = "facultyInfo")
    FacultyAwareStudentInfo toInfo(Student student);

    Student toStudent(FacultyAwareStudentInfo info);

}

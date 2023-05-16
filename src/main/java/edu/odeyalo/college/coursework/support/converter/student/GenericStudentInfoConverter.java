package edu.odeyalo.college.coursework.support.converter.student;

import edu.odeyalo.college.coursework.dto.student.GenericStudentInfo;
import edu.odeyalo.college.coursework.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericStudentInfoConverter {

    GenericStudentInfo toInfo(Student student);

    Student toStudent(GenericStudentInfo info);

}

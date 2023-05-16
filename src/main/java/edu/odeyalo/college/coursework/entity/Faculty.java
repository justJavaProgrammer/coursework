package edu.odeyalo.college.coursework.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Table(name = "faculties")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Faculty extends BaseEntity {
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @Column(name = "faculty_code", nullable = false, unique = true)
    private String facultyCode;

    @Column(name = "deanery_phone", nullable = false)
    private String deaneryPhone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "faculty_groups")
    @JoinColumn(name = "group_id", nullable = false)
    @ToString.Exclude
    @Singular
    private List<FacultyGroup> groups = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "faculty_students")
    @JoinColumn(name = "student_id", nullable = false)
    @ToString.Exclude
    @Singular
    private List<Student> students;

    public void addGroup(FacultyGroup facultyGroup) {
        facultyGroup.setFaculty(this);
        groups.add(facultyGroup);
    }

    public void addStudent(Student student) {
//        student.getFaculties().add(this);
        students.add(student);
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

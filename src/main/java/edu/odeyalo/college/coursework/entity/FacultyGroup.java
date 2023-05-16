package edu.odeyalo.college.coursework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Table(name = "groups")
@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FacultyGroup extends BaseEntity {
    @Column(name = "group_cipher", nullable = false, unique = true)
    private String cipher;

    @Column(name = "group_code", nullable = false, unique = true)
    private String groupCode;

    @ManyToOne
    @JoinColumn(name = "associated_faculty", nullable = false)
    private Faculty faculty;

    @OneToMany
    @JoinTable(name = "group_students")
    @JoinColumn(name = "students")
    @ToString.Exclude
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
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

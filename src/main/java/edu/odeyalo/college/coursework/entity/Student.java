package edu.odeyalo.college.coursework.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends Person {
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
    @JoinColumn(name = "faculty_id")
    @OneToOne
    private Faculty faculty;
    // Contains information about group where current student studies
    @JoinColumn(name = "associated_group")
    @OneToOne
    private FacultyGroup group;
}
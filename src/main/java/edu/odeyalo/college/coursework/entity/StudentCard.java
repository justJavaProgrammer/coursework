package edu.odeyalo.college.coursework.entity;

import edu.odeyalo.college.coursework.entity.address.Address;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class StudentCard extends BaseEntity {
    @JoinColumn(name = "student_id", nullable = false, unique = true, updatable = false)
    @OneToOne
    private Student student;
    @JoinColumn(name = "parents_address_id", nullable = false)
    @OneToOne
    private Address parentsAddress;
    @JoinColumn(name = "dormitory_id", nullable = false)
    @OneToOne
    private Dormitory dormitory;
    @Column(name = "room_number", nullable = false)
    private String roomNumber;
}

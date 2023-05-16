package edu.odeyalo.college.coursework.entity;

import edu.odeyalo.college.coursework.entity.address.Address;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Dormitory extends BaseEntity {
    @Column(name = "dormitory_number", nullable = false)
    private String dormitoryNumber;
    @JoinColumn(name = "address", nullable = false)
    @OneToOne
    private Address address;
    /**
     * A generic phone number for the dormitory that is not associated with a specific commandant.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    @JoinTable(name = "registered_student_cards")
    @JoinColumn(name = "student_card_id", nullable = false)
    @OneToMany
    @Singular
    private List<StudentCard> studentCards = new ArrayList<>();

    @OneToOne(mappedBy = "dormitory")
    @JoinColumn(name = "commandant")
    private Commandant commandant;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

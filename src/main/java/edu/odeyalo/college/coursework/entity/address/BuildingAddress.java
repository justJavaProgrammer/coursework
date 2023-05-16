package edu.odeyalo.college.coursework.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BuildingAddress extends Address {
    @Column(name = "number", nullable = false)
    private String number;

    public BuildingAddress(String street, String country, String zipCode, String state) {
        super(street, country, zipCode, state);
    }
}

package edu.odeyalo.college.coursework.entity.address;

import edu.odeyalo.college.coursework.entity.BaseEntity;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Address extends BaseEntity {
    @Column(name = "street", nullable = false)
    protected String street;
    @Column(name = "country", nullable = false)
    protected String country;
    @Column(name = "zip_code", nullable = false)
    protected String zipCode;
    @Column(name = "state", nullable = false)
    protected String state;
}

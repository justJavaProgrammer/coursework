package edu.odeyalo.college.coursework.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ApartmentAddress extends Address {
    @Column(name = "apartment_number", nullable = false)
    private String apartmentNumber;
    @Column(name = "entrance", nullable = false)
    private String entrance;

    public ApartmentAddress() {}

    public ApartmentAddress(String street, String country, String zipCode, String state, String apartmentNumber, String entrance) {
        super(street, country, zipCode, state);
        this.apartmentNumber = apartmentNumber;
        this.entrance = entrance;
    }

    public ApartmentAddress(String apartmentNumber, String entrance) {
        this.apartmentNumber = apartmentNumber;
        this.entrance = entrance;
    }

    protected ApartmentAddress(ApartmentAddressBuilder<?, ?> b) {
        super(b);
        this.apartmentNumber = b.apartmentNumber;
        this.entrance = b.entrance;
    }
}

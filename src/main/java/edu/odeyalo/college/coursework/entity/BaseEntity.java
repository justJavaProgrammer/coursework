package edu.odeyalo.college.coursework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import java.util.Objects;
import java.util.UUID;

@SuperBuilder
@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NaturalId
    @Column(name = "business_key", unique = true, nullable = false)
    protected String businessKey;

    public BaseEntity() {
        this.businessKey = UUID.randomUUID().toString();
    }

    public BaseEntity(Long id) {
        this.id = id;
        this.businessKey = UUID.randomUUID().toString();
    }

    public BaseEntity(Long id, String businessKey) {
        this.id = id;
        this.businessKey = businessKey;
    }

    protected BaseEntity(BaseEntityBuilder<?, ?> builder) {
        if (builder.businessKey == null) {
            builder.businessKey = UUID.randomUUID().toString();
        }
        this.id = builder.id;
        this.businessKey = builder.businessKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return getBusinessKey() != null && Objects.equals(getBusinessKey(), that.getBusinessKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessKey);
    }
}
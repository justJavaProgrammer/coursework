CREATE TABLE student(
    id BIGINT NOT NULL PRIMARY KEY,
    business_key varchar(255) NOT NULL UNIQUE,
    birthdate DATE NOT NULL,
    faculty_id BIGINT NOT NULL,
    associated_group BIGINT NOT NULL,

    CONSTRAINT person_fk FOREIGN KEY(id) REFERENCES person(id),
    CONSTRAINT faculty_id_fk FOREIGN KEY(faculty_id) REFERENCES faculties(id),
    CONSTRAINT faculty_group_id FOREIGN KEY (associated_group) REFERENCES groups(id)
)
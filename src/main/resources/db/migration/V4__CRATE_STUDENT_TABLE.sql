CREATE TABLE student(
    id bigserial NOT NULL PRIMARY KEY,
    birthdate DATE NOT NULL,
    faculty_id BIGINT NOT NULL,
    associated_group BIGINT NOT NULL,

    CONSTRAINT person_fk FOREIGN KEY(id) REFERENCES person(id),
    CONSTRAINT faculty_id_fk FOREIGN KEY(faculty_id) REFERENCES faculties(id),
    CONSTRAINT faculty_group_id FOREIGN KEY (associated_group) REFERENCES groups(id)
)
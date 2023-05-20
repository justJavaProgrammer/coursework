-- Migration is used to create One-to-Many relationship between the faculty and faculty groups

CREATE TABLE faculty_groups (
    faculty_id bigserial NOT NULL,
    groups_id bigserial NOT NULL UNIQUE,


    CONSTRAINT faculty_id_fk FOREIGN KEY (faculty_id) REFERENCES faculties(id),
    CONSTRAINT faculty_group_id_fk FOREIGN KEY (groups_id) REFERENCES groups(id)
)
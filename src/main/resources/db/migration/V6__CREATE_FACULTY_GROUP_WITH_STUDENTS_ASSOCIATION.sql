-- Migration is used to create One-to-Many relationship between the faculty group and students

CREATE TABLE group_students (
    faculty_group_id bigserial NOT NULL,
    students_id bigserial NOT NULL UNIQUE,


    CONSTRAINT group_id_fk FOREIGN KEY (faculty_group_id) REFERENCES groups(id),
    CONSTRAINT student_id_fk FOREIGN KEY (students_id) REFERENCES student(id)
)
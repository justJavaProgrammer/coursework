-- Migration is used to create One-to-Many relationship between the faculty and students

CREATE TABLE faculty_students (
    faculty_id bigserial NOT NULL,
    students_id bigserial NOT NULL UNIQUE,


    CONSTRAINT faculty_id_fk FOREIGN KEY (faculty_id) REFERENCES faculties(id),
    CONSTRAINT student_id_fk FOREIGN KEY (students_id) REFERENCES student(id)
)
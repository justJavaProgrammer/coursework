CREATE TABLE registered_student_cards(
    dormitory_id bigserial NOT NULL,
    student_cards_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT dormitory_id_fk FOREIGN KEY (dormitory_id) REFERENCES dormitory (id),
    CONSTRAINT student_cards_id_fk FOREIGN KEY (student_cards_id) REFERENCES student(id)
)
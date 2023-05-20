CREATE TABLE student_card (
    id bigserial PRIMARY KEY,
    business_key varchar(255) NOT NULL UNIQUE,
    room_number varchar(255) NOT NULL,
    dormitory_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL UNIQUE,
    parents_address_id BIGINT NOT NULL,

    CONSTRAINT dormitory_id_fk FOREIGN KEY (dormitory_id) REFERENCES dormitory(id),
    CONSTRAINT student_id_fk FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT parents_address_id_fk FOREIGN KEY (parents_address_id) REFERENCES address(id)
)
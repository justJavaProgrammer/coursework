CREATE TABLE apartment_address (
    id bigserial NOT NULL,
    entrance varchar(255) NOT NULL,
    apartment_number varchar(255) NOT NULL,

    CONSTRAINT address_id_fk FOREIGN KEY(id) REFERENCES address(id)
)
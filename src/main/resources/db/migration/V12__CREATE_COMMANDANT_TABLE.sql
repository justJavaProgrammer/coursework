CREATE TABLE commandant (
    id bigserial NOT NULL PRIMARY KEY,
    phone_number varchar NOT NULL,
    dormitory BIGINT NOT NULL,

    CONSTRAINT dormitory_id_fk FOREIGN KEY (dormitory) REFERENCES dormitory(id)
)
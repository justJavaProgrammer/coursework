CREATE TABLE building_address(
    id     bigserial       NOT NULL,
    number varchar(255) NOT NULL,

    CONSTRAINT address_id_fk FOREIGN KEY (id) REFERENCES address (id)
)
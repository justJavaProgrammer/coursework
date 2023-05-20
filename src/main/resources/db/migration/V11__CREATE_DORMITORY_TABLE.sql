CREATE TABLE dormitory(
    id BIGINT PRIMARY KEY,
    business_key varchar(255) NOT NULL UNIQUE,
    dormitory_number varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    address BIGINT NOT NULL,

    CONSTRAINT address_id_fk FOREIGN KEY(address) REFERENCES address(id)
)
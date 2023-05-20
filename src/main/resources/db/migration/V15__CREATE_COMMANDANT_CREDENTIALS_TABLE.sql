CREATE TABLE commandant_credentials (
    id bigserial PRIMARY KEY,
    business_key  varchar(255) NOT NULL UNIQUE,
    commandant_id BIGINT NOT NULL UNIQUE,
    username varchar(255),
    password varchar(3000),

    CONSTRAINT commandant_id_fk FOREIGN KEY (commandant_id) REFERENCES commandant(id)
)
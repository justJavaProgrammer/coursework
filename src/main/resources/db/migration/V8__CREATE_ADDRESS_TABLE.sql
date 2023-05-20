CREATE TABLE address (
    id           bigserial PRIMARY KEY,
    business_key varchar(255) NOT NULL UNIQUE,
    street       varchar(255) NOT NULL,
    country      varchar(255) NOT NULL,
    zip_code     varchar(255) NOT NULL,
    state        varchar(255)
)
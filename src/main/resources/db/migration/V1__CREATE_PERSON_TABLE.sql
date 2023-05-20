  CREATE TABLE person(
    id BIGINT PRIMARY KEY,
    business_key varchar(255) NOT NULL UNIQUE,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    patronymic varchar(255) NOT NULL
)
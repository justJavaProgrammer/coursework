CREATE TABLE groups (
    id bigserial PRIMARY KEY,
    business_key  varchar(255) NOT NULL UNIQUE,
    group_cipher varchar(255) NOT NULL UNIQUE,
    group_code varchar(255) NOT NULL UNIQUE,
    associated_faculty BIGINT,

    CONSTRAINT associated_faculty_fk FOREIGN KEY(associated_faculty) REFERENCES faculties(id)
)
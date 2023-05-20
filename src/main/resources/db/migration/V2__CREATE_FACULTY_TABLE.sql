CREATE TABLE faculties (
    id            bigserial PRIMARY KEY,
    business_key  varchar(255) NOT NULL UNIQUE,
    faculty_name  varchar(255) NOT NULL,
    faculty_code  varchar(255) NOT NULL UNIQUE,
    deanery_phone varchar(255) NOT NULL
)
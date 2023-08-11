CREATE TABLE "users"(
    id serial primary key,
    uuid varchar not null,
    login varchar not null,
    email varchar not null,
    password varchar not null,
    role varchar not null,
    islock boolean DEFAULT true,
    isenabled boolean DEFAULT false
)
CREATE TABLE "users"(
    id serial primary key,
    uuid varchar not null,
    login varchar not null,
    email varchar not null,
    password varchar not null,
    role varchar not null,
    is_lock boolean DEFAULT true,
    is_enabled boolean DEFAULT false
)
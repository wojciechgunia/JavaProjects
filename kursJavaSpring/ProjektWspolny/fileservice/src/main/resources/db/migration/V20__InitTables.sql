CREATE TABLE "image_data"
(
    id serial PRIMARY KEY,
    uid varchar not null,
    path varchar not null,
    isused boolean not null DEFAULT FALSE,
    createat DATE not null
)
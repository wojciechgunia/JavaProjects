CREATE TABLE "resetopetations"
(
    id serial primary key,
    user integer REFERENCES "users" (id),
    createdate timestamp DEFAULT current_timestamp,
    uid varchar
)
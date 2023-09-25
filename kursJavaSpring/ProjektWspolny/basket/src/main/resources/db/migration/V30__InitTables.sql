CREATE TABLE "basket"
(
    id serial primary key,
    uuid varchar not null
);

CREATE TABLE "basket_items"
(
    id serial primary key,
    uuid varchar not null,
    product varchar not null,
    basket integer REFERENCES basket(id),
    quantity int not null DEFAULT 1
)
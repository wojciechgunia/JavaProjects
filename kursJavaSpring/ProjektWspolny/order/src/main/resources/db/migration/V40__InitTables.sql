CREATE TABLE deliver
(
    id serial primary key,
    uuid varchar not null,
    name varchar not null,
    price decimal not null
);

CREATE TABLE orders
(
    id serial primary key,
    uuid varchar not null,
    orders varchar not null,
    status varchar not null,
    firstname varchar not null,
    lastname varchar not null,
    phone varchar not null,
    email varchar not null,
    city varchar not null,
    street varchar not null,
    number varchar not null,
    postcode varchar not null,
    client  varchar,
    deliver integer REFERENCES "deliver" (id)
);

CREATE TABLE order_items
(
    id serial primary key,
    uuid varchar not null,
    name varchar not null,
    product varchar not null,
    priceunit decimal DEFAULT 0,
    pricesummary decimal DEFAULT 0,
    quantity bigint DEFAULT 1,
    orders bigint REFERENCES orders(id)
);

insert into deliver values (1, 'DPD', 'Kurier DPD',14.90);
insert into deliver values (2, 'InPost', 'Kurier InPost',12.90);
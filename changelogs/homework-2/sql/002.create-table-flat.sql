create table rent.flat (
    flat_id serial primary key,
    description VARCHAR(520) not null ,
    house_location VARCHAR(200) not null ,
    address VARCHAR(200) not null,
    rooms_amount INTEGER not null,
    time_built TIMESTAMP
);
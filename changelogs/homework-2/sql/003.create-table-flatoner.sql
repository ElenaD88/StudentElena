create table rent.flatOwner (
    flat_owner_id SERIAL primary key,
    first_name VARCHAR(30) not null,
    surname VARCHAR(30),
    email VARCHAR(255) not null
   );

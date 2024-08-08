CREATE TABLE rent.announcement (
    announcement_id SERIAL PRIMARY KEY,
    price INTEGER,
    flat_id INTEGER,
    flat_owner_id INTEGER,
    FOREIGN KEY (flat_id) REFERENCES rent.flat(flat_id),
    FOREIGN KEY (flat_owner_id) REFERENCES rent.flatOwner(flat_owner_id)
);
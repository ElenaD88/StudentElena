CREATE SCHEMA cd;

CREATE TABLE cd.members (
    memid INTEGER PRIMARY KEY,
    surname VARCHAR(200),
    firstname VARCHAR(200),
    address VARCHAR(300),
    zipcode INTEGER,
    telephone VARCHAR(20),
    recommendedby INTEGER,
    joindate TIMESTAMP
);

INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) VALUES
(1, 'Иванов', 'Иван', 'Улица Пушкина, дом 1', 123456, '123-456-7890', NULL, '2023-01-15 10:00:00'),
(2, 'Петров', 'Петр', 'Улица Лермонтова, дом 2', 654321, '098-765-4321', 1, '2023-02-20 11:30:00'),
(3, 'Сидоров', 'Сидор', 'Улица Гоголя, дом 3', 112233, '555-555-5555', 2, '2023-03-05 14:45:00'),
(4, 'Кузнецов', 'Алексей', 'Улица Чехова, дом 4', 445566, '444-444-4444', NULL, '2023-04-10 09:15:00'),
(5, 'Смирнова', 'Анна', 'Улица Толстого, дом 5', 778899, '333-333-3333', 1, '2023-05-25 16:30:00');


CREATE TABLE cd.facilities (
    facid INTEGER PRIMARY KEY,
    name VARCHAR(200),
    membercost NUMERIC,
    guestcost NUMERIC,
    initialoutlay NUMERIC,
    monthlymaintenance NUMERIC
);

INSERT INTO cd.facilities (facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) VALUES
(1, 'Tennis Court 1', 5.00, 20.00, 2000.00, 50.00),
(2, 'Tennis Court 2', 5.00, 20.00, 2000.00, 50.00),
(3, 'Badminton Court', 3.00, 15.00, 1500.00, 30.00),
(4, 'Swimming Pool', 10.00, 25.00, 5000.00, 100.00),
(5, 'Gym', 7.50, 15.00, 3000.00, 75.00);


CREATE TABLE cd.bookings (
    bookingid SERIAL PRIMARY KEY,
    facid INTEGER REFERENCES cd.facilities(facid),
    memid INTEGER REFERENCES cd.members(memid),
    starttime TIMESTAMP,
    slots INTEGER
);

INSERT INTO cd.bookings (facid, memid, starttime, slots) VALUES
(1, 1, '2023-10-01 10:00:00', 2),
(2, 5, '2023-10-01 11:00:00', 4),
(3, 4, '2023-10-01 12:00:00', 1),
(4, 3, '2023-10-01 13:00:00', 3),
(5, 2, '2023-10-01 14:00:00', 5);

select firstname, surname, joindate
	from cd.members
	where joindate =(select max(joindate)
			from cd.members);
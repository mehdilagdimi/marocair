-- Cliant table
CREATE TABLE client
(
    id       serial PRIMARY KEY,
    code     serial UNIQUE       NOT NULL,
    fullname VARCHAR(50) UNIQUE  NOT NULL,
    password VARCHAR(50)         NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL,
    phone    VARCHAR(100) UNIQUE NOT NULL
);

-- Admin table
CREATE TABLE admin
(
    id       serial PRIMARY KEY,
    code     serial UNIQUE       NOT NULL,
    fullname VARCHAR(50) UNIQUE  NOT NULL,
    password VARCHAR(50)         NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL,
    phone    VARCHAR(100) UNIQUE NOT NULL
);

-- Passanger table
CREATE TABLE passanger
(
    id       serial PRIMARY KEY,
    fullname VARCHAR(50) UNIQUE NOT NULL
);

-- Flight table
CREATE TABLE flight
(
    id              serial PRIMARY KEY,
    _from VARCHAR(100) NOT NULL,
    _to VARCHAR(100) NOT NULL,
    nbr_of_seats    Integer   NOT NULL DEFAULT 33,
    available_seats Integer   NOT NULL,
    depart_time     TIMESTAMP NOT NULL,
    arrival_time    TIMESTAMP NOT NULL
);

-- Reservation table
CREATE TABLE reservation
(
    id           serial PRIMARY KEY,
    client_id    Integer   NOT NULL,
    passanger_id Integer   NOT NULL,
    created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (client_id)
        REFERENCES client (id)
        ON DELETE CASCADE ON UPDATE CASCADE,

    FOREIGN KEY (passanger_id)
        REFERENCES passanger (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE reservation
    ADD flight_id Integer;

ALTER TABLE reservation
    ADD CONSTRAINT fk_reservation_flight
        FOREIGN KEY (flight_id)
            REFERENCES flight (id)
            ON DELETE CASCADE ON UPDATE CASCADE;

-- Extra table
CREATE TABLE extra
(
    id    serial PRIMARY KEY,
    name  VARCHAR(50) NOT NULL,
    price REAL        NOT NULL
);

CREATE TABLE ReservationExtra
(
    id             serial PRIMARY KEY,
    extra_id       Integer NOT NULL,
    reservation_id Integer NOT NULL,

    FOREIGN KEY (extra_id)
        REFERENCES extra (id)
        ON DELETE CASCADE ON UPDATE CASCADE,

    FOREIGN KEY (reservation_id)
        REFERENCES reservation (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);







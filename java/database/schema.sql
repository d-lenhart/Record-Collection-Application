BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS album;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE album (
    album_id SERIAL,
    release_date date,
    artist varchar(200) NOT NULL,
    title varchar(300) NOT NULL,
    number_of_tracks int,
    genre varchar(100),
    notes varchar(100000),
    play_time time,
    CONSTRAINT PK_album PRIMARY KEY(album_id)
);

COMMIT TRANSACTION;

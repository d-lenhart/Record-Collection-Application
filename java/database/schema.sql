BEGIN TRANSACTION;

DROP TABLE IF EXISTS album_library;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS album_collection;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE album_library (
    album_id SERIAL,
    user_id int,
    release_date date,
    artist varchar(200) NOT NULL,
    title varchar(300) NOT NULL,
    number_of_tracks int,
    genre varchar(100),
    notes varchar(100000),
    play_time time,
    CONSTRAINT PK_album_library PRIMARY KEY(album_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES user(user_id)

);

CREATE TABLE collection (
    collection_id SERIAL,
    title varchar(200) NOT NULL,
    is_public boolean,
    notes varchar(10000),
    CONSTRAINT PK_collection PRIMARY KEY(collection_id)
);

CREATE TABLE album_collection (
    album_id int,
    collection_id int,
    CONSTRAINT FK_album_collection_album_id FOREIGN KEY (album_id) REFERENCES album_library(album_id),
    CONSTRAINT FK_album_collection_collection_id FOREIGN KEY (collection_id) REFERENCES collection(collection_id)
);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Dane','$2a$10$1.POq80ChZnzaT4urzfp5eao9wN6fBpQVwPnUpzO4Ss7zGW3n90g.','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Robert','$2a$10$xSLMZTWeBHXXboIi01QmIOMzg4NxQYEw0zoOb.ZjDMzGI9YzXlSQi','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Jimmy','$2a$10$nuOBqDe5fa81v88ZNOBDSO0pBTZ.XH/xEvTzesA8t0kTd35SAenYe','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('John Paul','$2a$10$HhgLDrA10oeSigwJGy4EOuAjv4Q8oY6.yCDdueTjJSD0Gi0sbe3G6','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('John','$2a$10$VCeekjElnyi9nT4El2yPZOV00YKwQAtqNbaMMKFVt5MesQLmU.xw2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Roger','$2a$10$qJQSJIi1dTLr55u5Q.ejPOa8OowA4UssqQQP0To5x47R9.p09aqnq','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('David','$2a$10$4Zdq22dxIINLlt0TroQdTuu0/h.QGdTY84hBAw1YG7isxOdzl791q','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Richard','$2a$10$5.1hIGNeD1an9G8CIgCvvukYA58bWP1aFFJZayCUkzBKA3kau0eK6','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Nick','$2a$10$sRQXSeXEfm.KcI9cR3fJY.HEC5IqwPjLWFSH1b1TIOSCIgKPfJGCK','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Syd','$2a$10$TRzljdmBwFKImb7gVNe9xOr9plwpHrKrOn56s1snIcAwnOb0wIJT.','ROLE_USER');

INSERT INTO album_library (user_id,artist,title,genre,play_time,notes,release_date,number_of_tracks) VALUES (4,'Muddy Waters','Can''t Get No Grindin''','Blues','00:35:29','I''d totally rip off every one of these tracks','1973-08-01',10);
INSERT INTO album_library (user_id,artist,title,genre,play_time,release_date,number_of_tracks) VALUES (4,'Muddy Waters','Folk Singer','Blues','00:34:24','1964-01-30',9);
INSERT INTO album_library (user_id,artist,title,genre,play_time,release_date,number_of_tracks) VALUES (4,'Muddy Waters','Muddy Waters At Newport 1960','Blues','00:34:28','1960-11-15',9);

INSERT INTO collection (user_id,title,is_public,notes) VALUES (4,'Muddy Waters',true,'One of a kind');

INSERT INTO album_collection (album_id, collection_id) VALUES (1, 1);
INSERT INTO album_collection (album_id, collection_id) VALUES (2, 1);
INSERT INTO album_collection (album_id, collection_id) VALUES (3, 1);

COMMIT TRANSACTION;

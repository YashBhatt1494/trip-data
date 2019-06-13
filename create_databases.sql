
create database trip_data;
 CREATE TABLE places (place_id BIGINT(20) NOT NULL AUTO_INCREMENT,place_name VARCHAR(200),state    VARCHAR(200),address VARCHAR(300), PRIMARY KEY (place_id))ENGINE = innodb DEFAULT CHARSET = utf8;
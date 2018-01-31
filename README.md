# Delphino java application

## Requirements
JVM, SDK 1.8
Postgres database
Postgres JDBC Driver

## Guide
1. First, you have to configure a file config.properties as you prefer and place it in the root's project.

2. Then you have to place a jdbc driver in a folder /lib under the root's project.

3. Now you are ready to go, with our application.

#### config.properties Example
  
  USER = postgres
  
  PASSWORD = postgres
  
  DB_URL = jdbc:postgresql://localhost:5432/databasename
  
  DRIVER_CLASS_NAME = org.postgresql.Driver
  
#### sql query to create tables

CREATE TABLE building
(
  id   SERIAL      NOT NULL
    CONSTRAINT building_pkey
    PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  area VARCHAR(20) NOT NULL,
  CONSTRAINT name_area
  UNIQUE (name, area)
);

CREATE TABLE features
(
  id          SERIAL      NOT NULL
    CONSTRAINT features_pkey
    PRIMARY KEY,
  name        VARCHAR(20) NOT NULL,
  description VARCHAR(30)
);

CREATE UNIQUE INDEX features_name_uindex
  ON features (name);

create table if not exists room
(
	id serial not null
		constraint room_pkey
			primary key,
	name varchar(20) not null,
	type varchar(20) not null,
	seats integer,
	board varchar(20),
	projectors integer,
	computers integer,
	teacher_desk boolean,
	building varchar(30) not null,
	area varchar(20)
)
;


CREATE TABLE room_feature
(
  room    INTEGER NOT NULL
    CONSTRAINT room_fk
    REFERENCES room,
  feature INTEGER NOT NULL
    CONSTRAINT feature_fk
    REFERENCES features,
  CONSTRAINT room_feature_room_feature_pk
  PRIMARY KEY (room, feature)
);


CREATE TABLE template_room
(
  name_template VARCHAR(20) NOT NULL
    CONSTRAINT template_room_name_model_pk
    PRIMARY KEY
    CONSTRAINT template_room_name_model_key
    UNIQUE,
  seats         INTEGER,
  board         VARCHAR(20),
  projectors    INTEGER,
  computers     INTEGER,
  teacher_desk  BOOLEAN
);

CREATE TABLE "user"
(
  name     VARCHAR(30) NOT NULL,
  surname  VARCHAR(30) NOT NULL,
  email    VARCHAR(30) NOT NULL
    CONSTRAINT user_pkey
    PRIMARY KEY,
  password VARCHAR(30) NOT NULL,
  type     VARCHAR(20) NOT NULL
);



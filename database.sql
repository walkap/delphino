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

CREATE TABLE room
(
  id           SERIAL      NOT NULL
    CONSTRAINT room_pkey
    PRIMARY KEY,
  name         VARCHAR(20) NOT NULL,
  type         VARCHAR(20) NOT NULL,
  seats        INTEGER,
  board        VARCHAR(20),
  projectors   INTEGER,
  computers    INTEGER,
  teacher_desk BOOLEAN,
  building     INTEGER     NOT NULL,
  CONSTRAINT room_id_name_pk
  UNIQUE (name, building)
);

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
  id           SERIAL      NOT NULL
  CONSTRAINT template_room_pkey
  PRIMARY KEY,
  name_model   VARCHAR(20) NOT NULL
  CONSTRAINT template_room_name_model_key
  UNIQUE,
  seats        INTEGER,
  board        VARCHAR(20),
  projectors   INTEGER,
  computers    INTEGER,
  teacher_desk BOOLEAN
);




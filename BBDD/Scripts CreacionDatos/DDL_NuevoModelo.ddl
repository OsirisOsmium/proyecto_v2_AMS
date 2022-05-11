-- Generado por Oracle SQL Developer Data Modeler 21.4.2.059.0838
--   en:        2022-05-11 18:20:46 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE battle (
    id_battle          INTEGER NOT NULL,
    user_id_user       INTEGER NOT NULL,
    enemy_id_enemy     INTEGER NOT NULL,
    planet_id_planet   INTEGER NOT NULL,
    report_stepbystep  LONG NOT NULL,
    user_winner        CHAR(1) NOT NULL,
    enemy_winner       CHAR(1) NOT NULL,
    waste_metal        NUMBER NOT NULL,
    waste_deuterium    NUMBER NOT NULL,
    ui_lighthunter     INTEGER DEFAULT 0,
    ui_heavyhunter     INTEGER DEFAULT 0,
    ui_battleship      INTEGER DEFAULT 0,
    ui_armoredship     INTEGER DEFAULT 0,
    ui_missilelauncher INTEGER DEFAULT 0,
    ui_ioncannon       INTEGER DEFAULT 0,
    ui_plasmacannon    INTEGER DEFAULT 0,
    uf_lighthunter     INTEGER DEFAULT 0,
    uf_heavyhunter     INTEGER DEFAULT 0,
    uf_battleship      INTEGER DEFAULT 0,
    uf_armoredship     INTEGER DEFAULT 0,
    uf_missilelauncher INTEGER DEFAULT 0,
    uf_ioncannon       INTEGER DEFAULT 0,
    uf_plasmacannon    INTEGER DEFAULT 0,
    ei_lighthunter     INTEGER DEFAULT 0,
    ei_heavyhunter     INTEGER DEFAULT 0,
    ei_battleship      INTEGER DEFAULT 0,
    ei_armoredship     INTEGER DEFAULT 0,
    ei_missilelauncher INTEGER DEFAULT 0,
    ei_ioncannon       INTEGER DEFAULT 0,
    ei_plasmacannon    INTEGER DEFAULT 0,
    ef_lighthunter     INTEGER DEFAULT 0,
    ef_heavyhunter     INTEGER DEFAULT 0,
    ef_battleship      INTEGER DEFAULT 0,
    ef_armoredship     INTEGER DEFAULT 0,
    ef_missilelauncher INTEGER DEFAULT 0,
    ef_ioncannon       INTEGER DEFAULT 0,
    ef_plasmacannon    INTEGER DEFAULT 0
);

ALTER TABLE battle ADD CONSTRAINT battle_pk PRIMARY KEY ( id_battle );

ALTER TABLE battle ADD CONSTRAINT battle_id_battle_un UNIQUE ( id_battle );

CREATE TABLE constants (
    id_constant INTEGER NOT NULL,
    name        VARCHAR2(100),
    value       INTEGER NOT NULL
);

ALTER TABLE constants ADD CONSTRAINT constants_pk PRIMARY KEY ( id_constant );

ALTER TABLE constants ADD CONSTRAINT constants_name_un UNIQUE ( name );

CREATE TABLE defense (
    id_defense      INTEGER NOT NULL,
    name            VARCHAR2(30) NOT NULL,
    metal_cost      INTEGER NOT NULL,
    crystal_cost    INTEGER NOT NULL,
    deuterium_cost  INTEGER NOT NULL,
    initialarmor    INTEGER NOT NULL,
    armor           INTEGER,
    basedamage      INTEGER NOT NULL,
    speed           INTEGER NOT NULL,
    generatewasting INTEGER NOT NULL
);

ALTER TABLE defense ADD CONSTRAINT defense_pk PRIMARY KEY ( id_defense );

ALTER TABLE defense ADD CONSTRAINT defense_name_un UNIQUE ( name );

ALTER TABLE defense ADD CONSTRAINT defense_id_defense_un UNIQUE ( id_defense );

CREATE TABLE enemy (
    id_enemy             INTEGER NOT NULL,
    name                 VARCHAR2(30) NOT NULL,
    quantity_metal       INTEGER DEFAULT 0,
    quantity_crystal     INTEGER DEFAULT 0,
    quantity_deuterium   INTEGER DEFAULT 0,
    num_lighthunter      INTEGER DEFAULT 0,
    num_heavyhunter      INTEGER DEFAULT 0,
    num_battleship       INTEGER DEFAULT 0,
    num_armoredship      INTEGER DEFAULT 0,
    current_leveldefense INTEGER NOT NULL,
    current_levelattack  INTEGER NOT NULL
);

ALTER TABLE enemy ADD CONSTRAINT enemy_pk PRIMARY KEY ( id_enemy );

ALTER TABLE enemy ADD CONSTRAINT enemy_name_un UNIQUE ( name );

ALTER TABLE enemy ADD CONSTRAINT enemy_id_enemy_un UNIQUE ( id_enemy );

CREATE TABLE planet (
    id_planet                      INTEGER NOT NULL,
    user_id_user                   INTEGER NOT NULL,
    planet_name                    VARCHAR2(30) NOT NULL,
    quantity_metal                 INTEGER DEFAULT 0,
    quantity_crystal               INTEGER DEFAULT 0,
    quantity_deuterium             INTEGER DEFAULT 0,
    num_lighthunter                INTEGER DEFAULT 0,
    num_heavyhunter                INTEGER DEFAULT 0,
    num_battleship                 INTEGER DEFAULT 0,
    num_armoredship                INTEGER DEFAULT 0,
    num_missilelauncher            INTEGER DEFAULT 0,
    num_ioncannon                  INTEGER DEFAULT 0,
    num_plasmacannon               INTEGER DEFAULT 0,
    current_leveldefense           INTEGER NOT NULL,
    cost_defenseup                 NUMBER NOT NULL,
    current_levelattack            INTEGER NOT NULL,
    cost_attackup                  NUMBER NOT NULL,
    technology_defense_id_leveldef INTEGER NOT NULL,
    technology_attack_id_levelat   INTEGER NOT NULL
);

CREATE INDEX planet_user_fk ON
    planet (
        user_id_user
    ASC );

ALTER TABLE planet ADD CONSTRAINT planet_pk PRIMARY KEY ( id_planet );

ALTER TABLE planet ADD CONSTRAINT planet_planet_name_un UNIQUE ( planet_name );

ALTER TABLE planet ADD CONSTRAINT planet_id_planet_un UNIQUE ( id_planet );

CREATE TABLE ship (
    id_ship         INTEGER NOT NULL,
    name            VARCHAR2(30) NOT NULL,
    metal_cost      INTEGER NOT NULL,
    crystal_cost    INTEGER NOT NULL,
    deuterium_cost  INTEGER NOT NULL,
    initialarmor    INTEGER NOT NULL,
    armor           INTEGER,
    basedamage      INTEGER NOT NULL,
    speed           INTEGER NOT NULL,
    generatewasting INTEGER NOT NULL
);

ALTER TABLE ship ADD CONSTRAINT ship_pk PRIMARY KEY ( id_ship );

ALTER TABLE ship ADD CONSTRAINT ship_name_un UNIQUE ( name );

ALTER TABLE ship ADD CONSTRAINT ship_id_ship_un UNIQUE ( id_ship );

CREATE TABLE units (
    id_unit            INTEGER NOT NULL,
    defense_level      INTEGER,
    attack_level       INTEGER,
    defense_id_defense INTEGER,
    ship_id_ship       INTEGER,
    enemy_id_enemy     INTEGER,
    planet_id_planet   INTEGER
);

ALTER TABLE units ADD CONSTRAINT units_pk PRIMARY KEY ( id_unit );

CREATE TABLE "User" (
    id_user    INTEGER NOT NULL,
    username   VARCHAR2(30) NOT NULL,
    password   VARCHAR2(20) NOT NULL,
    birth_date DATE NOT NULL
);

ALTER TABLE "User" ADD CONSTRAINT user_pk PRIMARY KEY ( id_user );

ALTER TABLE "User" ADD CONSTRAINT user_username_un UNIQUE ( username );

ALTER TABLE "User" ADD CONSTRAINT user_id_user_un UNIQUE ( id_user );

ALTER TABLE battle
    ADD CONSTRAINT battle_enemy_fk FOREIGN KEY ( enemy_id_enemy )
        REFERENCES enemy ( id_enemy );

ALTER TABLE battle
    ADD CONSTRAINT battle_planet_fk FOREIGN KEY ( planet_id_planet )
        REFERENCES planet ( id_planet );

ALTER TABLE battle
    ADD CONSTRAINT battle_user_fk FOREIGN KEY ( user_id_user )
        REFERENCES "User" ( id_user );

ALTER TABLE planet
    ADD CONSTRAINT planet_user_fk FOREIGN KEY ( user_id_user )
        REFERENCES "User" ( id_user );

ALTER TABLE units
    ADD CONSTRAINT units_defense_fk FOREIGN KEY ( defense_id_defense )
        REFERENCES defense ( id_defense );

ALTER TABLE units
    ADD CONSTRAINT units_enemy_fk FOREIGN KEY ( enemy_id_enemy )
        REFERENCES enemy ( id_enemy );

ALTER TABLE units
    ADD CONSTRAINT units_planet_fk FOREIGN KEY ( planet_id_planet )
        REFERENCES planet ( id_planet );

ALTER TABLE units
    ADD CONSTRAINT units_ship_fk FOREIGN KEY ( ship_id_ship )
        REFERENCES ship ( id_ship );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             1
-- ALTER TABLE                             28
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

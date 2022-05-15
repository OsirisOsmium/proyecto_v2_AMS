CREATE OR REPLACE PACKAGE INITIALIZE_DB
AS
PROCEDURE DROP_TABLE;
PROCEDURE CREATE_TABLE;
PROCEDURE INSERT_DATA;
PROCEDURE INITIALIZE;
END INITIALIZE_DB;

/

CREATE OR REPLACE PACKAGE BODY INITIALIZE_DB
AS

PROCEDURE DROP_TABLE

IS

exists_Battle NUMBER(1);
exists_Constants NUMBER(1);
exists_Defense NUMBER(1);
exists_Enemy NUMBER(1);
exists_Planet NUMBER(1);
exists_Ship NUMBER(1);
exists_Units NUMBER(1);
exists_User NUMBER(1);
exists_Step NUMBER(1);

/*Varchars con las sentencias de DDL para borrar o crear tablas*/

drop_Battle VARCHAR (2000) := 'DROP TABLE battle';
drop_Constants VARCHAR (2000) := 'DROP TABLE constants';
drop_Units VARCHAR(2000) := 'DROP TABLE units';
drop_Defense VARCHAR(2000) := 'DROP TABLE defense';
drop_Enemy VARCHAR(2000) := 'DROP TABLE enemy';
drop_Planet VARCHAR(2000) := 'DROP TABLE planet';
drop_User VARCHAR(2000) := 'DROP TABLE "USER"';
drop_Ship VARCHAR(2000) := 'DROP TABLE ship';
drop_Step VARCHAR(2000) := 'DROP TABLE step';

BEGIN
/*Comprovamos si cada una de las tablas existe*/

SELECT COUNT(table_name) INTO exists_Battle
FROM user_tables
WHERE table_name = 'BATTLE';

SELECT COUNT(table_name) INTO exists_Constants
FROM user_tables
WHERE table_name = 'CONSTANTS';

SELECT COUNT(table_name) INTO exists_Defense
FROM user_tables
WHERE table_name = 'DEFENSE';

SELECT COUNT(table_name) INTO exists_Enemy
FROM user_tables
WHERE table_name = 'ENEMY';

SELECT COUNT(table_name) INTO exists_Planet
FROM user_tables
WHERE table_name = 'PLANET';

SELECT COUNT(table_name) INTO exists_Ship
FROM user_tables
WHERE table_name = 'SHIP';

SELECT COUNT(table_name) INTO exists_Units
FROM user_tables
WHERE table_name = 'UNITS';

SELECT COUNT(table_name) INTO exists_User
FROM user_tables
WHERE table_name = 'USER';

/*Si la tabla existe, se borra, en caso de no existir no se intenta hacer un borrado que dara el error de que no existe la tabla*/

SELECT COUNT(table_name) INTO exists_Step
FROM user_tables
WHERE table_name = 'STEP';

IF exists_Constants = 1 THEN
execute immediate drop_Constants;
DBMS_OUTPUT.PUT_LINE('Tabla CONSTANTS eliminada');
END IF;

IF exists_Units = 1 THEN
execute immediate drop_Units;
DBMS_OUTPUT.PUT_LINE('Tabla UNITS eliminada');
END IF;

IF exists_Defense = 1 THEN
execute immediate drop_Defense;
DBMS_OUTPUT.PUT_LINE('Tabla DEFENSE eliminada');
END IF;

IF exists_Ship = 1 THEN
execute immediate drop_Ship;
DBMS_OUTPUT.PUT_LINE('Tabla SHIP eliminada');
END IF;

IF exists_Step = 1 THEN
execute immediate drop_Step;
DBMS_OUTPUT.PUT_LINE('Tabla STEP eliminada');
END IF;

IF exists_Battle = 1 THEN
execute immediate drop_Battle;
DBMS_OUTPUT.PUT_LINE('Tabla BATTLE eliminada');
END IF;

IF exists_Enemy = 1 THEN
execute immediate drop_Enemy;
DBMS_OUTPUT.PUT_LINE('Tabla ENEMY eliminada');
END IF;

IF exists_Planet = 1 THEN
execute immediate drop_Planet;
DBMS_OUTPUT.PUT_LINE('Tabla PLANET eliminada');
END IF;

IF exists_User = 1 THEN
execute immediate drop_User;
DBMS_OUTPUT.PUT_LINE('Tabla USER eliminada');
END IF;

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERROR en el borrado de tablas');
DBMS_OUTPUT.PUT_LINE('Descipcion del error; '||SQLERRM);
ROLLBACK;

END;

PROCEDURE CREATE_TABLE

IS

exists_Battle NUMBER(1);
exists_Constants NUMBER(1);
exists_Defense NUMBER(1);
exists_Enemy NUMBER(1);
exists_Planet NUMBER(1);
exists_Ship NUMBER(1);
exists_Units NUMBER(1);
exists_User NUMBER(1);
exists_Step NUMBER(1);

/*Varchars con sentencias DDL para crear las tablas y añadirles restricciones,
El orden de creación, asi como las restricciones y el orden en que se ejecutan es el
mismo del DDL exportado a partir del SQL Data Modeler*/

create_Battle VARCHAR (2000) := 'CREATE TABLE battle (
    id_battle          INTEGER NOT NULL,
    user_id_user       INTEGER NOT NULL,
    enemy_id_enemy     INTEGER NOT NULL,
    planet_id_planet   INTEGER NOT NULL,
    user_winner        INTEGER NOT NULL,
    enemy_winner       INTEGER NOT NULL,
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
    ef_lighthunter     INTEGER DEFAULT 0,
    ef_heavyhunter     INTEGER DEFAULT 0,
    ef_battleship      INTEGER DEFAULT 0,
    ef_armoredship     INTEGER DEFAULT 0
)';

alter_Battle1 VARCHAR(1000) := 'ALTER TABLE battle ADD CONSTRAINT battle_pk PRIMARY KEY ( id_battle )';

create_Constants VARCHAR(1000) := 'CREATE TABLE constants (
    id_constant INTEGER NOT NULL,
    name        VARCHAR2(100),
    value       INTEGER NOT NULL
)';

alter_Constants1 VARCHAR (1000) := 'ALTER TABLE constants ADD CONSTRAINT constants_pk PRIMARY KEY ( id_constant )';
alter_Constants2 VARCHAR (1000) := 'ALTER TABLE constants ADD CONSTRAINT constants_name_un UNIQUE ( name )';

create_Defense VARCHAR(2000) := 'CREATE TABLE defense (
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
)';
alter_Defense1 VARCHAR (1000) := 'ALTER TABLE defense ADD CONSTRAINT defense_pk PRIMARY KEY ( id_defense )';
alter_Defense2 VARCHAR (1000) := 'ALTER TABLE defense ADD CONSTRAINT defense_name_un UNIQUE ( name )';

create_Enemy VARCHAR(2000) := 'CREATE TABLE enemy (
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
)';

alter_Enemy1 VARCHAR (1000) := 'ALTER TABLE enemy ADD CONSTRAINT enemy_pk PRIMARY KEY ( id_enemy )';
alter_Enemy2 VARCHAR (1000) := 'ALTER TABLE enemy ADD CONSTRAINT enemy_name_un UNIQUE ( name )';

create_Planet VARCHAR(2000) := 'CREATE TABLE planet (
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
    cost_attackup                  NUMBER NOT NULL
)';

index_Planet1 VARCHAR (1000) :='CREATE INDEX planet_user_fk ON
    planet (
        user_id_user
    ASC )';

alter_planet1 VARCHAR (1000) := 'ALTER TABLE planet ADD CONSTRAINT planet_pk PRIMARY KEY ( id_planet )';
alter_planet2 VARCHAR (1000) := 'ALTER TABLE planet ADD CONSTRAINT planet_planet_name_un UNIQUE ( planet_name )';

create_Ship VARCHAR(2000) := 'CREATE TABLE ship (
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
)';
alter_Ship1 VARCHAR (1000) := 'ALTER TABLE ship ADD CONSTRAINT ship_pk PRIMARY KEY ( id_ship )';
alter_Ship2 VARCHAR (1000) := 'ALTER TABLE ship ADD CONSTRAINT ship_name_un UNIQUE ( name )';

create_Step VARCHAR(1000) :='CREATE TABLE step (
    id_step          INTEGER NOT NULL,
    battle_id_battle INTEGER NOT NULL,
    Order_Position          INTEGER NOT NULL,
    description      VARCHAR2(4000) NOT NULL
)';

alter_Step1 VARCHAR(2000) := 'ALTER TABLE step ADD CONSTRAINT setps_battle_pk PRIMARY KEY ( id_step )';

create_units VARCHAR(1000) :='CREATE TABLE units (
    id_unit            INTEGER NOT NULL,
    defense_level      INTEGER,
    attack_level       INTEGER,
    defense_id_defense INTEGER,
    ship_id_ship       INTEGER,
    enemy_id_enemy     INTEGER,
    planet_id_planet   INTEGER
)';

alter_Units1 VARCHAR(1000) := 'ALTER TABLE units ADD CONSTRAINT units_pk PRIMARY KEY ( id_unit )';

create_User VARCHAR(2000) := 'CREATE TABLE "USER" (
    id_user    INTEGER NOT NULL,
    username   VARCHAR2(30) NOT NULL,
    password   VARCHAR2(20) NOT NULL,
    birth_date DATE NOT NULL
)';
alter_user1 VARCHAR (1000) := 'ALTER TABLE "USER" ADD CONSTRAINT user_pk PRIMARY KEY ( id_user )';
alter_user2 VARCHAR (1000) := 'ALTER TABLE "USER" ADD CONSTRAINT user_username_un UNIQUE ( username )';

alter_Battle2 VARCHAR (1000) := 'ALTER TABLE battle
    ADD CONSTRAINT battle_enemy_fk FOREIGN KEY ( enemy_id_enemy )
        REFERENCES enemy ( id_enemy )';
alter_Battle3 VARCHAR (1000) := 'ALTER TABLE battle
    ADD CONSTRAINT battle_planet_fk FOREIGN KEY ( planet_id_planet )
        REFERENCES planet ( id_planet )';
alter_Battle4 VARCHAR (1000) := 'ALTER TABLE battle
    ADD CONSTRAINT battle_user_fk FOREIGN KEY ( user_id_user )
        REFERENCES "USER" ( id_user )';
        
alter_planet3 VARCHAR (1000) := 'ALTER TABLE planet
    ADD CONSTRAINT planet_user_fk FOREIGN KEY ( user_id_user )
        REFERENCES "USER" ( id_user )';
        
alter_Step2 VARCHAR(2000) := 'ALTER TABLE step
    ADD CONSTRAINT setps_battle_battle_fk FOREIGN KEY ( battle_id_battle )
        REFERENCES battle ( id_battle )';
        
alter_Units2 VARCHAR(1000) := 'ALTER TABLE units
    ADD CONSTRAINT units_defense_fk FOREIGN KEY ( defense_id_defense )
        REFERENCES defense ( id_defense )';
        
alter_Units3 VARCHAR(1000) := 'ALTER TABLE units
    ADD CONSTRAINT units_enemy_fk FOREIGN KEY ( enemy_id_enemy )
        REFERENCES enemy ( id_enemy )';
        
alter_Units4 VARCHAR(1000) := 'ALTER TABLE units
    ADD CONSTRAINT units_planet_fk FOREIGN KEY ( planet_id_planet )
        REFERENCES planet ( id_planet )';
        
alter_Units5 VARCHAR(1000) := 'ALTER TABLE units
    ADD CONSTRAINT units_ship_fk FOREIGN KEY ( ship_id_ship )
        REFERENCES ship ( id_ship )';

BEGIN

/*Comprovamos si las tablas existen antes d eintentar crearlas para que no nos salten mensajes de error
aunque este procedimiento la idea es que se ejecute justo despues del borrado de tablas*/

SELECT COUNT(table_name) INTO exists_Battle
FROM user_tables
WHERE table_name = 'BATTLE';

SELECT COUNT(table_name) INTO exists_Constants
FROM user_tables
WHERE table_name = 'CONSTANTS';

SELECT COUNT(table_name) INTO exists_Defense
FROM user_tables
WHERE table_name = 'DEFENSE';

SELECT COUNT(table_name) INTO exists_Enemy
FROM user_tables
WHERE table_name = 'ENEMY';

SELECT COUNT(table_name) INTO exists_Planet
FROM user_tables
WHERE table_name = 'PLANET';

SELECT COUNT(table_name) INTO exists_User
FROM user_tables
WHERE table_name = '"USER"';

SELECT COUNT(table_name) INTO exists_Units
FROM user_tables
WHERE table_name = 'UNITS';

SELECT COUNT(table_name) INTO exists_Step
FROM user_tables
WHERE table_name = 'STEP';

SELECT COUNT(table_name) INTO exists_Ship
FROM user_tables
WHERE table_name = 'SHIP';

/*Crea las tablas si no las ha encontrado*/

IF exists_Battle = 0 THEN
execute immediate create_Battle;
execute immediate alter_Battle1;
DBMS_OUTPUT.PUT_LINE('Tabla BATTLE creada');
END IF;

IF exists_Constants = 0 THEN
execute immediate create_Constants;
execute immediate alter_Constants1;
DBMS_OUTPUT.PUT_LINE('Tabla CONSTANTS creada');
END IF;

IF exists_Defense = 0 THEN
execute immediate create_Defense;
execute immediate alter_Defense1;
execute immediate alter_Defense2;
DBMS_OUTPUT.PUT_LINE('Tabla DEFENSE creada');
END IF;

IF exists_Enemy = 0 THEN
execute immediate create_Enemy;
execute immediate alter_Enemy1;
execute immediate alter_Enemy2;
DBMS_OUTPUT.PUT_LINE('Tabla ENEMY creada');
END IF;

IF exists_Planet = 0 THEN
execute immediate create_Planet;
execute immediate index_Planet1;
execute immediate alter_Planet1;
execute immediate alter_Planet2;
DBMS_OUTPUT.PUT_LINE('Tabla PLANET creada');
END IF;

IF exists_Ship = 0 THEN
execute immediate create_Ship;
execute immediate alter_Ship1;
execute immediate alter_Ship2;
DBMS_OUTPUT.PUT_LINE('Tabla SHIP creada');
END IF;

IF exists_Units = 0 THEN
execute immediate create_Units;
execute immediate alter_Units1;
DBMS_OUTPUT.PUT_LINE('Tabla UNITS creada');
END IF;

IF exists_Step = 0 THEN
execute immediate create_Step;
execute immediate alter_Step1;
DBMS_OUTPUT.PUT_LINE('Tabla STEP creada');
END IF;

IF exists_User = 0 THEN
execute immediate create_User;
execute immediate alter_User1;
execute immediate alter_User2;
DBMS_OUTPUT.PUT_LINE('Tabla USER creada');
END IF;

execute immediate alter_Battle2;
execute immediate alter_Battle3;
execute immediate alter_Battle4;
execute immediate alter_planet3;
execute immediate alter_Step2;
execute immediate alter_Units2;
execute immediate alter_Units3;
execute immediate alter_Units4;
execute immediate alter_Units5;

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERROR en la creacion de las tablas');
DBMS_OUTPUT.PUT_LINE('Descipcion del error; '||SQLERRM);
ROLLBACK;

END;

PROCEDURE INSERT_DATA

IS

insert_LightHunter VARCHAR(1000) := 'INSERT INTO SHIP VALUES(1, ''Light Hunter'', 3000, 0, 50, 400, null, 80, 3, 20)';
insert_HeavyHunter VARCHAR(1000) := 'INSERT INTO SHIP VALUES(2, ''Heavy Hunter'', 6500, 0, 50, 1000, null, 150, 7, 30)';
insert_BattleShip VARCHAR(1000) := 'INSERT INTO SHIP VALUES(3, ''Battle Ship'', 45000, 0, 7000, 6000, null, 1000, 45, 60)';
insert_ArmoredShip VARCHAR(1000) := 'INSERT INTO SHIP VALUES(4, ''Armored Ship'', 30000, 0, 15000, 8000, null, 700, 70, 75)';
insert_MissileLauncher VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES (1, ''Missile Launcher'', 2000, 0, 0, 200, null, 80, 5, 10)';
insert_IonCannon VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES(2, ''Ion Cannon'', 4000, 0, 500, 1200, null, 250, 12, 25)';
insert_PlasmaCannon VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES(3, ''PLasma Cannon'', 50000, 0, 5000, 7000, null, 2000, 30, 50)';

BEGIN

execute immediate insert_LightHunter;
execute immediate insert_HeavyHunter;
execute immediate insert_BattleShip;
execute immediate insert_ArmoredShip;
DBMS_OUTPUT.PUT_LINE('Insertados los datos de las naves en la tabla SHIP');

execute immediate insert_MissileLauncher;
execute immediate insert_IonCannon;
execute immediate insert_PlasmaCannon;
DBMS_OUTPUT.PUT_LINE('Insertados lo datos de las estructuras defensivas en la tabla DEFENSE');

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT DATA:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;

PROCEDURE INITIALIZE

IS

BEGIN

DROP_TABLE;
DBMS_OUTPUT.PUT_LINE('');
CREATE_TABLE;
DBMS_OUTPUT.PUT_LINE('');
INSERT_DATA;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INITIALIZE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;

END INITIALIZE_DB;
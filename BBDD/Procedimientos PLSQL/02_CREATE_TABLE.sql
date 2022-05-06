SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE CREATE_TABLES

IS

/*
DECLARE
num_Prueba NUMBER := 2;

flag_Users NUMBER(1);
flag_Ship NUMBER(1);
flag_Defense NUMBER(1); 
flag_Planet NUMBER(1);
flag_Registre NUMBER(1);*/

existe_Ships NUMBER(1);
existe_Users NUMBER(1);
existe_Defense NUMBER(1);
existe_Planet NUMBER(1);
existe_Registre NUMBER(1);

create_Users VARCHAR(2000):= 'CREATE TABLE USERS(
    User_ID number PRIMARY KEY,
    username VARCHAR(30) unique,
    birth_date date null,
    password VARCHAR(30) not null
)';

create_Ship VARCHAR(2000):= 'CREATE TABLE SHIP(
    Id_Ship number not null,
    Name varchar(30) not null, 
    Metal_cost number,
    Crystal_Cost number,
    Deuterium_Crystal number,
    Initial_Armor number,
    Armor number null,
    Base_Damage number, 
    Speed number,
    GenerateWastings number
)';

create_Defense VARCHAR(2000):='CREATE TABLE DEFENSE(
    Id_Defense number not null,
    Name varchar(30) not null, 
    Metal_Cost number,
    Crystal_Cost number,
    Deuterium_Cost number,
    Initial_Armor number,
    Armor number null,
    Base_Damage number, 
    Speed number,
    Generate_Warnings number
)';

create_Planet VARCHAR(2000):= 'CREATE TABLE PLANET(
    Id_Planet number,
    Name VARCHAR(30) not null,
    Id_Ship number,
    Id_Defense number
)';

create_Registre VARCHAR (2000):= 'CREATE TABLE REGISTRE(
    Id_Battle number,
    Id_User number
)';

error_NumIntroducido EXCEPTION;

BEGIN
/*
flag_Users := num_Prueba;
flag_Ship := num_Prueba;
flag_Defense := num_Prueba;
flag_Planet := num_Prueba;
flag_Registre := num_Prueba;
*/

SELECT COUNT(table_name) INTO existe_Users
FROM user_tables
WHERE table_name = 'USERS';

SELECT COUNT(table_name) INTO existe_Ships
FROM user_tables
WHERE table_name = 'SHIP';

SELECT COUNT(table_name) INTO existe_Defense
FROM user_tables
WHERE table_name = 'DEFENSE';

SELECT COUNT(table_name) INTO existe_Planet
FROM user_tables
WHERE table_name = 'PLANET';

SELECT COUNT(table_name) INTO existe_Registre
FROM user_tables
WHERE table_name = 'REGISTRE';

IF existe_Users = 0 THEN
execute immediate create_Users;
DBMS_OUTPUT.PUT_LINE('Tabla USERS creada');
ELSIF existe_Users != 1 THEN
raise error_NumIntroducido;
END IF;

IF existe_Ships = 0 THEN
execute immediate create_Ship;
DBMS_OUTPUT.PUT_LINE('Tabla SHIP creada');
ELSIF existe_Ships != 1 THEN
raise error_NumIntroducido;
END IF;

IF existe_Defense = 0 THEN
execute immediate create_Defense;
DBMS_OUTPUT.PUT_LINE('Tabla DEFENSE creada');
ELSIF existe_Defense != 1 THEN
raise error_NumIntroducido;
END IF;

IF existe_Planet = 0 THEN
execute immediate create_Planet;
DBMS_OUTPUT.PUT_LINE('Tabla PLANET creada');
ELSIF existe_Planet != 1 THEN
raise error_NumIntroducido;
END IF;

IF existe_Registre = 0 THEN
execute immediate create_Registre;
DBMS_OUTPUT.PUT_LINE('Tabla REGISTRE creada');
ELSIF existe_Registre != 1 THEN
raise error_NumIntroducido;
END IF;


EXCEPTION

WHEN error_NumIntroducido THEN
DBMS_OUTPUT.PUT_LINE('Uno de los numeros introducidos no es correcto, la funcion CREATE_TABLE debe recibir o ceros (no existe la tabla) o unos (existe la tabla)');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERROR en la creacion de las tablas');
DBMS_OUTPUT.PUT_LINE('Descipcion del error; '||SQLERRM);


END;
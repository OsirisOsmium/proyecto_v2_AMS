CREATE OR REPLACE PROCEDURE DROP_TABLES

IS

/*
DECLARE

num_Prueba NUMBER := 1;

flag_Users NUMBER(1);
flag_Ship NUMBER(1);
flag_Defense NUMBER(1);
flag_Planet NUMBER(1);
flag_Registre NUMBER(1);
*/

existe_Ships NUMBER(1);
existe_Users NUMBER(1);
existe_Defense NUMBER(1);
existe_Planet NUMBER(1);
existe_Registre NUMBER(1);

drop_Users VARCHAR(2000) := 'DROP TABLE SHIP';
drop_Ship VARCHAR(2000) := 'DROP TABLE USERS';
drop_Defense VARCHAR(2000) := 'DROP TABLE DEFENSE';
drop_Planet VARCHAR(2000) := 'DROP TABLE PLANET';
drop_Registre VARCHAR (2000) := 'DROP TABLE REGISTRE';

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

IF existe_Users = 1 THEN
execute immediate drop_Users;
DBMS_OUTPUT.PUT_LINE('Tabla USERS eliminada');
ELSIF existe_Users != 0 THEN
raise error_NumIntroducido;
END IF;

IF existe_Ships = 1 THEN
execute immediate drop_Ship;
DBMS_OUTPUT.PUT_LINE('Tabla SHIP eliminada');
ELSIF existe_Ships != 0 THEN
raise error_NumIntroducido;
END IF;

IF existe_Defense = 1 THEN
execute immediate drop_Defense;
DBMS_OUTPUT.PUT_LINE('Tabla DEFENSE eliminada');
ELSIF existe_Defense != 0 THEN
raise error_NumIntroducido;
END IF;

IF existe_Planet = 1 THEN
execute immediate drop_Planet;
DBMS_OUTPUT.PUT_LINE('Tabla PLANET eliminada');
ELSIF existe_Planet != 0 THEN
raise error_NumIntroducido;
END IF;

IF existe_Registre = 1 THEN
execute immediate drop_Registre;
DBMS_OUTPUT.PUT_LINE('Tabla REGISTRE eliminada');
ELSIF existe_Registre != 0 THEN
raise error_NumIntroducido;
END IF;

EXCEPTION

WHEN error_NumIntroducido THEN
DBMS_OUTPUT.PUT_LINE('Uno de los numeros introducidos no es correcto, la funcion DROP_TABLE debe recibir o ceros (no existe la tabla) o unos (existe la tabla)');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERROR en el borrado de tablas');
DBMS_OUTPUT.PUT_LINE('Descipcion del error; '||SQLERRM);

END;
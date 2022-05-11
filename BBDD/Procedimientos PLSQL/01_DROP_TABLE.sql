CREATE OR REPLACE PROCEDURE DROP_TABLE

IS

exists_Battle NUMBER(1);
exists_Constants NUMBER(1);
exists_Defense NUMBER(1);
exists_Enemy NUMBER(1);
exists_Planet NUMBER(1);
exists_Ship NUMBER(1);
exists_Units NUMBER(1);
exists_User NUMBER(1);

/*Varchars con las sentencias de DDL para borrar o crear tablas*/

drop_Battle VARCHAR (2000) := 'DROP TABLE battle';
drop_Constants VARCHAR (2000) := 'DROP TABLE constants';
drop_Units VARCHAR(2000) := 'DROP TABLE units';
drop_Defense VARCHAR(2000) := 'DROP TABLE defense';
drop_Enemy VARCHAR(2000) := 'DROP TABLE enemy';
drop_Planet VARCHAR(2000) := 'DROP TABLE planet';
drop_User VARCHAR(2000) := 'DROP TABLE "USER"';
drop_Ship VARCHAR(2000) := 'DROP TABLE ship';

BEGIN
/*Comprovamos si cada una de las 6 tablas existe*/

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

IF exists_Battle = 1 THEN
execute immediate drop_Battle;
DBMS_OUTPUT.PUT_LINE('Tabla BATTLE eliminada');
END IF;

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

IF exists_Enemy = 1 THEN
execute immediate drop_Enemy;
DBMS_OUTPUT.PUT_LINE('Tabla ENEMY eliminada');
END IF;

IF exists_Planet = 1 THEN
execute immediate drop_Planet;
DBMS_OUTPUT.PUT_LINE('Tabla PLANET eliminada');
END IF;

IF exists_Ship = 1 THEN
execute immediate drop_Ship;
DBMS_OUTPUT.PUT_LINE('Tabla SHIP eliminada');
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


/


SET SERVEROUTPUT ON

BEGIN

DROP_TABLE;

END;

CREATE OR REPLACE FUNCTION check_TablasExisten RETURN BOOLEAN

IS

id_DefCheck NUMBER(5);
id_PlaCheck NUMBER(5);
id_RegCheck NUMBER(5);
id_ShCheck NUMBER(5);
id_UsCheck NUMBER(5);

BEGIN

SELECT id_Defense INTO id_DefCheck
FROM defense;

SELECT  id_Planet INTO id_PlaCheck
FROM planet;

SELECT  id_Battle INTO id_RegCheck
FROM registre;

SELECT  id_Ship INTO id_ShCheck
FROM ship;

SELECT USER_ID INTO id_UsCheck
FROM USERS;

RETURN TRUE;

EXCEPTION

WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('Alguna de las tablas esta vacia');
RETURN TRUE;

END;
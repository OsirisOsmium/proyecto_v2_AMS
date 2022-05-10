CREATE OR REPLACE PROCEDURE GET_CONSVAL_BYNAME( nombre IN constants.name%TYPE, 
valor OUT constants.value%TYPE)

IS
nombre_Encontrado NUMBER(1);
excepcion_Nombre EXCEPTION;

BEGIN
SELECT COUNT(name) INTO nombre_Encontrado
FROM CONSTANTS
WHERE name = nombre;

IF nombre_Encontrado =0 THEN 
RAISE excepcion_Nombre;
END IF;

SELECT  value INTO valor
FROM CONSTANTS
WHERE name = nombre;
EXCEPTION

WHEN excepcion_Nombre THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado este nombre en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_VALUE_BYNAME:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
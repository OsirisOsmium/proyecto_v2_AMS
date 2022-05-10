CREATE OR REPLACE PROCEDURE GET_CONSTANTS(id_Entrada IN constants.id_Constant%TYPE, 
nombre OUT constants.name%TYPE, valor OUT constants.value%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM "USER"
WHERE id_User = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT name, value INTO nombre, valor
FROM CONSTANTS
WHERE ID_Constant = id_Entrada;
EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
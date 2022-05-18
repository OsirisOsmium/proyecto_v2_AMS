CREATE OR REPLACE PROCEDURE GET_PLAYER (nom IN VARCHAR, 
nombre OUT VARCHAR, 
contras OUT VARCHAR, 
ids OUT NUMBER, 
fecha_Nac OUT DATE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_PLAYER) INTO id_Encontrada
FROM PLAYER
WHERE PLAYERname = nom;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT id_player, PLAYERname, password, birth_date INTO ids, nombre, contras, fecha_Nac
FROM PLAYER
WHERE PLAYERname = nom;


EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_PLAYER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
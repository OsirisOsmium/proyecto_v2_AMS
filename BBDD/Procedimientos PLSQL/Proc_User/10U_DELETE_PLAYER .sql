CREATE OR REPLACE PROCEDURE DELETE_PLAYER(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_PLAYER) INTO id_Encontrada
FROM PLAYER
WHERE id_PLAYER = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

delete_Script := 'DELETE FROM PLAYER
WHERE id_PLAYER = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado el usuario con id '||id_Entrada||' de la base de datos PLAYER');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado este ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso DELETE_PLAYER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
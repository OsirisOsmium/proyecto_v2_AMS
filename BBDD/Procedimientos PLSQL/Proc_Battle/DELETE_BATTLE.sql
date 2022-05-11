CREATE OR REPLACE PROCEDURE DELETE_BATTLE(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_Battle) INTO id_Encontrada
FROM BATTLE
WHERE id_Battle = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;


delete_Script := 'DELETE FROM BATTLE
WHERE id_Battle = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado la batalla, con id '||id_Entrada||', de la base de datos BATTLE');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID de planeta y por lo tanto no se puede borrar');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso DELETE_BATTLE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
CREATE OR REPLACE PROCEDURE DELETE_STEP(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_step) INTO id_Encontrada
FROM STEP
WHERE id_step = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

delete_Script := 'DELETE FROM STEP
WHERE id_Step = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado el paso con id '||id_Entrada||' de la base de datos STEP');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso DELETE_STEP:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
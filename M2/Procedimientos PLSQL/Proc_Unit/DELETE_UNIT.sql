CREATE OR REPLACE PROCEDURE DELETE_UNIT(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_Unit) INTO id_Encontrada
FROM UNITS
WHERE id_Unit = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

delete_Script := 'DELETE FROM UNIT
WHERE id_Unit = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado la unidad con id '||id_Entrada||' de la base de datos UNITS');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_UNIT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
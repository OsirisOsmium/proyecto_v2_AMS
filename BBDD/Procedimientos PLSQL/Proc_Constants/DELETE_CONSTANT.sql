CREATE OR REPLACE PROCEDURE DELETE_CONSTANT(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_constant) INTO id_Encontrada
FROM CONSTANTS
WHERE id_Constant = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

delete_Script := 'DELETE FROM CONSTANT
WHERE id_User = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado el usuario con id '||id_Entrada||' de la base de datos USER');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso DELETE_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
CREATE OR REPLACE PROCEDURE DELETE_PLANET(id_Entrada NUMBER)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

nombre_Borrado planet.planet_name%TYPE;

delete_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_Planet) INTO id_Encontrada
FROM PLANET
WHERE id_Planet = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT planet_name INTO nombre_Borrado
FROM PLANET
WHERE id_Planet = id_Entrada;

delete_Script := 'DELETE FROM PLANET
WHERE id_Planet = '||id_Entrada||'';

execute immediate delete_Script;
DBMS_OUTPUT.PUT_LINE('Se ha borrado el planeta, con id '||id_Entrada||', llamado '||nombre_Borrado||', de la base de datos PLANET');
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID de planeta y por lo tanto no se puede borrar');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso DELETE_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
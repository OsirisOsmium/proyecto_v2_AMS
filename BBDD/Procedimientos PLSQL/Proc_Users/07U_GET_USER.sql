CREATE OR REPLACE PROCEDURE GET_USER_ (id_Entrada IN NUMBER, nombre OUT VARCHAR, contras OUT VARCHAR, fecha_Nac OUT DATE)

/*El nombre GET_USER tal como esta no lo admite, da el error de que ya hay un objeto usando este nombre, añadiendole la barra baja ya nos*/

IS

BEGIN

SELECT username, password, birth_date INTO nombre, contras, fecha_Nac
FROM "USER"
WHERE id_user = id_Entrada;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INITIALIZE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
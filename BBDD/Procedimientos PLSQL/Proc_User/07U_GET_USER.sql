CREATE OR REPLACE PROCEDURE GET_USER_ (id_Entrada IN NUMBER, 
nombre OUT VARCHAR, 
contras OUT VARCHAR, 
fecha_Nac OUT DATE)

/*El nombre GET_USER tal como esta no lo admite, da el error de que ya hay un objeto usando este nombre, 
añadiendole la barra baja ya nos funciona (Gracias PLSQL por hacerme la vida tan facil con la palabras reservadas) */

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

SELECT username, password, birth_date INTO nombre, contras, fecha_Nac
FROM "USER"
WHERE id_user = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
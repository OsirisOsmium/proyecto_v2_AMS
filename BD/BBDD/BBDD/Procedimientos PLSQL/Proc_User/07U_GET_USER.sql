CREATE OR REPLACE PROCEDURE GET_USER_ (nom IN VARCHAR,
nombre OUT VARCHAR, 
contras OUT VARCHAR, 
ids OUT NUMBER)

/*El nombre GET_USER tal como esta no lo admite, da el error de que ya hay un objeto usando este nombre, 
añadiendole la barra baja ya nos funciona (Gracias PLSQL por hacerme la vida tan facil con la palabras reservadas) */

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM USR
WHERE username=nom;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT username, password, id_user INTO nombre, contras, ids
FROM USR
WHERE username=nom ;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
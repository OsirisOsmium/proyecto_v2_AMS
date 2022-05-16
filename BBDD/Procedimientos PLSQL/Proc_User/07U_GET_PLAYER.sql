CREATE OR REPLACE PROCEDURE GET_PLAYER_ (id_Entrada IN NUMBER, 
nombre OUT VARCHAR, 
contras OUT VARCHAR, 
fecha_Nac OUT DATE)

/*El nombre GET_PLAYER tal como esta no lo admite, da el error de que ya hay un objeto usando este nombre, 
añadiendole la barra baja ya nos funciona (Gracias PLSQL por hacerme la vida tan facil con la palabras reservadas) */

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_PLAYER) INTO id_Encontrada
FROM PLAYER
WHERE id_PLAYER = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT PLAYERname, password, birth_date INTO nombre, contras, fecha_Nac
FROM PLAYER
WHERE id_PLAYER = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_PLAYER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
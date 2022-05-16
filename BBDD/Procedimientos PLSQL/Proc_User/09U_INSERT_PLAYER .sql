CREATE OR REPLACE PROCEDURE INSERT_PLAYER(id_Entrada IN NUMBER,
nombre IN VARCHAR, 
contras IN VARCHAR, 
fecha_Nac IN DATE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);


insert_Script VARCHAR(300);

BEGIN

SELECT MAX(id_PLAYER) INTO max_Id
FROM PLAYER;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;

insert_Script := 'INSERT INTO PLAYER
VALUES('''||id_Entrada_Insertar||''', 
'''||nombre||''', 
'''||contras||''', 
'''||fecha_Nac||''')';

execute immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla PLAYER');
DBMS_OUTPUT.PUT_LINE('ID_Usuario: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre);
DBMS_OUTPUT.PUT_LINE('Contraseña: '||contras);
DBMS_OUTPUT.PUT_LINE('Fecha de nacimiento: '||fecha_Nac);
COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_PLAYER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
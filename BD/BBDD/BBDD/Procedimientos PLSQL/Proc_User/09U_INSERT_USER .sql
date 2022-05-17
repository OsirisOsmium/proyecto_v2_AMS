
CREATE OR REPLACE PROCEDURE INSERT_USER(id_Entrada NUMBER,
nombre VARCHAR, 
contras VARCHAR, 
fecha_Nac DATE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM USR
WHERE id_User = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

insert_Script := 'INSERT INTO USR
VALUES('''||id_Entrada||''', 
'''||nombre||''', 
'''||contras||''', 
'''||fecha_Nac||''')';

execute immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla USER');
DBMS_OUTPUT.PUT_LINE('ID_Usuario: '||id_Entrada);
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre);
DBMS_OUTPUT.PUT_LINE('Contraseña: '||contras);
DBMS_OUTPUT.PUT_LINE('Fecha de nacimiento: '||fecha_Nac);
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
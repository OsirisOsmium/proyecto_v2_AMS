CREATE OR REPLACE PROCEDURE INSERT_USER(id_Entrada IN NUMBER,
nombre IN VARCHAR, 
contras IN VARCHAR, 
fecha_Nac IN DATE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(300);

BEGIN

SELECT COUNT(id_user) INTO id_Encontrada
FROM "USER"
WHERE id_User = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

IF id_Entrada IS NULL THEN
SELECT MAX(id_user) INTO max_Id
FROM "USER";
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;
ELSE
id_Entrada_Insertar := id_Entrada;
END IF;

insert_Script := 'INSERT INTO "USER"
VALUES('''||id_Entrada_Insertar||''', 
'''||nombre||''', 
'''||contras||''', 
'''||fecha_Nac||''')';

execute immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla USER');
DBMS_OUTPUT.PUT_LINE('ID_Usuario: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre);
DBMS_OUTPUT.PUT_LINE('Contraseña: '||contras);
DBMS_OUTPUT.PUT_LINE('Fecha de nacimiento: '||fecha_Nac);
COMMIT;
/*
EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;
*/
END;
CREATE OR REPLACE PROCEDURE INSERT_CONSTANTS(id_Entrada IN constants.id_Constant%TYPE, 
nombre IN constants.name%TYPE, valor IN constants.value%TYPE)

IS
nombre_insertar constants.name%TYPE;
valor_insertat constants.value%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM CONSTANTS
WHERE id_User = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF nombre IS NULL THEN
SELECT name INTO nombre_Insertar
FROM CONSTANTS
WHERE id_Constant = id_Entrada;
ELSE 
nombre_Insertar := nombre;
END IF;

IF valor IS NULL THEN
SELECT value INTO value_Insertar
FROM CONSTANTS
WHERE id_Constant = id_Entrada;
ELSE 
valor_Insertar := valor;
END IF;

update_Script:= 'UPDATE CONSTANTS
SET name = '''||nombre_Insertar||''', valor = '''||valor_Insertar||'''
WHERE id_Constant = '||id_Entrada||'';

execute immediate update_Script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos CONSTANTS con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre_Insertar);
DBMS_OUTPUT.PUT_LINE('Valor: '||valor_Insertar);

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
CREATE OR REPLACE PROCEDURE INSERT_CONSTANTS(id_Entrada IN constants.id_Constant%TYPE, 
nombre IN constants.name%TYPE, valor IN constants.value%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_constant) INTO id_Encontrada
FROM CONSTANTS
WHERE id_Constant = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

insert_Script:= 'INSERT INTO CONSTANTS
VALUES ('''||id_Entrada||''', '''||nombre||''', '''||valor||''')';
execute immediate insert_Script;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
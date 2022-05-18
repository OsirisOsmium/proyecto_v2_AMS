CREATE OR REPLACE PROCEDURE INSERT_CONSTANTS(id_Entrada IN constants.id_Constant%TYPE, 
nombre IN constants.name%TYPE, 
valor IN constants.value%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);

insert_Script VARCHAR(300);

BEGIN

SELECT MAX(id_constant) INTO max_Id
FROM CONSTANTS;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;

insert_Script:= 'INSERT INTO CONSTANTS
VALUES ('''||id_Entrada_Insertar||''', 
'''||nombre||''', 
'''||valor||''')';
execute immediate insert_Script;

DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla CONSTANT');
DBMS_OUTPUT.PUT_LINE('ID Constante: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE('Nombre Constante: '||nombre);
DBMS_OUTPUT.PUT_LINE('Valor: '||valor);

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
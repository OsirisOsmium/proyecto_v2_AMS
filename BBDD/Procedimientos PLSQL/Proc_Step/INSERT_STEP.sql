CREATE OR REPLACE PROCEDURE INSERT_STEP(id_Entrada IN step.id_step%TYPE,
id_Batalla IN step.battle_id_battle%TYPE, 
orden IN step.order_Position%TYPE, 
descripcion IN step.description%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_step) INTO id_Encontrada
FROM STEP
WHERE id_step = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

IF id_Entrada IS NULL THEN
SELECT MAX(id_step) INTO max_Id
FROM STEP;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;
ELSE
id_Entrada_Insertar := id_Entrada;
END IF;

insert_Script := 'INSERT INTO STEP
VALUES ('''||id_Entrada_Insertar||''',
'''||id_Batalla||''',
'''||orden||''',
('''||descripcion||''')';

execute immediate insert_Script;

DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla STEP');
DBMS_OUTPUT.PUT_LINE('ID del Paso: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE('ID Batalla: '||id_batalla);
DBMS_OUTPUT.PUT_LINE('Orden en Batalla: '||orden);
DBMS_OUTPUT.PUT_LINE('Descripcion del Paso: '||descripcion);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
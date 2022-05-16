CREATE OR REPLACE PROCEDURE INSERT_STEP(id_Entrada IN step.id_step%TYPE,
id_Batalla IN step.battle_id_battle%TYPE, 
orden IN step.order_Position%TYPE, 
descripcion IN step.description%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);
insert_Script VARCHAR(300);

BEGIN

SELECT MAX(id_step) INTO max_Id
FROM STEP;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
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

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_CONSTANT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
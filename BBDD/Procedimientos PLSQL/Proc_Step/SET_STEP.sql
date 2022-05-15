CREATE OR REPLACE PROCEDURE SET_STEP (id_Entrada IN step.id_step%TYPE,
id_Batalla IN step.battle_id_battle%TYPE, 
orden IN step.order_Position%TYPE, 
descripcion IN step.description%TYPE)

IS
id_Batalla_Insertar step.battle_id_battle%TYPE;
orden_Insertar step.order_Position%TYPE;
descripcion_Insertar step.description%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_step) INTO id_Encontrada
FROM STEP
WHERE id_step = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF id_Batalla IS NULL THEN
SELECT battle_id_battle INTO id_Batalla_Insertar
FROM STEP
WHERE id_step = id_Entrada;
ELSE
id_Batalla_Insertar := id_Batalla;
END IF;

IF orden IS NULL THEN
SELECT order_Position INTO orden_Insertar
FROM STEP
WHERE id_step = id_Entrada;
ELSE
orden_Insertar := orden;
END IF;

IF descripcion IS NULL THEN
SELECT descripcion INTO descripcion_Insertar
FROM STEP
WHERE id_step = id_Entrada;
ELSE
descripcion_Insertar := descripcion;
END IF;

update_Script := 'UPDATE STEP
SET battle_id_battle = '''||id_Batalla_Insertar||''',
SET order_position = '''||orden_Insertar||''',
SET description = '''||descripcion_Insertar||'''
WHERE id_step = '||id_Entrada||'';

execute immediate update_Script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos STEP con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('id Batalla: '||id_Batalla_Insertar);
DBMS_OUTPUT.PUT_LINE('Numero de paso: '||orden_Insertar);
DBMS_OUTPUT.PUT_LINE('Descripcion: '||descripcion_Insertar);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
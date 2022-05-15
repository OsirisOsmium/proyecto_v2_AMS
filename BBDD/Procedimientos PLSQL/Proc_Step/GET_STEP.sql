CREATE OR REPLACE PROCEDURE GET_STEP (id_Entrada IN step.ID_Step%TYPE, 
id_Batalla OUT step.battle_id_battle%TYPE, 
orden OUT step.order_Position%TYPE, 
descripcion OUT step.description%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_step) INTO id_Encontrada
FROM STEP
WHERE id_step = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT battle_id_battle, order_Position, description INTO id_Batalla, orden, descripcion
FROM step
WHERE id_step = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
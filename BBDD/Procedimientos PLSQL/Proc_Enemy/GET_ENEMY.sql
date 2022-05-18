CREATE OR REPLACE PROCEDURE GET_ENEMY(id_Entrada IN enemy.ID_Enemy%TYPE, 
nombre OUT  enemy.name%TYPE, 
metal OUT enemy.quantity_metal%TYPE, 
cristal OUT enemy.quantity_crystal%TYPE, 
deuterio OUT enemy.quantity_deuterium%TYPE, 
cazadores_L OUT enemy.num_LightHunter%TYPE, 
cazadores_H OUT enemy.num_heavyHunter%TYPE, 
naves_Batalla OUT enemy.num_battleship%TYPE, 
acorazados OUT enemy.num_armoredShip%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_enemy) INTO id_Encontrada
FROM ENEMY
WHERE id_Enemy = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT name, quantity_Metal, quantity_Crystal, quantity_Deuterium, num_LightHunter, num_HeavyHunter, num_BattleShip, num_ArmoredShip
INTO nombre, metal, cristal, deuterio, cazadores_L, cazadores_H, naves_Batalla, acorazados
FROM ENEMY
WHERE ID_Enemy = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');


WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_ENEMY:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;

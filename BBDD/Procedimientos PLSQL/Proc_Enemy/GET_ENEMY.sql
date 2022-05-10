CREATE OR REPLACE PROCEDURE GET_ENEMY(id_Entrada IN enemy.ID_Enemy%TYPE, 
nombre OUT  enemy.name%TYPE, 
metal OUT enemy.quantity_metal%TYPE, 
cristal OUT enemy.quantity_crystal%TYPE, 
deuterio OUT enemy.quantity_deuterium%TYPE, 
cazadores_L OUT enemy.num_LightHunter%TYPE, 
cazadores_H OUT enemy.num_heavyHunter%TYPE, 
naves_Batalla OUT enemy.num_battleship%TYPE, 
acorazados OUT enemy.num_armoredShip%TYPE,
nivelDefensa OUT planet.current_LevelDefense%TYPE, 
nivelAtaque OUT planet.current_LevelAttack%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT name, quantity_Metal, quantity_Crystal, quantity_Deuterium, num_LightHunter, num_HeavyHunter, num_BattleShip, num_ArmoredShip, current_LevelDefense, current_LevelAttack
INTO nombre, metal, cristal, deuterio, cazadores_L, cazadores_H, naves_Batalla, acorazados, nivelDefensa, nivelAtaque
FROM ENEMY
WHERE ID_Enemy = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');


WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_ENEMY:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;

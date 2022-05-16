CREATE OR REPLACE PROCEDURE COUNT_ARMY_ENEMY(enemigo enemy.ID_Enemy%TYPE)

IS
cant_LightHunter NUMBER(6);
cant_HeavyHunter NUMBER(6);
cant_BattleShip NUMBER(6);
cant_ArmoredShip NUMBER(6);

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(1000);

BEGIN

SELECT COUNT(*) INTO cant_LightHunter
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.enemy_ID_enemy = enemigo AND Ship_ID_Ship = 'Light Hunter';

SELECT COUNT(*) INTO cant_HeavyHunter
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.enemy_ID_enemy = enemigo AND Ship_ID_Ship = 'Heavy Hunter';

SELECT COUNT(*) INTO cant_BattleShip
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.enemy_ID_enemy = enemigo AND Ship_ID_Ship = 'Battle Ship';

SELECT COUNT(*) INTO cant_ArmoredShip
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.enemy_ID_enemy = enemigo AND Ship_ID_Ship = 'Armored Ship';

update_Script := 'UPDATE enemy 
num_LightHunter = '''||cant_LightHunter||''', 
num_HeavyHunter = '''||cant_HeavyHunter||''', 
num_BattleShip = '''||cant_BattleShip||''', 
num_ArmoredShip = '''||cant_ArmoredShip||''', 
WHERE id_enemy = '||enemigo||'';

execute immediate update_script;

DBMS_OUTPUT.PUT_LINE('Actualizada el ejercito del enemigo '||enemigo||':');
DBMS_OUTPUT.PUT_LINE('Light Hunters: '||cant_LightHunter);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters: '||cant_HeavyHunter);
DBMS_OUTPUT.PUT_LINE('BattleShips: '||cant_BattleShip);
DBMS_OUTPUT.PUT_LINE('ArmoredShips: '||cant_ArmoredShip);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso COUNT_ARMY_ENEMY:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
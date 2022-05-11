CREATE OR REPLACE PROCEDURE SET_ENEMY(id_Entrada IN enemy.ID_Enemy%TYPE, 
nombre IN enemy.name%TYPE, 
metal IN enemy.quantity_metal%TYPE, 
cristal IN enemy.quantity_crystal%TYPE, 
deuterio IN enemy.quantity_deuterium%TYPE, 
cazadores_L IN enemy.num_LightHunter%TYPE, 
cazadores_H IN enemy.num_heavyHunter%TYPE, 
naves_Batalla IN enemy.num_battleship%TYPE, 
acorazados IN enemy.num_armoredShip%TYPE,
nivelDefensa IN planet.current_LevelDefense%TYPE, 
nivelAtaque IN planet.current_LevelAttack%TYPE)

IS
nombre_Insertar enemy.name%TYPE; 
metal_Insertar enemy.quantity_metal%TYPE;
cristal_Insertar enemy.quantity_crystal%TYPE;
deuterio_Insertar enemy.quantity_deuterium%TYPE;
cazadores_L_Insertar enemy.num_LightHunter%TYPE;
cazadores_H_Insertar enemy.num_heavyHunter%TYPE;
naves_Batalla_Insertar enemy.num_battleship%TYPE;
acorazados_Insertar enemy.num_armoredShip%TYPE;
nivelDefensa_Insertar planet.current_LevelDefense%TYPE;
nivelAtaque_Insertar planet.current_LevelAttack%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_enemy) INTO id_Encontrada
FROM ENEMY
WHERE id_Enemy = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF nombre IS NULL THEN
SELECT name INTO nombre_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
nombre_Insertar := nombre;
END IF;

IF metal IS NULL THEN
SELECT quantity_metal INTO metal_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
metal_Insertar := metal;
END IF;

IF cristal IS NULL THEN
SELECT quantity_crystal INTO cristal_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
cristal_Insertar := cristal;
END IF;

IF deuterio IS NULL THEN
SELECT quantity_Deuterium INTO deuterio_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
deuterio_Insertar := deuterio;
END IF;

IF cazadores_L IS NULL THEN
SELECT num_LightHunter INTO cazadores_L_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
cazadores_L_Insertar := cazadores_L;
END IF;

IF cazadores_H IS NULL THEN
SELECT num_HeavyHunter INTO cazadores_H_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
cazadores_H_Insertar := cazadores_H;
END IF;

IF naves_Batalla IS NULL THEN
SELECT num_BattleShip INTO naves_Batalla_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
naves_Batalla_Insertar := naves_Batalla;
END IF;

IF acorazados IS NULL THEN
SELECT num_ArmoredShip INTO acorazados_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
acorazados_Insertar := acorazados;
END IF;

IF nivelDefensa IS NULL THEN
SELECT current_LevelDefense INTO nivelDefensa_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
nivelDefensa_Insertar := nivelDefensa;
END IF;

IF nivelAtaque IS NULL THEN
SELECT current_LevelAttack INTO nivelAtaque_Insertar
FROM ENEMY
WHERE id_Enemy = id_Entrada;
ELSE
nivelAtaque_Insertar := nivelAtaque;
END IF;

update_Script := 'UPDATE ENEMY
SET name = '''||nombre_Insertar||''',
SET quantity_Metal = '''||metal_insertar||''',
SET quantity_Crystal = '''||cristal_insertar||''',
SET quantity_Deuterium = '''||deuterio_insertar||''',
SET num_LightHunter= '''||cazadores_L_Insertar||''',
SET num_HeavyHunter = '''||cazadores_H_Insertar||''',
SET num_BattleShip = '''||naves_Batalla_Insertar||''',
SET num_ArmoredShip = '''||acorazados_Insertar||''',
SET current_LevelDefense = '''||nivelDefensa_insertar||''',
SET current_LevelAttack= '''||nivelAtaque_insertar||'''';

execute immediate update_Script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos PLANET con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre_Insertar);
DBMS_OUTPUT.PUT_LINE('Metal: '||metal_insertar);
DBMS_OUTPUT.PUT_LINE('Cristal: '||cristal_insertar);
DBMS_OUTPUT.PUT_LINE('Deuterio: '||deuterio_insertar);
DBMS_OUTPUT.PUT_LINE('Light Hunters'||cazadores_L_Insertar);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters'||cazadores_H_Insertar);
DBMS_OUTPUT.PUT_LINE('BattleShip'||naves_Batalla_Insertar);
DBMS_OUTPUT.PUT_LINE('ArmoredShip'||acorazados_Insertar);
DBMS_OUTPUT.PUT_LINE('Level'||nivelDefensa_insertar);
DBMS_OUTPUT.PUT_LINE(''||nivelAtaque_insertar);

COMMIT;

EXCEPTION
WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_ENEMY:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;

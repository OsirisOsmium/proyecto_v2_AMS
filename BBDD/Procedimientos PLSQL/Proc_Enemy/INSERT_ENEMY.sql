CREATE OR REPLACE PROCEDURE INSERT_ENEMY(id_Entrada IN enemy.ID_Enemy%TYPE, 
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
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_enemy) INTO id_Encontrada
FROM ENEMY
WHERE id_Enemy = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

insert_Script := 'INSERT INTO ENEMY
VALUES('''||id_Entrada||''', 
'''||nombre||''', 
'''||metal||''', 
'''||cristal||''',
'''||deuterio||''',
'''||cazadores_L||''',
'''||cazadores_H||''',
'''||naves_Batalla||''',
'''||acorazados||''',
'''||nivelDefensa||''',
'''||nivelAtaque||''')';

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
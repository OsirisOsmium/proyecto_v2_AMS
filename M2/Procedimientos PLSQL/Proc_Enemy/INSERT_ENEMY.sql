CREATE OR REPLACE PROCEDURE INSERT_ENEMY( 
nombre IN enemy.name%TYPE, 
metal IN enemy.quantity_metal%TYPE, 
cristal IN enemy.quantity_crystal%TYPE, 
deuterio IN enemy.quantity_deuterium%TYPE, 
cazadores_L IN enemy.num_LightHunter%TYPE, 
cazadores_H IN enemy.num_heavyHunter%TYPE, 
naves_Batalla IN enemy.num_battleship%TYPE, 
acorazados IN enemy.num_armoredShip%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN


SELECT MAX(id_enemy) INTO max_Id
FROM ENEMY;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;

insert_Script := 'INSERT INTO ENEMY
VALUES('''||id_Entrada_Insertar||''', 
'''||nombre||''', 
'''||metal||''', 
'''||cristal||''',
'''||deuterio||''',
'''||cazadores_L||''',
'''||cazadores_H||''',
'''||naves_Batalla||''',
'''||acorazados||''')
';
execute Immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla ENEMY');
DBMS_OUTPUT.PUT_LINE('ID Constante: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||nombre);
DBMS_OUTPUT.PUT_LINE(': '||cristal);
DBMS_OUTPUT.PUT_LINE(': '||deuterio);
DBMS_OUTPUT.PUT_LINE(': '||cazadores_L);
DBMS_OUTPUT.PUT_LINE(': '||cazadores_H);
DBMS_OUTPUT.PUT_LINE(': '||naves_Batalla);
DBMS_OUTPUT.PUT_LINE(': '||acorazados);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_ENEMY:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
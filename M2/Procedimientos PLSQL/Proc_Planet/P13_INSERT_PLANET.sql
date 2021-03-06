CREATE OR REPLACE PROCEDURE INSERT_PLANET( 
id_usuario IN planet.player_id_player%TYPE, 
nombre IN planet.planet_Name%TYPE, 
metal IN planet.quantity_metal%TYPE, 
cristal IN planet.quantity_crystal%TYPE,
deuterio IN planet.quantity_deuterium%TYPE, 
cazadores_L IN planet.num_LightHunter%TYPE, 
cazadores_H IN planet.num_HeavyHunter%TYPE, 
naves_Batalla IN planet.num_BattleShip%TYPE, 
acorazados IN planet.num_ArmoredShip%TYPE, 
lanzamisiles IN planet.num_MissileLauncher%TYPE, 
canon_Iones IN planet.num_IonCannon%TYPE, 
canon_Plasma IN planet.num_PlasmaCannon%TYPE,
nivelDefensa IN planet.current_LevelDefense%TYPe, 
coste_SubirDefensa IN planet.cost_AttackUp%TYPE,
nivelAtaque IN planet.current_LevelAttack%TYPE, 
coste_SubirAtaque IN planet.cost_DefenseUp%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);

idplayer_Encontrada NUMBER(1);
excepcion_Idplayer EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN
id_Entrada_Insertar:=id_usuario;
SELECT COUNT(id_player) INTO idplayer_Encontrada
FROM player
WHERE id_player = id_Usuario;

IF idplayer_Encontrada =0 THEN 
RAISE excepcion_Idplayer;
END IF;


insert_Script := 'INSERT INTO PLANET
VALUES('''||id_Entrada_Insertar||''', 
'''||id_Usuario||''', 
'''||nombre||''', 
'''||metal||''', 
'''||cristal||''', 
'''||deuterio||''', 
'''||cazadores_L||''', 
'''||cazadores_H||''', 
'''||naves_Batalla||''', 
'''||acorazados||''', 
'''||lanzamisiles||''', 
'''||canon_iones||''', 
'''||canon_plasma||''', 
'''||nivelDefensa||''', 
'''||coste_SubirDefensa||''', 
'''||nivelAtaque||''', 
'''||coste_SubirAtaque||''')
';

execute immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla PLANET');
DBMS_OUTPUT.PUT_LINE('ID_Usuario: '||id_Entrada_Insertar);
DBMS_OUTPUT.PUT_LINE('Nombre Planeta: '||nombre);
DBMS_OUTPUT.PUT_LINE(': '||metal);
DBMS_OUTPUT.PUT_LINE(': '||cristal);
DBMS_OUTPUT.PUT_LINE(': '||deuterio);
DBMS_OUTPUT.PUT_LINE(': '||cazadores_L);
DBMS_OUTPUT.PUT_LINE(': '||cazadores_H);
DBMS_OUTPUT.PUT_LINE(': '||naves_Batalla);
DBMS_OUTPUT.PUT_LINE(': '||acorazados);
DBMS_OUTPUT.PUT_LINE(': '||lanzamisiles);
DBMS_OUTPUT.PUT_LINE(': '||canon_iones);
DBMS_OUTPUT.PUT_LINE(': '||canon_plasma);
DBMS_OUTPUT.PUT_LINE(': '||nivelDefensa);
DBMS_OUTPUT.PUT_LINE(': '||coste_SubirDefensa);
DBMS_OUTPUT.PUT_LINE(': '||nivelAtaque);
DBMS_OUTPUT.PUT_LINE(': '||coste_SubirAtaque);
COMMIT;

EXCEPTION

WHEN excepcion_Idplayer THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado este ID de usuario en la base de datos y no se le puede asignar al planeta');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
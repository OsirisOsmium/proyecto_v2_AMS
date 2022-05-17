CREATE OR REPLACE PROCEDURE GET_PLANET(
id_Entrada IN planet.id_planet%TYPE, 
id_usuario OUT planet.user_id_user%TYPE, 
nombre OUT planet.planet_Name%TYPE, 
metal OUT planet.quantity_metal%TYPE, 
cristal OUT planet.quantity_crystal%TYPE,
deuterio OUT planet.quantity_deuterium%TYPE, 
cazadores_L OUT planet.num_LightHunter%TYPE, 
cazadores_H OUT planet.num_HeavyHunter%TYPE, 
naves_Batalla OUT planet.num_BattleShip%TYPE, 
acorazados OUT planet.num_ArmoredShip%TYPE, 
lanzamisiles OUT planet.num_MissileLauncher%TYPE, 
canon_Iones OUT planet.num_IonCannon%TYPE, 
canon_Plasma OUT planet.num_PlasmaCannon%TYPE,
nivelDefensa OUT planet.current_LevelDefense%TYPe, 
coste_SubirDefensa OUT planet.cost_DefenseUp%TYPE,
nivelAtaque OUT planet.current_LevelAttack%TYPE, 
coste_SubirAtaque OUT planet.cost_AttackUp%TYPE)

IS

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_planet) INTO id_Encontrada
FROM PLANET
WHERE id_Planet = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT  user_id_user, planet_Name, quantity_metal, quantity_crystal,
quantity_deuterium, num_LightHunter, num_HeavyHunter, num_BattleShip, num_ArmoredShip, 
num_MissileLauncher, num_IonCannon, num_PlasmaCannon, current_LevelDefense,
cost_AttackUp, current_LevelAttack, cost_DefenseUp
INTO
id_usuario, nombre, metal, cristal, deuterio, cazadores_L, cazadores_H,
naves_Batalla, acorazados, lanzamisiles, canon_Iones, canon_Plasma, nivelDefensa, 
coste_SubirDefensa, nivelAtaque, coste_SubirAtaque 
FROM PLANET
WHERE id_Planet = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;

/*
id_planeta  planet.id_planet%TYPE;
id_usuario planet.user_id_user%TYPE;
nombre planet.planet_Name%TYPE;

metal planet.quantityt_metal%TYPE;
cristal planet.quantityt_crystal%TYPE;
deuterio planet.quantityt_deuterium%TYPE;
cazadores_L planet.num_LightHunter%TYPE;
cazadores_H planet.num_HeavyHunter%TYPE;
naves_Batalla planet.num_BattleShip%TYPE;
acorazados planet.num_ArmoredShip%TYPE;
lanzamisiles planet.num_MissileLauncher%TYPE;
canon_Iones planet.num_IonCannon%TYPE;
canon_Plasma planet.num_PlasmasCannon%TYPE;

nivelDefensa planet.current_LevelDefense%TYPE;
coste_SubirDefensa planet.cost_AttackUp%TYPE;
nivelAtaque planet.current_LevelAttack%TYPE;
coste_SubirAtaque planet.cost_DefenseUp%TYPE;
*/
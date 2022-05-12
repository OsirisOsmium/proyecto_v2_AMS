CREATE OR REPLACE PROCEDURE SET_PLANET(id_Entrada IN planet.id_planet%TYPE, 
id_usuario IN planet.user_id_user%TYPE, 
nombre IN planet.planet_Name%TYPE, 

metal IN planet.quantity_metal%TYPE, 
cristal IN planet.quantity_crystal%TYPE,
deuterio IN planet.quantity_deuterium%TYPE, 
cazadores_L IN planet.num_LightHunter%TYPE, 
cazadores_H IN planet.num_HeavyHunter%TYPE, 
naves_Batalla IN planet.num_BattleShip%TYPE, 
acorazados IN planet.num_ArmoredShip%TYPE, 
lanzamisiles IN planet.num_MissileLauncher%TYPE, 
cañon_Iones IN planet.num_IonCannon%TYPE, 
cañon_Plasma IN planet.num_PlasmaCannon%TYPE,
nivelDefensa IN planet.current_LevelDefense%TYPe, 
coste_SubirDefensa IN planet.cost_AttackUp%TYPE,
nivelAtaque IN planet.current_LevelAttack%TYPE, 
coste_SubirAtaque IN planet.cost_DefenseUp%TYPE)

IS

id_planeta_Insertar  planet.id_planet%TYPE;
id_usuario_Insertar planet.user_id_user%TYPE;
nombre_Insertar planet.planet_Name%TYPE;

metal_Insertar planet.quantity_metal%TYPE;
cristal_Insertar planet.quantity_crystal%TYPE;
deuterio_Insertar planet.quantity_deuterium%TYPE;
cazadores_L_Insertar planet.num_LightHunter%TYPE;
cazadores_H_Insertar planet.num_HeavyHunter%TYPE;
naves_Batalla_Insertar planet.num_BattleShip%TYPE;
acorazados_Insertar planet.num_ArmoredShip%TYPE;
lanzamisiles_Insertar planet.num_MissileLauncher%TYPE;
cañon_Iones_Insertar planet.num_IonCannon%TYPE;
cañon_Plasma_Insertar planet.num_PlasmaCannon%TYPE;

nivelDefensa_Insertar planet.current_LevelDefense%TYPE;
coste_SubirDefensa_Insertar planet.cost_DefenseUp%TYPE;
nivelAtaque_Insertar planet.current_LevelAttack%TYPE;
coste_SubirAtaque_Insertar planet.cost_AttackUp%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

idUser_Encontrada NUMBER(1);
excepcion_IdUser EXCEPTION;

update_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_Planet) INTO id_Encontrada
FROM PLANET
WHERE id_Planet = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT COUNT(id_User) INTO idUser_Encontrada
FROM "USER"
WHERE id_User = id_Usuario;

IF idUser_Encontrada =0 THEN 
RAISE excepcion_IdUser;
END IF;

IF id_Usuario IS NULL THEN
SELECT user_Id_User INTO id_Usuario_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
id_Usuario_Insertar := id_Usuario;
END IF;

IF nombre IS NULL THEN
SELECT planet_Name INTO nombre_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
nombre_Insertar := nombre;
END IF;

IF metal IS NULL THEN
SELECT quantity_metal INTO metal_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
metal_Insertar := metal;
END IF;

IF cristal IS NULL THEN
SELECT quantity_crystal INTO cristal_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
cristal_Insertar := cristal;
END IF;

IF deuterio IS NULL THEN
SELECT quantity_Deuterium INTO deuterio_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
deuterio_Insertar := deuterio;
END IF;

IF cazadores_L IS NULL THEN
SELECT num_LightHunter INTO cazadores_L_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
cazadores_L_Insertar := cazadores_L;
END IF;

IF cazadores_H IS NULL THEN
SELECT num_HeavyHunter INTO cazadores_H_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
cazadores_H_Insertar := cazadores_H;
END IF;

IF naves_Batalla IS NULL THEN
SELECT num_BattleShip INTO naves_Batalla_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
naves_Batalla_Insertar := naves_Batalla;
END IF;

IF acorazados IS NULL THEN
SELECT num_ArmoredShip INTO acorazados_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
acorazados_Insertar := acorazados;
END IF;

IF lanzamisiles IS NULL THEN
SELECT num_MissileLauncher INTO lanzamisiles_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
lanzamisiles_Insertar := lanzamisiles;
END IF;

IF cañon_Iones IS NULL THEN
SELECT num_IonCannon INTO cañon_Iones_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
cañon_Iones_Insertar := cañon_Iones;
END IF;

IF cañon_Plasma IS NULL THEN
SELECT num_PlasmaCannon INTO cañon_Plasma_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
cañon_Plasma_Insertar := cañon_Plasma;
END IF;

IF nivelDefensa IS NULL THEN
SELECT current_LevelDefense INTO nivelDefensa_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
nivelDefensa_Insertar := nivelDefensa;
END IF;

IF coste_SubirDefensa IS NULL THEN
SELECT cost_defenseUp INTO coste_SubirDefensa_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
coste_SubirDefensa_Insertar := coste_SubirDefensa;
END IF;

IF nivelAtaque IS NULL THEN
SELECT current_LevelAttack INTO nivelAtaque_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
nivelAtaque_Insertar := nivelAtaque;
END IF;

IF coste_SubirAtaque IS NULL THEN
SELECT cost_AttackUp INTO coste_SubirAtaque_Insertar
FROM PLANET
WHERE id_Planet = id_Entrada;
ELSE
coste_SubirAtaque_Insertar := coste_SubirAtaque;
END IF;

update_Script := 'UPDATE PLANET
SET user_id_user = '''||id_Usuario_Insertar||''',
planet_Name = '''||nombre_Insertar||''', 
quantity_metal = '''||metal_Insertar||''', 
quantity_crystal = '''||cristal_Insertar||''', 
quantity_deuterium = '''||deuterio_Insertar||''', 
num_LightHunter = '''||cazadores_L_Insertar||''', 
num_HeavyHunter = '''||cazadores_H_Insertar||''', 
num_BattleShip = '''||naves_Batalla_Insertar||''', 
num_ArmoredShip = '''||acorazados_Insertar||''', 
num_MissileLauncher = '''||lanzamisiles_Insertar||''', 
num_IonCannon = '''||cañon_Iones_Insertar||''', 
num_PlasmaCannon = '''||cañon_Plasma_Insertar||''', 
current_LevelDefense = '''||nivelDefensa_Insertar||''', 
cost_AttackUp ='''||coste_SubirDefensa_Insertar||''',
current_LevelAttack = '''||nivelAtaque_Insertar||''',
cost_DefenseUp ='''||coste_SubirAtaque_Insertar||'''
WHERE id_user = '||id_Entrada||'';

execute immediate update_script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos PLANET con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Codigo Usuario: '||id_Usuario_Insertar);
DBMS_OUTPUT.PUT_LINE('Metal: '||metal_Insertar);
DBMS_OUTPUT.PUT_LINE('Cristal: '||cristal_Insertar);
DBMS_OUTPUT.PUT_LINE('Deuterio: '||deuterio_Insertar);
DBMS_OUTPUT.PUT_LINE('Light Hunters: '||cazadores_L_Insertar);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters: '||cazadores_H_Insertar);
DBMS_OUTPUT.PUT_LINE('BattleShips: '||naves_Batalla_Insertar);
DBMS_OUTPUT.PUT_LINE('ArmoredShips: '||acorazados_Insertar);
DBMS_OUTPUT.PUT_LINE('Missile Launchers: '||lanzamisiles_Insertar);
DBMS_OUTPUT.PUT_LINE('Ion Cannons: '||cañon_iones_Insertar);
DBMS_OUTPUT.PUT_LINE('Plasma Cannons: '||cañon_plasma_Insertar);
DBMS_OUTPUT.PUT_LINE('Nivel de Defensa: '||nivelDefensa_Insertar);
DBMS_OUTPUT.PUT_LINE('Coste Subir Defensa: '||coste_SubirDefensa_Insertar);
DBMS_OUTPUT.PUT_LINE('Nivel de Ataque: '||nivelAtaque_Insertar);
DBMS_OUTPUT.PUT_LINE('Coste Subir Ataque: '||coste_SubirAtaque_Insertar);


COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN excepcion_IdUser THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado este ID de usuario en la base de datos y no se puede asignar al planeta');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
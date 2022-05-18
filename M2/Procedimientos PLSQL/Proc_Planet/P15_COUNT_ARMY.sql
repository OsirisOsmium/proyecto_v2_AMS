CREATE OR REPLACE PROCEDURE COUNT_ARMY_PLANET(planeta planet.ID_Planet%TYPE)

IS
cant_LightHunter NUMBER(6);
cant_HeavyHunter NUMBER(6);
cant_BattleShip NUMBER(6);
cant_ArmoredShip NUMBER(6);
cant_MissileLauncher NUMBER(6);
cant_IonCannon NUMBER(6);
cant_PlasmaCannon NUMBER(6);

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(1000);

BEGIN

SELECT COUNT(*) INTO cant_LightHunter
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.Planet_ID_Planet = planeta AND ship.name ='Light Hunter';

SELECT COUNT(*) INTO cant_HeavyHunter
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.Planet_ID_Planet = planeta AND ship.name ='Heavy Hunter';

SELECT COUNT(*) INTO cant_BattleShip
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.Planet_ID_Planet = planeta AND ship.name ='Battle Ship';

SELECT COUNT(*) INTO cant_ArmoredShip
FROM UNITS
JOIN ship ON ship.ID_Ship = units.Ship_ID_Ship
WHERE units.Planet_ID_Planet = planeta AND ship.name ='Armored Ship';

SELECT COUNT(*) INTO cant_MissileLauncher
FROM UNITS
JOIN defense ON defense.ID_Defense = units.Defense_ID_Defense
WHERE units.Planet_ID_Planet = planeta AND defense.name ='Missile Launcher';

SELECT COUNT(*) INTO cant_IonCannon
FROM UNITS
JOIN defense ON defense.ID_Defense = units.Defense_ID_Defense
WHERE units.Planet_ID_Planet = planeta AND defense.name ='Missile Launcher';

SELECT COUNT(*) INTO cant_PlasmaCannon
FROM UNITS
JOIN defense ON defense.ID_Defense = units.Defense_ID_Defense
WHERE units.Planet_ID_Planet = planeta AND defense.name ='Missile Launcher';

update_Script := 'UPDATE PLANET 
num_LightHunter = '''||cant_LightHunter||''', 
num_HeavyHunter = '''||cant_HeavyHunter||''', 
num_BattleShip = '''||cant_BattleShip||''', 
num_ArmoredShip = '''||cant_ArmoredShip||''', 
num_MissileLauncher = '''||cant_MissileLauncher||''', 
num_IonCannon = '''||cant_IonCannon||''', 
num_PlasmaCannon = '''||cant_PlasmaCannon||''',
WHERE id_planet = '||planeta||'';

execute immediate update_script;

DBMS_OUTPUT.PUT_LINE('Actualizada el ejercito del planeta '||planeta||':');
DBMS_OUTPUT.PUT_LINE('Light Hunters: '||cant_LightHunter);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters: '||cant_HeavyHunter);
DBMS_OUTPUT.PUT_LINE('BattleShips: '||cant_BattleShip);
DBMS_OUTPUT.PUT_LINE('ArmoredShips: '||cant_ArmoredShip);
DBMS_OUTPUT.PUT_LINE('Missile Launchers: '||cant_MissileLauncher);
DBMS_OUTPUT.PUT_LINE('Ion Cannons: '||cant_IonCannon);
DBMS_OUTPUT.PUT_LINE('Plasma Cannons: '||cant_PlasmaCannon);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso COUNT_ARMY_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
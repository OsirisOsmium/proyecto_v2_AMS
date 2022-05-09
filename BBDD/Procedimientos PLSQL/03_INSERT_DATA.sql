CREATE OR REPLACE PROCEDURE INSERT_DATA

IS

insert_LightHunter VARCHAR(1000) := 'INSERT INTO SHIP VALUES(1, ''Light Hunter'', 3000, 0, 50, 400, null, 80, 3, 20)';
insert_HeavyHunter VARCHAR(1000) := 'INSERT INTO SHIP VALUES(2, ''Heavy Hunter'', 6500, 0, 50, 1000, null, 150, 7, 30)';
insert_BattleShip VARCHAR(1000) := 'INSERT INTO SHIP VALUES(3, ''Battle Ship'', 45000, 0, 7000, 6000, null, 1000, 45, 60)';
insert_ArmoredShip VARCHAR(1000) := 'INSERT INTO SHIP VALUES(4, ''Armored Ship'', 30000, 0, 15000, 8000, null, 700, 70, 75)';
insert_MissileLauncher VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES (1, ''Missile Launcher'', 2000, 0, 0, 200, null, 80, 5, 10)';
insert_IonCannon VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES(2, ''Ion Cannon'', 4000, 0, 500, 1200, null, 250, 12, 25)';
insert_PlasmaCannon VARCHAR(1000) := 'INSERT INTO DEFENSE VALUES(3, ''PLasma Cannon'', 50000, 0, 5000, 7000, null, 2000, 30, 50)';

BEGIN

execute immediate insert_LightHunter;
execute immediate insert_HeavyHunter;
execute immediate insert_BattleShip;
execute immediate insert_ArmoredShip;
DBMS_OUTPUT.PUT_LINE('Insertados los datos de las naves en la tabla SHIP');

execute immediate insert_MissileLauncher;
execute immediate insert_IonCannon;
execute immediate insert_PlasmaCannon;
DBMS_OUTPUT.PUT_LINE('Insertados lo datos de las estructuras defensivas en la tabla DEFENSE');

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT DATA:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;


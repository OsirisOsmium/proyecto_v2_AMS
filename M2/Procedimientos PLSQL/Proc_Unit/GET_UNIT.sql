CREATE OR REPLACE PROCEDURE SET_UNIT(ID_Entrada IN units.ID_unit%TYPE, 
defensa OUT units.defense_Level%TYPE, 
ataque OUT units.attack_Level%TYPE, 
unidadDefensiva OUT units.defense_ID_Defense%TYPE, 
unidadNave OUT units.ship_ID_Ship%TYPE, 
enemigo OUT units.enemy_ID_Enemy%TYPE, 
planeta OUT units.planet_ID_planet%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_Unit) INTO id_Encontrada
FROM UNITS
WHERE id_Unit = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT defense_Level, attack_Level, defense_ID_defense, 
ship_ID_ship, enemy_ID_enemy, planet_ID_planet
INTO defensa, ataque, unidadDefensiva, unidadNave, enemigo, planeta
FROM UNITS
WHERE ID_Unit = id_Entrada;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');


WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_UNIT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;
CREATE OR REPLACE PROCEDURE SET_UNITS(ID_Entrada IN units.ID_unit%TYPE, 
defensa IN units.defense_Level%TYPE, 
ataque IN units.attack_Level%TYPE, 
unidadDefensiva IN units.defense_ID_Defense%TYPE, 
unidadNave IN units.ship_ID_Ship%TYPE, 
enemigo IN units.enemy_ID_Enemy%TYPE, 
planeta IN units.planet_ID_planet%TYPE)

IS
defensa_Insertar units.defense_Level%TYPE;
ataque_Insertar units.attack_Level%TYPE; 
unidadDefensiva_Insertar units.defense_ID_Defense%TYPE;
unidadNave_Insertar units.ship_ID_Ship%TYPE;
enemigo_Insertar units.enemy_ID_Enemy%TYPE;
planeta_Insertar units.planet_ID_planet%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_Unit) INTO id_Encontrada
FROM UNITS
WHERE id_Unit = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF defensa IS NULL THEN
SELECT defense_Level INTO defensa_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
defensa_Insertar := defensa;
END IF;

IF ataque IS NULL THEN
SELECT attack_level INTO ataque_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
ataque_Insertar := ataque;
END IF;

IF unidadDefensiva IS NULL THEN
SELECT defense_ID_defense INTO unidadDefensiva_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
unidadDefensiva_Insertar := unidadDefensiva;
END IF;

IF unidadNave IS NULL THEN
SELECT ship_ID_Ship INTO unidadNave_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
unidadNave_Insertar := unidadNave;
END IF;

IF enemigo IS NULL THEN
SELECT enemy_ID_Enemy INTO enemigo_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
enemigo_Insertar := enemigo;
END IF;

IF planeta IS NULL THEN
SELECT planet_ID_planet INTO planeta_Insertar
FROM UNITS
WHERE id_Unit = id_Entrada;
ELSE
planeta_Insertar := planeta;
END IF;

update_Script := 'UPDATE units
SET defense_level = '''||defensa_Insertar||''',
SET attack_Level = '''||ataque_insertar||''',
SET defense_ID_Defense= '''||unidadDefensiva_insertar||''',
SET ship_ID_Ship = '''||unidadNave_insertar||''',
SET enemy_ID_Enemy= '''||enemigo_Insertar||''',
SET planet_ID_Planet= '''||planeta_insertar||'''
WHERE id_player = '||id_Entrada||'';

execute immediate update_Script;
DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos UNITS con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Nivel Tecnologico Defensa: '||Defensa_Insertar);
DBMS_OUTPUT.PUT_LINE('Nivel Tecnologico Ataque: '||Ataque_Insertar);
DBMS_OUTPUT.PUT_LINE('ID Estructura defensiva: '||unidadDefensiva_Insertar);
DBMS_OUTPUT.PUT_LINE('ID Nave: '||unidadNave_Insertar);
DBMS_OUTPUT.PUT_LINE('ID Enemigo: '||enemigo_Insertar);
DBMS_OUTPUT.PUT_LINE('ID Planeta: '||planeta_Insertar);

COMMIT;

EXCEPTION
WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_UNIT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
CREATE OR REPLACE PROCEDURE INSERT_UNIT(ID_Entrada IN units.ID_unit%TYPE, 
defensa IN units.defense_Level%TYPE, 
ataque IN units.attack_Level%TYPE, 
unidadDefensiva IN units.defense_ID_Defense%TYPE, 
unidadNave IN units.ship_ID_Ship%TYPE, 
enemigo IN units.enemy_ID_Enemy%TYPE, 
planeta IN units.planet_ID_planet%TYPE)

IS
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);

excepcion_DefensaNave1 EXCEPTION;
excepcion_DefensaNave2 EXCEPTION;
excepcion_planetaEnemigo1 EXCEPTION;
excepcion_planetaEnemigo2 EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN

SELECT MAX(id_unit) INTO max_Id
FROM UNITS;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;

IF unidadDefensiva IS NOT NULL AND unidadNave IS NOT NULL THEN
RAISE excepcion_DefensaNave1;
END IF;

IF unidadDefensiva IS NULL AND unidadNave IS NULL THEN
RAISE excepcion_DefensaNave2;
END IF;

IF planeta IS NOT NULL AND enemigo IS NOT NULL THEN
RAISE excepcion_planetaEnemigo1;
END IF;

IF planeta IS NULL AND enemigo IS NULL THEN
RAISE excepcion_planetaEnemigo2;
END IF;

insert_Script := 'INSERT INTO UNITS
VALUES('''||id_Entrada||''', 
'''||defensa||''', 
'''||ataque||''', 
'''||unidadDefensiva||''',
'''||unidadNave||''',
'''||enemigo||''',
'''||planeta||''')
';

execute immediate insert_Script;

DBMS_OUTPUT.PUT_LINE('Insertados los datos de id '||id_Entrada||' de la base de datos UNIT con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Nivel Tecnologico Defensivo: '||defensa);
DBMS_OUTPUT.PUT_LINE('Nivel Tecnologico Ofensivo: '||ataque);
DBMS_OUTPUT.PUT_LINE('ID Estructura Defensiva: '||unidadDefensiva);
DBMS_OUTPUT.PUT_LINE('ID Nave: '||unidadNave);
DBMS_OUTPUT.PUT_LINE('ID Enemigo: '||enemigo);
DBMS_OUTPUT.PUT_LINE('ID Planeta: '||planeta);

COMMIT;

EXCEPTION

WHEN excepcion_DefensaNave1 THEN
DBMS_OUTPUT.PUT_LINE('La unidad no puede tener simultaneamente una id de nave y una de defensa');
ROLLBACK;

WHEN excepcion_DefensaNave2 THEN
DBMS_OUTPUT.PUT_LINE('La unidad debe tener al menos un id de defensa o una de nave');
ROLLBACK;

WHEN excepcion_planetaEnemigo1 THEN
DBMS_OUTPUT.PUT_LINE('La unidad no puede pertenecer simultaneamente a un planeta y un enemigo');
ROLLBACK;

WHEN excepcion_planetaEnemigo2 THEN
DBMS_OUTPUT.PUT_LINE('La unidad debe pertenecer al menos a un planeta o un enemigo');
ROLLBACK;


WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_UNIT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
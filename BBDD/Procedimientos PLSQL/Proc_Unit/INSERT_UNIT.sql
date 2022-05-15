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
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_unit) INTO id_Encontrada
FROM UNITS
WHERE id_Unit = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

IF id_Entrada IS NULL THEN
SELECT MAX(id_unit) INTO max_Id
FROM UNITS;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;
ELSE
id_Entrada_Insertar := id_Entrada;
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

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_UNIT:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
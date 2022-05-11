CREATE OR REPLACE PROCEDURE INSERT_BATTLE(
id_Entrada IN battle.ID_Battle%TYPE,
usuario IN battle.user_ID_User%TYPE,
enemigo IN battle.enemy_ID_Enemy%TYPE,
planeta IN battle.planet_ID_planet%TYPE,
reporte_Pasos IN battle.report_StepByStep%TYPE,
ganador IN battle.ID_Winner%TYPE,
residuos_Metal IN battle.waste_Metal%TYPE,
residuos_Deuterio IN battle.waste_Deuterium%TYPE,

UI_CazadoresL IN battle.UI_LightHunter%TYPE,
UI_CazadoresH IN battle.UI_HeavyHunter%TYPE,
UI_navesBatalla IN battle.UI_BattleShip%TYPE,
UI_Acorazados IN battle.UI_ArmoredShip%TYPE,
UI_Lanzamisiles IN battle.UI_MissileLauncher%TYPE,
UI_CañonIones IN battle.UI_IonCannon%TYPE,
UI_CañonPlasma IN battle.UI_PlasmaCannon%TYPE,

UF_CazadoresL IN battle.UF_LightHunter%TYPE,
UF_CazadoresH IN battle.UF_HeavyHunter%TYPE,
UF_navesBatalla IN battle.UF_BattleShip%TYPE,
UF_Acorazados IN battle.UF_ArmoredShip%TYPE,
UF_Lanzamisiles IN battle.UF_MissileLauncher%TYPE,
UF_CañonIones IN battle.UF_IonCannon%TYPE,
UF_CañonPlasma IN battle.UF_PlasmaCannon%TYPE,

EI_CazadoresL IN battle.EI_LightHunter%TYPE,
EI_CazadoresH IN battle.EI_HeavyHunter%TYPE,
EI_navesBatalla IN battle.EI_BattleShip%TYPE,
EI_Acorazados IN battle.EI_ArmoredShip%TYPE,

EF_CazadoresL IN battle.EF_LightHunter%TYPE,
EF_CazadoresH IN battle.EF_HeavyHunter%TYPE,
EF_navesBatalla IN battle.EF_BattleShip%TYPE,
EF_Acorazados IN battle.EF_ArmoredShip%TYPE
)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_Planet) INTO id_Encontrada
FROM PLANET
WHERE id_Planet = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

insert_Script := 'INSERT INTO BATTLE
VALUES('''||id_Entrada||''',
'''||usuario||''',
'''||enemigo||''',
'''||planeta||''',
'''||reporte_Pasos||''',
'''||ganador||''',
'''||residuos_Metal||''',
'''||residuos_Deuterio||''',

'''||UI_CazadoresL||''',
'''||UI_CazadoresH||''',
'''||UI_navesBatalla||''',
'''||UI_acorazados||''',
'''||UI_Lanzamisiles||''',
'''||UI_CañonIones||''',
'''||UI_CañonPlasma||''',

'''||UF_CazadoresL||''',
'''||UF_CazadoresH||''',
'''||UF_navesBatalla||''',
'''||UF_acorazados||''',
'''||UF_Lanzamisiles||''',
'''||UF_CañonIones||''',
'''||UF_CañonPlasma||''',

'''||EI_CazadoresL||''',
'''||EI_CazadoresH||''',
'''||EI_navesBatalla||''',
'''||EI_acorazados||''',

'''||EF_CazadoresL||''',
'''||EF_CazadoresH||''',
'''||EF_navesBatalla||''',
'''||EF_acorazados||''')
';

execute immediate insert_script;

DBMS_OUTPUT.PUT_LINE('Insertados los datos de id '||id_Entrada||' de la base de datos BATTLE con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE(': '||id_Entrada);
DBMS_OUTPUT.PUT_LINE(': '||usuario);
DBMS_OUTPUT.PUT_LINE(': '||enemigo);
DBMS_OUTPUT.PUT_LINE(': '||planeta);
DBMS_OUTPUT.PUT_LINE(': '||reporte_Pasos);
DBMS_OUTPUT.PUT_LINE(': '||ganador);
DBMS_OUTPUT.PUT_LINE(': '||residuos_Metal);
DBMS_OUTPUT.PUT_LINE(': '||residuos_Deuterio);

DBMS_OUTPUT.PUT_LINE(': '||UI_CazadoresL);
DBMS_OUTPUT.PUT_LINE(': '||UI_CazadoresH);
DBMS_OUTPUT.PUT_LINE(': '||UI_NavesBatalla);
DBMS_OUTPUT.PUT_LINE(': '||UI_Acorazados);
DBMS_OUTPUT.PUT_LINE(': '||UI_Lanzamisiles);
DBMS_OUTPUT.PUT_LINE(': '||UI_CañonIones);
DBMS_OUTPUT.PUT_LINE(': '||UI_CañonPlasma);

DBMS_OUTPUT.PUT_LINE(': '||UF_CazadoresL);
DBMS_OUTPUT.PUT_LINE(': '||UF_CazadoresH);
DBMS_OUTPUT.PUT_LINE(': '||UF_NavesBatalla);
DBMS_OUTPUT.PUT_LINE(': '||UF_Acorazados);
DBMS_OUTPUT.PUT_LINE(': '||UF_Lanzamisiles);
DBMS_OUTPUT.PUT_LINE(': '||UF_CañonIones);
DBMS_OUTPUT.PUT_LINE(': '||UF_CañonPlasma);

DBMS_OUTPUT.PUT_LINE(': '||EI_CazadoresL);
DBMS_OUTPUT.PUT_LINE(': '||EI_CazadoresH);
DBMS_OUTPUT.PUT_LINE(': '||EI_NavesBatalla);
DBMS_OUTPUT.PUT_LINE(': '||EI_Acorazados);

DBMS_OUTPUT.PUT_LINE(': '||EF_CazadoresL);
DBMS_OUTPUT.PUT_LINE(': '||EF_CazadoresH);
DBMS_OUTPUT.PUT_LINE(': '||EF_NavesBatalla);
DBMS_OUTPUT.PUT_LINE(': '||EF_Acorazados);

COMMIT;

EXCEPTION
WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
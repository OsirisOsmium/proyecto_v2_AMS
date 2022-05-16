CREATE OR REPLACE PROCEDURE INSERT_BATTLE(
id_Entrada IN battle.ID_Battle%TYPE,
usuario IN battle.user_ID_User%TYPE,
enemigo IN battle.enemy_ID_Enemy%TYPE,
planeta IN battle.planet_ID_planet%TYPE,
ganador_Usuario IN battle.User_Winner%TYPE,
ganador_Enemigo IN battle.enemy_Winner%TYPE,
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
max_Id NUMBER(6) := 0;
id_Entrada_Insertar NUMBER(6);

insert_Script VARCHAR(1000);

BEGIN

SELECT MAX(id_battle) INTO max_Id
FROM BATTLE;
IF max_Id IS NULL THEN
id_Entrada_Insertar := 1;
ELSE
id_Entrada_Insertar := max_Id +1;
END IF;

insert_Script := 'INSERT INTO BATTLE
VALUES('''||id_Entrada_Insertar||''',
'''||usuario||''',
'''||enemigo||''',
'''||planeta||''',
'''||ganador_Usuario||''',
'''||ganador_Enemigo||''',
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

DBMS_OUTPUT.PUT_LINE('Insertada la nueva id '||id_Entrada_Insertar||' en la tabla BATTLE con estos valores:');
DBMS_OUTPUT.PUT_LINE('Usuario Participante: '||usuario);
DBMS_OUTPUT.PUT_LINE('Enemigo Participante: '||enemigo);
DBMS_OUTPUT.PUT_LINE('Planeta: '||planeta);
DBMS_OUTPUT.PUT_LINE('Usuario es Ganador: '||ganador_Usuario);
DBMS_OUTPUT.PUT_LINE('Enemigo es Ganador: '||ganador_Usuario);
DBMS_OUTPUT.PUT_LINE('Residuos de Metal: '||residuos_Metal);
DBMS_OUTPUT.PUT_LINE('Residuos de Deuterio: '||residuos_Deuterio);

DBMS_OUTPUT.PUT_LINE('Light Hunters Iniciales Usuario: '||UI_CazadoresL);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters Iniciales Usuario: '||UI_CazadoresH);
DBMS_OUTPUT.PUT_LINE('Naves Batalla Iniciales Usuario: '||UI_NavesBatalla);
DBMS_OUTPUT.PUT_LINE('Acorazados Iniciales Usuario: '||UI_Acorazados);
DBMS_OUTPUT.PUT_LINE('Lanzamisiles Iniciales Usuario: '||UI_Lanzamisiles);
DBMS_OUTPUT.PUT_LINE('Cañones Iones Iniciales Usuario: '||UI_CañonIones);
DBMS_OUTPUT.PUT_LINE('Cañones Plasma Iniciales Usuario: '||UI_CañonPlasma);

DBMS_OUTPUT.PUT_LINE('Light Hunters Iniciales Usuario: '||UF_CazadoresL);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters Iniciales Usuario: '||UF_CazadoresH);
DBMS_OUTPUT.PUT_LINE('Naves Batalla Iniciales Usuario: '||UF_NavesBatalla);
DBMS_OUTPUT.PUT_LINE('Acorazados Iniciales Usuario: '||UF_Acorazados);
DBMS_OUTPUT.PUT_LINE('Lanzamisiles Iniciales Usuario: '||UF_Lanzamisiles);
DBMS_OUTPUT.PUT_LINE('Cañones Iones Iniciales Usuario: '||UF_CañonIones);
DBMS_OUTPUT.PUT_LINE('Cañones Plasma Iniciales Usuario: '||UF_CañonPlasma);

DBMS_OUTPUT.PUT_LINE('Light Hunters Iniciales Enemigo: '||EI_CazadoresL);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters Iniciales Eenmigo: '||EI_CazadoresH);
DBMS_OUTPUT.PUT_LINE('Naves Batalla Iniciales Enemigo: '||EI_NavesBatalla);
DBMS_OUTPUT.PUT_LINE('Acorazados Hunters Iniciales Enemigo: '||EI_Acorazados);

DBMS_OUTPUT.PUT_LINE('Light Hunters Finales Enemigo: '||EF_CazadoresL);
DBMS_OUTPUT.PUT_LINE('Heavy Hunters Finales Enemigo: '||EF_CazadoresH);
DBMS_OUTPUT.PUT_LINE('Naves Batalla Finales Enemigo: '||EF_NavesBatalla);
DBMS_OUTPUT.PUT_LINE('Acorazados Finales Enemigo: '||EF_Acorazados);

COMMIT;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_BATTLE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
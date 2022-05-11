CREATE OR REPLACE PROCEDURE SET_BATTLE(
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

id_Entrada_Insertar  battle.ID_Battle%TYPE;
usuario_Insertar  battle.user_ID_User%TYPE;
enemigo_Insertar  battle.enemy_ID_Enemy%TYPE;
planeta_Insertar  battle.planet_ID_planet%TYPE;
reporte_Pasos_Insertar  battle.report_StepByStep%TYPE;
ganador_Insertar  battle.ID_Winner%TYPE;
residuos_Metal_Insertar  battle.waste_Metal%TYPE;
residuos_Deuterio_Insertar  battle.waste_Deuterium%TYPE;

UI_CazadoresL_Insertar battle.UI_LightHunter%TYPE;
UI_CazadoresH_Insertar battle.UI_HeavyHunter%TYPE;
UI_navesBatalla_Insertar battle.UI_BattleShip%TYPE;
UI_Acorazados_insertar battle.UI_ArmoredShip%TYPE;
UI_Lanzamisiles_Insertar battle.UI_MissileLauncher%TYPE;
UI_CañonIones_Insertar battle.UI_IonCannon%TYPE;
UI_CañonPlasma_Insertar battle.UI_PlasmaCannon%TYPE;

UF_CazadoresL_Insertar battle.UF_LightHunter%TYPE;
UF_CazadoresH_Insertar battle.UF_HeavyHunter%TYPE;
UF_navesBatalla_Insertar battle.UF_BattleShip%TYPE;
UF_Acorazados_Insertar battle.UF_ArmoredShip%TYPE;
UF_Lanzamisiles_Insertar battle.UF_MissileLauncher%TYPE;
UF_CañonIones_Insertar battle.UF_IonCannon%TYPE;
UF_CañonPlasma_Insertar battle.UF_PlasmaCannon%TYPE;

EI_CazadoresL_Insertar battle.EI_LightHunter%TYPE;
EI_CazadoresH_Insertar battle.EI_HeavyHunter%TYPE;
EI_navesBatalla_Insertar battle.EI_BattleShip%TYPE;
EI_Acorazados_Insertar battle.EI_ArmoredShip%TYPE;

EF_CazadoresL_Insertar battle.EF_LightHunter%TYPE;
EF_CazadoresH_Insertar battle.EF_HeavyHunter%TYPE;
EF_navesBatalla_Insertar battle.EF_BattleShip%TYPE;
EF_Acorazados_Insertar battle.EF_ArmoredShip%TYPE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_Battle) INTO id_Encontrada
FROM BATTLE
WHERE id_Battle = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF usuario IS NULL THEN
SELECT user_ID_user INTO usuario_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
usuario_Insertar := usuario;
END IF;

IF enemigo IS NULL THEN
SELECT enemy_ID_enemy INTO enemigo_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
enemigo_Insertar := enemigo;
END IF;

IF planeta IS NULL THEN
SELECT planet_ID_planet INTO planeta_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
planeta_Insertar := planeta;
END IF;


IF reporte_Pasos IS NULL THEN
SELECT report_StepByStep INTO reporte_Pasos_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
reporte_Pasos_Insertar := reporte_Pasos;
END IF;

IF ganador IS NULL THEN
SELECT ID_Winner INTO ganador_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ganador_Insertar := ganador;
END IF;

IF residuos_Metal IS NULL THEN
SELECT waste_Metal INTO residuos_Metal_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
residuos_Metal_Insertar := residuos_Metal;
END IF;

IF residuos_Deuterio IS NULL THEN
SELECT waste_Deuterium INTO residuos_Deuterio_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
residuos_Deuterio_Insertar := residuos_Deuterio;
END IF;

IF ui_CazadoresL IS NULL THEN
SELECT UI_LightHunter INTO ui_CazadoresL_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_CazadoresL_Insertar := ui_CazadoresL;
END IF;

IF ui_CazadoresH IS NULL THEN
SELECT UI_HeavyHunter INTO ui_CazadoresH_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_CazadoresH_Insertar := ui_CazadoresH;
END IF;

IF ui_navesBatalla IS NULL THEN
SELECT UI_Battleship INTO ui_navesBatalla_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_navesBatalla_Insertar := ui_navesBatalla;
END IF;

IF ui_Acorazados IS NULL THEN
SELECT UI_ArmoredShip INTO ui_Acorazados_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_Acorazados_Insertar := ui_Acorazados;
END IF;

IF ui_Lanzamisiles IS NULL THEN
SELECT UI_MissileLauncher INTO ui_Lanzamisiles_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_Lanzamisiles_Insertar := ui_Lanzamisiles;
END IF;

IF ui_CañonIones IS NULL THEN
SELECT UI_IonCannon INTO ui_CañonIones_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_CañonIones_Insertar := ui_CañonIones;
END IF;

IF ui_CañonPlasma IS NULL THEN
SELECT UI_PlasmaCannon INTO ui_CañonPlasma_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ui_CañonPlasma_Insertar := ui_CañonPlasma;
END IF;

IF uf_CazadoresL IS NULL THEN
SELECT uf_LightHunter INTO uf_CazadoresL_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_CazadoresL_Insertar := uf_CazadoresL;
END IF;

IF uf_CazadoresH IS NULL THEN
SELECT uf_HeavyHunter INTO uf_CazadoresH_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_CazadoresH_Insertar := uf_CazadoresH;
END IF;

IF uf_navesBatalla IS NULL THEN
SELECT uf_Battleship INTO uf_navesBatalla_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_navesBatalla_Insertar := uf_navesBatalla;
END IF;

IF uf_Acorazados IS NULL THEN
SELECT uf_ArmoredShip INTO uf_Acorazados_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_Acorazados_Insertar := uf_Acorazados;
END IF;

IF uf_Lanzamisiles IS NULL THEN
SELECT uf_MissileLauncher INTO uf_Lanzamisiles_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_Lanzamisiles_Insertar := uf_Lanzamisiles;
END IF;

IF uf_CañonIones IS NULL THEN
SELECT uf_IonCannon INTO uf_CañonIones_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_CañonIones_Insertar := uf_CañonIones;
END IF;

IF uf_CañonPlasma IS NULL THEN
SELECT uf_PlasmaCannon INTO uf_CañonPlasma_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
uf_CañonPlasma_Insertar := uf_CañonPlasma;
END IF;

IF ei_CazadoresL IS NULL THEN
SELECT ei_LightHunter INTO ei_CazadoresL_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ei_CazadoresL_Insertar := ei_CazadoresL;
END IF;

IF ei_CazadoresH IS NULL THEN
SELECT ei_HeavyHunter INTO ei_CazadoresH_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ei_CazadoresH_Insertar := ei_CazadoresH;
END IF;

IF ei_navesBatalla IS NULL THEN
SELECT ei_Battleship INTO ei_navesBatalla_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ei_navesBatalla_Insertar := ei_navesBatalla;
END IF;

IF ei_Acorazados IS NULL THEN
SELECT ei_ArmoredShip INTO ei_Acorazados_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ei_Acorazados_Insertar := ei_Acorazados;
END IF;

IF ef_CazadoresL IS NULL THEN
SELECT ef_LightHunter INTO ef_CazadoresL_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ef_CazadoresL_Insertar := ef_CazadoresL;
END IF;

IF ef_CazadoresH IS NULL THEN
SELECT ef_HeavyHunter INTO ef_CazadoresH_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ef_CazadoresH_Insertar := ef_CazadoresH;
END IF;

IF ef_navesBatalla IS NULL THEN
SELECT ef_Battleship INTO ef_navesBatalla_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ef_navesBatalla_Insertar := ef_navesBatalla;
END IF;

IF ef_Acorazados IS NULL THEN
SELECT ef_ArmoredShip INTO ef_Acorazados_Insertar
FROM BATTLE
WHERE id_Battle = id_Entrada;
ELSE
ef_Acorazados_Insertar := ef_Acorazados;
END IF;

update_Script := 'UPDATE BATTLE
SET user_id_user = '''||usuario_Insertar||''',
SET enemy_id_enemy = '''||enemigo_Insertar||''',
SET planet_id_planet = '''||planeta_Insertar||''',
SET report_StebByStep = '''||reporte_Pasos_Insertar||''',
SET ID_Winner = '''||ganador_Insertar||''',
SET waste_Metal = '''||residuos_Metal_Insertar||''',
SET waste_Deuterium = '''||residuos_Deuterio_Insertar||''',

SET UI_LightHunter = '''||UI_CazadoresL_Insertar||''',
SET UI_HeavyHunter = '''||UI_CazadoresH_Insertar||''',
SET UI_BattleShip = '''||UI_navesBatalla_Insertar||''',
SET UI_ArmoredShip = '''||UI_acorazados_Insertar||''',
SET UI_MissileLauncher = '''||UI_Lanzamisiles_Insertar||''',
SET UI_IonCannon = '''||UI_CañonIones_Insertar||''',
SET UI_PlasmaCannon = '''||UI_CañonPlasma_Insertar||''',

SET UF_LightHunter = '''||UF_CazadoresL_Insertar||''',
SET UF_HeavyHunter = '''||UF_CazadoresH_Insertar||''',
SET UF_BattleShip = '''||UF_navesBatalla_Insertar||''',
SET UF_ArmoredShip = '''||UF_acorazados_Insertar||''',
SET UF_MissileLauncher = '''||UF_Lanzamisiles_Insertar||''',
SET UF_IonCannon = '''||UF_CañonIones_Insertar||''',
SET UF_PlasmaCannon = '''||UF_CañonPlasma_Insertar||''',

SET EI_LightHunter = '''||EI_CazadoresL_Insertar||''',
SET EI_HeavyHunter = '''||EI_CazadoresH_Insertar||''',
SET EI_BattleShip = '''||EI_navesBatalla_Insertar||''',
SET EI_ArmoredShip = '''||EI_acorazados_Insertar||''',

SET EF_LightHunter = '''||EF_CazadoresL_Insertar||''',
SET EF_HeavyHunter = '''||EF_CazadoresH_Insertar||''',
SET EF_BattleShip = '''||EF_navesBatalla_Insertar||''',
SET EF_ArmoredShip = '''||EF_acorazados_Insertar||''',
';

execute immediate update_script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos BATTLE con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE(': '||usuario_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||enemigo_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||planeta_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||reporte_Pasos_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||ganador_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||residuos_Metal_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||residuos_Deuterio_insertar);

DBMS_OUTPUT.PUT_LINE(': '||UI_CazadoresL_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_CazadoresH_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_NavesBatalla_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_Acorazados_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_Lanzamisiles_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_CañonIones_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UI_CañonPlasma_Insertar);

DBMS_OUTPUT.PUT_LINE(': '||UF_CazadoresL_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_CazadoresH_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_NavesBatalla_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_Acorazados_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_Lanzamisiles_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_CañonIones_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||UF_CañonPlasma_insertar);

DBMS_OUTPUT.PUT_LINE(': '||EI_CazadoresL_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EI_CazadoresH_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EI_NavesBatalla_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EI_Acorazados_Insertar);

DBMS_OUTPUT.PUT_LINE(': '||EF_CazadoresL_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EF_CazadoresH_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EF_NavesBatalla_Insertar);
DBMS_OUTPUT.PUT_LINE(': '||EF_Acorazados_Insertar);

COMMIT;

EXCEPTION

WHEN excePcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_BATTLE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;
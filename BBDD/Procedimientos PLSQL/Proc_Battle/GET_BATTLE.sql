CREATE OR REPLACE PROCEDURE GET_BATTLE(
id_Entrada IN battle.ID_Battle%TYPE,
usuario OUT battle.user_ID_User%TYPE,
enemigo OUT battle.enemy_ID_Enemy%TYPE,
planeta OUT battle.planet_ID_planet%TYPE,
reporte_Pasos OUT battle.report_StepByStep%TYPE,
ganador OUT battle.ID_Winner%TYPE,
residuos_Metal OUT battle.waste_Metal%TYPE,
residuos_Deuterio OUT battle.waste_Deuterium%TYPE,

UI_CazadoresL OUT battle.UI_LightHunter%TYPE,
UI_CazadoresH OUT battle.UI_HeavyHunter%TYPE,
UI_navesBatalla OUT battle.UI_BattleShip%TYPE,
UI_Acorazados OUT battle.UI_ArmoredShip%TYPE,
UI_Lanzamisiles OUT battle.UI_MissileLauncher%TYPE,
UI_Ca�onIones OUT battle.UI_IonCannon%TYPE,
UI_Ca�onPlasma OUT battle.UI_PlasmaCannon%TYPE,

UF_CazadoresL OUT battle.UF_LightHunter%TYPE,
UF_CazadoresH OUT battle.UF_HeavyHunter%TYPE,
UF_navesBatalla OUT battle.UF_BattleShip%TYPE,
UF_Acorazados OUT battle.UF_ArmoredShip%TYPE,
UF_Lanzamisiles OUT battle.UF_MissileLauncher%TYPE,
UF_Ca�onIones OUT battle.UF_IonCannon%TYPE,
UF_Ca�onPlasma OUT battle.UF_PlasmaCannon%TYPE,

EI_CazadoresL OUT battle.EI_LightHunter%TYPE,
EI_CazadoresH OUT battle.EI_HeavyHunter%TYPE,
EI_navesBatalla OUT battle.EI_BattleShip%TYPE,
EI_Acorazados OUT battle.EI_ArmoredShip%TYPE,

EF_CazadoresL OUT battle.EF_LightHunter%TYPE,
EF_CazadoresH OUT battle.EF_HeavyHunter%TYPE,
EF_navesBatalla OUT battle.EF_BattleShip%TYPE,
EF_Acorazados OUT battle.EF_ArmoredShip%TYPE
)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM "USER"
WHERE id_User = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT user_ID_user, enemy_ID_enemy, planet_ID_planet, report_StepByStep, ID_Winner, waste_Metal, waste_Deuterium,
UI_LightHunter, UI_HeavyHunter, UI_BattleShip, UI_ArmoredShip, UI_MissileLauncher, UI_IonCannon, UI_PlasmaCannon, 
UF_LightHunter, UF_HeavyHunter, UF_BattleShip, UF_ArmoredShip, UF_MissileLauncher, UF_IonCannon, UF_PlasmaCannon,
EI_LightHunter, EI_HeavyHunter, EI_BattleShip, EI_ArmoredShip, 
EF_LightHunter, EF_HeavyHunter, EF_BattleShip, EF_ArmoredShip 
INTO
usuario, enemigo, planeta, reporte_Pasos, ganador, residuos_Metal, residuos_Deuterio,
UI_CazadoresL, UI_CazadoresH, UI_NavesBatalla, UI_Acorazados, UI_Lanzamisiles, UI_Ca�onIones, UI_Ca�onPlasma,
UF_CazadoresL, UF_CazadoresH, UF_NavesBatalla, UF_Acorazados, UF_Lanzamisiles, UF_Ca�onIones, UF_Ca�onPlasma,
EI_CazadoresL, EI_CazadoresH, EI_NavesBatalla, EI_Acorazados, 
EI_CazadoresL, EI_CazadoresH, EI_NavesBatalla, EI_Acorazados
FROM BATTLE
WHERE ID_Battle = id_Entrada;

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;

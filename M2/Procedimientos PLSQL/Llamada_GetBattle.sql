SET SERVEROUTPUT ON

DECLARE
jugador battle.player_ID_player%TYPE;
enemigo battle.enemy_ID_Enemy%TYPE;
planeta battle.planet_ID_planet%TYPE;
ganador_jugador battle.player_Winner%TYPE;
ganador_Enemigo battle.enemy_Winner%TYPE;
residuos_Metal battle.waste_Metal%TYPE;
residuos_Deuterio battle.waste_Deuterium%TYPE;

UI_CazadoresL battle.UI_LightHunter%TYPE;
UI_CazadoresH battle.UI_HeavyHunter%TYPE;
UI_navesBatalla battle.UI_BattleShip%TYPE;
UI_Acorazados battle.UI_ArmoredShip%TYPE;
UI_Lanzamisiles battle.UI_MissileLauncher%TYPE;
UI_CanonIones battle.UI_IonCannon%TYPE;
UI_CanonPlasma battle.UI_PlasmaCannon%TYPE;

UF_CazadoresL battle.UF_LightHunter%TYPE;
UF_CazadoresH battle.UF_HeavyHunter%TYPE;
UF_navesBatalla battle.UF_BattleShip%TYPE;
UF_Acorazados battle.UF_ArmoredShip%TYPE;
UF_Lanzamisiles battle.UF_MissileLauncher%TYPE;
UF_CanonIones battle.UF_IonCannon%TYPE;
UF_CanonPlasma battle.UF_PlasmaCannon%TYPE;

EI_CazadoresL battle.EI_LightHunter%TYPE;
EI_CazadoresH battle.EI_HeavyHunter%TYPE;
EI_navesBatalla battle.EI_BattleShip%TYPE;
EI_Acorazados battle.EI_ArmoredShip%TYPE;

EF_CazadoresL battle.EF_LightHunter%TYPE;
EF_CazadoresH battle.EF_HeavyHunter%TYPE;
EF_navesBatalla battle.EF_BattleShip%TYPE;
EF_Acorazados battle.EF_ArmoredShip%TYPE;

BEGIN
/*
INSERT_player(1, 'albert', 'qwerty', '15/6/2000');
INSERT_ENEMY('pepe', 1000, 100, 100, 10, 10, 10, 10);
INSERT_PLANET( 1, 'Venus', 1000, 100, 100, 10, 8, 4, 1, 5, 2, 1,1, 100,1, 100);

INSERT_BATTLE(1, 1, 1, 1, 0, 500, 100, 
10, 10, 5, 5, 5, 5, 1, 
5, 5, 1, 1, 1, 1, 1,
10, 10, 5, 5, 
5, 5, 2, 2);
*/
GET_BATTLE(
1,
jugador,
enemigo,
planeta,
ganador_jugador,
ganador_Enemigo,
residuos_Metal,
residuos_Deuterio,

UI_CazadoresL,
UI_CazadoresH,
UI_navesBatalla,
UI_Acorazados,
UI_Lanzamisiles,
UI_CanonIones,
UI_CanonPlasma,

UF_CazadoresL,
UF_CazadoresH,
UF_navesBatalla,
UF_Acorazados,
UF_Lanzamisiles,
UF_CanonIones,
UF_CanonPlasma,

EI_CazadoresL,
EI_CazadoresH,
EI_navesBatalla,
EI_Acorazados,

EF_CazadoresL,
EF_CazadoresH,
EF_navesBatalla,
EF_Acorazados);

DBMS_OUTPUT.PUT_LINE(UF_Acorazados);
DBMS_OUTPUT.PUT_LINE(UF_Acorazados);
DBMS_OUTPUT.PUT_LINE(EI_Acorazados);
DBMS_OUTPUT.PUT_LINE(EF_Acorazados);

END;
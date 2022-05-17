package report;

public class report {
	public static void main(String[] args) {
		/*Todo esto son variables tipo int*/
		
		int 
		/*Battle number seria el id de la batalla*/
		battle_Number,
		/*Costes de las unidades para calcular los costes totales y perdidas*/
		metal_LightHunter, metal_HeavyHunter, metal_BattleShip, metal_ArmoredShip,
		metal_MissileLauncher, metal_IonCannon, metal_PlasmaCannon,
		deuterium_LightHunter, deuterium_HeavyHunter, deuterium_BattleShip, deuterium_ArmoredShip,
		deuterium_MissileLauncher, deuterium_IonCannon, deuterium_PlasmaCannon,
		/*Unidades iniciales Planeta*/
		planet_LightHunters, planet_HeavyHunters, 
		planet_BattleShips, planet_ArmoredShips, 
		planet_MissileLauncher, planet_IonCannon, 
		planet_PlasmaCannon,
		/*Unidades iniciales enemigo*/
		enemy_LightHunters, enemy_HeavyHunters,
		enemy_BattleShips, enemy_ArmoredShips,
		/*Unidades finales Planeta*/
		planet_LightHunters_F, planet_HeavyHunters_F, 
		planet_BattleShips_F, planet_ArmoredShips_F, 
		planet_MissileLauncher_F, planet_IonCannon_F, 
		planet_PlasmaCannon_F,
		/*Unidades finales enemigo*/
		enemy_LightHunters_F, enemy_HeavyHunters_F,
		enemy_BattleShips_F, enemy_ArmoredShips_F,
		/*Los costes de los ejercitos del planeta y del enemigo*/
		cost_Metal_Planet, cost_Deuterium_Planet, 
		cost_Metal_Enemy, cost_Deuterium_Enemy,
		/*Las perdidas en recursos del planeta y del enemigo*/
		losses_Metal_Planet, losses_Deuterium_Planet, losses_Weighted_Planet,
		losses_Metal_Enemy, losses_Deuterium_Enemy, losses_Enemy_Weighted,
		/*Residuos generades*/
		waste_Metal, waste_Deuterium;
		
		boolean winner_Planet, winner_Enemy, view_Battle;
		
		String message_Winner_Planet = "Battle Winned by Planet, We Collect Rubble",
				message_Winner_Enemy = "Battle Winned by the Enemy";
		
		battle_Number =1;
		
		metal_LightHunter= 3000;
		metal_HeavyHunter= 6500;
		metal_BattleShip= 45000;
		metal_ArmoredShip= 30000;
		metal_MissileLauncher= 2000;
		metal_IonCannon= 4000;
		metal_PlasmaCannon= 50000;
		deuterium_LightHunter= 50;
		deuterium_HeavyHunter= 50;
		deuterium_BattleShip= 7000;
		deuterium_ArmoredShip= 15000;
		deuterium_MissileLauncher= 0;
		deuterium_IonCannon= 500;
		deuterium_PlasmaCannon= 5000;
		
		planet_LightHunters= 11; 
		planet_HeavyHunters= 3; 
		planet_BattleShips= 1; 
		planet_ArmoredShips= 1;
		planet_MissileLauncher= 11; 
		planet_IonCannon= 1;
		planet_PlasmaCannon= 1;
		
		enemy_LightHunters= 19; 
		enemy_HeavyHunters= 7;
		enemy_BattleShips= 1;
		enemy_ArmoredShips= 1;
		
		planet_LightHunters_F= 3; 
		planet_HeavyHunters_F= 2; 
		planet_BattleShips_F= 1; 
		planet_ArmoredShips_F= 1;
		planet_MissileLauncher_F= 2; 
		planet_IonCannon_F= 0;
		planet_PlasmaCannon_F= 1;
		
		enemy_LightHunters_F= 2; 
		enemy_HeavyHunters_F= 2;
		enemy_BattleShips_F= 0;
		enemy_ArmoredShips_F= 1;
		
		cost_Metal_Planet= (
				(metal_LightHunter*  planet_LightHunters) +
				(metal_HeavyHunter * planet_HeavyHunters) +
				(metal_BattleShip * planet_BattleShips) +
				(metal_ArmoredShip * planet_ArmoredShips) +
				(metal_MissileLauncher * planet_MissileLauncher) +
				(metal_IonCannon * planet_IonCannon) +
				(metal_PlasmaCannon * planet_PlasmaCannon)
				); 
		cost_Deuterium_Planet= (
				(deuterium_LightHunter*  planet_LightHunters) +
				(deuterium_HeavyHunter * planet_HeavyHunters) +
				(deuterium_BattleShip * planet_BattleShips) +
				(deuterium_ArmoredShip * planet_ArmoredShips) +
				(deuterium_MissileLauncher * planet_MissileLauncher) +
				(deuterium_IonCannon * planet_IonCannon) +
				(deuterium_PlasmaCannon * planet_PlasmaCannon)
				); 
		cost_Metal_Enemy= (
				(metal_LightHunter*  enemy_LightHunters) +
				(metal_HeavyHunter * enemy_HeavyHunters) +
				(metal_BattleShip * enemy_BattleShips) +
				(metal_ArmoredShip * enemy_ArmoredShips) 
				);
		cost_Deuterium_Enemy= (
				(deuterium_LightHunter*  enemy_LightHunters) +
				(deuterium_HeavyHunter * enemy_HeavyHunters) +
				(deuterium_BattleShip * enemy_BattleShips) +
				(deuterium_ArmoredShip * enemy_ArmoredShips) 
				);
		
		losses_Metal_Planet= (
				(metal_LightHunter*  planet_LightHunters_F) +
				(metal_HeavyHunter * planet_HeavyHunters_F) +
				(metal_BattleShip * planet_BattleShips_F) +
				(metal_ArmoredShip * planet_ArmoredShips_F) +
				(metal_MissileLauncher * planet_MissileLauncher_F) +
				(metal_IonCannon * planet_IonCannon_F) +
				(metal_PlasmaCannon * planet_PlasmaCannon_F)
				);
		losses_Deuterium_Planet= (
				(deuterium_LightHunter*  planet_LightHunters_F) +
				(deuterium_HeavyHunter * planet_HeavyHunters_F) +
				(deuterium_BattleShip * planet_BattleShips_F) +
				(deuterium_ArmoredShip * planet_ArmoredShips_F) +
				(deuterium_MissileLauncher * planet_MissileLauncher_F) +
				(deuterium_IonCannon * planet_IonCannon_F) +
				(deuterium_PlasmaCannon * planet_PlasmaCannon_F)
				);
		losses_Weighted_Planet= (losses_Metal_Planet + (losses_Deuterium_Planet*5));
		losses_Metal_Enemy= (
				(metal_LightHunter*  enemy_LightHunters_F) +
				(metal_HeavyHunter * enemy_HeavyHunters_F) +
				(metal_BattleShip * enemy_BattleShips_F) +
				(metal_ArmoredShip * enemy_ArmoredShips_F) 
				);
		losses_Deuterium_Enemy= (
				(deuterium_LightHunter*  enemy_LightHunters_F) +
				(deuterium_HeavyHunter * enemy_HeavyHunters_F) +
				(deuterium_BattleShip * enemy_BattleShips_F) +
				(deuterium_ArmoredShip * enemy_ArmoredShips_F) 
				);
		losses_Enemy_Weighted= (losses_Metal_Enemy + (losses_Deuterium_Enemy*5));
	
		waste_Metal= 52150; 
		waste_Deuterium= 910;
		
		winner_Planet= true;
		winner_Enemy= false;
				
		System.out.println("BATTLE NUMBER: "+battle_Number+
				"\nBATTLE STATISTICS"
				+ "\n" +
				"\nArmy planet"+("        ")+"Units"+("        ")+"Drops"+("        ")+"Initial Army Enemy"+("        ")+"Units"+("        ")+"Drops"+
				"\nLight Hunter"+("        ")+planet_LightHunters+("        ")+(planet_LightHunters - planet_LightHunters_F)+("        ")+"Light Hunter"+("        ")+enemy_LightHunters+("        ")+(enemy_LightHunters - enemy_LightHunters_F)+
				"\nLight Hunter"+("        ")+planet_HeavyHunters+("        ")+(planet_HeavyHunters - planet_HeavyHunters_F)+("        ")+"Heavy Hunter"+("        ")+enemy_HeavyHunters+("        ")+(enemy_HeavyHunters - enemy_HeavyHunters_F)+
				"\nLight Hunter"+("        ")+planet_BattleShips+("        ")+(planet_BattleShips - planet_BattleShips_F)+("        ")+"Battle Ship"+("        ")+enemy_BattleShips+("        ")+(enemy_BattleShips - enemy_BattleShips_F)+
				"\nLight Hunter"+("        ")+planet_ArmoredShips+("        ")+(planet_ArmoredShips - planet_ArmoredShips_F)+("        ")+"ArmoredShips"+("        ")+enemy_ArmoredShips+("        ")+(enemy_ArmoredShips - enemy_ArmoredShips_F)+
				"\nLight Hunter"+("        ")+planet_LightHunters+("        ")+(planet_LightHunters - planet_LightHunters_F)+("        ")+
				"\nLight Hunter"+("        ")+planet_LightHunters+("        ")+(planet_LightHunters - planet_LightHunters_F)+("        ")+
				"\nLight Hunter"+("        ")+planet_LightHunters+("        ")+(planet_LightHunters - planet_LightHunters_F)+("        ")
				);
	
	}
}





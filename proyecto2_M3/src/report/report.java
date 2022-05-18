package report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/*(int id_Batalla, Connection conexion)*/
public class report {
	/*Para probar el print, esta en un main*/
	public static void main(String[] args) {
		try {
			/*Estas dos variables id_Batalla y la conexión, se deberian entrar desde fuera*/
			int id_Batalla =1;
			
			Connection conexion =null;
			
			int 
			/*Costes de las unidades para calcular los costes totales y perdidas SE EXTRAE metal_Cost y Deuterium_Cost Where name = 'LightHunter'*/
			metal_LightHunter, metal_HeavyHunter, metal_BattleShip, metal_ArmoredShip,
			metal_MissileLauncher, metal_IonCannon, metal_PlasmaCannon,
			deuterium_LightHunter, deuterium_HeavyHunter, deuterium_BattleShip, deuterium_ArmoredShip,
			deuterium_MissileLauncher, deuterium_IonCannon, deuterium_PlasmaCannon,
			/*Unidades iniciales Planeta SE EXTRAE UI_LightHunter, UI_HeavyHunter etc*/
			planet_LightHunters, planet_HeavyHunters, 
			planet_BattleShips, planet_ArmoredShips, 
			planet_MissileLauncher, planet_IonCannon, 
			planet_PlasmaCannon,
			/*Unidades iniciales enemigo EI_LightHunter, EI_HeavyHunter etc*/
			enemy_LightHunters, enemy_HeavyHunters,
			enemy_BattleShips, enemy_ArmoredShips,
			/*Unidades finales Planeta SE EXTRAE UF_LightHunter, UF_HeavyHunter etc*/
			planet_LightHunters_F, planet_HeavyHunters_F, 
			planet_BattleShips_F, planet_ArmoredShips_F, 
			planet_MissileLauncher_F, planet_IonCannon_F, 
			planet_PlasmaCannon_F,
			/*Unidades finales enemigo SE EXTRAE EF_LightHunter, EF_HeavyHunter etc*/
			enemy_LightHunters_F, enemy_HeavyHunters_F,
			enemy_BattleShips_F, enemy_ArmoredShips_F,
			/*Los costes de los ejercitos del planeta y del enemigo SE CALCULAN*/
			cost_Metal_Planet, cost_Deuterium_Planet, 
			cost_Metal_Enemy, cost_Deuterium_Enemy,
			/*Las perdidas en recursos del planeta y del enemigo*/
			losses_Metal_Planet, losses_Deuterium_Planet, losses_Weighted_Planet,
			losses_Metal_Enemy, losses_Deuterium_Enemy, losses_Weighted_Enemy,
			/*Residuos generades SE EXTRAE waste_Metal, waste_Deuterium*/
			waste_Metal, waste_Deuterium;
			
			/*Quien ha ganado y perdido, o winner 1 o enemy 1*/
			int winner_Planet, winner_Enemy; 
			
			String respuesta;
			boolean view_Battle;
			
			/*Mensaje que saldra segun gane el planeta/jugador o el enemigo*/
			String message_Winner;
			
			String full_Report;
			
			/* 
			CallableStatement cstat_LightHunter =conexion.prepareCall("{call GET_SHIP(?,?,?,?,?,?,?,?)}");
			CallableStatement cstat_HeavyHunter =conexion.prepareCall("{call GET_SHIP(?,?,?,?,?,?,?,?)}");
			CallableStatement cstat_BattleShip =conexion.prepareCall("{call GET_SHIP(?,?,?,?,?,?,?,?)}");
			CallableStatement cstat_ArmoredShip =conexion.prepareCall("{call GET_SHIP(?,?,?,?,?,?,?,?)}");
			
			CallableStatement cstat_MissileLauncher =conexion.prepareCall("{call GET_DEFENSE(?,?,?,?,?,?,?,?)}");
			CallableStatement cstat_IonCannon =conexion.prepareCall("{call GET_DEFENSE(?,?,?,?,?,?,?,?)}");
			CallableStatement cstat_PlasmaCannon =conexion.prepareCall("{call GET_DEFENSE(?,?,?,?,?,?,?,?)}");
			
			CallableStatement cstat_Battle =conexion.prepareCall("call GET_BATTLE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstat_LightHunter.setInt(1, 1);
			cstat_LightHunter.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_LightHunter.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_LightHunter.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_LightHunter.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_LightHunter.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_LightHunter.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_LightHunter.execute();
			
			cstat_HeavyHunter.setInt(1, 2);
			cstat_HeavyHunter.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_HeavyHunter.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_HeavyHunter.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_HeavyHunter.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_HeavyHunter.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_HeavyHunter.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_HeavyHunter.execute();
			
			cstat_BattleShip.setInt(1, 3);
			cstat_BattleShip.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_BattleShip.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_BattleShip.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_BattleShip.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_BattleShip.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_BattleShip.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_BattleShip.execute();
			
			cstat_ArmoredShip.setInt(1, 4);
			cstat_ArmoredShip.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_ArmoredShip.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_ArmoredShip.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_ArmoredShip.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_ArmoredShip.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_ArmoredShip.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_ArmoredShip.execute();
			
			cstat_MissileLauncher.setInt(1, 1);
			cstat_MissileLauncher.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_MissileLauncher.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_MissileLauncher.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_MissileLauncher.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_MissileLauncher.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_MissileLauncher.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_MissileLauncher.execute();
			
			cstat_IonCannon.setInt(1, 2);
			cstat_IonCannon.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_IonCannon.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_IonCannon.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_IonCannon.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_IonCannon.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_IonCannon.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_IonCannon.execute();
			
			cstat_PlasmaCannon.setInt(1, 3);
			cstat_PlasmaCannon.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstat_PlasmaCannon.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_PlasmaCannon.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_PlasmaCannon.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_PlasmaCannon.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_PlasmaCannon.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_PlasmaCannon.execute();
			
			cstat_Battle.setInt(1, id_Batalla);
			cstat_Battle.registerOutParameter(2, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(3, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(4, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(5, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(6, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(7, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(8, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(9, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(10, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(11, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(12, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(13, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(14, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(15, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(16, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(17, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(18, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(19, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(20, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(21, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(22, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(23, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(24, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(25, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(26, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(27, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(28, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(29, java.sql.Types.INTEGER);
			cstat_Battle.registerOutParameter(30, java.sql.Types.INTEGER);
			cstat_Battle.execute();

			metal_LightHunter= cstat_LightHunter.getInt(3);
			metal_HeavyHunter= cstat_HeavyHunter.getInt(3);
			metal_BattleShip= cstat_BattleShip.getInt(3);
			metal_ArmoredShip= cstat_ArmoredShip.getInt(3);
			metal_MissileLauncher= cstat_MissileLauncher.getInt(3);
			metal_IonCannon= cstat_IonCannon.getInt(3);
			metal_PlasmaCannon= cstat_PlasmaCannon.getInt(3);
			deuterium_LightHunter= cstat_LightHunter.getInt(5);
			deuterium_HeavyHunter= cstat_HeavyHunter.getInt(5);
			deuterium_BattleShip= cstat_BattleShip.getInt(5);
			deuterium_ArmoredShip= cstat_ArmoredShip.getInt(5);
			deuterium_MissileLauncher= cstat_MissileLauncher.getInt(5);
			deuterium_IonCannon= cstat_IonCannon.getInt(5);
			deuterium_PlasmaCannon= cstat_PlasmaCannon.getInt(5);
			
			planet_LightHunters= cstat_Battle.getInt(9); 
			planet_HeavyHunters= cstat_Battle.getInt(10); 
			planet_BattleShips= cstat_Battle.getInt(11); 
			planet_ArmoredShips= cstat_Battle.getInt(12);
			planet_MissileLauncher= cstat_Battle.getInt(13); 
			planet_IonCannon= cstat_Battle.getInt(14);
			planet_PlasmaCannon= cstat_Battle.getInt(15);
			
			enemy_LightHunters= cstat_Battle.getInt(23); 
			enemy_HeavyHunters= cstat_Battle.getInt(24);
			enemy_BattleShips= cstat_Battle.getInt(25);
			enemy_ArmoredShips= cstat_Battle.getInt(26);
			
			planet_LightHunters_F= cstat_Battle.getInt(16); 
			planet_HeavyHunters_F= cstat_Battle.getInt(17); 
			planet_BattleShips_F= cstat_Battle.getInt(18); 
			planet_ArmoredShips_F= cstat_Battle.getInt(19);
			planet_MissileLauncher_F= cstat_Battle.getInt(20); 
			planet_IonCannon_F= cstat_Battle.getInt(21);
			planet_PlasmaCannon_F= cstat_Battle.getInt(22);
			
			enemy_LightHunters_F= cstat_Battle.getInt(27); 
			enemy_HeavyHunters_F= cstat_Battle.getInt(28);
			enemy_BattleShips_F= cstat_Battle.getInt(29);
			enemy_ArmoredShips_F= cstat_Battle.getInt(30);
			
			waste_Metal= cstat_Battle.getInt(7); 
			waste_Deuterium= cstat_Battle.getInt(8);
			
			winner_Planet= cstat_Battle.getInt(5);
			winner_Enemy= cstat_Battle.getInt(6);
			*/
			
			/*BBDD*/metal_LightHunter= 3000;
			/*BBDD*/metal_HeavyHunter= 6500;
			/*BBDD*/metal_BattleShip= 45000;
			/*BBDD*/metal_ArmoredShip= 30000;
			/*BBDD*/metal_MissileLauncher= 2000;
			/*BBDD*/metal_IonCannon= 4000;
			/*BBDD*/metal_PlasmaCannon= 50000;
			/*BBDD*/deuterium_LightHunter= 50;
			/*BBDD*/deuterium_HeavyHunter= 50;
			/*BBDD*/deuterium_BattleShip= 7000;
			/*BBDD*/deuterium_ArmoredShip= 15000;
			/*BBDD*/deuterium_MissileLauncher= 0;
			/*BBDD*/deuterium_IonCannon= 500;
			/*BBDD*/deuterium_PlasmaCannon= 5000;
			
			/*BBDD*/planet_LightHunters= 11; 
			/*BBDD*/planet_HeavyHunters= 3; 
			/*BBDD*/planet_BattleShips= 1; 
			/*BBDD*/planet_ArmoredShips= 1;
			/*BBDD*/planet_MissileLauncher= 11; 
			/*BBDD*/planet_IonCannon= 1;
			/*BBDD*/planet_PlasmaCannon= 1;
			
			/*BBDD*/enemy_LightHunters= 19; 
			/*BBDD*/enemy_HeavyHunters= 7;
			/*BBDD*/enemy_BattleShips= 1;
			/*BBDD*/enemy_ArmoredShips= 1;
			
			/*BBDD*/planet_LightHunters_F= 3; 
			/*BBDD*/planet_HeavyHunters_F= 2; 
			/*BBDD*/planet_BattleShips_F= 1; 
			/*BBDD*/planet_ArmoredShips_F= 1;
			/*BBDD*/planet_MissileLauncher_F= 2; 
			/*BBDD*/planet_IonCannon_F= 0;
			/*BBDD*/planet_PlasmaCannon_F= 1;
			
			/*BBDD*/enemy_LightHunters_F= 2; 
			/*BBDD*/enemy_HeavyHunters_F= 2;
			/*BBDD*/enemy_BattleShips_F= 0;
			/*BBDD*/enemy_ArmoredShips_F= 1;
			
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
					(metal_LightHunter*  (planet_LightHunters -planet_LightHunters_F)) +
					(metal_HeavyHunter * (planet_HeavyHunters -planet_HeavyHunters_F)) +
					(metal_BattleShip * (planet_BattleShips -planet_BattleShips_F)) +
					(metal_ArmoredShip * (planet_ArmoredShips -planet_ArmoredShips_F)) +
					(metal_MissileLauncher * (planet_MissileLauncher -planet_MissileLauncher_F)) +
					(metal_IonCannon * (planet_IonCannon -planet_IonCannon_F)) +
					(metal_PlasmaCannon * (planet_PlasmaCannon -planet_PlasmaCannon_F))
					);
			losses_Deuterium_Planet= (
					(deuterium_LightHunter* (planet_LightHunters -planet_LightHunters_F)) +
					(deuterium_HeavyHunter * (planet_HeavyHunters -planet_HeavyHunters_F)) +
					(deuterium_BattleShip * (planet_BattleShips -planet_BattleShips_F)) +
					(deuterium_ArmoredShip * (planet_ArmoredShips -planet_ArmoredShips_F)) +
					(deuterium_MissileLauncher * (planet_MissileLauncher -planet_MissileLauncher_F)) +
					(deuterium_IonCannon * (planet_IonCannon -planet_IonCannon_F)) +
					(deuterium_PlasmaCannon * (planet_PlasmaCannon -planet_PlasmaCannon_F))
					);
			losses_Weighted_Planet= (losses_Metal_Planet + (losses_Deuterium_Planet*5));
			losses_Metal_Enemy= (
					(metal_LightHunter*  (enemy_LightHunters -enemy_LightHunters_F)) +
					(metal_HeavyHunter * (enemy_HeavyHunters - enemy_HeavyHunters_F)) +
					(metal_BattleShip * (enemy_BattleShips - enemy_BattleShips_F)) +
					(metal_ArmoredShip * (enemy_ArmoredShips - enemy_ArmoredShips_F)) 
					);
			losses_Deuterium_Enemy= (
					(deuterium_LightHunter*  (enemy_LightHunters -enemy_LightHunters_F)) +
					(deuterium_HeavyHunter * (enemy_HeavyHunters -enemy_HeavyHunters_F)) +
					(deuterium_BattleShip * (enemy_BattleShips - enemy_BattleShips_F)) +
					(deuterium_ArmoredShip * (enemy_ArmoredShips -enemy_ArmoredShips_F)) 
					);
			losses_Weighted_Enemy= (losses_Metal_Enemy + (losses_Deuterium_Enemy*5));

			/*BBDD*/waste_Metal= 52150; 
			/*BBDD*/waste_Deuterium= 910;
			
			/*BBDD*/winner_Planet= 1;
			/*BBDD*/winner_Enemy= 0;
			
			if(winner_Planet == 1) {
				message_Winner = "Battle Winned by Planet, We Collect Rubble";
			}else if(winner_Enemy ==1){
				message_Winner = "Battle Winned by enemy, He Takes the Planet";
			}else {
				message_Winner = "";
			}
					
			full_Report = "BATTLE NUMBER: "+id_Batalla+
					"\nBATTLE STATISTICS"
					+ "\n" +
					"\nArmy planet"+("         ")+"Units"+("        ")+"Drops"+("        ")+"Initial Army Enemy"+("        ")+"Units"+("         ")+"Drops"+
					"\nLight Hunter"+("        ")+planet_LightHunters+("            ")+(planet_LightHunters - planet_LightHunters_F)+("            ")+"Light Hunter"+("              ")+enemy_LightHunters+("             ")+(enemy_LightHunters - enemy_LightHunters_F)+
					"\nHeavy Hunter"+("        ")+planet_HeavyHunters+("            ")+(planet_HeavyHunters - planet_HeavyHunters_F)+("            ")+"Heavy Hunter"+("              ")+enemy_HeavyHunters+("             ")+(enemy_HeavyHunters - enemy_HeavyHunters_F)+
					"\nBattle Ship"+("         ")+planet_BattleShips+("            ")+(planet_BattleShips - planet_BattleShips_F)+("            ")+"Battle Ship"+("               ")+enemy_BattleShips+("             ")+(enemy_BattleShips - enemy_BattleShips_F)+
					"\nArmored Ship"+("        ")+planet_ArmoredShips+("            ")+(planet_ArmoredShips - planet_ArmoredShips_F)+("            ")+"ArmoredShips"+("              ")+enemy_ArmoredShips+("             ")+(enemy_ArmoredShips - enemy_ArmoredShips_F)+
					"\nMissile Launcher"+("    ")+planet_MissileLauncher+("            ")+(planet_MissileLauncher - planet_MissileLauncher_F)+("             ")+
					"\nIon Cannon"+("          ")+planet_IonCannon+("            ")+(planet_IonCannon - planet_IonCannon)+("            ")+
					"\nPlasma Cannon"+("       ")+planet_PlasmaCannon+("            ")+(planet_PlasmaCannon - planet_PlasmaCannon)+("             ")+
					"\n"+
					"\n**************************************************************************************"+
					"\nCost Army Planet"+("                ")+"Cost Army Enemy"+
					"\nMetal:"+("  ")+cost_Metal_Planet+("                     ")+"Metal:"+("  ")+cost_Metal_Enemy+
					"\nDeuterium:"+("  ")+cost_Deuterium_Planet+("                 ")+"Metal:"+("  ")+cost_Deuterium_Enemy+
					"\n"+
					"\n**************************************************************************************"+
					"\nLosses Army Planet"+("           ")+"Losses Army Enemy"+
					"\nMetal:"+("  ")+losses_Metal_Planet+("                  ")+"Metal:"+("  ")+losses_Metal_Enemy+
					"\nDeuterium:"+("  ")+losses_Deuterium_Planet+("              ")+"Metal:"+("  ")+losses_Deuterium_Enemy+
					"\nWeighted:"+("  ")+losses_Weighted_Planet+("               ")+"Metal:"+("  ")+losses_Weighted_Enemy+
					"\n"+
					"\n**************************************************************************************"+
					"\nWaste Generated:"+
					"\nMetal"+("  ")+waste_Metal+
					"\nDeuterium"+("  ")+waste_Deuterium+
					"\n"+
					"\n"+message_Winner+
					"\n"+
					"\n######################################################################################"+
					"\nView Battle Development?(S/N)"
					;

			System.out.println(full_Report);
			
			Scanner lector = new Scanner(System.in);
			respuesta = lector.nextLine();
			
			if (respuesta.equals("S")) {
				view_Battle =true;
			}else {
				view_Battle =false;
			}
			
			/*
			return view_Battle;
			*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}






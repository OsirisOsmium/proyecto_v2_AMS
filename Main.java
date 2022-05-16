import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	private static int numBatallas=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Planet planet=new Planet();
		Planet enemy=new Planet();
		planet.newLigthHunter(5);
		planet.newArmoredShip(5);
		planet.newBattleShip(5);
		planet.newHeavyHunter(5);
		planet.newIonCannon(5);
		planet.newMissileLauncher(5);
		planet.newPlasmaCannon(5);
		enemy.newLigthHunter(5);
		enemy.newArmoredShip(5);
		enemy.newBattleShip(5);
		enemy.newHeavyHunter(5);
		planet.printStats();
		ArrayList<MilitaryUnit>[] army=planet.getArmy();
		System.out.println(army[1].get(1));
		ArrayList<MilitaryUnit>[] enemigo=new ArrayList [4];
		enemigo[0]=enemy.getArmy()[0];
		enemigo[1]=enemy.getArmy()[1];
		enemigo[2]=enemy.getArmy()[2];
		enemigo[3]=enemy.getArmy()[3];
		Battle battle=new Battle(planet.getArmy(),enemigo);
		int turn=0;
		int lastTurn=0;
		int planetPct=battle.remainderPercentageFleet(battle.getPlanetArmy());
		int enemyPct=battle.remainderPercentageFleet(battle.getEnemyArmy());
		while(planetPct>20 && enemyPct>20) {
			planetPct=battle.remainderPercentageFleet(battle.getPlanetArmy());
			enemyPct=battle.remainderPercentageFleet(battle.getEnemyArmy());
			for (int i=0;i<battle.getEnemyArmy().length;i++) {
				System.out.println("Planeta: "+battle.getPlanetArmy()[i].size());
				System.out.println("Enemigo: "+battle.getEnemyArmy()[i].size());
			}
			System.out.println("Planeta: "+planetPct+" Enemigo "+enemyPct);
			if (turn==0) {
				lastTurn=(int) (Math.random()*(3-1));
			}
			else {
				if (lastTurn==0) {
					lastTurn=1;
				}
				else if (lastTurn==1) {
					lastTurn=0;
				}
			}
			battle.batalla(lastTurn);
			turn++;
			//System.out.println(battle.getBattleDevelopment());
		}
		System.out.println("Batalla en main\n"+battle.getBattleDevelopment());
		//System.out.println(battle.getBattleReport(0));*/
		Planet planet=new Planet();
		planet.newLigthHunter(5);
  		planet.newHeavyHunter(3);
  		planet.newArmoredShip(1);
  		planet.newBattleShip(1);
  		planet.newIonCannon(3);
  		planet.newMissileLauncher(5);
  		planet.newPlasmaCannon(2);
		Timer time = new Timer();
		TimerTask task = new TimerTask() {;
		public void schedule(TimerTask task,long delay, long period) {
			run();
		}
	        public void run()
	        {
	            
		        System.out.println(numBatallas);
		        ArrayList<MilitaryUnit>[] enemyArmy=createEnemyArmy();
		  		viewThread(createEnemyArmy());
		  		Battle batalla=new Battle(planet.getArmy(),enemyArmy);
		  		boolean ganador=batalla.batallas();
		  		System.out.println(batalla.getBattleDevelopment());
		  		planet.setArmy(batalla.getPlanetArmy());
		  		for (int i=0;i<planet.getArmy().length;i++) {
		  			System.out.println(planet.getArmy()[i].size());
		  		}
		  		if (ganador==true) {
		  			System.out.println("Usuario gana");
		  		}
		  		else {
		  			System.out.println("Usuario pierde");
		  		}
		  		numBatallas=numBatallas+1;
	        }
	        };
	    time.schedule(task, 5000, 5000);
	}
	public static void viewThread(ArrayList<MilitaryUnit>[] army) {
		System.out.println("NEW THREAD COMING");
		System.out.println("Light Hunter       "+army[0].size());
		System.out.println("Heavy Hunter       "+army[1].size());
		System.out.println("Battle Ship        "+army[2].size());
		System.out.println("Armored Ship       "+army[3].size());
	}
	public static ArrayList<MilitaryUnit>[] createEnemyArmy(){
		ArrayList<MilitaryUnit>[] enemyArmy= new ArrayList [4];
		int arrayCreate[]=new int[4];
		arrayCreate[0]=35;
		arrayCreate[1]=25;
		arrayCreate[2]=20;
		arrayCreate[3]=20;
		int deuterioInicial=0;
		int metalInicial=0;
		if (numBatallas>0) {
			deuterioInicial=Variables.DEUTERIUM_BASE_ENEMY_ARMY*(numBatallas*Variables.ENEMY_FLEET_INCREASE);
			metalInicial=Variables.METAL_BASE_ENEMY_ARMY*(numBatallas*Variables.ENEMY_FLEET_INCREASE);
		}
		else {
			deuterioInicial=Variables.DEUTERIUM_BASE_ENEMY_ARMY;
			metalInicial=Variables.METAL_BASE_ENEMY_ARMY;
		}
		Planet enemyPlanet=new Planet(metalInicial,deuterioInicial);
		while (enemyPlanet.getDeuterium()>=Variables.DEUTERIUM_COST_LIGTHHUNTER && enemyPlanet.getMetal()>=Variables.METAL_COST_LIGTHHUNTER) {
			int numAleatorio=(int) (Math.random()*(100-1));
			int totalArrays=0;
			for (int i=0;i<arrayCreate.length;i++) {
				totalArrays=totalArrays+arrayCreate[i];
				if (totalArrays>=numAleatorio) {
						if (totalArrays==35) {
							enemyPlanet.newLigthHunter(1);
						}
						else if(totalArrays==60) {
							enemyPlanet.newHeavyHunter(1);
						}
						else if (totalArrays==80) {
							enemyPlanet.newBattleShip(1);
						}
						else if (totalArrays==100) {
							enemyPlanet.newArmoredShip(1);
						}
					}
				}
		}
		enemyArmy[0]=enemyPlanet.getArmy()[0];
		enemyArmy[1]=enemyPlanet.getArmy()[1];
		enemyArmy[2]=enemyPlanet.getArmy()[2];
		enemyArmy[3]=enemyPlanet.getArmy()[3];
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Connection cn = null;

        try {
            // Carga el driver de oracle
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password

            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoAMS17", "alumnoAMS17");
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call INSERT_ENEMY (?,?,?,?,?,?,?,?,?,?,?)}");
           
                
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, 1);
                
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                cst.setString(2, "Ejercito enemigo");
                cst.setInt(3, metalInicial);
                cst.setInt(4, 0);
                cst.setInt(5, deuterioInicial);
                cst.setInt(6, enemyArmy[0].size());
                cst.setInt(7, enemyArmy[1].size());
                cst.setInt(8, enemyArmy[2].size());
                cst.setInt(9, enemyArmy[3].size());
                cst.setInt(10, 0);
                cst.setInt(11, 0);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();

            
                // Se obtienen la salida del procedimineto almacenado

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
		return enemyArmy;
	}
}

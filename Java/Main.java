import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	private static int numBatallas=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MilitaryUnit>[] enemy=createEnemyArmy();
		Planet planet=new Planet();
		logInWindow login=new logInWindow(planet,enemy);
		Timer time = new Timer();
		TimerTask task = new TimerTask() {;
		    public void schedule(TimerTask task,long delay, long period) {
		        run();
		    }
		        public void run()
		        {
		            planet.setMetal(planet.getMetal()+Variables.PLANET_METAL_GENERATED);
		            planet.setDeuterium(planet.getDeuterium()+Variables.PLANET_DEUTERIUM_GENERATED);
		            String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
		    		String user="alumnoAMS17";
		    		String password="alumnoAMS17";
		    		connectionOracle conn=new connectionOracle(url, user, password);
		    		conn.insertarPlaneta(planet);
		        }
		        };
		    time.schedule(task, 5000, 5000);
		    Timer time2 = new Timer();
		    TimerTask ts2 = new TimerTask() {;
		    public void schedule(TimerTask ts2,long delay, long period) {
		        run();
		    }
		        public void run()
		        {
		        	ArrayList<MilitaryUnit>[] enemy=createEnemyArmy();
		    		login.setEnemyArmy(enemy);
		    		Battle battle=new Battle(planet.getArmy(),enemy);
		    		battle.batallas();
		    		//new comingWindow(planet,enemy);
		    		
		        }
		        };
		    time.schedule(ts2, 180000, 180000);	
		/*planet.newLigthHunter(5);
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
	        	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	            Connection cn = null;

	            try {
	                // Carga el driver de oracle
	               DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	                
	                // Conecta con la base de datos orcl con el usuario system y la contrase�a password

	                cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoAMS17", "alumnoAMS17");
	                
	                // Llamada al procedimiento almacenado
	                CallableStatement cst = cn.prepareCall("{call INSERT_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	               
	                    // Parametro 1 del procedimiento almacenado
	                    
	                    // Definimos los tipos de los parametros de salida del procedimiento almacenado
	                    cst.setInt(1, 1);
	                    cst.setString(2, "Planeta");
	                    cst.setInt(3, planet.getMetal());
	                    cst.setInt(4, 0);
	                    cst.setInt(5, planet.getDeuterium());
	                    cst.setInt(6, planet.getArmy()[0].size());
	                    cst.setInt(7, planet.getArmy()[1].size());
	                    cst.setInt(8, planet.getArmy()[2].size());
	                    cst.setInt(9, planet.getArmy()[3].size());
	                    cst.setInt(10, planet.getArmy()[4].size());
	                    cst.setInt(11, planet.getArmy()[5].size());
	                    cst.setInt(12, planet.getArmy()[6].size());
	                    cst.setInt(13, planet.getTechnologyDefense());
	                    cst.setInt(14, planet.getUpgradeDefenseTechnologyDeuteriumCost());
	                    cst.setInt(15, planet.getTechnologyAtack());
	                    cst.setInt(16,planet.getUpgradeAttackTechnologyDeuteriumCost());
	                    
	                    // Ejecuta el procedimiento almacenado
	                    cst.execute();

	                

	            } catch (SQLException ex) {
	                System.out.println("Error: " + ex.getMessage());
	            } finally {
	                try {
	                    cn.close();
	                } catch (SQLException ex) {
	                    System.out.println("Error: " + ex.getMessage());
	                }
	            }
		        System.out.println(numBatallas);
		        ArrayList<MilitaryUnit>[] enemyArmy=createEnemyArmy();
		  		viewThread(enemyArmy);
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
	    time.schedule(task, 5000, 5000);*/
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
		String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
		String user="alumnoAMS17";
		String password="alumnoAMS17";
		connectionOracle conn=new connectionOracle(url, user, password);
		conn.insertarEnemigo(enemyArmy, metalInicial, deuterioInicial);
		return enemyArmy;
	}
}

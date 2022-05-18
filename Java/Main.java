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
			int plusD=0;
			int plusM=0;
			ArrayList<MilitaryUnit>[] enemy=createEnemyArmy(plusD,plusM);
			Planet planet=new Planet();
			logInWindow login=new logInWindow(planet,enemy);
			while (login.getIniciado()==false) {
				Timer time1 = new Timer();
				TimerTask task1 = new TimerTask() {;
				    public void schedule(TimerTask task,long delay, long period) {
				        run();
				    }
				        public void run()
				        {
				           System.out.println("Tu planeta esta esperando");
				        }
				        };
				        time1.schedule(task1,6000000,600000);
			}
			Timer time = new Timer();
			TimerTask task = new TimerTask() {;
			    public void schedule(TimerTask task,long delay, long period) {
			        run();
			    }
			        public void run()
			        {
			            login.getPlanet().setMetal(login.getPlanet().getMetal()+Variables.PLANET_METAL_GENERATED);
			            login.getPlanet().setDeuterium(login.getPlanet().getDeuterium()+Variables.PLANET_DEUTERIUM_GENERATED);
			            new mainWindow(login.getPlanet(),enemy,login.getIdes());
			        }
			        };
			    time.schedule(task, 60000, 60000);
			    Timer time2 = new Timer();
			    TimerTask ts2 = new TimerTask() {;
			    public void schedule(TimerTask ts2,long delay, long period) {
			        run();
			    }
			        public void run()
			        {
			        	int plusDe=0;
			        	int plusMe=0;
			        	ArrayList<MilitaryUnit>[] enemy=createEnemyArmy(plusDe,plusMe);
			    		login.setEnemyArmy(enemy);
			    		Battle battle=new Battle(login.getPlanet().getArmy(),enemy);
			    		login.getPlanet().setArmy(battle.getPlanetArmy());
			    		int[] resultBat=battle.batallas();
			    		if (resultBat[2]==0) {
			    			login.getPlanet().setMetal(login.getPlanet().getMetal()+resultBat[0]);
			    			login.getPlanet().setDeuterium(login.getPlanet().getDeuterium()+resultBat[1]);
			    		}
			    		else if(resultBat[2]==1) {
			    			int lastWin=1;
			    		}
			    		new mainWindow(login.getPlanet(),enemy,login.getIdes());
			    		numBatallas=numBatallas+1;
			    		//new comingWindow(planet,enemy);
			    		
			        }
			        };
			    time.schedule(ts2, 180000, 180000);	
	}
		public static void viewThread(ArrayList<MilitaryUnit>[] army) {
			System.out.println("NEW THREAD COMING");
			System.out.println("Light Hunter       "+army[0].size());
			System.out.println("Heavy Hunter       "+army[1].size());
			System.out.println("Battle Ship        "+army[2].size());
			System.out.println("Armored Ship       "+army[3].size());
		}
		public static ArrayList<MilitaryUnit>[] createEnemyArmy(int plusM,int plusD){
			ArrayList<MilitaryUnit>[] enemyArmy= new ArrayList [4];
			int arrayCreate[]=new int[4];
			arrayCreate[0]=35;
			arrayCreate[1]=25;
			arrayCreate[2]=20;
			arrayCreate[3]=20;
			int deuterioInicial=0;
			int metalInicial=0;
			if (numBatallas>0) {
				deuterioInicial=Variables.DEUTERIUM_BASE_ENEMY_ARMY*(numBatallas*Variables.ENEMY_FLEET_INCREASE)+plusD;
				metalInicial=Variables.METAL_BASE_ENEMY_ARMY*(numBatallas*Variables.ENEMY_FLEET_INCREASE)+plusM;
			}
			else {
				deuterioInicial=Variables.DEUTERIUM_BASE_ENEMY_ARMY+plusD;
				metalInicial=Variables.METAL_BASE_ENEMY_ARMY+plusM;
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
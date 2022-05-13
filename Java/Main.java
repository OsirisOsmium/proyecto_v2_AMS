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
		Timer time = new Timer();
		TimerTask task = new TimerTask() {;
		public void schedule(TimerTask task,long delay, long period) {
			run();
		}
	        public void run()
	        {
	            

		        System.out.println(numBatallas);
		        createEnemyArmy();
		  		viewThread(createEnemyArmy());
		  		numBatallas=numBatallas+1;
	        }
	        };
	    time.schedule(task, 3000, 5000);
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
		enemyArmy=enemyPlanet.getArmy();
		return enemyArmy;
	}
}

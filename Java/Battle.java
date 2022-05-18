import java.util.ArrayList;

public class Battle{
	private ArrayList<MilitaryUnit>[] planetArmy=new ArrayList [7];
	private ArrayList<MilitaryUnit>[] enemyArmy=new ArrayList [4];
	private ArrayList<MilitaryUnit>[][] armies= new ArrayList[7][7];
	private String battleDevelopment="";
	private int[][] initialCostFleet=new int[2][2];
	private int initialNumberUnitsPlanet,initialNumberUnitsEnemy;
	private int[] wasteMetalDeuterium=new int[2];
	private int[] enemyDrops,planetDrops;
	private int[][] resourcesLoses=new int[2][3];
	private int[][] initialArmies=new int[2][7];
	private int[] actualNumberUnitsPlanet=new int[7],actualNumberUnitsEnemy=new int[4];
	
	
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		super();
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;
		this.armies[0]=planetArmy;
		this.armies[1]=enemyArmy;
		this.initialCostFleet[0]=this.fleetResourceCost(planetArmy);
		this.initialCostFleet[1]=this.fleetResourceCost(enemyArmy);
		this.initialNumberUnitsPlanet=this.initialFleetNumber(planetArmy);
		this.initialNumberUnitsEnemy=this.initialFleetNumber(enemyArmy);
		this.wasteMetalDeuterium[0]=0;
		this.wasteMetalDeuterium[1]=0;
		this.planetDrops=null;
		this.enemyDrops=null;
		this.resourcesLoses[0]=null;
		this.resourcesLoses[1]=null;
		
		initInitialArmies();
		this.actualNumberUnitsPlanet[0]=planetArmy[0].size();
		this.actualNumberUnitsPlanet[1]=planetArmy[1].size();
		this.actualNumberUnitsPlanet[2]=planetArmy[2].size();
		this.actualNumberUnitsPlanet[3]=planetArmy[3].size();
		this.actualNumberUnitsPlanet[4]=planetArmy[4].size();
		this.actualNumberUnitsPlanet[5]=planetArmy[5].size();
		this.actualNumberUnitsPlanet[6]=planetArmy[6].size();
		this.actualNumberUnitsEnemy[0]=enemyArmy[0].size();
		this.actualNumberUnitsEnemy[1]=enemyArmy[1].size();
		this.actualNumberUnitsEnemy[2]=enemyArmy[2].size();
		this.actualNumberUnitsEnemy[3]=enemyArmy[3].size();
		
	}
	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return planetArmy;
	}
	public void setPlanetArmy(ArrayList<MilitaryUnit>[] planetArmy) {
		this.planetArmy = planetArmy;
	}
	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}
	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	public ArrayList<MilitaryUnit>[][] getArmies() {
		return armies;
	}
	public void setArmies(ArrayList<MilitaryUnit>[][] armies) {
		this.armies = armies;
	}
	public String getBattleDevelopment() {
		return battleDevelopment;
	}
	public void setBattleDevelopment(String battleDevelopment) {
		this.battleDevelopment = battleDevelopment;
	}
	public int[][] getInitialCostFleet() {
		return initialCostFleet;
	}
	public void setInitialCostFleet(int[][] initialCostFleet) {
		this.initialCostFleet = initialCostFleet;
	}
	public int getInitialNumberUnitsPlanet() {
		return initialNumberUnitsPlanet;
	}
	public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
		this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
	}
	public int getInitialNumberUnitsEnemy() {
		return initialNumberUnitsEnemy;
	}
	public void setInitialNumberUnitsEnemy(int initialNumbersUnitsEnemy) {
		this.initialNumberUnitsEnemy = initialNumbersUnitsEnemy;
	}
	public int[] getWasteMetalDeuterium() {
		return wasteMetalDeuterium;
	}
	public void setWasteMetalDeuterium(int[] wasteMetalDeuterium) {
		this.wasteMetalDeuterium = wasteMetalDeuterium;
	}
	public int[] getEnemyDrops() {
		return enemyDrops;
	}
	public void setEnemyDrops(int[] enemyDrops) {
		this.enemyDrops = enemyDrops;
	}
	public int[] getPlanetDrops() {
		return planetDrops;
	}
	public void setPlanetDrops(int[] planetDrops) {
		this.planetDrops = planetDrops;
	}
	public int[][] getResourcesLoses() {
		return resourcesLoses;
	}
	public void setResourcesLoses(int[][] resourcesLoses) {
		this.resourcesLoses = resourcesLoses;
	}
	public int[][] getInitialArmies() {
		return initialArmies;
	}
	public void setInitialArmies(int[][] initialArmies) {
		this.initialArmies = initialArmies;
	}
	public int[] getActualNumberUnitsPlanet() {
		return actualNumberUnitsPlanet;
	}
	public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
		this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
	}
	public int[] getActualNumberUnitsEnemy() {
		return actualNumberUnitsEnemy;
	}
	public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
		this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
	}
	
	public String[] getBattleReport(int battles) {
		String[] report = null;
		report[0]="BATTLE STATISTICS\n\nArmy planet\nLight Hunter    Units: "+this.initialArmies[0][0]+
				" Drops: "+(this.initialArmies[0][0]-this.actualNumberUnitsPlanet[0]);
		
		return report;
	}
	
	public void initInitialArmies() {
		this.initialArmies[0][0]=planetArmy[0].size();
		this.initialArmies[0][1]=planetArmy[1].size();
		this.initialArmies[0][2]=planetArmy[2].size();
		this.initialArmies[0][3]=planetArmy[3].size();
		this.initialArmies[0][4]=planetArmy[4].size();
		this.initialArmies[0][5]=planetArmy[5].size();
		this.initialArmies[0][6]=planetArmy[6].size();
		this.initialArmies[1][0]=enemyArmy[0].size();
		this.initialArmies[1][1]=enemyArmy[1].size();
		this.initialArmies[1][2]=enemyArmy[2].size();
		this.initialArmies[1][3]=enemyArmy[3].size();
	}
	
	public void updateResourcesLoses(ArrayList<MilitaryUnit>[] army) {
		int loses00=0;
		int loses01=0;
		int loses10=0;
		int loses11=0;
		loses00=(this.initialArmies[0][0]-this.actualNumberUnitsPlanet[0])*Variables.METAL_COST_LIGTHHUNTER;
		loses00=loses00+(this.initialArmies[0][1]-this.actualNumberUnitsPlanet[1])*Variables.METAL_COST_HEAVYHUNTER;
		loses00=loses00+(this.initialArmies[0][2]-this.actualNumberUnitsPlanet[2])*Variables.METAL_COST_BATTLESHIP;
		loses00=loses00+(this.initialArmies[0][3]-this.actualNumberUnitsPlanet[3])*Variables.METAL_COST_ARMOREDSHIP;
		loses00=loses00+(this.initialArmies[0][4]-this.actualNumberUnitsPlanet[4])*Variables.METAL_COST_MISSILELAUNCHER;
		loses00=loses00+(this.initialArmies[0][5]-this.actualNumberUnitsPlanet[5])*Variables.METAL_COST_IONCANNON;
		loses00=loses00+(this.initialArmies[0][6]-this.actualNumberUnitsPlanet[6])*Variables.METAL_COST_PLASMACANNON;
		this.resourcesLoses[0][0]=loses00;
		loses01=(this.initialArmies[0][0]-this.actualNumberUnitsPlanet[0])*Variables.DEUTERIUM_COST_LIGTHHUNTER;
		loses01=loses01+(this.initialArmies[0][1]-this.actualNumberUnitsPlanet[1])*Variables.DEUTERIUM_COST_HEAVYHUNTER;
		loses01=loses01+(this.initialArmies[0][2]-this.actualNumberUnitsPlanet[2])*Variables.DEUTERIUM_COST_BATTLESHIP;
		loses01=loses01+(this.initialArmies[0][3]-this.actualNumberUnitsPlanet[3])*Variables.DEUTERIUM_COST_ARMOREDSHIP;
		loses01=loses01+(this.initialArmies[0][4]-this.actualNumberUnitsPlanet[4])*Variables.DEUTERIUM_COST_MISSILELAUNCHER;
		loses01=loses01+(this.initialArmies[0][5]-this.actualNumberUnitsPlanet[5])*Variables.DEUTERIUM_COST_IONCANNON;
		loses01=loses01+(this.initialArmies[0][6]-this.actualNumberUnitsPlanet[6])*Variables.DEUTERIUM_COST_PLASMACANNON;
		this.resourcesLoses[0][1]=loses01;
		loses10=(this.initialArmies[1][0]-this.actualNumberUnitsEnemy[0])*Variables.METAL_COST_LIGTHHUNTER;
		loses10=loses10+(this.initialArmies[1][1]-this.actualNumberUnitsEnemy[1])*Variables.METAL_COST_HEAVYHUNTER;
		loses10=loses10+(this.initialArmies[1][2]-this.actualNumberUnitsEnemy[2])*Variables.METAL_COST_BATTLESHIP;
		loses10=loses10+(this.initialArmies[1][3]-this.actualNumberUnitsEnemy[3])*Variables.METAL_COST_ARMOREDSHIP;
		this.resourcesLoses[1][0]=loses10;
		loses01=(this.initialArmies[1][0]-this.actualNumberUnitsEnemy[0])*Variables.DEUTERIUM_COST_LIGTHHUNTER;
		loses01=loses01+(this.initialArmies[1][1]-this.actualNumberUnitsEnemy[1])*Variables.DEUTERIUM_COST_HEAVYHUNTER;
		loses01=loses01+(this.initialArmies[1][2]-this.actualNumberUnitsEnemy[2])*Variables.DEUTERIUM_COST_BATTLESHIP;
		loses01=loses01+(this.initialArmies[1][3]-this.actualNumberUnitsEnemy[3])*Variables.DEUTERIUM_COST_ARMOREDSHIP;
		this.resourcesLoses[1][1]=loses01;
		this.resourcesLoses[0][2]=(this.resourcesLoses[0][0]+this.resourcesLoses[0][1]*5);
		this.resourcesLoses[1][2]=(this.resourcesLoses[1][0]+this.resourcesLoses[1][1]*5);
	}
	public int[] fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		int totalMetal=0;
		int totalDeuterio=0;
		for (int i=0;i<army.length;i++) {
			for (int j=0;j<army[i].size();j++) {
				totalMetal=totalMetal+army[i].get(j).getMetalCost();
				totalDeuterio=totalDeuterio+army[i].get(j).getDeuteriumCost();
			}

		}
		int[] valores=new int[2];
		valores[0]=totalMetal;
		valores[1]=totalDeuterio;
		return valores;
		
	}
	public int initialFleetNumber(ArrayList<MilitaryUnit>[] army) {
		int total=0;
		for (int i=0;i<army.length;i++) {
			total=total+army[i].size();
		}
		return total;
	}
	public int remainderPercentageFleet(ArrayList<MilitaryUnit>[] army) {
		int numeroActual=0;
		for (int i=0;i<army.length;i++) {
			numeroActual=numeroActual+army[i].size();
		}
		if (army.length==7) {
			try {
				return (numeroActual*100/this.getInitialNumberUnitsPlanet());
			}
			catch(Exception e) {
				System.out.println("El ejercito del planeta no tiene unidades");
			}
		}
		else if (army.length==4) {
			try {
				return (numeroActual*100/this.getInitialNumberUnitsEnemy());
			}
			catch(Exception e) {
				System.out.println("El ejercito del enemigo no tiene unidades");
			}
		}
		return 0;
	}
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		if (army.length==7) {
			while(true) {
			int[] array=this.actualNumberUnitsPlanet;
			int total=0;
			for (int i=0;i<array.length;i++) {
				total=total+array[i];
			}
			int numAleatorio=(int) (Math.random()*(total-1));
			int totalArrays=0;
			for (int i=0;i<array.length;i++) {
				totalArrays=totalArrays+array[i];
				if (totalArrays>=numAleatorio) {
					if (planetArmy[i].size()>0) {
						return i;
					}
				}
			}
		}
		}
		else if (army.length==4){
			while(true) {
			int[] array=this.actualNumberUnitsEnemy;
			int total=0;
			for (int i=0;i<array.length;i++) {
				total=total+array[i];
			}
			int numAleatorio=(int) (Math.random()*(total-1));
			int totalArrays=0;
			for (int i=0;i<array.length;i++) {
				totalArrays=totalArrays+array[i];
				if (totalArrays>=numAleatorio) {
					if (enemyArmy[i].size()>0) {
						return i;
					}
				}
			}
		}
		}
		return 0;

	}
	public int getPlanetGroupAttacker() {
		while (true) {
		int[] array=Variables.CHANCE_ATTACK_PLANET_UNITS;
		int total=0;
		for (int i=0;i<array.length;i++) {
			total=total+array[i];
		}
		int numAleatorio=(int) (Math.random()*(total-1));
		int totalArrays=0;
		for (int i=0;i<array.length;i++) {
			totalArrays=totalArrays+array[i];
			if (totalArrays>=numAleatorio) {
				if (planetArmy[i].size()>0) {
					return i;
				}
			}
			}
		}
	}
	public int getEnemyGroupAttacker() {
		while(true) {
			/*LigthHunter ship=new LigthHunter();
			int[] array=ship.CHANCE_ATTACK_ENEMY_UNITS;*/
			int[] array=Variables.CHANCE_ATTACK_ENEMY_UNITS;
			int total=0;
			for (int i=0;i<array.length;i++) {
				total=total+array[i];
			}
			int numAleatorio=(int) (Math.random()*(total-1));
			int totalArrays=0;
			for (int i=0;i<array.length;i++) {
				totalArrays=totalArrays+array[i];
				if (totalArrays>=numAleatorio) {
					if (enemyArmy[i].size()>0) {
						return i;
					}
				}
			}
		}
	}
	public void batalla(int ejercito) {
		String reporteBatalla="";
		reporteBatalla="\n****************CHANGE ATTACKER*******************";
		MilitaryUnit defensor=null;
		MilitaryUnit atacante=null;
		int grupoDefensor=0;
		int numRand=0;
		int waste=0;
		if (ejercito==0) {
			int grupoAtacante=this.getPlanetGroupAttacker();
			int numAtacante=(int) (Math.random()*(this.planetArmy[grupoAtacante].size()-1));
			atacante=this.planetArmy[grupoAtacante].get(numAtacante);
			grupoDefensor=this.getGroupDefender(this.enemyArmy);
			int numDefensor=(int) (Math.random()*(this.enemyArmy[grupoDefensor].size()-1));
			defensor=this.enemyArmy[grupoDefensor].get(numDefensor);
			reporteBatalla=reporteBatalla+"\nAttacks Planet: "+atacante.getClass().getSimpleName()+" attacks "+defensor.getClass().getSimpleName();
		}
		else if (ejercito==1) {
			int grupoAtacante=this.getEnemyGroupAttacker();
			int numAtacante=(int) (Math.random()*(this.enemyArmy[grupoAtacante].size()-1));
			atacante=this.enemyArmy[grupoAtacante].get(numAtacante);
			grupoDefensor=this.getGroupDefender(this.planetArmy);
			int numDefensor=(int) (Math.random()*(this.planetArmy[grupoDefensor].size()-1));
			defensor=this.planetArmy[grupoDefensor].get(numDefensor);
			reporteBatalla=reporteBatalla+"\nAttacks fleet enemy: "+atacante.getClass().getSimpleName()+" attacks "+defensor.getClass().getSimpleName();
		}
		while(numRand<=atacante.getChanceAttackAgain()) {
			if (defensor instanceof Ship && atacante instanceof Ship) {
				((Ship) defensor).setArmor(defensor.getActualArmor()-((Ship) atacante).getBaseDamage());
				reporteBatalla=reporteBatalla+"\n"+atacante.getClass().getSimpleName()+" generates the damage = "+((Ship) atacante).getBaseDamage()+
				"\n"+defensor.getClass().getSimpleName()+" stays with the armor = "+defensor.getActualArmor();

			}
			else if (defensor instanceof Defense && atacante instanceof Ship){
				((Defense) defensor).setArmor(defensor.getActualArmor()-((Ship) atacante).getBaseDamage());
				reporteBatalla=reporteBatalla+"\n"+atacante.getClass().getSimpleName()+" generates the damage = "+((Ship) atacante).getBaseDamage()+
						"\n"+defensor.getClass().getSimpleName()+" stays with the armor = "+defensor.getActualArmor();

			}
			else if (defensor instanceof Ship && atacante instanceof Defense) {
				((Ship) defensor).setArmor(defensor.getActualArmor()-((Defense) atacante).getBaseDamage());
				reporteBatalla=reporteBatalla+"\n"+atacante.getClass().getSimpleName()+" generates the damage = "+((Defense) atacante).getBaseDamage()+
						"\n"+defensor.getClass().getSimpleName()+ "stays with the armor = "+defensor.getActualArmor();
			}
			if (defensor.getActualArmor()<=0) {
				int genWaste=defensor.getChanceGeneratinWaste();
				int randW=(int) (Math.random()*(100-1));
				if (randW<genWaste) {
					waste=waste+defensor.getMetalCost()*(Variables.PERCENTATGE_WASTE*100)+(defensor.getDeuteriumCost()*(Variables.PERCENTATGE_WASTE*100))*5;
				}
				if (ejercito==0) {
					this.enemyArmy[grupoDefensor].remove(defensor);
				}
				else if (ejercito==1) {
					this.planetArmy[grupoDefensor].remove(defensor);
				}
				reporteBatalla=reporteBatalla+"\nwe eliminate "+defensor.getClass().getSimpleName();
			}
			this.updateActualactualNumberUnits();
			numRand=(int) (Math.random()*(100-1));
			if(numRand<=atacante.getChanceAttackAgain()) {
				if (ejercito==0) {
					grupoDefensor=this.getGroupDefender(this.enemyArmy);
					int numDefensor=(int) (Math.random()*(this.enemyArmy[grupoDefensor].size()-1));
					defensor=this.enemyArmy[grupoDefensor].get(numDefensor);
					reporteBatalla=reporteBatalla+"\nAttacks Planet: "+atacante.getClass().getSimpleName()+" attacks "+defensor.getClass().getSimpleName();
				}
				else if (ejercito==1) {
					grupoDefensor=this.getGroupDefender(this.planetArmy);
					int numDefensor=(int) (Math.random()*(this.planetArmy[grupoDefensor].size()-1));
					defensor=this.planetArmy[grupoDefensor].get(numDefensor);
					reporteBatalla=reporteBatalla+"\nAttacks fleet enemy: "+atacante.getClass().getSimpleName()+" attacks "+defensor.getClass().getSimpleName();
					
				}
			}
			
		}
		this.setBattleDevelopment(this.battleDevelopment+reporteBatalla);
	}
	public int[] batallas() {
		int[] valores=new int[2];
		int turn=0;
		int lastTurn=0;
		int planetPct=this.remainderPercentageFleet(this.getPlanetArmy());
		int enemyPct=this.remainderPercentageFleet(this.getEnemyArmy());
		while(planetPct>=20 && enemyPct>=20) {
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
			this.batalla(lastTurn);
			planetPct=this.remainderPercentageFleet(this.getPlanetArmy());
			enemyPct=this.remainderPercentageFleet(this.getEnemyArmy());
			turn++;
		}
		boolean ganador=false;
		if (this.fleetResourceCost(planetArmy)[1]>this.fleetResourceCost(enemyArmy)[1]) {
			ganador=true;
		}
		else if (this.fleetResourceCost(planetArmy)[1]<this.fleetResourceCost(enemyArmy)[1]) {
			ganador=false;
		}
		/*if (ganador) {
			valores[0]=0;
			valores[1]=
		}*/
		return valores;
	}
	
	public void updateActualactualNumberUnits() {
		this.actualNumberUnitsPlanet[0]=planetArmy[0].size();
		this.actualNumberUnitsPlanet[1]=planetArmy[1].size();
		this.actualNumberUnitsPlanet[2]=planetArmy[2].size();
		this.actualNumberUnitsPlanet[3]=planetArmy[3].size();
		this.actualNumberUnitsPlanet[4]=planetArmy[4].size();
		this.actualNumberUnitsPlanet[5]=planetArmy[5].size();
		this.actualNumberUnitsPlanet[6]=planetArmy[6].size();
		this.actualNumberUnitsEnemy[0]=enemyArmy[0].size();
		this.actualNumberUnitsEnemy[1]=enemyArmy[1].size();
		this.actualNumberUnitsEnemy[2]=enemyArmy[2].size();
		this.actualNumberUnitsEnemy[3]=enemyArmy[3].size();
	}
	public void resetArmyArmor() {
		for (ArrayList<MilitaryUnit> m:this.planetArmy) {
			for (int i=0;i<m.size();i++) {
				m.get(i).resetArmor();
			}
		}
	}
}

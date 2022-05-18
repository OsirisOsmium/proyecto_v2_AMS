

import java.util.ArrayList;

public class Planet {
	private int technologyDefense, technologyAtack, metal, deuterium, upgradeDefenseTechnologyDeuteriumCost, upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army = new ArrayList [7];
	
	/* Es un array de arrayLists, donde cada posición del array representa el conjunto de unidades del mismo tipo.
	Army[0] → arrayList de Ligth Hunter
	Army[1] → arrayList de Heavy Hunter
	Army[2] → arrayList de Battle Ship 
	Army[3] → arrayList de Armored Ship
	Army[4] → arrayList de Missile Launcher
	Army[5] → arrayList de Ion Cannon
	Army[6] → arrayList de Plasma Cannon */
	public Planet() {
		this.technologyDefense=1;
		this.technologyAtack=1;
		this.metal=10000;
		this.deuterium=1000;
		Defense ship=new MissileLauncher();
		this.upgradeDefenseTechnologyDeuteriumCost=ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST+ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1))/100);
		this.upgradeAttackTechnologyDeuteriumCost=ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST+ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1))/100);
		
		for (int i=0;i<7;i++) {
            this.army[i]= new ArrayList<MilitaryUnit>();
        }
	}
	public Planet(int metal,int deuterium) {
		this.technologyDefense=1;
		this.technologyAtack=1;
		this.metal=metal;
		this.deuterium=deuterium;
		Defense ship=new MissileLauncher();
		this.upgradeDefenseTechnologyDeuteriumCost=ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST+ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1))/100);
		this.upgradeAttackTechnologyDeuteriumCost=ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST+ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1))/100);
		
		for (int i=0;i<7;i++) {
            this.army[i]= new ArrayList<MilitaryUnit>();
        }
	}
	
	public Planet(int technologyDefense, int technologyAtack, int metal, int deuterium,
			int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost,
			ArrayList<MilitaryUnit>[] army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAtack = technologyAtack;
		this.metal = metal;
		this.deuterium = deuterium;
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
		for (int i=0;i<7;i++) {
            army[i]= new ArrayList<MilitaryUnit>();
        }
		this.army = army;
	}
	
	/**
	 * @return the technologyDefense
	 */
	public int getTechnologyDefense() {
		return technologyDefense;
	}
	/**
	 * @param technologyDefense the technologyDefense to set
	 */
	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}
	/**
	 * @return the technologyAtack
	 */
	public int getTechnologyAtack() {
		return technologyAtack;
	}
	/**
	 * @param technologyAtack the technologyAtack to set
	 */
	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}
	/**
	 * @return the metal
	 */
	public int getMetal() {
		return metal;
	}
	/**
	 * @param metal the metal to set
	 */
	public void setMetal(int metal) {
		this.metal = metal;
	}
	/**
	 * @return the deuterium
	 */
	public int getDeuterium() {
		return deuterium;
	}
	/**
	 * @param deuterium the deuterium to set
	 */
	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}
	/**
	 * @return the upgradeDefenseTechnologyDeuteriumCost
	 */
	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}
	/**
	 * @param upgradeDefenseTechnologyDeuteriumCost the upgradeDefenseTechnologyDeuteriumCost to set
	 */
	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}
	/**
	 * @return the upgradeAttackTechnologyDeuteriumCost
	 */
	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}
	/**
	 * @param upgradeAttackTechnologyDeuteriumCost the upgradeAttackTechnologyDeuteriumCost to set
	 */
	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}
	/**
	 * @return the army
	 * 
	 */
	public ArrayList<MilitaryUnit>[] getArmy() {
		return this.army;
	}
	/**
	 * @param army the army to set
	 */
	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	public void upgradeTechnologyDefense() {
		Defense ship=new MissileLauncher();
		int costeUpgrade=ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST+(ship.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1)))/100);
		this.setUpgradeDefenseTechnologyDeuteriumCost(costeUpgrade);
		if (this.deuterium>=costeUpgrade) {
			this.deuterium=this.deuterium-costeUpgrade;
			this.technologyDefense=this.technologyDefense+1;
		}
		else {
			try {
				throw new ResourceException(2);
				}
				catch(ResourceException ex) {
					System.out.println(ex.getMessage());
				}
		}
	}
	
	public void upgradeTechnologyAttack() {
		Ship ship=new LigthHunter();
		int costeUpgrade=ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST+(ship.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST*((ship.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST*(this.technologyAtack-1)))/100);
		this.setUpgradeAttackTechnologyDeuteriumCost(costeUpgrade);
		if (this.deuterium>=costeUpgrade) {
			this.deuterium=this.deuterium-costeUpgrade;
			this.technologyAtack=this.technologyAtack+1;
		}
		else {
			try {
			throw new ResourceException(1);
			}
			catch(ResourceException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}
	
	public void newLigthHunter(int n) {
		LigthHunter ligth=new LigthHunter();
		int armadura=ligth.ARMOR_LIGTHHUNTER+(this.technologyDefense*ligth.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)*1000/100;
		int ataque=ligth.BASE_DAMAGE_LIGTHHUNTER+(this.technologyAtack*ligth.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=ligth.DEUTERIUM_COST_LIGTHHUNTER*n && this.metal>=ligth.METAL_COST_LIGTHHUNTER*n) {
			this.deuterium=this.deuterium-ligth.DEUTERIUM_COST_LIGTHHUNTER*n;
			this.metal=this.metal-ligth.METAL_COST_LIGTHHUNTER*n;
			for(int i=0;i<n;i++) {
				this.army[0].add(new LigthHunter(armadura,ataque));
			}
		}
	}
	
	public void newHeavyHunter(int n) {
		HeavyHunter heavy=new HeavyHunter();
		int armadura=heavy.ARMOR_HEAVYHUNTER+(this.technologyDefense*heavy.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY)*1000/100;
		int ataque=heavy.BASE_DAMAGE_HEAVYHUNTER+(this.technologyAtack*heavy.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=heavy.DEUTERIUM_COST_HEAVYHUNTER*n && this.metal>=heavy.METAL_COST_HEAVYHUNTER*n) {
			this.deuterium=this.deuterium-heavy.DEUTERIUM_COST_HEAVYHUNTER*n;
			this.metal=this.metal-heavy.METAL_COST_HEAVYHUNTER*n;
			for(int i=0;i<n;i++) {
				this.army[1].add(new HeavyHunter(armadura,ataque));
			}
		}
	}
	
	public void newBattleShip(int n) {
		BattleShip ship=new BattleShip();
		int armadura=ship.ARMOR_BATTLESHIP+(this.technologyDefense*ship.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY)*1000/100;
		int ataque=ship.BASE_DAMAGE_BATTLESHIP+(this.technologyAtack*ship.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=ship.DEUTERIUM_COST_BATTLESHIP*n && this.metal>=ship.METAL_COST_BATTLESHIP*n) {
			this.deuterium=this.deuterium-ship.DEUTERIUM_COST_BATTLESHIP*n;
			this.metal=this.metal-ship.METAL_COST_BATTLESHIP*n;
			for(int i=0;i<n;i++) {
				this.army[2].add(new BattleShip(armadura,ataque));
			}
		}
	}
	
	public void newArmoredShip(int n) {
		ArmoredShip ship=new ArmoredShip();
		int armadura=ship.ARMOR_ARMOREDSHIP+(this.technologyDefense*ship.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY)*1000/100;
		int ataque=ship.BASE_DAMAGE_ARMOREDSHIP+(this.technologyAtack*ship.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=ship.DEUTERIUM_COST_ARMOREDSHIP*n && this.metal>=ship.METAL_COST_ARMOREDSHIP*n) {
			this.deuterium=this.deuterium-ship.DEUTERIUM_COST_ARMOREDSHIP*n;
			this.metal=this.metal-ship.METAL_COST_ARMOREDSHIP*n;
			for(int i=0;i<n;i++) {
				this.army[3].add(new ArmoredShip(armadura,ataque));
			}
		}
	}
	
	public void newMissileLauncher(int n) {
		MissileLauncher missile=new MissileLauncher();
		int armadura=missile.ARMOR_MISSILELAUNCHER+(this.technologyDefense*missile.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY)*1000/100;
		int ataque=missile.BASE_DAMAGE_MISSILELAUNCHER+(this.technologyAtack*missile.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=missile.DEUTERIUM_COST_MISSILELAUNCHER*n && this.metal>=missile.METAL_COST_MISSILELAUNCHER*n) {
			this.deuterium=this.deuterium-missile.DEUTERIUM_COST_MISSILELAUNCHER*n;
			this.metal=this.metal-missile.METAL_COST_MISSILELAUNCHER*n;
			for(int i=0;i<n;i++) {
				this.army[4].add(new MissileLauncher(armadura,ataque));
			}
		}
	}
	
	public void newIonCannon(int n) {
		IonCannon ion=new IonCannon();
		int armadura=ion.ARMOR_IONCANNON+(this.technologyDefense*ion.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY)*1000/100;
		int ataque=ion.BASE_DAMAGE_IONCANNON+(this.technologyAtack*ion.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=ion.DEUTERIUM_COST_IONCANNON*n && this.metal>=ion.METAL_COST_IONCANNON*n) {
			this.deuterium=this.deuterium-ion.DEUTERIUM_COST_IONCANNON*n;
			this.metal=this.metal-ion.METAL_COST_IONCANNON*n;
			for(int i=0;i<n;i++) {
				this.army[5].add(new IonCannon(armadura,ataque));
			}
		}
	}
	
	public void newPlasmaCannon(int n) {
		PlasmaCannon plasma=new PlasmaCannon();
		int armadura=plasma.ARMOR_PLASMACANNON+(this.technologyDefense*plasma.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY)*1000/100;
		int ataque=plasma.BASE_DAMAGE_PLASMACANNON+(this.technologyAtack*plasma.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY)*1000/100;
		if(this.deuterium>=plasma.DEUTERIUM_COST_PLASMACANNON*n && this.metal>=plasma.METAL_COST_PLASMACANNON*n) {
			this.deuterium=this.deuterium-plasma.DEUTERIUM_COST_PLASMACANNON*n;
			this.metal=this.metal-plasma.METAL_COST_PLASMACANNON*n;
			for(int i=0;i<n;i++) {
				this.army[6].add(new PlasmaCannon(armadura,ataque));
			}
		}
	}
	
	public void printStats() {
		System.out.println("Planet Stats: ");
		System.out.println("\n\nTECHNOLOGY\n\nAttack Technology: "+this.technologyAtack+"\nDefense Technology: "+this.technologyDefense);
		System.out.println("\n\nDEFENSES");
		System.out.println("\nMissile Launcher: "+this.army[4].size());
		System.out.println("Ion Cannon: "+this.army[5].size());
		System.out.println("Plasma Cannon: "+this.army[6].size());
		System.out.println("\nFLEET\n");
		System.out.println("Ligth Hunter: "+this.army[0].size());
		System.out.println("Heavy Hunter: "+this.army[1].size());
		System.out.println("Battle Ship: "+this.army[2].size());
		System.out.println("Armored Ship: "+this.army[3].size());
		System.out.println("\nRESOURCES\n");
		System.out.println("Metal: "+this.metal);
		System.out.println("Deuterium: "+this.deuterium);
		
	}
}

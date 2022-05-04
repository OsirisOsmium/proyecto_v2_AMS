package Projecto2;

import java.util.ArrayList;

public class Planet {
	private int technologyDefense, technologyAtack, metal, deuterium, upgradeDefenseTechnologyDeuteriumCost, upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit> army = new ArrayList[7];
	
	/* Es un array de arrayLists, donde cada posición del array representa el conjunto de unidades del mismo tipo.
	Army[0] → arrayList de Ligth Hunter
	Army[1] → arrayList de Heavy Hunter
	Army[2] → arrayList de Battle Ship 
	Army[3] → arrayList de Armored Ship
	Army[4] → arrayList de Missile Launcher
	Army[5] → arrayList de Ion Cannon
	Army[6] → arrayList de Plasma Cannon */
	
	public Planet(int technologyDefense, int technologyAtack, int metal, int deuterium,
			int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost,
			ArrayList<MilitaryUnit> army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAtack = technologyAtack;
		this.metal = metal;
		this.deuterium = deuterium;
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
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
	 */
	public ArrayList<MilitaryUnit> getArmy() {
		return army;
	}
	/**
	 * @param army the army to set
	 */
	public void setArmy(ArrayList<MilitaryUnit> army) {
		this.army = army;
	}
	
	public void upgradeTechnologyDefense() {
		
	}
	
	public void upgradeTechnologyAttack() {
		
	}
	
	public void newLigthHunter(int n) {
		
	}
	
	public void newHeavyHunter(int n) {
		
	}
	
	public void newBattleShip(int n) {
		
	}
	
	public void newArmoredShip(int n) {
		
	}
	
	public void newMissileLauncher(int n) {
		
	}
	
	public void newIonCannon(int n) {
		
	}
	
	public void newPlasmaCannon(int n) {
		
	}
	
	public void printStats() {
		
	}
}

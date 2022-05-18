

public abstract class Ship implements MilitaryUnit, Variables{
	private int armor, initialArmor, baseDamage;

	public Ship() {
		super();
	}

	public Ship(int armor, int baseDamage) {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * @return the initialArmor
	 */
	public int getInitialArmor() {
		return initialArmor;
	}

	/**
	 * @param initialArmor the initialArmor to set
	 */
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}

	/**
	 * @return the baseDamage
	 */
	public int getBaseDamage() {
		return baseDamage;
	}

	/**
	 * @param baseDamage the baseDamage to set
	 */
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	
}

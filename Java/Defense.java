import java.util.ArrayList;

public abstract class Defense implements Variables,MilitaryUnit{
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	public Defense() {
		super();
	}
	public Defense(int armor, int baseDamage) {
		// TODO Auto-generated constructor stub
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getInitialArmor() {
		return initialArmor;
	}
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	
	
	
}

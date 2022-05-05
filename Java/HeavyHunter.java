package Projecto2;

public class HeavyHunter extends Ship{

	public HeavyHunter(int armor, int baseDamage) {
		super(armor, baseDamage);
		// TODO Auto-generated constructor stub
		this.setInitialArmor(armor);
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
	}
	
	public HeavyHunter() {
		this.setInitialArmor(this.ARMOR_HEAVYHUNTER);
		this.setArmor(this.ARMOR_HEAVYHUNTER);
		this.setBaseDamage(this.BASE_DAMAGE_HEAVYHUNTER);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return this.getBaseDamage();
	}

	@Override
	public void takeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		this.setArmor(this.getArmor()-receivedDamage);
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return this.getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return this.METAL_COST_HEAVYHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return DEUTERIUM_COST_HEAVYHUNTER;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		if (this.getArmor()<=0) {
			return this.CHANCE_GENERATNG_WASTE_HEAVYHUNTER;
		}
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return this.CHANCE_ATTACK_AGAIN_HEAVYHUNTER;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		this.setArmor(this.getInitialArmor());
	}

}

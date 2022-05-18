

public class ArmoredShip extends Ship {
	public ArmoredShip(int armor, int baseDamage) {
		super(armor, baseDamage);
		// TODO Auto-generated constructor stub
		this.setInitialArmor(armor);
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
	}
	
	public ArmoredShip() {
		this.setInitialArmor(Variables.ARMOR_ARMOREDSHIP);
		this.setArmor(Variables.ARMOR_ARMOREDSHIP);
		this.setBaseDamage(Variables.BASE_DAMAGE_ARMOREDSHIP);
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
		return Variables.METAL_COST_ARMOREDSHIP;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return Variables.DEUTERIUM_COST_ARMOREDSHIP;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		if (this.getArmor()<=0) {
			return Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP;
		}
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		this.setArmor(this.getInitialArmor());
	}

}
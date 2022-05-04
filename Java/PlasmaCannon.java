
public class PlasmaCannon extends Defense {

	public PlasmaCannon() {
		this.setInitialArmor(this.ARMOR_PLASMACANNON);
		this.setArmor(this.ARMOR_PLASMACANNON);
		this.setBaseDamage(this.BASE_DAMAGE_PLASMACANNON);
	}
	
	public PlasmaCannon(int armor, int baseDamage) {
		super(armor, baseDamage);
		// TODO Auto-generated constructor stub
		this.setInitialArmor(armor);
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
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
		return this.METAL_COST_PLASMACANNON;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return this.DEUTERIUM_COST_PLASMACANNON;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return this.CHANCE_GENERATNG_WASTE_PLASMACANNON;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return this.CHANCE_ATTACK_AGAIN_PLASMACANNON;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		this.setArmor(this.getInitialArmor());
	}



}
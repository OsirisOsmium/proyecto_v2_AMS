

public class BattleShip extends Ship{

	public BattleShip(int armor, int baseDamage) {
		super(armor, baseDamage);
		// TODO Auto-generated constructor stub
		this.setInitialArmor(armor);
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
	}
	
	public BattleShip() {
		this.setInitialArmor(this.ARMOR_BATTLESHIP);
		this.setArmor(this.ARMOR_BATTLESHIP);
		this.setBaseDamage(this.BASE_DAMAGE_BATTLESHIP);
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
		return this.METAL_COST_BATTLESHIP;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return DEUTERIUM_COST_BATTLESHIP;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		if (this.getArmor()<=0) {
			return this.CHANCE_GENERATNG_WASTE_BATTLESHIP;
		}
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return this.CHANCE_ATTACK_AGAIN_BATTLESHIP;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		this.setArmor(this.getInitialArmor());
	}

}

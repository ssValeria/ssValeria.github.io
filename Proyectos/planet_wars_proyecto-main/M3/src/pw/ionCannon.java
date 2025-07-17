package pw;

public class ionCannon extends defense{
	private  final int  ARMOR_IONCANNON = 1200;
	private  final int PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY = 5;
	private  final int  BASE_DAMAGE_IONCANNON = 250;
	private  final int  PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY = 5;

	public ionCannon(int armor, int baseDamage) {
		super(armor, baseDamage);
		
	}
	
	public int getARMOR_IONCANNON() {
		return ARMOR_IONCANNON;
	}

	public int getPLUS_ARMOR_IONCANNON_BY_TECHNOLOGY() {
		return PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY;
	}

	public int getBASE_DAMAGE_IONCANNON() {
		return BASE_DAMAGE_IONCANNON;
	}

	public int getPLUS_ATTACK_IONCANNON_BY_TECHNOLOGY() {
		return PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY;
	}

	public ionCannon() {
        this(1200,250);
    }

}

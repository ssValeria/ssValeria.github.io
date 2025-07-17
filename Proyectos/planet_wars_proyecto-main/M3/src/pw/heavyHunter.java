package pw;

public class heavyHunter extends ship{
	private final int  ARMOR_HEAVYHUNTER = 1000;
	private final int PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY = 5;
	private  final int  BASE_DAMAGE_HEAVYHUNTER = 150;
	private  final int  PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY = 5;


	public heavyHunter(int armor, int baseDamage) {
		super(armor, baseDamage);
		
	}
	
	 public int getARMOR_HEAVYHUNTER() {
		return ARMOR_HEAVYHUNTER;
	}

	public int getPLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY() {
		return PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
	}

	public int getBASE_DAMAGE_HEAVYHUNTER() {
		return BASE_DAMAGE_HEAVYHUNTER;
	}

	public int getPLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY() {
		return PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
	}

	// Segundo contructor
    public heavyHunter() {
        this(1000,150);
    }

}

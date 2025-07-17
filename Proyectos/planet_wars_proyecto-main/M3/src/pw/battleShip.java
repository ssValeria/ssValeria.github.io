package pw;

public class battleShip extends ship{
	private  final int  ARMOR_BATTLESHIP = 6000;
	private  final int PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY = 5;
	private final int BASE_DAMAGE_BATTLESHIP = 1000;
	public final int PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY = 5;


	public battleShip(int armor, int baseDamage) {
		super(armor, baseDamage);
		
	}
	
	public int getARMOR_BATTLESHIP() {
		return ARMOR_BATTLESHIP;
	}

	public int getPLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY() {
		return PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY;
	}

	public int getBASE_DAMAGE_BATTLESHIP() {
		return BASE_DAMAGE_BATTLESHIP;
	}

	public int getPLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY() {
		return PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY;
	}

	public battleShip() {
        this(6000,1000);
    }

}

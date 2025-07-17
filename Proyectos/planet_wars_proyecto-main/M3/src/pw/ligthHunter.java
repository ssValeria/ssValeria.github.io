package pw;

public class ligthHunter extends ship{
	private  final int  ARMOR_LIGTHHUNTER = 400;
	private  final int PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY = 5;
	private  final int  BASE_DAMAGE_LIGTHHUNTER = 80;
	private  final int  PLUS_ATTACK_LIGHTHUNTER_BY_TECHNOLOGY = 5;
	
	public ligthHunter(int armor, int baseDamage) {
        super(armor, baseDamage);
        
        
    }
	
    public int getARMOR_LIGTHHUNTER() {
		return ARMOR_LIGTHHUNTER;
	}

	public int getPLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY() {
		return PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY;
	}

	public int getBASE_DAMAGE_LIGTHHUNTER() {
		return BASE_DAMAGE_LIGTHHUNTER;
	}

	public int getPLUS_ATTACK_LIGHTHUNTER_BY_TECHNOLOGY() {
		return PLUS_ATTACK_LIGHTHUNTER_BY_TECHNOLOGY;
	}

	// Segundo contructor
    public ligthHunter() {
        this(400,80);
    }

}

package pw;


public abstract class defense implements militaryUnit, variables{
	private int armor;
	private int initialArmor;
	private int baseDamage;
	

	public defense(int armor, int baseDamage) {
		super();
		this.armor = armor;
		this.baseDamage = baseDamage;
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
/******************************************************************************************/
	@Override
	public int attack() {
		return this.baseDamage;
	}

	@Override
	public void takeDamage(int receivedDamage) {
		armor -= receivedDamage;
		
	}

	@Override
	public int getActualArmor() {
		return this.armor;
	}

	@Override
	public int getMetalCost() {
		if (this instanceof missileLauncher) {
            return variables.METAL_COST_MISSILELAUNCHER;
        } else if (this instanceof ionCannon) {
            return variables.METAL_COST_IONCANNON;
        } else if (this instanceof plasmaCannon) {
            return variables.METAL_COST_PLASMACANNON;
        } else {
        	return 0;
        }
       
	}
	

	@Override
	public int getDeuteriumCost() {
		 if (this instanceof missileLauncher) {
	            return variables.DEUTERIUM_COST_MISSILELAUNCHER;
	        } else if (this instanceof ionCannon) {
	            return variables.DEUTERIUM_COST_IONCANNON;
	        } else if (this instanceof plasmaCannon) {
	            return variables.DEUTERIUM_COST_PLASMACANNON;
	        } else {
	        	return 0;
	        }
	       
		}
	

	@Override
	public int getChanceGeneratingWaste() {
		 if (this instanceof missileLauncher) {
	            return variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER;
	        } else if (this instanceof ionCannon) {
	            return variables.CHANCE_GENERATNG_WASTE_IONCANNON;
	        } else if (this instanceof plasmaCannon) {
	            return variables.CHANCE_GENERATNG_WASTE_PLASMACANNON;
	        } else {
	        	return 0;
	        }
	       
		}
		

	@Override
	public int getChanceAttackAgain() {
		 if (this instanceof missileLauncher) {
	            return variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER;
	        } else if (this instanceof ionCannon) {
	            return variables.CHANCE_ATTACK_AGAIN_IONCANNON;
	        } else if (this instanceof plasmaCannon) {
	            return variables.CHANCE_ATTACK_AGAIN_PLASMACANNON;
	        } else {
	        	return 0;
	        }
	    
		
	}

	@Override
	public String toString() {
		return "defense [armor=" + armor + ", initialArmor=" + initialArmor + ", baseDamage=" + baseDamage + "]";
	}




	@Override
	public void resetArmor() {
		this.armor = this.initialArmor;
		
	}

}

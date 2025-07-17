package pw;

import java.util.ArrayList;

public class planet implements variables{
	private int technologyDefense;
	private int technologyAtack;
	private int metal; 
	private int deuterium;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	ArrayList<militaryUnit>[] army = new ArrayList[7];
	
	
		
	public planet(int technologyDefense, int technologyAtack, int metal, int deuterium,
		int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost) {
	super();
	this.technologyDefense = technologyDefense;
	this.technologyAtack = technologyAtack;
	this.metal = metal;
	this.deuterium = deuterium;
	this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	 for (int i = 0; i < 7; i++) {
         this.army[i] = new ArrayList<militaryUnit>();
     }
}

	public planet() {
		for (int i = 0; i < 7; i++) {
            this.army[i] = new ArrayList<militaryUnit>();
        }
	}

	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAtack() {
		return technologyAtack;
	}

	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}

	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

	public ArrayList<militaryUnit>[] getArmy() {
		return army;
	}

	public void setArmy(ArrayList<militaryUnit>[] army) {
		this.army = army;
	}
	
/**********************************************************************************************************/
	
	public void upgradeTechnologyDefense()  {
		try {
            if (deuterium >= upgradeDefenseTechnologyDeuteriumCost) {
                technologyDefense++;
                deuterium -= upgradeDefenseTechnologyDeuteriumCost;
                upgradeDefenseTechnologyDeuteriumCost *= 1.1;
            } else {
                throw new resourceException("Deuterium insuficiente para actualizar la tecnologia de defensa.");
            }
        }catch (resourceException e) {
            System.out.println(e.getMessage());
        }
	}
	
    public void upgradeTechnologyAttack()  {
    	try {
            if (deuterium >= upgradeAttackTechnologyDeuteriumCost) {
                technologyAtack++;
                deuterium -= upgradeAttackTechnologyDeuteriumCost;
                upgradeAttackTechnologyDeuteriumCost *= 1.1;
            } else {
                throw new resourceException("Deuterium insuficiente para actualizar la tecnologia de defensa.");
            }
        }catch (resourceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void newLigthHunter(int n) {
        int unidad = n;
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_LIGTHHUNTER & metal >= METAL_COST_LIGTHHUNTER) {
                    int armor = ARMOR_LIGTHHUNTER + ((technologyDefense * PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_LIGTHHUNTER + ((technologyAtack * PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY) * BASE_DAMAGE_LIGTHHUNTER / 100);
                    deuterium -= DEUTERIUM_COST_LIGTHHUNTER;
                    metal -= METAL_COST_LIGTHHUNTER;
                    army[0].add(new ligthHunter());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a LightHunter.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage()); 
                break; 
            }
        }
        System.out.println("Added "+ addedUnits +" LigthHunters");
    }
    public void generarResources () {
    	this.metal += 12500;
    	this.deuterium += 6500;
    }

    public void newHeavyHunter(int n) {
        int unidad = n;
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_HEAVYHUNTER & metal >= METAL_COST_HEAVYHUNTER) {
                    int armor = ARMOR_HEAVYHUNTER + ((technologyDefense * PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_HEAVYHUNTER + ((technologyAtack * PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY) * BASE_DAMAGE_HEAVYHUNTER / 100);
                    deuterium -= DEUTERIUM_COST_HEAVYHUNTER;
                    metal -= METAL_COST_HEAVYHUNTER;
                    army[1].add(new heavyHunter());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a HeavyHunter.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage()); 
                break; 
            }
        }
        System.out.println("Added "+ addedUnits +" HeavyHunters");
    }

    public void newBattleShip(int n) {
        int unidad = n;
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_BATTLESHIP & metal >= METAL_COST_BATTLESHIP) {
                    int armor = ARMOR_BATTLESHIP + ((technologyDefense * PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_BATTLESHIP + ((technologyAtack * PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY) * BASE_DAMAGE_BATTLESHIP / 100);
                    deuterium -= DEUTERIUM_COST_BATTLESHIP;
                    metal -= METAL_COST_BATTLESHIP;
                    army[2].add(new battleShip());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a BattleShips.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage()); 
                break; 
            }
        }
        System.out.println("Added "+ addedUnits +" BattleShips");
    }

    public void newArmoredShip(int n) {
        int unidad = n;
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_ARMOREDSHIP & metal >= METAL_COST_ARMOREDSHIP) {
                    int armor = ARMOR_ARMOREDSHIP + ((technologyDefense * PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_ARMOREDSHIP + ((technologyAtack * PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY) * BASE_DAMAGE_ARMOREDSHIP / 100);
                    deuterium -= DEUTERIUM_COST_ARMOREDSHIP;
                    metal -= METAL_COST_ARMOREDSHIP;
                    army[3].add(new armoredShip());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a ArmoredShips.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage()); 
                break; 
            }
        }
        System.out.println("Added "+ addedUnits +" ArmoredShips");
    }

    public void newMissileLauncher(int n) {
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_MISSILELAUNCHER & metal >= METAL_COST_MISSILELAUNCHER) {
                    int armor = ARMOR_MISSILELAUNCHER + ((technologyDefense * PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_MISSILELAUNCHER + ((technologyAtack * PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY) * BASE_DAMAGE_MISSILELAUNCHER / 100);
                    deuterium -= DEUTERIUM_COST_MISSILELAUNCHER;
                    metal -= METAL_COST_MISSILELAUNCHER;
                    army[4].add(new missileLauncher());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a MissileLauncher.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Added " + addedUnits + " MissileLaunchers");
    }


    public void newIonCannon(int n) {
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_IONCANNON & metal >= METAL_COST_IONCANNON) {
                    int armor = ARMOR_IONCANNON + ((technologyDefense * PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_IONCANNON + ((technologyAtack * PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY) * BASE_DAMAGE_IONCANNON / 100);
                    deuterium -= DEUTERIUM_COST_IONCANNON;
                    metal -= METAL_COST_IONCANNON;
                    army[5].add(new ionCannon());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build an IonCannon.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Added " + addedUnits + " IonCannons");
    }

    

    public void newPlasmaCannon(int n) {
        int addedUnits = 0;
        for (int i = 0; i < n; i++) {
            try {
                if (deuterium >= DEUTERIUM_COST_PLASMACANNON && metal >= METAL_COST_PLASMACANNON) {
                    int armor = ARMOR_PLASMACANNON + ((technologyDefense * PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY) * 1000 / 100);
                    int baseDamage = BASE_DAMAGE_PLASMACANNON + ((technologyAtack * PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY) * BASE_DAMAGE_PLASMACANNON / 100);
                    deuterium -= DEUTERIUM_COST_PLASMACANNON;
                    metal -= METAL_COST_PLASMACANNON;
                    army[6].add(new plasmaCannon());
                    addedUnits++;
                } else {
                    throw new resourceException("There's not enough resources to build a PlasmaCannon.");
                }
            } catch (resourceException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Added " + addedUnits + " PlasmaCannons");
    }

    	

    

    public void printStats() {
    	String datos = String.format("Planet Stats:\n\n" +
                "TECHNOLOGY\n\n" +
                "Atack Technology:       %d\n" +
                "Defense Technology:     %d\n\n" +
                "DEFENSES\n\n" +
                "Missile Launcher:       %d\n" +
                "Ion Cannon:             %d\n" +
                "Plasma Cannon:          %d\n\n" +
                "FLEET\n\n" +
                "Light Hunter:           %d\n" +
                "Heavy Hunter:           %d\n" +
                "Battle Ship:            %d\n" +
                "Armored Ship:           %d\n\n" +
                "RESOURCES\n\n" +
                "Metal:          %d\n" +
                "Deuterium:      %d\n",
                technologyAtack, technologyDefense,army[4].size(),army[5].size(),army[6].size(),
                army[0].size(),army[1].size(),army[2].size(),army[3].size(), metal, deuterium);
        System.out.println(datos);
    }

    }



package pw;

import java.util.ArrayList;

public class battle implements variables{
	 	private ArrayList<militaryUnit>[] planetArmy;
	    private ArrayList<militaryUnit>[] enemyArmy;
	    private ArrayList[][] armies;
	    private String battleDevelopment;
	    private int[][] initialCostFleet;
	    private int initialNumberUnitsPlanet;
	    private int initialNumberUnitsEnemy;
	    private int[] wasteMetalDeuterium;
	    private int[] enemyDrops;
	    private int[] planetDrops;
	    private int[][] resourcesLooses;
	    private int[][] initialArmies;
	    private int[] actualNumberUnitsPlanet;
	    private int[] actualNumberUnitsEnemy;
	    
	    
	    
	    
	    public battle() {
			super();
			this.planetArmy = new ArrayList[7];
	        this.enemyArmy = new ArrayList[4];
	        this.armies = new ArrayList[2][7];
	        this.initialCostFleet = new int[2][2];
	        this.wasteMetalDeuterium = new int[2];
	        this.enemyDrops = new int[7];
	        this.planetDrops = new int[7];
	        this.resourcesLooses = new int[2][3];
	        this.initialArmies = new int[2][7];
	        this.actualNumberUnitsPlanet = new int[7];
	        this.actualNumberUnitsEnemy = new int[4];
			
		}

		public ArrayList<militaryUnit>[] getPlanetArmy() {
			return planetArmy;
		}

		public void setPlanetArmy(ArrayList<militaryUnit>[] planetArmy) {
			this.planetArmy = planetArmy;
		}

		public ArrayList<militaryUnit>[] getEnemyArmy() {
			return enemyArmy;
		}

		public void setEnemyArmy(ArrayList<militaryUnit>[] enemyArmy) {
			this.enemyArmy = enemyArmy;
		}

		public ArrayList[][] getArmies() {
			return armies;
		}

		public void setArmies(ArrayList[][] armies) {
			this.armies = armies;
		}

		public int[][] getInitialCostFleet() {
			return initialCostFleet;
		}

		public void setInitialCostFleet(int[][] initialCostFleet) {
			this.initialCostFleet = initialCostFleet;
		}

		public int getInitialNumberUnitsPlanet() {
			return initialNumberUnitsPlanet;
		}

		public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
			this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
		}

		public int getInitialNumberUnitsEnemy() {
			return initialNumberUnitsEnemy;
		}

		public void setInitialNumberUnitsEnemy(int initialNumberUnitsEnemy) {
			this.initialNumberUnitsEnemy = initialNumberUnitsEnemy;
		}

		public int[] getWasteMetalDeuterium() {
			return wasteMetalDeuterium;
		}

		public void setWasteMetalDeuterium(int[] wasteMetalDeuterium) {
			this.wasteMetalDeuterium = wasteMetalDeuterium;
		}

		public int[] getEnemyDrops() {
			return enemyDrops;
		}

		public void setEnemyDrops(int[] enemyDrops) {
			this.enemyDrops = enemyDrops;
		}

		public int[] getPlanetDrops() {
			return planetDrops;
		}

		public void setPlanetDrops(int[] planetDrops) {
			this.planetDrops = planetDrops;
		}

		public int[][] getResourcesLooses() {
			return resourcesLooses;
		}

		public void setResourcesLooses(int[][] resourcesLooses) {
			this.resourcesLooses = resourcesLooses;
		}

		public int[][] getInitialArmies() {
			return initialArmies;
		}

		public void setInitialArmies(int[][] initialArmies) {
			this.initialArmies = initialArmies;
		}

		public int[] getActualNumberUnitsPlanet() {
			return actualNumberUnitsPlanet;
		}

		public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
			this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
		}

		public int[] getActualNumberUnitsEnemy() {
			return actualNumberUnitsEnemy;
		}

		public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
			this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
		}

		public void setBattleDevelopment(String battleDevelopment) {
			this.battleDevelopment = battleDevelopment;
		}
		
	/********************************************************************  *******************************************************************/

		public String getBattleReport(int battles) {
	        return battleDevelopment;
	    }

	    public String getBattleDevelopment() {
	        return battleDevelopment;
	    }
	    
	    
	    public void initInitialArmies() { /*BIEN*/
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 7; j++) {
	                if (armies[i][j] == null) {
	                    initialArmies[i][j] = 0;
	                } else {
	                    	initialArmies[i][j] = armies[i][j].size();
	                    }
	                } 
	            }
	        }
	    
	    
	    //final
	    public void updateResourcesLooses() {
	       
	    }
	    
	    public void fleetResourceCost(ArrayList<militaryUnit>[] army) {
	        int totalMetal = 0;
	        int totalDeuterium = 0;
	        
	         for (int i = 0; i < army.length; i++) {
	                 totalMetal += army[i].size() * METAL_COST_UNITS[i];
	                 totalDeuterium += army[i].size() * DEUTERIUM_COST_UNITS[i];
	         }
	         
	         if (army.length == 7) {
	             initialCostFleet[0][0] =  totalMetal;
	             initialCostFleet[0][1] = totalDeuterium;
	         }
	         else {
	             initialCostFleet[1][0] = totalMetal;
	             initialCostFleet[1][1] = totalDeuterium;
	         }
	    }
	      
	        
	    
	    public void initialFleetNumber(ArrayList<militaryUnit>[] army) {
	        int totalUnidades = 0;
	        for (int i = 0; i < army.length; i++) {
	        	 if (army[i] == null) {
	        		 totalUnidades += 0;
	        	 }
	        	 else {
	        		 totalUnidades += army[i].size();
	        	 }
	        }
	        
	        if (army.length == 7) {
	        	 initialNumberUnitsPlanet = totalUnidades;
	        
	        }
	        else {
	        	initialNumberUnitsPlanet = totalUnidades;
	        	
	                  } 
	              }	 

	  
	    public int remainderPercentageFleet(ArrayList<militaryUnit>[] army) {
	    	System.out.println("remainderdeloscojones");
	    	 int flotaActual = 0;
	    	 int resultado = 0;
	    	 for (int i = 0; i < army.length; i++) {
	    		 if (army[i] != null)    			
	    			 flotaActual += army[i].size();
	    	 }

	    	  if (army.length == 7) {
	    	         resultado = (flotaActual * 100) / initialNumberUnitsPlanet;
	    	         
	    	        }
	    	  else {
	    	         resultado = (flotaActual * 100) / initialNumberUnitsEnemy;
	    	        
	    	        }
	    	  		return resultado;
	    	    }
	    		 
	 	   
	    public int getGroupDefender(ArrayList<militaryUnit>[] army) {
	       
	        int totalUnits = 0;
	        int calculo = 0;
	        int totalprobabilidad = 0;
	        int randomNumber = 0;
	        int comprobarPorcentages = 0;
	        boolean salir = false;
	        ArrayList groupProbabilidades = new ArrayList();
	        System.out.println("Mierda de array de probabilidades");

	    
	        for (int i = 0; i < army.length; i++) {
	        	if (army[i] != null) {
	            totalUnits += army[i].size();
	            System.out.println("totalunidades for");
	        }
	        	
	        	}
	        if (totalUnits== 0) {
	            totalUnits = 1;
	        }
	        for (int i = 0; i < army.length; i++) {
	        	if(army[i] != null) {
	                calculo = army[i].size()*100;
	            }
	            calculo = calculo/totalUnits;
	        	 groupProbabilidades.add(calculo);
	        	 totalprobabilidad += calculo;
	        }
	        System.out.println("Mierdaseca group defender");
	        
	        	
	        while (true) {
	            randomNumber = (int)Math.random() * totalprobabilidad;
	            for (int i = 0; i < groupProbabilidades.size(); i++) {
	                comprobarPorcentages += (int) groupProbabilidades.get(i);
	                if (comprobarPorcentages >= randomNumber) {
	                	System.out.println("despues del while de mierda");
	                    return i;
	                    
	                }
	            }
	            
	        }
	            
	        
	       
	    }
	    

	    public int getPlanetGroupAttacker() {
	        int totalUnits = 0;
	        double randomNumber = 0;
	        int comprobacionPorcentages = 0;
	        for (int i = 0; i < CHANCE_ATTACK_PLANET_UNITS.length; i++) {
	             totalUnits += CHANCE_ATTACK_PLANET_UNITS[i];
	        }
	        while (true) {
	            randomNumber =  (int)(Math.random()*totalUnits);
	            for (int i = 0; i < CHANCE_ATTACK_PLANET_UNITS.length; i++) {
	                comprobacionPorcentages += (int) CHANCE_ATTACK_PLANET_UNITS[i];
	                if (comprobacionPorcentages >= randomNumber & armies[0][i].size()>0) {
	                    return i;
	                }
	            }
	        }
	    }

	    public int  getEnemyGroupAttacker() {
	        int totalUnits = 0;
	        double randomNumber = 0;
	        int comprobacionPorcentages = 0;
	        for (int i = 0; i < CHANCE_ATTACK_ENEMY_UNITS.length; i++) {
	             totalUnits += CHANCE_ATTACK_ENEMY_UNITS[i];
	        }
	        while (true) {
	            randomNumber =  (int)(Math.random()*totalUnits);
	            for (int i = 0; i < CHANCE_ATTACK_ENEMY_UNITS.length; i++) {
	                comprobacionPorcentages += (int) CHANCE_ATTACK_ENEMY_UNITS[i];
	                if (comprobacionPorcentages >= randomNumber & armies[1][i].size()>0) {
	                    return i;
	                }
	            }
	        }
	    }

	    public void resetArmyArmor() {

	    }
	    public void iniciarArmies() {
	        for (int i = 0;i<this.armies.length;i++) {
	            if (i == 0) {
	                armies[i] = this.planetArmy.clone();
	            }
	            else {
	                armies[i] = this.enemyArmy.clone();
	            }
	        }
	    }
}


	



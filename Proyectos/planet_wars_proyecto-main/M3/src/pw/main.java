package pw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;
import pw.*;

public class main implements variables{
	
	
	
	private planet planeta;
	private battle pelea;
	private int metalEnemigo = METAL_BASE_ENEMY_ARMY;
	private int deuterioEnemigo = DEUTERIUM_BASE_ENEMY_ARMY;
	private TimerTask task1;
	private TimerTask task2;
	private TimerTask task3;
	private final String menu00 = "\n1)View Planet Stats\n2)Build\n3)Upgrade Technology\n4)View Battle Reports\n0)Exit";
	private final String menu05 = "\nMain Menu\n1)View Planet Stats\n2)Build\n3)Upgrade Technology\n4)View Battle Reports\n5)View Thread Comming\n0)Exit";
	private boolean flg_00 = true;
	private boolean nosAtacan = false;
	private String menuMostrar = "";
	main(){
		this.planeta = new planet();
		this.pelea = new battle();
	}
	public static void main(String[] args) throws resourceException {
		//VARIABLES DE CONEXION BD
		oraclejava conexion = new oraclejava();
		conexion.conectar();
		
		
		
		main programa = new main();
		planet planet1 = programa.getPlanet();
		battle pelea = programa.getPelea();
		planet1.setMetal(200000);
		planet1.setDeuterium(54500);
		planet1.setTechnologyDefense(0);
        planet1.setTechnologyAtack(0);
        
        //---------------------------
		
        planet1.setTechnologyAtack(0);
		planet1.setUpgradeAttackTechnologyDeuteriumCost(2000);
		planet1.setUpgradeDefenseTechnologyDeuteriumCost(2000);
		
		// ---------------------------
		
		//ATAQUE
		planet1.newArmoredShip(1);
		planet1.newBattleShip(1);
		planet1.newLigthHunter(3);
		planet1.newHeavyHunter(1);

		//DEFENSA

		planet1.newMissileLauncher(1);
		planet1.newIonCannon(1);
		planet1.newPlasmaCannon(1);
		Timer timer = new Timer();
		programa.timers();
		timer.schedule(programa.task1, 60000,60000);
        timer.schedule(programa.task2, 120000,180000);
        timer.schedule(programa.task3, 120000,180000);
		
		
        
		final String menu02 = "Build\n1)Build troops\n2)Build Defenses\n3)Go Back";
		final String menu021 = "Menu Build troops\n\n1)Build Ligth Hunter\n2)Build HeavyHunter\n3)Build Battle Ship\n4)Build ArmoredShip\n5)Go Back";
		final String menu022 = "Menu Build Defenses\n\n1)Build Missile Launcher\n2)Build Ion Cannon\n3)Build Plasma Cannon\n4)Go Back";
		final String menu03 = "1)Upgrade Defense Technology.\n2)Upgrade Attack Technology.\n3)Go Back";
		final String menu04 = "Battle Reports\nThere is not reports to read";
		programa.setMenuMostrar(programa.menu00);
		Comprobar comprobacion = new Comprobar();
		
		boolean salir = false;
		 while (!salir) {
	            System.out.println(programa.menuMostrar);
	            System.out.println("Option > ");
	            int option = comprobacion.comprobarNumero();
	            switch (option) {
	            case 1:
	            	planet1.printStats();
	            	break;
	            case 2:
	            	boolean salirbuild = false;
	            	 while (!salirbuild) {
	            		 System.out.println(menu02);
	                     System.out.println("Option > ");
	                     option = comprobacion.comprobarNumero();
	                     switch (option){
	                     case 1:
	                    	 boolean salirbuildtroops = false;
	                    	 while (!salirbuildtroops) {
	                    		 System.out.println(menu021);
	                             System.out.println("Option > ");
	                             option = comprobacion.comprobarNumero();
	                             switch (option){
	                             case 1:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 int cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newLigthHunter(cantidad);
	                            	 break;
	                             case 2:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newHeavyHunter(cantidad);
	                            	 break;
	                             case 3:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newBattleShip(cantidad);
	                            	 break;
	                             case 4:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newArmoredShip(cantidad);
	                            	 break;
	                             case 5:
	                            	 salirbuildtroops = true;
	                            	 break;
	                             default:
	          						System.out.println("\nInvalid option\n");
	                            
	                             }          
	                            	}
	                	
	                     break;     	 
	                     case 2:
	                    	 boolean salirbuilddefense = false;
	                    	 while (!salirbuilddefense) {
	                    		 System.out.println(menu022);
	                             System.out.println("Option > ");
	                             option = comprobacion.comprobarNumero();
	                             switch (option){
	                             case 1:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 int cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newMissileLauncher(cantidad);
	                            	 break;
	                             case 2:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newIonCannon(cantidad);
	                            	 break;
	                             case 3:
	                            	 System.out.println("Amount of Units ");
	                            	 System.out.println("Amount: > ");
	                            	 cantidad = comprobacion.comprobarNumero();
	                            	 planet1.newPlasmaCannon(cantidad);
	                            	 break;
	                            
	                             case 4:
	                            	 salirbuilddefense = true;
	                            	 break;
	                             default:
	          						System.out.println("\nInvalid option\n");
	                            
	                             }          
	                            	}
	                    
	                     break;
	                    	
	                     case 3:
	                    	 salirbuild = true;
	                    	 break;
	                     default:
	 						System.out.println("\nInvalid option\n");
	 					}
	  
	                     }
			      
			        break;
	            case 3:
	            	boolean salirUpgrade = false;
					while (!salirUpgrade) {
//						
						int actualDefense = planet1.getTechnologyDefense();
						int actualAttack = planet1.getTechnologyAtack();
						int costDefenseUpgrade = planet1.getUpgradeDefenseTechnologyDeuteriumCost();
						int costAttackUpgrade = planet1.getUpgradeAttackTechnologyDeuteriumCost();
						int deuteriumActual = planet1.getDeuterium();
//			
						String menuUpgrade = String.format(
								"Upgrade Technology\nActual Defense Technology:             %d\nActual Attack Technology:              %d\n\n1)Upgrade Defense Technology. Cost: %d  Deuterium\n2)Upgrade Attack Technology.  Cost: %d  Deuterium\n3)Go back\n\nDeuterium resources = %d",
								actualDefense, actualAttack, costDefenseUpgrade, costAttackUpgrade, deuteriumActual);

//						
						System.out.println(menuUpgrade);
						System.out.println("Option >");
						option = comprobacion.comprobarNumero();
						switch (option){
							
								case 1:
									planet1.upgradeTechnologyDefense();
									break;
								case 2:
									planet1.upgradeTechnologyAttack();
									break;
								case 3:
									salirUpgrade = true;
									break;
								}
					}
					
					break;
	            
	            case 4:
	            	System.out.println(menu04);
	            	break;
	            case 5:
	            	if (programa.flg_00 & programa.nosAtacan){
	            		programa.ViewThreat();
	            		break;
	            	}
	            
	            case 0:
	            	timer.cancel();
	                System.out.println("Exiting...");
	                comprobacion.parar();
	               conexion.insertar(planet1.getMetal(), planet1.getDeuterium(), planet1.getTechnologyDefense(), planet1.getTechnologyAtack(), planet1.getArmy()[4].size(), planet1.getArmy()[5].size(), 
	            		   planet1.getArmy()[6].size(), planet1.getArmy()[0].size(), planet1.getArmy()[1].size(), planet1.getArmy()[2].size(), planet1.getArmy()[3].size());
	                salir = true;
	                break;
	                
	            default:
	                System.out.println("\nInvalid option\n");
			} 
	            
	           

	}
      
           }
	public void createEnemyArmy() {
		int recursosMetal = metalEnemigo;
	    int recursosDeuterium = deuterioEnemigo;
	    int[] porcentajesEnemy = {35, 25, 20, 20}; // LigthHunter, HeavyHunter, BattleShip, ArmoredShip
	    int total = 0;
	    
	    
	    ArrayList<militaryUnit>[] enemyArmy = new ArrayList[4];
	    for (int i= 0; i < enemyArmy.length; i++) {
	    	enemyArmy[i] = new ArrayList<militaryUnit>();
	    	//System.out.println("despues de arraylist enemyarmy");
	    	
	    }
	    
        while (recursosMetal >= METAL_COST_LIGTHHUNTER & recursosDeuterium >= DEUTERIUM_COST_LIGTHHUNTER) {
            int randNum =  (int)(Math.random()*100);
            //System.out.println("metal" + recursosMetal + "deuterio" + recursosDeuterium);
            //System.out.println("dpepepeepepeep");
            total = 0;
            boolean seleccionado = false;
            //System.out.println(randNum);
            for (int i = 0; i < porcentajesEnemy.length; i++) {
            	total += porcentajesEnemy[i];
            	//System.out.println(total);
            	//System.out.println(seleccionado);
            	if(total >= randNum) {
            		//System.out.println("despues del for de porcentajes enemy");
            	
            	 if (i == 0 & !seleccionado & recursosMetal >= METAL_COST_LIGTHHUNTER & recursosDeuterium >= DEUTERIUM_COST_LIGTHHUNTER) {
                     enemyArmy[0].add(new ligthHunter());
                     recursosMetal -= METAL_COST_LIGTHHUNTER;
                     recursosDeuterium -= DEUTERIUM_COST_LIGTHHUNTER;
                     seleccionado = true;
                     //System.out.println("Ha añadido LigthHunter");
                     
                     
                 } else if (i == 1 &  !seleccionado & recursosMetal >= METAL_COST_HEAVYHUNTER & recursosDeuterium >= DEUTERIUM_COST_HEAVYHUNTER) {
                     enemyArmy[1].add(new heavyHunter());
                     recursosMetal -= METAL_COST_HEAVYHUNTER;
                     recursosDeuterium -= DEUTERIUM_COST_HEAVYHUNTER;
                     seleccionado = true;
                     //System.out.println("Ha añadido HeavyHunter");
                 } else if ( i == 2 &  !seleccionado &   recursosMetal >= METAL_COST_BATTLESHIP & recursosDeuterium >= DEUTERIUM_COST_BATTLESHIP) {
                     enemyArmy[2].add(new battleShip());
                     recursosMetal -= METAL_COST_BATTLESHIP;
                     recursosDeuterium -= DEUTERIUM_COST_BATTLESHIP;
                     seleccionado = true;
                     //System.out.println("Ha añadido BattleShip");
                 } else if ( i == 3 &    !seleccionado &  recursosMetal >= METAL_COST_ARMOREDSHIP & recursosDeuterium >= DEUTERIUM_COST_ARMOREDSHIP) {
                     enemyArmy[3].add(new armoredShip());
                     recursosMetal -= METAL_COST_ARMOREDSHIP;
                     recursosDeuterium -= DEUTERIUM_COST_ARMOREDSHIP;
                     seleccionado = true;
                     //System.out.println("Ha añadido AromredShip");
                 } 
            	}
            	}
            	
            
            
           
        }
        metalEnemigo += 40000;
        deuterioEnemigo += 20000;
      
        pelea.setEnemyArmy(enemyArmy.clone());
      
        }

	public void ViewThreat() {
        String datos = String.format("NEW THREAT COMING\n\nLigth Hunter:            %d\nHeavyHunter:            %d\nBattle Ship:            %d\nArmored Ship            %d", 
                pelea.getEnemyArmy()[0].size(),pelea.getEnemyArmy()[1].size(), pelea.getEnemyArmy()[2].size(),pelea.getEnemyArmy()[3].size() );
        System.out.println(datos);
    }

public void timers(){
	
	task1 = new TimerTask() {

		 public void run()
		 {
			 planeta.setMetal(planeta.getMetal()+12500);
			 planeta.setDeuterium(planeta.getDeuterium()+6500);
		 }
		 };	
		 
	task2 = new TimerTask() {

		 public void run()
		 {
			 Comprobar comprobacion = new Comprobar();
			 nosAtacan = true;
			 System.out.println("\n\nNEW THREAD IS COMMING");
			 menuMostrar = menu05;
			 createEnemyArmy();
			 int option = 0;
			 if (flg_00) {
				 System.out.println(menuMostrar);
				 option = comprobacion.comprobarNumero();
				 switch(option) {
				 case 5:
					 ViewThreat();
					 break;
				 }
			 }
		 }
		 };	
		 
	task3 = new TimerTask() {

		 public void run()
		 {
			 nosAtacan = false;
			 System.out.println("\n\nWE HAVE BEEN ATTACKED!!!");
			 menuMostrar = menu00;
			 if (flg_00) {
				 System.out.println(menuMostrar);
			 }
		 }
		 };	
}


public void batalla() {
    pelea = new battle();
    int cont = 0;
    int numAleatorio = (int) (Math.random() * 2 + 1);
    int grupoAtacante = 0;
    int grupoDefensor = 0;
    int atacante = 0;
    int defensor = 0;
    boolean salir = false;

    while (!salir) {
        boolean salir2 = false;
        if (numAleatorio % 2 == 0) {
            grupoAtacante = pelea.getEnemyGroupAttacker();
            cont = 1;
        } else {
            grupoAtacante = pelea.getEnemyGroupAttacker();
            cont = 0;
        }

        grupoDefensor = pelea.getGroupDefender(pelea.getArmies()[numAleatorio % 2]);
        atacante = (int) (Math.random() * pelea.getArmies()[cont][grupoAtacante].size());
        defensor = (int) (Math.random() * pelea.getArmies()[numAleatorio % 2][grupoDefensor].size());

        ((militaryUnit) pelea.getArmies()[numAleatorio % 2][grupoDefensor].get(defensor))
                .takeDamage(((militaryUnit) pelea.getArmies()[cont][grupoAtacante].get(atacante)).attack());

        while (!salir2) {
            int numAleatorio2 = (int) (Math.random() * 100);

            if (((militaryUnit) pelea.getArmies()[numAleatorio % 2][grupoDefensor].get(defensor)).getActualArmor() <= 0) {
                pelea.getArmies()[numAleatorio % 2][grupoDefensor].remove(defensor);

                if (pelea.getArmies()[numAleatorio % 2][grupoDefensor].isEmpty()) {
                    if (pelea.remainderPercentageFleet(pelea.getArmies()[numAleatorio % 2]) <= 20) {
                        salir2 = true;
                        salir = true;
                        break;
                    }
                    grupoDefensor = pelea.getGroupDefender(pelea.getArmies()[numAleatorio % 2]);
                }
                defensor = (int) (Math.random() * pelea.getArmies()[numAleatorio % 2][grupoDefensor].size());
            }

            if (numAleatorio % 2 == 0) {
                if (CHANCE_ATTACK_ENEMY_UNITS[grupoAtacante] <= numAleatorio2) {
                    ((militaryUnit) pelea.getArmies()[numAleatorio % 2][grupoDefensor].get(defensor))
                            .takeDamage(((militaryUnit) pelea.getArmies()[cont][grupoAtacante].get(atacante)).attack());
                } else {
                    salir2 = true;
                }
            } else {
                if (CHANCE_ATTACK_PLANET_UNITS[grupoAtacante] <= numAleatorio2) {
                    ((militaryUnit) pelea.getArmies()[numAleatorio % 2][grupoDefensor].get(defensor))
                            .takeDamage(((militaryUnit) pelea.getArmies()[cont][grupoAtacante].get(atacante)).attack());
                } else {
                    salir2 = true;
                }
            }
        }

        if (pelea.remainderPercentageFleet(pelea.getArmies()[0]) <= 20 || pelea.remainderPercentageFleet(pelea.getArmies()[1]) <= 20) {
            salir = true;
        }

        numAleatorio += 1;
    }
}


public planet getPlanet() {
	return planeta;
}

public void setPlanet(planet planet1) {
	this.planeta = planet1;
}

public battle getPelea() {
	return pelea;
}

public void setPelea(battle pelea) {
	this.pelea = pelea;
}
public String getMenuMostrar() {
	return menuMostrar;
}
public void setMenuMostrar(String menuMostrar) {
	this.menuMostrar = menuMostrar;
}


}

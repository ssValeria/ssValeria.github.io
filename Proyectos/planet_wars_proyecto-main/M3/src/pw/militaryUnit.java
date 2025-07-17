package pw;

public abstract interface militaryUnit {
	  // Método abstracto que devuelve el poder de ataque de la nave
    public abstract int attack();
    
    
    // Método abstracto que reduce el blindaje de la nave según el daño recibido
    public abstract void takeDamage(int receivedDamage);
    
    // Método abstracto que devuelve el valor actual del blindaje de la nave
    public abstract int getActualArmor();
    
    // Método abstracto que devuelve el costo de metal para crear una nueva unidad de esta nave
    public abstract int getMetalCost();
    
    // Método abstracto que devuelve el costo de deuterio para crear una nueva unidad de esta nave
    public abstract int getDeuteriumCost();
    
    // Método abstracto que devuelve la probabilidad de generar residuos al ser eliminada
    public abstract int getChanceGeneratingWaste();
    
    // Método abstracto que devuelve la probabilidad de atacar nuevamente
    public abstract int getChanceAttackAgain();
    
    // Método abstracto que restablece el blindaje de la nave a su valor inicial
    public abstract void resetArmor();
}

/**
 * The Enemy class contains all of the setters and getters for the stats of an enemy such as health, attack and defense.
 * This class also calculates the damage taken by an enemy.
 */
public class Enemy {
    private String name;
    private int health;
    private int originalHealth;
    private int attack;
    private double physicalDefense;
    private double sorceryDefense;
    private double incantationDefense;

    /**
     * Constructor
     * 
     * @param name name of the enemy
     * @param health health of the enemy
     * @param attack attack of the enemy
     * @param physicalDefense physical defense of the enemy
     * @param sorceryDefense sorcery defense of the enemy
     * @param incantationDefense incantation defense of the enemy
     */
    public Enemy(String name, int health, int attack, double physicalDefense, double sorceryDefense, double incantationDefense) {
        this.name = name;
        this.health = health;
        this.originalHealth = health;
        this.attack = attack;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;
    }

    /**
     * Gets the name of the enemy.
     * 
     * @return name of the enemy
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current health of the enemy.
     * 
     * @return current health of the enemy
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the original health of the enemy.
     * 
     * @return original health of the enemy
     */
    public int getOriginalHealth() {
        return originalHealth;
    }

    /**
     * Gets the attack of the enemy.
     * 
     * @return attack of the enemy
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the physical defense of the enemy.
     * 
     * @return physical defense of the enemy
     */
    public double getPhysicalDefense() {
        return physicalDefense;
    }

    /**
     * Gets the sorecry defense of the enemy.
     * 
     * @return sorcery defense of the enemy
     */
    public double getSorceryDefense() {
        return sorceryDefense;
    }

    /**
     * Gets the incantation defense of the enemy.
     * 
     * @return incantation defense of the enemy
     */
    public double getIncantationDefense() {
        return incantationDefense;
    }

    /**
     * Sets the current health of the enemy.
     * 
     * @param health the current health of the enemy
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the original health of the enemy.
     * 
     * @param health the original health of the enemy
     */
    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    /**
     * Sets the attack of the enemy.
     * 
     * @param attack the attack of the enemy
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Sets the physical defense of the enemy.
     * 
     * @param physicalDefense the physical defense of the enemy
     */
    public void setPhysicalDefense(double physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    /**
     * Sets the sorcery defense of the enemy.
     * 
     * @param sorceryDefense the sorcery defense of the enemy
     */
    public void setSorceryDefense(double sorceryDefense) {
        this.sorceryDefense = sorceryDefense;
    }

    /**
     * Sets the incantation defense of the enemy.
     * 
     * @param incantationDefense the incantation defense of the enemy
     */
    public void setIncantationDefense(double incantationDefense) {
        this.incantationDefense = incantationDefense;
    }

    /**
     * Method to apply damage to the enemy.
     * 
     * @param damage Amount of damage to apply.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}

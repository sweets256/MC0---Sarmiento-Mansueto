/**
 * The Enemy class represents an enemy in the game with various attributes such as name, health, attack, and defenses.
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
     * Constructor to initialize an Enemy object with the provided attributes.
     *
     * @param name              The name of the enemy.
     * @param health            The health points of the enemy.
     * @param attack            The attack points of the enemy.
     * @param physicalDefense   The physical defense of the enemy.
     * @param sorceryDefense    The sorcery defense of the enemy.
     * @param incantationDefense The incantation defense of the enemy.
     */
    public Enemy(String name, int health, int attack, double physicalDefense, double sorceryDefense, double incantationDefense) {
        this.name = name;
        this.health = health;
        this.originalHealth = health; // Set the original health
        this.attack = attack;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;
    }

    /**
     * Retrieves the name of the enemy.
     *
     * @return The name of the enemy.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the current health points of the enemy.
     *
     * @return The current health points of the enemy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the original health points of the enemy.
     *
     * @return The original health points of the enemy.
     */
    public int getOriginalHealth() {
        return originalHealth;
    }

    /**
     * Retrieves the attack points of the enemy.
     *
     * @return The attack points of the enemy.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Retrieves the physical defense of the enemy.
     *
     * @return The physical defense of the enemy.
     */
    public double getPhysicalDefense() {
        return physicalDefense;
    }

    /**
     * Retrieves the sorcery defense of the enemy.
     *
     * @return The sorcery defense of the enemy.
     */
    public double getSorceryDefense() {
        return sorceryDefense;
    }

    /**
     * Retrieves the incantation defense of the enemy.
     *
     * @return The incantation defense of the enemy.
     */
    public double getIncantationDefense() {
        return incantationDefense;
    }

    /**
     * Sets the health points of the enemy.
     *
     * @param health The health points to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the original health points of the enemy.
     *
     * @param originalHealth The original health points to set.
     */
    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    /**
     * Sets the attack points of the enemy.
     *
     * @param attack The attack points to set.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Sets the physical defense of the enemy.
     *
     * @param physicalDefense The physical defense to set.
     */
    public void setPhysicalDefense(double physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    /**
     * Sets the sorcery defense of the enemy.
     *
     * @param sorceryDefense The sorcery defense to set.
     */
    public void setSorceryDefense(double sorceryDefense) {
        this.sorceryDefense = sorceryDefense;
    }

    /**
     * Sets the incantation defense of the enemy.
     *
     * @param incantationDefense The incantation defense to set.
     */
    public void setIncantationDefense(double incantationDefense) {
        this.incantationDefense = incantationDefense;
    }

    /**
     * Applies damage to the enemy.
     *
     * @param damage The amount of damage to apply.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}

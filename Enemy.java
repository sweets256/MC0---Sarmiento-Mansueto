public class Enemy {
    private String name;
    private int health;
    private int attack;
    private double physicalDefense;
    private double sorceryDefense;
    private double incantationDefense;

    public Enemy(String name, int health, int attack, double physicalDefense, double sorceryDefense, double incantationDefense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public double getSorceryDefense() {
        return sorceryDefense;
    }

    public double getIncantationDefense() {
        return incantationDefense;
    }

    // Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setPhysicalDefense(double physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public void setSorceryDefense(double sorceryDefense) {
        this.sorceryDefense = sorceryDefense;
    }

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

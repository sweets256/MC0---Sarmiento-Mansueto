/**
 * The Enemy class contains all of the constructor as well as all of the 
 * getters and setters stats of a weapon such as the name, cost and different stats, 
 * namely the hp, endurance, dexterity, strength, intelligence and faith of a weapon.
 */

public class Weapon {
    private String name;
    private int dexterity;
    private int hp;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;
    private int cost;

    /**
     * Constructor
     * 
     * @param name name of the weapon
     * @param cost cost of the weapon
     * @param hp hp stat of the weapon
     * @param endurance endurance stat of the weapon
     * @param dexterity dexterity stat of the weapon
     * @param strength strength stat of the weapon
     * @param intelligence intelligence stat of the weapon
     * @param faith faith stat of the weapon
     */
    public Weapon(String name, int cost, int hp, int endurance, int dexterity, int strength, int intelligence, int faith) {
        this.name = name;
        this.dexterity = dexterity;
        this.hp = hp;
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.strength = strength;
        this.faith = faith;
        this.cost = cost;
    }

    /**
     * Gets the name of a weapon.
     *
     * @return the name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the dexterity stat of a weapon.
     *
     * @return the dexterity stat of the weapon
     */

    public int getDexterity() {
        return dexterity;
    }

    /**
     * Gets the health stat of a weapon.
     *
     * @return the health stat of the weapon
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets the intelligence stat of a weapon.
     *
     * @return the intelligence stat of the weapon
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Gets the endurance stat of a weapon.
     *
     * @return the endurance stat of the weapon
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Gets the strength stat of a weapon.
     *
     * @return the strength stat of the weapon
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Gets the faith stat of a weapon.
     *
     * @return the faith stat of the weapon
     */
    public int getFaith() {
        return faith;
    }

    /**
     * Gets the cost of a weapon.
     *
     * @return the cost of the weapon
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets the name of a weapon.
     *
     * @param name name of the weapon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the dexterity stat of a weapon.
     *
     * @param dexterity dexterity of a weapon
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Sets the health stat of a weapon.
     *
     * @param health health stat of a weapon
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Sets the intelligence stat of a weapon.
     *
     * @param intelligence intelligence stat of a weapon
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Sets the endurance stat of a weapon.
     *
     * @param endurance endurance stat of a weapon
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /**
     * Sets the strength stat of a weapon.
     *
     * @param strength strength stat of a weapon
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Sets the faith stat of a weapon.
     *
     * @param faith faith stat of a weapon
     */
    public void setFaith(int faith) {
        this.faith = faith;
    }

    /**
     * Sets the cost of a weapon.
     *
     * @param cost cost of a weapon
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}

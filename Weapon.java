

public class Weapon {
    private String name;
    private int dexterity;
    private int hp;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;
    private int cost;

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

    // Getters
    public String getName() {
        return name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getHp() {
        return hp;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
    }

    public int getFaith() {
        return faith;
    }

    public int getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

import java.util.Random;

/**
 * The EnemyStats class contains all of the the stats and methods for generating enemy types and bosses for all areas.
 */
public class EnemyStats {

    /**
     * Stats for enemy type 1 in area 1 and 2
     * 
     * @return returns the enemy with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateEnemyType1(int areaIndex) {
        Random rand = new Random();
        String name = "";
        if (areaIndex == 1){
            name = "Godrick Soldier";
        } else if (areaIndex == 2){
            name = "Living Jar";
        }
        int health = rand.nextInt(30 - 20 + 1) + 20;
        int attack = rand.nextInt(80 - 70 + 1) + 70;
        double physicalDefense = 0.20;
        double sorceryDefense = 0.15;
        double incantationDefense = 0.10;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }

    /**
     * Stats for enemy type 2 in area 1 and 2
     * 
     * @return returns the enemy with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateEnemyType2(int areaIndex) {
        Random rand = new Random();
        String name = "";
        if (areaIndex == 1){
            name = "Godrick Archer";
        } else if (areaIndex == 2){
            name = "Glintstone Sorcerer";
        }
        int health = rand.nextInt(35 - 25 + 1) + 25;
        int attack = rand.nextInt(120 - 110 + 1) + 110;
        double physicalDefense = 0.50;
        double sorceryDefense = 0.15;
        double incantationDefense = 0.20;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }

    /**
     * Stats for enemy type 3 in area 1 and 2
     * 
     * @return returns the enemy with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateEnemyType3(int areaIndex) {
        Random rand = new Random();
        String name = "";
        if (areaIndex == 1){
            name = "Godrick Knight";
        } else if (areaIndex == 2){
            name = "Battle Mage";
        }
        int health = rand.nextInt(80 - 70 + 1) + 70;
        int attack = rand.nextInt(130 - 120 + 1) + 120;
        double physicalDefense = 0.25;
        double sorceryDefense = 0.25;
        double incantationDefense = 0.20;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }

    /**
     * Stats for boss in area 1.
     * 
     * @return returns the boss with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateGodrickBoss() {
        int health = 200;
        Random rand = new Random();
        String name = "Godrick the Grafted";
        int attack = rand.nextInt(300 - 150 + 1) + 150;
        double physicalDefense = 0.35;
        double sorceryDefense = 0.20;
        double incantationDefense = 0.15;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }

    /**
     * Stats for boss in area 2.
     * 
     * @return returns the boss with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateNalaBoss() {
        int health = 400;
        Random rand = new Random();
        String name = "Rennala, Queen of the Full Moon";
        int attack = rand.nextInt(300 - 200 + 1) + 200;
        double physicalDefense = 0.15;
        double sorceryDefense = 0.35;
        double incantationDefense = 0.25;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }

    /**
     * Stats for boss in area 3.
     * 
     * @return returns the boss with its name, health, attack, physical defense, sorcery defense and incantation defense
     */
    public static Enemy generateEldenBeast() {
        int health = 800;
        Random rand = new Random();
        String name = "Elden Beast";
        int attack = rand.nextInt(500 - 250 + 1) + 250;
        double physicalDefense = 0.25;
        double sorceryDefense = 0.50;
        double incantationDefense = 0.40;

        return new Enemy(name, health, attack, physicalDefense, sorceryDefense, incantationDefense);
    }
    
}
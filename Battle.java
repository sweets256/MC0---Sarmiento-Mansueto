import java.util.Random;
import java.util.Scanner;

public class Battle {
    private int attackChoice = 0;
    private Character player;
    private Enemy enemy;
    private int areaIndex;
    private Scanner input = new Scanner(System.in);


    /**
     * Constructor
     */
    public Battle(Character player, Enemy enemy, int areaIndex) {
        this.player = player;
        this.enemy = enemy;
        this.areaIndex = areaIndex;
    }

    /**
     * Called from Area(1-3) whenever spawn tile is a monster
     */
    public void startBattle() {
        System.out.println("Battle begins!");
        System.out.println("Player: " + player.getCharacterName() + " | Health: " + player.getCurrentHealth());
        System.out.println("Enemy: " + enemy.getName() + " | Health: " + enemy.getHealth());

        while (true) {
            playerTurn();
            if (enemy.getHealth() <= 0) {
                playerWins();
                break;
            } else {
                enemyTurn();
            }

            enemyTurn();
            if (player.getCurrentHealth() <= 0) {
                playerLoses();
                break;
            }
        }
    }

    /**
     * When it is the player's turn. Can choose to attack [1] or dodge [2]
     */
    private void playerTurn() {
        System.out.println("\nPlayer's Turn:");
        System.out.println("[1] Attack");
        System.out.println("[2] Dodge");
        //System.out.println("[1] Incoming Enemy Damage: " + calculateEnemyDamage()); // This is also present in the character method takeDamage()

        int choice = input.nextInt();        
        int attackType = attackChoice;

        // Implement try catch for wrong inputs
        switch (choice) {
            case 1:
                int playerDamage = calculatePlayerDamage(attackType);
                enemy.takeDamage(playerDamage);
                System.out.println("Player deals " + playerDamage + " damage to the enemy.");
            case 2:
                //int dodge_rate = Math.floor(20 + ((player.getStatValue(3) + weapon_endurance) / 2 )) / 100; 
                // Incomplete. Still need to set get values of player's equipped weapon
            default:
                System.out.println("Invalid choice, please input [1] to attack, or [2] to dodge");
                // Insert error checking and such here
        }

        enemyTurn();
    }

    /**
     * When it is the enemy's turn. Attack always
     */
    private void enemyTurn() {
        System.out.println("\nEnemy's Turn:");
        int enemyDamage = calculateEnemyDamage();
        player.takeDamage(enemyDamage);
        System.out.println("Enemy deals " + enemyDamage + " damage to the player.");

        playerTurn(); 
    }

    /**
     * Calculates player damage based on player and weapon stats. Also depends on what attack they want to do
     */
    private int calculatePlayerDamage(int attackChoice) {
        // Calculation of player damage
        Weapon weapon = player.getEquippedWeapon();
        int physicalDamage = (int) ((player.getStatValue(4) + weapon.getStrength()) * (1 - enemy.getPhysicalDefense()));
        int sorceryDamage = (int) ((player.getStatValue(2) + weapon.getIntelligence()) * (1 - enemy.getSorceryDefense()));
        int incantationDamage = (int) ((player.getStatValue(5) + weapon.getFaith()) * (1 - enemy.getIncantationDefense()));

        attackChoice = input.nextInt(); 

        // Insert sys.out
        // Depends on user input
        switch (attackChoice) {
            case 1:
                return physicalDamage;
            case 2:
                return sorceryDamage;
            case 3:
                return incantationDamage;
            default:
                return 0;
                // Input error message for wrong input
        }

        // Do we need a scanner closer here????
    }

    /**
     * Calculates enemy damage based on their stats in EnemyStats class.
     */
    private int calculateEnemyDamage() {
        Random rand = new Random();
        int baseAttack = enemy.getAttack();
        int damage = rand.nextInt(baseAttack - baseAttack / 2 + 1) + baseAttack / 2;
        return damage * areaIndex;
    }

    /**
     * Result when player wins
     */
    private void playerWins() {
        int runesGained = enemy.getHealth() * 2;
        System.out.println("Enemy felled!");
        System.out.println("Player gains " + runesGained + " runes.");

        // Add gained runes to player's inventory
        player.addRunes(runesGained);
    }

    /**
     * Result when player dies
     */
    private void playerLoses() {
        System.out.println("You died!");
        // Insert code to reset player's health and return to game lobby
        player.setRunes(0);
    }
}

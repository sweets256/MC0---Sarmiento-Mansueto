import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * The Battle class handles all of the calculations and interactions within a given battle sequence,
 */
public class Battle {
    private Character player;
    private Enemy enemy;
    private int areaIndex;

    /**
     * Constructor
     * 
     * @param player the player
     * @param enemy the enemy
     * @param areaIndex the index of the current area
     */
    public Battle(Character player, Enemy enemy, int areaIndex) {
        this.player = player;
        this.enemy =  enemy;
        this.areaIndex = areaIndex;
    }

    /**
     * Called from Area(1-3) whenever spawn tile is a monster
     */
    public void startBattle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Battle begins!");
        System.out.println("Player: " + player.getCharacterName() + " | Health: " + player.getEffectiveHealth());
        System.out.println("Enemy: " + enemy.getName() + " | Health: " + enemy.getHealth());

        while (true) {
            playerTurn(input);
            if (enemy.getHealth() <= 0) {
                playerWins();
                break;
            } else {
                enemyTurn();
            }

            if (player.getEffectiveHealth() <= 0) {
                playerLoses();
                break;
            }
        }
    }

    /**
     * When it is the player's turn. Can choose to attack [1] or dodge [2]
     * 
     * @param input the player's input
     */
    private void playerTurn(Scanner input) {
        while (true) {
            try {
                System.out.println("\nPlayer's Turn:");
                System.out.println("[1] Attack");
                System.out.println("[2] Dodge");
                System.out.println("Enemy health: " + enemy.getHealth());

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        int playerDamage = calculatePlayerDamage(input);
                        enemy.takeDamage(playerDamage);
                        System.out.println("Player deals " + playerDamage + " damage to the enemy.");
                        pauseForMessage();
                        System.out.print("\033\143");
                        return;
                    case 2:
                        int dodge_rate = (int) Math.floor(20 + ((player.getStatValue(3) + player.getEquippedWeaponEndurance()) / 2 )) / (100);

                        if (Math.random() <= dodge_rate) {
                            System.out.println("Player successfully dodges the enemy's attack!");
                        } else {
                            System.out.println("Player fails to dodge the enemy's attack!");
                            int enemyDamage = calculateEnemyDamage();
                            System.out.println("Player takes " + enemyDamage + " damage from the enemy.");
                            player.takeDamage(enemyDamage);
                        }
                        pauseForMessage();
                        System.out.print("\033\143");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select [1] to attack or [2] to dodge.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
            }
        }
    }

    /**
     * Calculates player damage based on player and weapon stats. Also depends on what attack they want to do
     * 
     * @param input the player's choice
     * @return The chosen attack type
     */
    private int calculatePlayerDamage(Scanner input) {
        int physicalDamage;
        int sorceryDamage;
        int incantationDamage;
        
        physicalDamage = (int) (player.getStatValue(4) * (1 - enemy.getPhysicalDefense()));
        sorceryDamage = (int) (player.getStatValue(2) * (1 - enemy.getSorceryDefense()));
        incantationDamage = (int) (player.getStatValue(5) * (1 - enemy.getIncantationDefense()));

        if (player.getEquippedWeapon() != null){
        physicalDamage = (int) ((player.getStatValue(4) + player.getEquippedWeaponStrength()) * (1 - enemy.getPhysicalDefense()));
        sorceryDamage = (int) ((player.getStatValue(2) + player.getEquippedWeaponIntelligence()) * (1 - enemy.getSorceryDefense()));
        incantationDamage = (int) ((player.getStatValue(5) + player.getEquippedWeaponEndurance()) * (1 - enemy.getIncantationDefense()));
        }

        int attackChoice = 0;

        while (true) {
            try {
                System.out.println("What damage type would you like to perform?:");
                System.out.println("[1] Physical Damage");
                System.out.println("[2] Sorcery Damage");
                System.out.println("[3] Incantation Damage");

                attackChoice = input.nextInt();

                switch (attackChoice) {
                    case 1:
                        return physicalDamage;
                    case 2:
                        return sorceryDamage;
                    case 3:
                        return incantationDamage;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        pauseForMessage();
                        System.out.print("\033\143");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
                pauseForMessage();
                System.out.print("\033\143");
            }
        }
    }

    /**
     * When it is the enemy's turn. Attack always
     */
    private void enemyTurn() {
        System.out.println("\nEnemy's Turn:");
        int enemyDamage = calculateEnemyDamage();
        player.takeDamage(enemyDamage);
        System.out.println("Enemy deals " + enemyDamage + " damage to the player.");
    }

    /**
     * Calculates enemy damage based on their stats in EnemyStats class.
     * 
     * @return the damage an enemy deals to the player
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
        int runesGained = enemy.getOriginalHealth() * 2;
        System.out.println("Enemy felled!");
        System.out.println("Player gains " + runesGained + " runes.");
        player.addRunes(runesGained);
    }


    /**
     * Result when player dies
     * 
     * @return returns 0 when a player dies, thus sending them to the game lobby
     */
    private int playerLoses() {
        System.out.println("You died!");
        player.setRunes(0);
        return 0;
    }

    /**
     * Pauses the execution for a short duration to display messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(0500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
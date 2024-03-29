import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private int attackChoice = 0;
    private Character player;
    private Enemy enemy;
    private int areaIndex;
    //Weapon weapon = player.getEquippedWeapon();
    //private Scanner input = new Scanner(System.in);


    /**
     * Constructor
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
        Weapon weapon = player.getEquippedWeapon();
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("\nPlayer's Turn:");
                    System.out.println("[1] Attack");
                    System.out.println("[2] Dodge");

                    int choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            int attackType = attackChoice; // Get the attack type
                            int playerDamage = calculatePlayerDamage(attackType); // Player performs damage
                            enemy.takeDamage(playerDamage); // Enemy takes damage
                            System.out.println("Player deals " + playerDamage + " damage to the enemy.");
                            pauseForMessage();
                            System.out.print("\033\143");
                            enemyTurn(); // Enemy's turn, not sure if we need this bc its already called in startBattle()
                            return; // Exit the method after successful attack
                        case 2:
                            // Implement dodge logic here
                            int dodge_rate = (int) Math.floor(20 + ((player.getStatValue(3) + weapon.getEndurance()) / 2 )) / 100; 

                            if (Math.random() <= dodge_rate) { // Check if dodge is successful (random 1-100 should be <= than dodge rate)
                                System.out.println("Player successfully dodges the enemy's attack!");
                            } else {
                                System.out.println("Player fails to dodge the enemy's attack!");
                                int enemyDamage = calculateEnemyDamage(); // Calculate enemy damage
                                player.takeDamage(enemyDamage); // Player takes damage
                                System.out.println("Player takes " + enemyDamage + " damage from the enemy.");
                            }
                            pauseForMessage();
                            System.out.print("\033\143");
                            enemyTurn(); // Not sure if we need this bc its already called in startBattle()
                            return; // Exit the method after dodge
                        default:
                            System.out.println("Invalid choice. Please select [1] to attack or [2] to dodge.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    input.next(); // Clear the invalid input
                }
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

        playerTurn(); 
    }

    /**
     * Calculates player damage based on player and weapon stats. Also depends on what attack they want to do
     * @return The chosen attack type
     */
        private int calculatePlayerDamage(int attackChoice) {
        // Calculation of player damage with the equipped weapon
        Weapon weapon = player.getEquippedWeapon();
        int physicalDamage = (int) ((player.getStatValue(4) + weapon.getStrength()) * (1 - enemy.getPhysicalDefense()));
        int sorceryDamage = (int) ((player.getStatValue(2) + weapon.getIntelligence()) * (1 - enemy.getSorceryDefense()));
        int incantationDamage = (int) ((player.getStatValue(5) + weapon.getFaith()) * (1 - enemy.getIncantationDefense()));

        attackChoice = 0; // Initialize attackChoice variable

        try (Scanner input = new Scanner(System.in)) {
            // Loop to repeatedly ask for input until a valid input is provided
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
                    input.next(); // Clear the invalid input
                    pauseForMessage();
                    System.out.print("\033\143");
                }
            }
        }
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
        // Player returns back to gamelobby
    }

    /**
     * Pauses the execution for a short duration to display messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

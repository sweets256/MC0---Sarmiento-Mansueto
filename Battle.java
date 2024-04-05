import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * The Battle class represents a battle between the player and an enemy.
 */
public class Battle {
    private Character player;
    private Enemy enemy;
    private int areaIndex;

    /**
     * Constructor to initialize a Battle object with the provided player, enemy, and area index.
     *
     * @param player    The player participating in the battle.
     * @param enemy     The enemy participating in the battle.
     * @param areaIndex The index of the area where the battle takes place.
     */
    public Battle(Character player, Enemy enemy, int areaIndex) {
        this.player = player;
        this.enemy =  enemy;
        this.areaIndex = areaIndex;
    }

    /**
     * Starts the battle between the player and the enemy.
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
     * Handles the player's turn in the battle.
     *
     * @param input The Scanner object for user input.
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
     * Calculates the damage dealt by the player based on their choice of attack type.
     *
     * @param input The Scanner object for user input.
     * @return The damage dealt by the player.
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
     * Handles the enemy's turn in the battle.
     */
    private void enemyTurn() {
        System.out.println("\nEnemy's Turn:");
        int enemyDamage = calculateEnemyDamage();
        player.takeDamage(enemyDamage);
        System.out.println("Enemy deals " + enemyDamage + " damage to the player.");
    }

    /**
     * Calculates the damage dealt by the enemy.
     *
     * @return The damage dealt by the enemy.
     */
    private int calculateEnemyDamage() {
        Random rand = new Random();
        int baseAttack = enemy.getAttack();
        int damage = rand.nextInt(baseAttack - baseAttack / 2 + 1) + baseAttack / 2;
        return damage * areaIndex;
    }

    /**
     * Handles the result when the player wins the battle.
     */
    private void playerWins() {
        int runesGained = enemy.getOriginalHealth() * 2;
        System.out.println("Enemy felled!");
        System.out.println("Player gains " + runesGained + " runes.");
        player.addRunes(runesGained);
    }


    /**
     * Handles the result when the player loses the battle.
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

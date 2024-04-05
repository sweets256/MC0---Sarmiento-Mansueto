import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Character class represents a game character with various attributes 
 * such as name, job class, level, stats, and runes.
 */
public class Character {
    private String characterName;
    private String jobClass;
    private int origHealth = 0;
    private int level = 1;
    private int runes = 100000;
    private int[] stats = new int[6];
    private int effectiveHealth = 0;
    private static final String[][] characterClasses = {
        {"Vagabond", "9", "15", "13", "9", "11", "14", "9"},
        {"Samurai", "9", "12", "15", "9", "13", "12", "8"},
        {"Warrior", "8", "11", "16", "10", "11", "10", "8"},
        {"Hero", "7", "14", "9", "7", "12", "16", "8"},
        {"Astrologer", "6", "9", "12", "16", "9", "8", "7"},
        {"Prophet", "7", "10", "10", "7", "8", "11", "16"}
    };
    private List<Weapon> inventory = new ArrayList<>();
    private Weapon equippedWeapon;

    /**
     * Pauses the execution for a specified duration.
     *
     * @param milliseconds the duration to pause in milliseconds
     */
    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Creates a new character by prompting the user to input character name and job class.
     *
     * @param input the Scanner object to receive user input
     * @return boolean true if the character creation is successful, otherwise false
     */
    public boolean createCharacter(Scanner input) {
        boolean nameSet = false, classSet = false;

        while (!nameSet || !classSet) {
            System.out.print("\033\143");
            System.out.println("========== Character Creation ==========");
            System.out.println("Select the field you want to input:");
            System.out.println("[1] Character Name");
            System.out.println("[2] Job Class");
            System.out.println("Type 'back' at any time to return to the title screen.");
            System.out.print("Enter your choice: ");

            String choice = input.nextLine().trim();

            if ("back".equalsIgnoreCase(choice)) {
                System.out.print("\033\143");
                return false;
            }

            switch (choice) {
                case "1":
                    inputCharacterName(input);
                    nameSet = this.characterName != null && !this.characterName.isEmpty();
                    break;
                case "2":
                    selectJobClass(input);
                    classSet = this.jobClass != null && !this.jobClass.isEmpty();
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    pause(2000);
                    break;
            }
        }

        System.out.print("\033\143");
        System.out.println("========== Character Summary ==========");
        System.out.println("Character name: " + characterName);
        System.out.println("Job class: " + jobClass);
        System.out.println("Starting Level: " + level);
        System.out.println("\n===Stats===");
        System.out.println("Health: " + stats[0]);
        System.out.println("Dexterity: " + stats[1]);
        System.out.println("Intelligence: " + stats[2]);
        System.out.println("Endurance: " + stats[3]);
        System.out.println("Strength: " + stats[4]);
        System.out.println("Faith: " + stats[5]);

        System.out.print("\nConfirm this character? (Y/N): ");

        String confirmation = input.nextLine().trim().toUpperCase();
        while (!"Y".equals(confirmation) && !"N".equals(confirmation)) {
            System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to redo character creation.");
            confirmation = input.nextLine().trim().toUpperCase();
        }
        if ("Y".equals(confirmation)) {
            System.out.print("\033\143");
            System.out.println("Character created successfully!");
            pauseForMessage();
            System.out.print("\033\143");
            return true;
        } else {
            System.out.print("\033\143");
            return createCharacter(input);
        }
    }

    /**
     * Prompts the user to input character name.
     *
     * @param input the Scanner object to receive user input
     */
    private void inputCharacterName(Scanner input) {
        System.out.print("\033\143");
        System.out.println("========== Character Creation ==========");
        System.out.println("Enter character name (or type 'back' to return to the main menu): ");
        String nameInput = input.nextLine();
        if (!"back".equalsIgnoreCase(nameInput.trim())) {
            this.characterName = nameInput;
        } else {
            System.out.print("\033\143");
        }
    }

    /**
     * Prompts the user to select a job class from available options.
     *
     * @param input the Scanner object to receive user input
     */
    private void selectJobClass(Scanner input) {
        System.out.print("\033\143");
        System.out.println("========== Character Creation ==========");
        System.out.println("Select a job class (or type 'back' to return to the main menu)");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.printf("[%d] %s - Level: %s, Health: %s, Dexterity: %s, Intelligence: %s, Endurance: %s, Strength: %s, Faith: %s%n",
                    i + 1, characterClasses[i][0], characterClasses[i][1], characterClasses[i][2], characterClasses[i][3],
                    characterClasses[i][4], characterClasses[i][5], characterClasses[i][6], characterClasses[i][7]);
        }
        while (true) {
            String classInput = input.nextLine();
            if ("back".equalsIgnoreCase(classInput.trim())) {
                return;
            }
            try {
                int classChoice = Integer.parseInt(classInput) - 1;
                if (classChoice >= 0 && classChoice < characterClasses.length) {
                    this.jobClass = characterClasses[classChoice][0];
                    setInitialStats(classChoice);
                    return;
                } else {
                    System.out.println("Invalid choice. Please select a valid job class or type 'back'.");
                    pauseForMessage();
                    System.out.print("\033\143");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'back'.");
                pauseForMessage();
                System.out.print("\033\143");
            }
        }
    }

    /**
     * Sets initial stats based on the selected job class.
     *
     * @param classIndex the index of the selected job class
     */
    private void setInitialStats(int classIndex) {
        this.level = Integer.parseInt(characterClasses[classIndex][1]);
        for (int i = 0; i < stats.length; i++) {
            stats[i] = Integer.parseInt(characterClasses[classIndex][i + 2]);
        }
        effectiveHealth = (100 * (stats[0] / 2));
    }

    /**
     * Displays the character's stats.
     */
    public void displayStats() {
        System.out.println("\n========== Character Stats ==========");
        System.out.println("Name: " + characterName);
        System.out.println("Job Class: " + jobClass);
        System.out.println("Level: " + level);
        System.out.println("Runes: " + runes);
        System.out.println("Health: " + maxHealth()); // Add current health display
        System.out.println("=====================================");
    }

    /**
     * Checks if a player has a weapon equipped and uses the appropriate calculation to get the origHealth and equates effectiveHealth to it
     *
     * @return origHealth
     */
    public int maxHealth(){
        if (equippedWeapon != null){
            origHealth = (100 * (int)Math.floor((stats[0] + getEquippedWeaponHp()) / 2));
        }else {
            origHealth = (100 * (stats[0] / 2));
        }
        effectiveHealth = origHealth;
        return origHealth;
    }

    public void setEffectiveHealth(int origHealth){
        this.effectiveHealth = origHealth;
    }

    /**
     * Increases the specified stat by 1.
     *
     * @param statIndex the index of the stat to increase
     */
    public void increaseStat(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            stats[statIndex - 1]++;
        } else {
            System.out.println("Invalid stat choice.");
        }
    }

    /**
     * Reduces the character's health by the specified amount of damage.
     *
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage) {
        effectiveHealth -= damage;
        if (effectiveHealth < 0){
            effectiveHealth = 0;
        }
        System.out.println("Current Health: " + effectiveHealth);
    }

    public int getEffectiveHealth() {
        return effectiveHealth;
    }

    /**
     * Adds a weapon to the character's inventory.
     *
     * @param weapon the weapon to add
     */
    public void addToInventory(Weapon weapon) {
        inventory.add(weapon);
    }

    /**
     * Removes a weapon from the character's inventory.
     *
     * @param weapon the weapon to remove
     */
    public void removeFromInventory(Weapon weapon) {
        inventory.remove(weapon);
    }

    /**
     * Gets the character's inventory.
     *
     * @return the list of weapons in the inventory
     */
    public List<Weapon> getInventory() {
        return inventory;
    }

     /**
     * Gets the equipped weapon.
     *
     * @return the equipped weapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * Sets the equipped weapon.
     *
     * @param equippedWeapon the weapon to equip
     */
    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        effectiveHealth = (100 * (int)Math.floor((stats[0] + getEquippedWeaponHp()) / 2));
    }

    /**
     * Gets the value of the specified stat.
     *
     * @param statIndex the index of the stat to retrieve
     * @return the value of the specified stat, or -1 if the index is invalid
     */
    public int getStatValue(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            return stats[statIndex - 1];
        } else {
            System.out.println("Invalid stat index.");
            return -1;
        }
    }

    /**
     * Adds the specified amount of runes to the character's inventory.
     *
     * @param additionalRunes the amount of runes to add
     */
    public void addRunes(int additionalRunes) {
        this.runes += additionalRunes;
        System.out.println("Gained " + additionalRunes + " runes. Total now: " + this.runes);
    }

    /**
     * Gets the total number of runes in the character's inventory.
     *
     * @return the total number of runes
     */
    public int getRunes() {
        return this.runes;
    }

    /**
     * Sets the total number of runes in the character's inventory.
     *
     * @param newRunes the new total number of runes
     */
    public void setRunes(int newRunes) {
        this.runes = newRunes;
    }

    /**
     * Gets the level of the character.
     *
     * @return the level of the character
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the character.
     *
     * @param newLevel the new level of the character
     */
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    /**
     * Gets the inputted name of the player.
     *
     * @return the current name of the player
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Gets the dexterity of the equipped weapon.
     * 
     * @return the dexterity of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponDexterity() {
        if (equippedWeapon != null) {
            return equippedWeapon.getDexterity();
        } else {
            return 0;
        }
    }

    /**
     * Gets the health bonus of the equipped weapon.
     * 
     * @return the health bonus of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponHp() {
        if (equippedWeapon != null) {
            return equippedWeapon.getHp();
        } else {
            return 0;
        }
    }

    /**
     * Gets the intelligence bonus of the equipped weapon.
     * 
     * @return the intelligence bonus of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponIntelligence() {
        if (equippedWeapon != null) {
            return equippedWeapon.getIntelligence();
        } else {
            return 0;
        }
    }

    /**
     * Gets the endurance bonus of the equipped weapon.
     * 
     * @return the endurance bonus of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponEndurance() {
        if (equippedWeapon != null) {
            return equippedWeapon.getEndurance();
        } else {
            return 0;
        }
    }

    /**
     * Gets the strength bonus of the equipped weapon.
     * 
     * @return the strength bonus of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponStrength() {
        if (equippedWeapon != null) {
            return equippedWeapon.getStrength();
        } else {
            return 0;
        }
    }

    /**
     * Gets the faith bonus of the equipped weapon.
     * 
     * @return the faith bonus of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponFaith() {
        if (equippedWeapon != null) {
            return equippedWeapon.getFaith();
        } else {
            return 0;
        }
    }

    /**
     * Gets the cost of the equipped weapon.
     * 
     * @return the cost of the equipped weapon, or 0 if no weapon is equipped
     */
    public int getEquippedWeaponCost() {
        if (equippedWeapon != null) {
            return equippedWeapon.getCost();
        } else {
            return 0;
        }
    }

    /**
     * Pauses the execution for a fixed duration to display messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(0500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

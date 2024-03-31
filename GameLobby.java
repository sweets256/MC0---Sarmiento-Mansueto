import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The GameLobby class represents the lobby area of the game where players can access various features.
 * It allows players to fast travel to different areas and level up their characters.
 */
public class GameLobby {
    private Character player;
    private Scanner input = new Scanner(System.in);
    private Navigation navigation;
    private boolean areasCleared = false;
    List<Weapon> weaponsForSale;

    /**
     * Constructs a GameLobby object with the provided Navigation and Character instances.
     *
     * @param navigation the navigation system of the game
     * @param player the player character
     */
    public GameLobby(Navigation navigation, Character player) {
        this.navigation = navigation;
        this.player = player;
        this.weaponsForSale = new ArrayList<>(); // Initialize weapons only once
        initializeWeapons(); // Initialize weapons available for sale
    }

    private boolean isArea1and2Clear(){
        if (Area1Grid.isAreaDone == true && Area2Grid.isAreaDone == true){
            return areasCleared = true;
        }
        return areasCleared;
    }

    /**
     * Initiates the fast travel process for the player.
     * Allows the player to teleport to different available areas.
     */
    public void fastTravel() {
        System.out.print("\033\143");
        String currentArea = navigation.getCurrentArea();
    
        while (true) {
            System.out.println("========== Fast Travel ==========");
            System.out.println("Available areas:");
            System.out.println("[1] Stormveil Castle");
            System.out.println("[2] Raya Lucaria Academy");
            if (isArea1and2Clear() == true){
                System.out.println("[3] The Elden Throne");
            } else {
                System.out.println("[3] The Elden Throne [LOCKED]");
            }
            System.out.print("\nEnter your choice or 'back' to cancel: ");
    
            String inputChoice = input.nextLine().trim();
    
            if ("back".equalsIgnoreCase(inputChoice)) {
                System.out.print("\033\143");
                System.out.println("Teleportation cancelled. Staying in " + currentArea + ".");
                pauseForMessage();
                System.out.print("\033\143");
                break;
            }
    
            try {
                int areaChoice = Integer.parseInt(inputChoice);
                switch (areaChoice) {
                    case 1:
                        System.out.print("\033\143");
                        navigation.setCurrentArea("Stormveil Castle");
                        System.out.println("Teleporting to Stormveil Castle...");
                        pauseForMessage();
                        System.out.print("\033\143");
                        navigation.enterArea("Stormveil Castle");
                        return;
                    case 2:
                        System.out.print("\033\143");
                        navigation.setCurrentArea("Raya Lucaria Academy");
                        System.out.println("Teleporting to Raya Lucaria Academy...");
                        pauseForMessage();
                        System.out.print("\033\143");
                        navigation.enterArea("Raya Lucaria Academy");
                        return;
                    case 3:
                        if (isArea1and2Clear() == true){
                        System.out.print("\033\143");
                        navigation.setCurrentArea("The Elden Throne");
                        System.out.println("Teleporting to The Elden Throne...");
                        pauseForMessage();
                        System.out.print("\033\143");
                        navigation.enterArea("The Elden Throne");
                        } else if (isArea1and2Clear() == false){
                            System.out.println("This Area is locked! Areas 1 and 2 need to be cleared before entering!");
                            pauseForMessage();
                            System.out.print("\033\143");
                        }
                        return;
                    default:
                        System.out.print("\033\143");
                        System.out.println("Invalid choice! Choose an available location or type 'back'.");
                        pauseForMessage();
                        System.out.print("\033\143");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.print("\033\143");
                System.out.println("Invalid input! Choose an available location or type 'back'.");
                pauseForMessage();
                System.out.print("\033\143");
            }
        }
    }
    
    /**
     * Initiates the level-up process for the player.
     * Allows the player to spend runes to increase their character's stats.
     */
    public void levelUp() {
        boolean leveling = true;
    
        while (leveling) {
            int runeCost = (player.getLevel() * 100) / 2;
    
            System.out.println("========== Level Up ==========");
            System.out.println("Current Level: " + player.getLevel());
            System.out.println("You have " + player.getRunes() + " runes.");
            System.out.println("Rune cost to level up: " + runeCost);
            displayStats();
    
            if (player.getRunes() < runeCost) {
                System.out.print("\033\143");
                System.out.println("Not enough runes. You have " + player.getRunes() + " runes, but need " + runeCost + ".");
                pauseForMessage();
                System.out.print("\033\143");
                continue;
            }
    
            System.out.println("Choose a stat to level up or type 'back' to cancel leveling up:");
            String inputChoice = input.nextLine().trim();
    
            if ("back".equalsIgnoreCase(inputChoice)) {
                System.out.print("\033\143");
                System.out.println("Level up cancelled...");
                break;
            }
    
            try {
                int statChoice = Integer.parseInt(inputChoice);
                if (statChoice < 1 || statChoice > 6) {
                    System.out.print("\033\143");
                    throw new IllegalArgumentException("Invalid stat choice. Please select a number between 1 and 6.");
                }
    
                System.out.println("Leveling up stat. This will cost " + runeCost + " runes. Proceed? (Y/N)");
                String confirmation = input.nextLine().toUpperCase();
    
                if ("Y".equals(confirmation)) {
                    System.out.print("\033\143");
                    player.setRunes(player.getRunes() - runeCost);
                    player.increaseStat(statChoice);
                    player.setLevel(player.getLevel() + 1);
    
                    System.out.println("Stat increased successfully!");
                    System.out.println("New player level: " + player.getLevel());
                    displayStats();
                    pauseForMessage();
                    System.out.print("\033\143");
                    continue;
                } else {
                    System.out.print("\033\143");
                    System.out.println("Level up cancelled.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid stat number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Displays the player's inventory and allows them to change their equipped weapon.
     */
    public void inventory() {
        while (true) {
            System.out.println("===== Inventory =====");
            System.out.println("Equipped Weapon:");
            if (player.getEquippedWeapon() != null) {
                System.out.println("Name: " + player.getEquippedWeapon().getName() + "| Dexterity: " + player.getEquippedWeaponDexterity() + ", HP: " + player.getEquippedWeaponHp() + ", Intelligence: " + player.getEquippedWeaponIntelligence() + 
                ", Endurance: " + player.getEquippedWeaponEndurance() + ", Strength: " + player.getEquippedWeaponStrength() + ", Faith: " + player.getEquippedWeaponFaith());
                System.out.println("\nDexterity Requirement: " + player.getEquippedWeapon().getDexterity() + "\n");
            } else {
                System.out.println("None\n");
            }
            
            // Display inventory
            System.out.println("Weapons in Inventory:");
            List<Weapon> inventory = player.getInventory();
            int i;
            for (i = 0; i < inventory.size(); i++) {
                Weapon weapon = inventory.get(i);
                System.out.println((i + 1) + ". " + weapon.getName() +
                        " - Dexterity Requirement: " + weapon.getDexterity() +
                        ", HP: " + weapon.getHp() +
                        ", Intelligence: " + weapon.getIntelligence() +
                        ", Endurance: " + weapon.getEndurance() +
                        ", Strength: " + weapon.getStrength() +
                        ", Faith: " + weapon.getFaith() +
                        ", Cost: " + weapon.getCost() + " runes");
            }
            

            // Pick 1 for weapon select, 2 to go back to GameLobby
            System.out.println("\n[1] Select Weapon");
            System.out.println("[2] Back");
            System.out.print("Enter your choice: ");
            String inputChoice = input.nextLine().trim();


            if ("2".equals(inputChoice)) { // Go back to GameLobby
                System.out.print("\033\143");
                return;
            } else if ("1".equals(inputChoice)) { // Prompts user to pick a weapon to equip
                System.out.print("\nEnter the index of the weapon to equip: ");
                int index = Integer.parseInt(input.nextLine().trim()) - 1;

                if (index >= 0 && index < inventory.size()) { // Checks if input is a valid weapon index
                    Weapon selectedWeapon = inventory.get(index);
                    if (player.getStatValue(2) >= selectedWeapon.getDexterity()) { // If player dex is >= weapon dex
                        player.setEquippedWeapon(selectedWeapon);
                        System.out.println("You equipped the " + selectedWeapon.getName() + ".");
                        pauseForMessage();
                        System.out.print("\033\143");
                        continue;
                    } else {
                        System.out.println("\nYou don't have enough dexterity to equip this weapon."); // If player dex is < weapon dex
                    }
                } else {
                    System.out.println("\nInvalid weapon index."); // Invalid weapon index
                }
            } else {
                System.out.println("\nInvalid choice."); // Choice is not [1] Select Weapon or [2] Back
            }
            // Pause and clear per system message
            pauseForMessage(); 
            System.out.print("\033\143");
        }
    }

    /**
     * Initializes the weapons available for sale.
     */
    private void initializeWeapons() {
        weaponsForSale.add(new Weapon("Short Sword", 1000, 0, 15, 13, 15, 15, 15));
        weaponsForSale.add(new Weapon("Rogier's Rapier", 2000, 10, 25, 18, 35, 35, 35));
        weaponsForSale.add(new Weapon("Coded Sword", 4000, 20, 35, 21, 40, 40, 40));
        weaponsForSale.add(new Weapon("Sword of Night and Flame", 8000, 30, 45, 25, 55, 55, 55));
        weaponsForSale.add(new Weapon("Uchigatana", 1875, 20, 35, 15, 30, 0, 0));
        weaponsForSale.add(new Weapon("Moonveil", 3750, 30, 40, 20, 45, 0, 0));
        weaponsForSale.add(new Weapon("River of Blood", 7500, 40, 45, 25, 60, 0, 0));
        weaponsForSale.add(new Weapon("Hand of Malenia", 15000, 50, 50, 30, 75, 0, 0));
        weaponsForSale.add(new Weapon("Whip", 1500, 15, 60, 20, 20, 0, 0));
        weaponsForSale.add(new Weapon("Urumi", 3000, 20, 70, 25, 40, 10, 0));
        weaponsForSale.add(new Weapon("Thorned Whip", 5000, 30, 80, 30, 50, 0, 40));
        weaponsForSale.add(new Weapon("Hoslow's Petal Whip", 10000,35, 90, 35, 55, 20, 20));
        weaponsForSale.add(new Weapon("Claymore", 3000, 15, 10, 9, 20, 0, 0));
        weaponsForSale.add(new Weapon("Starscourge Greatsword", 6000, 20, 15, 14, 40, 0, 20));
        weaponsForSale.add(new Weapon("Inseparable Sword", 12000, 25, 20, 19, 70, 60, 60));
        weaponsForSale.add(new Weapon("Malekith's Black Blade", 24000, 30, 25, 24, 80, 40, 60));
        weaponsForSale.add(new Weapon("Astrologer's Staff", 2000, 5, 20, 12, 5, 25, 15));
        weaponsForSale.add(new Weapon("Albinauric Staff", 4000, 10, 30, 14, 10, 45, 35));
        weaponsForSale.add(new Weapon("Staff of the Guilty", 8000, 15, 40, 16, 15, 65, 60));
        weaponsForSale.add(new Weapon("Carian Regal Scepter", 16000, 25, 50, 18, 20, 85, 75));
        weaponsForSale.add(new Weapon("Finger Seal", 2500, 10, 45, 10, 0, 15, 20));
        weaponsForSale.add(new Weapon("Godslayer's Seal", 5000, 15, 50, 12, 0, 35, 40));
        weaponsForSale.add(new Weapon("Golden Order Seal", 10000, 20, 55, 14, 0, 65, 65));
        weaponsForSale.add(new Weapon("Dragon Communion Seal", 15000, 25, 60, 18, 0, 75, 80));
    }
    

    /**
     * Displays the weapons available for sale in the shop.
     */
    private void displayAvailableWeapons() {
        System.out.println("===== Weapons Available in the Shop =====");
        System.out.println("\nYou have " + player.getRunes() + " runes");
    
        // Define weapon categories and their sizes
        String[] categories = {"Swords", "Katanas", "Whips", "Greatswords", "Staves", "Seals"};
        int[] categorySizes = {4, 4, 4, 4, 4, 4};
    
        // Counter for tracking the index in the weapons list
        int weaponIndex = 0;
    
        // Iterate through categories
        for (int i = 0; i < categories.length; i++) {
            System.out.println("\n---------- " + categories[i] + " ----------");
    
            // Iterate through weapons in the category
            for (int j = 0; j < categorySizes[i]; j++) {
                if (weaponIndex >= weaponsForSale.size()) {
                    break; // Exit loop if all weapons are displayed
                }
                Weapon weapon = weaponsForSale.get(weaponIndex++);
                System.out.println("[" + (weaponIndex) + "] " + weapon.getName() +
                        " - Dexterity: " + weapon.getDexterity() +
                        ", HP: " + weapon.getHp() +
                        ", Intelligence: " + weapon.getIntelligence() +
                        ", Endurance: " + weapon.getEndurance() +
                        ", Strength: " + weapon.getStrength() +
                        ", Faith: " + weapon.getFaith() +
                        ", Cost: " + weapon.getCost() + " runes");
            }
        }
    }
    

    /**
     * Allows the player to buy weapons from the shop using their runes.
     * 
     */
    public void shop() {
        while (true) {
            displayAvailableWeapons(); 
            
            // Prompt the player to buy a weapon
            System.out.println("\nEnter the number of the weapon you want to buy, or type 'exit' to leave the shop:");
            String inputChoice = input.nextLine().trim();
    
            if ("exit".equalsIgnoreCase(inputChoice)) {
                System.out.print("\033\143");
                System.out.println("Exiting the shop...");
                pauseForMessage();
                System.out.print("\033\143");
                return;
            }
    
            try {
                int weaponChoice = Integer.parseInt(inputChoice);
                if (weaponChoice >= 1 && weaponChoice <= weaponsForSale.size()) {
                    Weapon selectedWeapon = weaponsForSale.get(weaponChoice - 1);
                    if (player.getRunes() >= selectedWeapon.getCost()) { // Checker to see if player has enough money
                        // Player has enough runes to buy the weapon, subtract cost from player runes
                        player.setRunes(player.getRunes() - selectedWeapon.getCost());

                        System.out.print("\033\143");
                        System.out.println("You bought the " + selectedWeapon.getName() + "!"); // Weapon bought print
                        player.addToInventory(selectedWeapon); // Add the weapon to player's inventory
                        pauseForMessage();
                        System.out.print("\033\143");
    
                        continue; // Continue shopping, don't go back to game lobby till exit
                    } else {
                        System.out.print("\033\143");
                        System.out.println("You don't have enough runes to buy this weapon.\n"); // Player not enough runes
                    }
                } else {
                    System.out.print("\033\143");
                    System.out.println("Invalid choice. Please select a valid weapon number.\n"); // Invalid weapon index input
                }
            } catch (NumberFormatException e) {
                System.out.print("\033\143");
                System.out.println("Invalid input. Please enter a valid weapon number or 'exit'.\n"); // Error handling
            }
        }
    }



    /**
     * Displays the current stats of the player character.
     */
    private void displayStats() {
        System.out.println("Current stats:");
        System.out.println("[1] Health: " + player.getStatValue(1));
        System.out.println("[2] Dexterity: " + player.getStatValue(2));
        System.out.println("[3] Intelligence: " + player.getStatValue(3));
        System.out.println("[4] Endurance: " + player.getStatValue(4));
        System.out.println("[5] Strength: " + player.getStatValue(5));
        System.out.println("[6] Faith: " + player.getStatValue(6) + "\n");
    }

    /**
     * Pauses the execution for a short duration to display messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

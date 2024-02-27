import java.util.Scanner;

public class GameLobby {
    private Character player;
    private Scanner input = new Scanner(System.in);
    private Navigation navigation; // Reference to Navigation for area management

    public GameLobby(Navigation navigation, Character player) {
        this.navigation = navigation;
        this.player = player;
    }

    public void fastTravel() {
        String currentArea = navigation.getCurrentArea();
        System.out.println("========== Fast Travel ==========");
        System.out.println("Available areas:");
        System.out.println("[1] Stormveil Castle");
        System.out.println("[2] Raya Lucaria Academy");
        System.out.println("[3] The Elden Throne [LOCKED]");
        System.out.println("Type 'back' to cancel teleportation and remain in " + currentArea + ".");
    
        while (true) {
            System.out.print("Enter your choice or 'back' to cancel: ");
            String inputChoice = input.nextLine().trim();
    
            if ("back".equalsIgnoreCase(inputChoice)) {
                System.out.println("Teleportation cancelled. Staying in " + currentArea + ".");
                break;
            }
    
            try {
                int areaChoice = Integer.parseInt(inputChoice);
                switch (areaChoice) {
                    case 1:
                        navigation.setCurrentArea("Stormveil Castle");
                        System.out.println("Teleporting to Stormveil Castle...");
                        navigation.enterArea(); // Directly call enterArea() after setting the area.
                        return; // Exiting the method to avoid falling back to the game lobby loop.
                    case 2:
                        navigation.setCurrentArea("Raya Lucaria Academy");
                        System.out.println("Teleporting to Raya Lucaria Academy...");
                        navigation.enterArea(); // Adjust accordingly for other areas.
                        return;
                    default:
                        System.out.println("Area is locked! Please choose another location or type 'back'.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for your choice or 'back' to cancel.");
            }
        }
    }
    
    public void levelUp() {
        // Calculate rune cost for leveling up based on the player's current level
        int runeCost = (player.getLevel() * 100) / 2;
    
        // Display current level, rune cost, and stats
        System.out.println("========== Level Up ==========");
        System.out.println("Current Level: " + player.getLevel());
        System.out.println("You have " + player.getRunes() + " runes.");
        System.out.println("Rune cost to level up: " + runeCost);
        displayStats(); // Helper method to display current stats
    
        // Check if the player has enough runes
        if (player.getRunes() < runeCost) {
            System.out.println("Not enough runes. You have " + player.getRunes() + " runes, but need " + runeCost + ".");
            return; // Exit the method if not enough runes
        }
    
        System.out.println("Choose a stat to level up or type 'back' to cancel leveling up:");
        String inputChoice = input.nextLine().trim();
    
        // Check for 'back' input to return to the Game Lobby
        if ("back".equalsIgnoreCase(inputChoice)) {
            System.out.println("Level up cancelled...");
            return; // Exit the method and return to the game lobby
        }
    
        // Convert the string input to an integer for stat choice, handling invalid inputs
        int statChoice;
        try {
            statChoice = Integer.parseInt(inputChoice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid stat number or 'back' to return to the Game Lobby.");
            return; // Exit the method due to invalid input
        }
    
        System.out.println("Leveling up stat. This will cost " + runeCost + " runes. Proceed? (Y/N)");
        String confirmation = input.nextLine().toUpperCase();
    
        if ("Y".equals(confirmation)) {
            player.setRunes(player.getRunes() - runeCost); // Deduct the rune cost
            player.increaseStat(statChoice); // Increase the chosen stat
            player.setLevel(player.getLevel() + 1); // Increase player level
    
            System.out.println("Stat increased successfully!");
            System.out.println("New player level: " + player.getLevel());
            displayStats(); // Display updated stats
        } else {
            System.out.println("Level up cancelled.");
        }
    }    

    private void displayStats() {
        System.out.println("Current stats:");
        System.out.println("[1] Health: " + player.getStatValue(1));
        System.out.println("[2] Dexterity: " + player.getStatValue(2));
        System.out.println("[3] Intelligence: " + player.getStatValue(3));
        System.out.println("[4] Endurance: " + player.getStatValue(4));
        System.out.println("[5] Strength: " + player.getStatValue(5));
        System.out.println("[6] Faith: " + player.getStatValue(6));
    }
}

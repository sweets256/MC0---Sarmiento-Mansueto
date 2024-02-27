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
        System.out.println("[2] Raya Lucaria Academy [LOCKED]");
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
                    // case 2:
                    //     navigation.setCurrentArea("Raya Lucaria Academy");
                    //     System.out.println("Teleporting to Raya Lucaria Academy...");
                    //     navigation.enterArea(); // Adjust accordingly for other areas.
                    //     return;
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
        boolean leveling = true;
    
        while (leveling) {
            int runeCost = (player.getLevel() * 100) / 2;
    
            System.out.println("========== Level Up ==========");
            System.out.println("Current Level: " + player.getLevel());
            System.out.println("You have " + player.getRunes() + " runes.");
            System.out.println("Rune cost to level up: " + runeCost);
            displayStats();
    
            if (player.getRunes() < runeCost) {
                System.out.println("Not enough runes. You have " + player.getRunes() + " runes, but need " + runeCost + ".");
                break; // Exit the loop if not enough runes
            }
    
            System.out.println("Choose a stat to level up or type 'back' to cancel leveling up:");
            String inputChoice = input.nextLine().trim();
    
            if ("back".equalsIgnoreCase(inputChoice)) {
                System.out.println("Level up cancelled...");
                break; // Exit the loop if player chooses to go back
            }
    
            try {
                int statChoice = Integer.parseInt(inputChoice);
                if (statChoice < 1 || statChoice > 6) { // Assuming there are 6 stats
                    throw new IllegalArgumentException("Invalid stat choice. Please select a number between 1 and 6.");
                }
    
                System.out.println("Leveling up stat. This will cost " + runeCost + " runes. Proceed? (Y/N)");
                String confirmation = input.nextLine().toUpperCase();
    
                if ("Y".equals(confirmation)) {
                    player.setRunes(player.getRunes() - runeCost);
                    player.increaseStat(statChoice);
                    player.setLevel(player.getLevel() + 1);
    
                    System.out.println("Stat increased successfully!");
                    System.out.println("New player level: " + player.getLevel());
                    displayStats();
                    break; // Exit the loop after successful level up
                } else {
                    System.out.println("Level up cancelled.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid stat number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            // The loop will continue if the input was invalid, allowing the player to try again.
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

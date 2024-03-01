import java.util.Scanner;

public class GameLobby {
    private Character player;
    private Scanner input = new Scanner(System.in);
    private Navigation navigation;

    public GameLobby(Navigation navigation, Character player) {
        this.navigation = navigation;
        this.player = player;
    }

    public void fastTravel() {
        System.out.print("\033\143");
        String currentArea = navigation.getCurrentArea();
    
        while (true) {
            System.out.println("========== Fast Travel ==========");
            System.out.println("Available areas:");
            System.out.println("[1] Stormveil Castle");
            System.out.println("[2] Raya Lucaria Academy [LOCKED]");
            System.out.println("[3] The Elden Throne [LOCKED]");
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
                        navigation.enterArea();
                        return;
                    case 2:
                        System.out.print("\033\143");
                        System.out.println("Raya Lucaria Academy is LOCKED!");
                        pauseForMessage();
                        System.out.print("\033\143");
                        break;
                    case 3:
                        System.out.print("\033\143");
                        System.out.println("Elden Throne is LOCKED!");
                        pauseForMessage();
                        System.out.print("\033\143");
                        break;
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
                break;
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
                    break;
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

    private void displayStats() {
        System.out.println("Current stats:");
        System.out.println("[1] Health: " + player.getStatValue(1));
        System.out.println("[2] Dexterity: " + player.getStatValue(2));
        System.out.println("[3] Intelligence: " + player.getStatValue(3));
        System.out.println("[4] Endurance: " + player.getStatValue(4));
        System.out.println("[5] Strength: " + player.getStatValue(5));
        System.out.println("[6] Faith: " + player.getStatValue(6) + "\n");
    }

    private static void pauseForMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

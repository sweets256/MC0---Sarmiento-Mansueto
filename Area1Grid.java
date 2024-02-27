import java.util.Scanner;
import java.util.Random;

public class Area1Grid {
    private static Character character;
    private static AreaInteractionListener listener;
    private static String[][] currentFloor;
    private static int playerRow = 6; // Default starting position for demonstration
    private static int playerCol = 2; // Default starting position for demonstration
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean shouldExitArea = false;
    private static String[][] floor1Data = {
        {"|     |", "|  D  |", "|     |"},
        {"|  ?  |", "|     |", "|  ?  |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  F  |", "|     |"}
    };
    private static String[][] floor2Data = {
        {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|  ?  |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|  ?  |", "|     |", "|  ?  |", "|  ?  |", "|  ?  |", "|     |", "|  ?  |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"}
    };
    private static String[][] floor3Data = {
        {"|     |", "|     |", "|  F  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  B  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  D  |", "|     |", "|     |"}
    };
    private static String[][][] floors = {floor1Data, floor2Data, floor3Data};
    private static int currentFloorIndex = 0;

    // Define starting positions for each floor
    private static final int[][] startingPositions = {
        {6, 1}, // Starting position on Floor 1
        {6, 3}, // Starting position on Floor 2
        {6, 2}  // Starting position on Floor 3
    };

    public static void startArea() {
        shouldExitArea = false;
        currentFloorIndex = 0; // Reset to start from Floor 1
        currentFloor = floors[currentFloorIndex];
        // Reset player position to the starting position of Floor 1 as well
        playerRow = startingPositions[currentFloorIndex][0];
        playerCol = startingPositions[currentFloorIndex][1];
    
        System.out.println("Entering Area 1...");
    
        boolean exitArea = false;
        while (!exitArea && !shouldExitArea) {
            displayFloor();
            System.out.println("Enter action (WASD to move, E to interact, Q to quit): ");
            String action = scanner.nextLine().toUpperCase();
            switch (action) {
                case "W": movePlayer(-1, 0); System.out.print("\033\143"); break;
                case "A": movePlayer(0, -1); System.out.print("\033\143"); break;
                case "S": movePlayer(1, 0); System.out.print("\033\143"); break;
                case "D": movePlayer(0, 1); System.out.print("\033\143"); break;
                case "E": interact(); break;
                case "Q": exitArea = true; break;
                default: System.out.println("Invalid action."); break;
            }
        }
        if (shouldExitArea) {
            System.out.print("\033\143");
            System.out.println("Returning to the game lobby...");
        } else {
            System.out.print("\033\143");
            System.out.println("Exiting Area 1...");
        }
    }

    private static void displayFloor() {
        // Calculate the width of the grid in characters. Assuming each cell is 7 characters wide.
        int gridWidth = currentFloor[0].length * 7;
        
        // Prepare the title string including the space padding around "Floor: X"
        String title = " Floor " + (currentFloorIndex + 1) + " ";
        int titleLength = title.length();
        
        // Calculate how many '=' characters are needed before and after the title to center it
        int totalPadding = gridWidth - titleLength; // Total amount of '=' to distribute
        int paddingBefore = totalPadding / 2; // Half the padding goes before the title
        int paddingAfter = totalPadding / 2; // Start with an equal split for after the title
        
        // Adjust for an odd total padding by adding one more '=' to paddingAfter if necessary
        if (totalPadding % 2 != 0) {
            paddingAfter += 1;
        }
        
        // Construct the centered title with '=' padding
        String centeredTitle = new String(new char[paddingBefore]).replace('\0', '=') 
            + title 
            + new String(new char[paddingAfter]).replace('\0', '=');
        
        // Print the centered title
        System.out.println(centeredTitle);
        
        // Print the grid
        for (int i = 0; i < currentFloor.length; i++) {
            for (int j = 0; j < currentFloor[i].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("|  P  |");
                } else {
                    System.out.print(currentFloor[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void movePlayer(int rowChange, int colChange) {
        int newRow = playerRow + rowChange;
        int newCol = playerCol + colChange;
        if (newRow >= 0 && newRow < currentFloor.length && newCol >= 0 && newCol < currentFloor[0].length && !currentFloor[newRow][newCol].contains("W")) {
            playerRow = newRow;
            playerCol = newCol;
        } else {
            System.out.println("Cannot move there.");
        }
    }

    private static void interact() {
        if (isDoorToAnotherFloor()) {
            handleDoorInteraction();
            return; // Ensure no further interaction logic is processed after handling a door
        }
        
        String currentTile = currentFloor[playerRow][playerCol].trim();
        if ("|  F  |".equals(currentTile)) {
            if (listener != null) {
                listener.onFastTravel();
                shouldExitArea = true;
            }
        } else if ("|  ?  |".equals(currentTile)) {
            Random rand = new Random();
            double encounterChance = rand.nextDouble();
            String[] enemies = {"Godrick Soldier", "Godrick Archer", "Godrick Knight"};
            String encounteredEnemy = enemies[rand.nextInt(enemies.length)]; // Randomly select an enemy
    
            if (encounterChance < 0.75) {
                System.out.print("\033\143");
                System.out.println("You encounter an enemy! [ " + encounteredEnemy + " ]");
                pauseForMessage(); // Pause to allow reading the message
            } else {
                int runesGained = (currentFloorIndex + 1) * (rand.nextInt(101) + 50);
                character.addRunes(runesGained);
                System.out.print("\033\143");
                System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
                pauseForMessage(); // Pause to allow reading the message
            }
            currentFloor[playerRow][playerCol] = "|     |";
        } else if ("|  B  |".equals(currentTile)) {
            System.out.print("\033\143");
            System.out.println("You have encountered the Boss !!! [ Godrick The Grafted ]");
            pauseForMessage(); // Assuming you have a pauseForMessage method to pause the output
        } else {
            System.out.println("There's nothing to interact with here.");
        }
    }
    
    

    private static boolean isDoorToAnotherFloor() {
        return (currentFloorIndex == 0 && playerRow == 0 && playerCol == 1) ||
               (currentFloorIndex == 1 && playerRow == 0 && playerCol == 3) ||
               (currentFloorIndex == 1 && playerRow == 6 && playerCol == 3) ||
               (currentFloorIndex == 2 && playerRow == 6 && playerCol == 2);
    }
    
    private static void handleDoorInteraction() {
        if (currentFloorIndex == 0 && playerRow == 0 && playerCol == 1) {
            moveToFloor(1); // Floor 1 to Floor 2
        } else if (currentFloorIndex == 1 && playerRow == 0 && playerCol == 3) {
            moveToFloor(2); // Floor 2 to Floor 3
        } else if (currentFloorIndex == 1 && playerRow == 6 && playerCol == 3) {
            moveToFloor(0); // Floor 2 to Floor 1
        } else if (currentFloorIndex == 2 && playerRow == 6 && playerCol == 2) {
            moveToFloor(1); // Floor 3 to Floor 2
        }
    }

    private static void moveToFloor(int targetFloorIndex) {
        if (targetFloorIndex >= 0 && targetFloorIndex < floors.length) {
            int previousFloorIndex = currentFloorIndex;
            currentFloorIndex = targetFloorIndex;
            currentFloor = floors[currentFloorIndex];

            System.out.print("\033\143");
    
            // Determine the player's new position based on the floor transition
            if (previousFloorIndex < currentFloorIndex) {
                // Moving to a higher floor, set position at the "downward" door of the current floor
                setPlayerPositionForDescending();
            } else {
                // Moving to a lower floor, set position at the "upward" door of the current floor
                setPlayerPositionForAscending();
            }
    
            System.out.println("Moved to Floor " + (currentFloorIndex + 1) + ".");
        } else {
            System.out.println("Invalid floor index.");
        }
    }
    
    private static void setPlayerPositionForDescending() {
        // Example positions; adjust based on your game's actual door positions
        switch (currentFloorIndex) {
            case 1: // Moved up to Floor 2 from Floor 1
                playerRow = 6; // Position of door on Floor 2 going down to Floor 1
                playerCol = 3;
                break;
            case 2: // Moved up to Floor 3 from Floor 2
                playerRow = 6; // Position of door on Floor 3 going down to Floor 2
                playerCol = 2;
                break;
        }
    }
    
    private static void setPlayerPositionForAscending() {
        // Example positions; adjust based on your game's actual door positions
        switch (currentFloorIndex) {
            case 0: // Moved down to Floor 1 from Floor 2
                playerRow = 0; // Position of door on Floor 1 going up to Floor 2
                playerCol = 1;
                break;
            case 1: // Moved down to Floor 2 from Floor 3
                playerRow = 0; // Position of door on Floor 2 going up to Floor 3
                playerCol = 3;
                break;
        }
    }
    
    
    public static void setCharacter(Character characterInstance) {
        character = characterInstance;
    }

    public static void setAreaInteractionListener(AreaInteractionListener listenerInstance) {
        listener = listenerInstance;
    }

    private static void pauseForMessage() {
        try {
            Thread.sleep(3000); // Pause for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle the InterruptedException
        }
    }
    
}

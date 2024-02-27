import java.util.Scanner;

public class Area1Grid {
    private static Character character;
    private static String[][] currentFloor;
    private static int playerRow = 6; // Starting row position for the player
    private static int playerCol = 2; // Starting column position for the player
    private static final Scanner scanner = new Scanner(System.in);

    // Define map data for each floor using descriptive variable names
    private static String[][] floor1Data = {
        {"W", "|     |", "|  D  |", "|     |", "W"},
        {"W", "|  ?  |", "|     |", "|  ?  |", "W"},
        {"W", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|  F  |", "|     |", "W"}
    };

    private static String[][] floor2Data = {
        {"W", "|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|  ?  |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|  ?  |", "|     |", "|  ?  |", "|  ?  |", "|  ?  |", "|     |", "|  ?  |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |", "W"}
    };

    private static String[][] floor3Data = {
        {"W", "|     |", "|     |", "|  F  |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|  B  |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|     |", "|     |", "|     |", "W"},
        {"W", "|     |", "|     |", "|  D  |", "|     |", "|     |", "W"}
    };

    public static void startArea() {
        currentFloor = floor1Data; // Set the starting floor as floor1
        System.out.println("Entering Area 1...");

        boolean exitArea = false;
        while (!exitArea) {
            displayFloor();
            System.out.println("Enter action (WASD to move, E to interact, Q to quit): ");
            String action = scanner.nextLine().toUpperCase();
            switch (action) {
                case "W": movePlayer(-1, 0); break;
                case "A": movePlayer(0, -1); break;
                case "S": movePlayer(1, 0); break;
                case "D": movePlayer(0, 1); break;
                case "E": interact(); break;
                case "Q": exitArea = true; break;
                default: System.out.println("Invalid action."); break;
            }
        }
        System.out.println("Exiting Area 1...");
    }

    private static void displayFloor() {
        for (int i = 0; i < currentFloor.length; i++) {
            for (int j = 0; j < currentFloor[i].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("|  P  | "); // Represent the player with 'P'
                } else {
                    System.out.print(currentFloor[i][j] + " ");
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
        // Determine the tile type at the player's current position
        String currentTile = currentFloor[playerRow][playerCol].trim();
    
        if ("|  F  |".equals(currentTile)) {
            // Handle Fast Travel tile interaction
            System.out.println("Teleporting back to the game lobby...");
            // Signal to return to the lobby (the actual mechanism will depend on your game's architecture)
        } else if ("|  ?  |".equals(currentTile)) {
            // Handle Spawn tile interaction
            int runesGained = (int) (50 + Math.random() * 101); // Random number between 50 and 150
            character.addRunes(runesGained);
            System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
        } else if ("|  D  |".equals(currentTile)) {
            // Handle Door tile interaction (move to the next floor)
            moveToNextFloor();
        } else {
            System.out.println("There's nothing to interact with here.");
        }
    }
    

    private static void moveToNextFloor() {
        // Assuming floor1Data, floor2Data, and floor3Data are part of an array or list...
        String[][][] floors = {floor1Data, floor2Data, floor3Data};
        int currentFloorIndex = -1;

        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == currentFloor) {
                currentFloorIndex = i;
                break;
            }
        }

        if (currentFloorIndex >= 0 && currentFloorIndex < floors.length - 1) {
            currentFloor = floors[currentFloorIndex + 1];
            playerRow = 6; // Adjust based on new floor's starting position
            playerCol = 2;
            System.out.println("Moved to the next floor.");
        } else {
            System.out.println("There are no more floors above.");
        }
    }

    public static void setCharacter(Character characterInstance) {
        character = characterInstance;
    }
    
}
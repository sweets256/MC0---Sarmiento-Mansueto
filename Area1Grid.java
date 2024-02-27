import java.util.Scanner;

public class Area1Grid {
    private static Character character;
    private static AreaInteractionListener listener;
    private static String[][] currentFloor;
    private static int playerRow = 6;
    private static int playerCol = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean shouldExitArea = false;
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
    private static String[][][] floors = {floor1Data, floor2Data, floor3Data};
    private static int currentFloorIndex = 0;

    public static void startArea() {
        shouldExitArea = false;
        currentFloor = floors[currentFloorIndex];
        System.out.println("Entering Area 1...");

        boolean exitArea = false;
        while (!exitArea && !shouldExitArea) {
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
        if (shouldExitArea) {
            System.out.println("Returning to the game lobby...");
        } else {
            System.out.println("Exiting Area 1...");
        }
    }

    private static void displayFloor() {
        for (int i = 0; i < currentFloor.length; i++) {
            for (int j = 0; j < currentFloor[i].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("|  P  | ");
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
        String currentTile = currentFloor[playerRow][playerCol].trim();

        if ("|  F  |".equals(currentTile)) {
            if (listener != null) {
                listener.onFastTravel();
                shouldExitArea = true;
            }
        } else if ("|  D  |".equals(currentTile)) {
            moveToNextFloor();
        } else if ("|  ?  |".equals(currentTile)) {
            int runesGained = (int) (50 + Math.random() * 101);
            character.addRunes(runesGained);
            System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
            currentFloor[playerRow][playerCol] = "|     |";
        } else {
            System.out.println("There's nothing to interact with here.");
        }
    }

    private static void moveToNextFloor() {
        if (currentFloorIndex < floors.length - 1) {
            currentFloorIndex++;
            currentFloor = floors[currentFloorIndex];
            playerRow = 6;
            playerCol = 2;
            System.out.println("Moved to the next floor.");
        } else {
            System.out.println("There are no more floors above.");
        }
    }

    public static void setCharacter(Character characterInstance) {
        character = characterInstance;
    }

    public static void setAreaInteractionListener(AreaInteractionListener listenerInstance) {
        listener = listenerInstance;
    }
}

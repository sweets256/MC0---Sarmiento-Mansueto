import java.util.Scanner;
import java.util.Random;

/**
 * The Area1Grid class represents the grid-based game area in Raya Lucaria Academy.
 * It allows players to navigate through floors, interact with objects, and encounter enemies.
 */
public class Area2Grid {
    private static Character character;
    private static AreaInteractionListener listener;
    private static String[][] currentFloor;
    private static int playerRow = 0;
    private static int playerCol = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean shouldExitArea = false;
    private static String[][] floor1Data = {
        {"|     |", "|     |", "|  F  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|  D  |", "|     |", "|     |"}
    };
    private static String[][] floor2Data = {
        {"|     |", "|  D  |", "|     |",},
        {"|  ?  |", "|     |", "|     |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  D  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|     |",},
        {"|     |", "|     |", "|     |",}
    };
    private static String[][] floor3Data = {
        {"|     |", "|     |", "|  D  |", "|     |", "|     |"},
        {"|     |", "|     |", "|  ?  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|  D  |", "|     |", "|     |", "|     |", "|  D  |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  ?  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |"}
    };
    private static String[][] floor4Data = {
        {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
        {"|  D  |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"}
    };
    private static String[][] floor5Data = {
        {"|     |", "|     |", "|     |", "|  F  |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |", "|  B  |", "|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |", "|     |", "|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"}
    };
    private static String[][][] floors = {floor1Data, floor2Data, floor3Data, floor4Data, floor5Data};
    private static int currentFloorIndex = 0;
    
    private static final int[][] startingPositions = {
        {0, 2},
        {0, 1},
        {3, 0},
        {0, 1},
        {7, 3}
    };

     /**
     * Starts the area by initializing the floor, player position, and processing player actions.
     */
    public static void startArea() {
        shouldExitArea = false;
        currentFloorIndex = 0;
        currentFloor = floors[currentFloorIndex];
       
        playerRow = startingPositions[currentFloorIndex][0];
        playerCol = startingPositions[currentFloorIndex][1];
    
        System.out.println("Raya Lucaria Academy");
        pauseForMessage();
        System.out.print("\033\143");
    
        boolean exitArea = false;
        while (!exitArea && !shouldExitArea) {
            displayFloor();
            System.out.println("Enter action (WASD to move, E to interact): ");
            String action = scanner.nextLine().toUpperCase();
            switch (action) {
                case "W": movePlayer(-1, 0); System.out.print("\033\143"); break;
                case "A": movePlayer(0, -1); System.out.print("\033\143"); break;
                case "S": movePlayer(1, 0); System.out.print("\033\143"); break;
                case "D": movePlayer(0, 1); System.out.print("\033\143"); break;
                case "E": interact(); break;
                default: System.out.println("Invalid action."); pauseForMessage(); System.out.print("\033\143"); break;
            }
        }
        if (shouldExitArea) {
            System.out.print("\033\143");
            System.out.println("Returning to the game lobby...");
            pauseForMessage();
            System.out.print("\033\143");
        } else {
            System.out.print("\033\143");
            System.out.println("Exiting Raya Lucaria Academy...");
            pauseForMessage();
            System.out.print("\033\143");
        }
    }

    /**
     * Displays the current floor layout and player stats.
     */
    private static void displayFloor() {
        int gridWidth = currentFloor[0].length * 7;
        String title = " Floor " + (currentFloorIndex + 1) + " ";
        int titleLength = title.length();
        int totalPadding = gridWidth - titleLength;
        int paddingBefore = totalPadding / 2;
        int paddingAfter = totalPadding / 2;
        
        if (totalPadding % 2 != 0) {
            paddingAfter += 1;
        }
        
        String centeredTitle = new String(new char[paddingBefore]).replace('\0', '=') 
            + title 
            + new String(new char[paddingAfter]).replace('\0', '=');
        
        System.out.println(centeredTitle);
        
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

        System.out.println("\n========== Player Stats ==========");
        System.out.println("Health: " + character.getCurrentHealth());
        System.out.println("Level: " + character.getLevel());
        System.out.println("Runes: " + character.getRunes());
        System.out.println("==================================\n");
    }

    /**
     * Moves the player in the specified direction if valid.
     *
     * @param rowChange the change in row position
     * @param colChange the change in column position
     */
    private static void movePlayer(int rowChange, int colChange) {
        int newRow = playerRow + rowChange;
        int newCol = playerCol + colChange;
        
        if (newRow >= 0 && newRow < currentFloor.length && newCol >= 0 && newCol < currentFloor[0].length && !currentFloor[newRow][newCol].contains("W")) {
            playerRow = newRow;
            playerCol = newCol;
        } else {
            System.out.print("\033\143");
            System.out.println("Cannot move there.");
            pauseForMessage();
            System.out.print("\033\143");
        }
    }

    /**
     * Handles player interaction with objects in the area.
     */
    private static void interact() {
        if (isDoorToAnotherFloor()) {
            handleDoorInteraction();
            return;
        }
        
        String currentTile = currentFloor[playerRow][playerCol].trim();
        if ("|  F  |".equals(currentTile)) {
            if (listener != null) {
                listener.onFastTravel();
                shouldExitArea = true;
            } else {
                System.out.println("Fast travel point activated. Returning to game lobby...");
                shouldExitArea = true; 
            }
        } else if ("|  ?  |".equals(currentTile)) {
            Random rand = new Random();
            double encounterChance = rand.nextDouble();
            String[] enemies = {"Living Jar", "Glintstone Sorcerer", "Battlemage"};
            String encounteredEnemy = enemies[rand.nextInt(enemies.length)];
            boolean isHighType = rand.nextBoolean();
            int enemyHealth;

            switch (encounteredEnemy) {
                case "Living Jar":
                    enemyHealth = isHighType ? 30 : 20;
                    break;
                case "Glintstone Sorcerer":
                    enemyHealth = isHighType ? 35 : 25;
                    break;
                case "Battlemage":
                    enemyHealth = isHighType ? 80 : 70;
                    break;
                default:
                    enemyHealth = 0;
            }
    
            if (encounterChance < 0.75) {
                System.out.print("\033\143");
                System.out.println("You encounter an enemy!");
                System.out.println("\n[ " + encounteredEnemy + " ]");
                System.out.println("HP: "+ enemyHealth);
                pauseForMessage();
                System.out.print("\033\143");
            } else {
                int runesGained = (currentFloorIndex + 1) * (rand.nextInt(101) + 50);
                character.addRunes(runesGained);
                System.out.print("\033\143");
                System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
                pauseForMessage();
                System.out.print("\033\143");
            }
            currentFloor[playerRow][playerCol] = "|     |";
        } else if ("|  B  |".equals(currentTile)) {
            System.out.print("\033\143");
            System.out.println("You have found the Boss of Raya Lucaria Academy !!!");
            System.out.println("\n[ Renala, Queen of the Full Moon ]");
            System.out.println("HP: 400");
            pauseForMessage();
            System.out.print("\033\143");
        } else {
            System.out.print("\033\143");
            System.out.println("There's nothing to interact with here.");
            pauseForMessage();
            System.out.print("\033\143");
        }
    }
    
    /**
     * Checks if the player is standing on a door leading to another floor.
     *
     * @return boolean true if the player is standing on a door, false otherwise
     */
    private static boolean isDoorToAnotherFloor() {
        return (currentFloorIndex == 0 && playerRow == 4 && playerCol == 2) ||
               (currentFloorIndex == 1 && playerRow == 0 && playerCol == 1) ||
               (currentFloorIndex == 1 && playerRow == 3 && playerCol == 2) ||
               (currentFloorIndex == 2 && playerRow == 3 && playerCol == 0) ||
               (currentFloorIndex == 2 && playerRow == 0 && playerCol == 2) ||
               (currentFloorIndex == 2 && playerRow == 3 && playerCol == 4) ||
               (currentFloorIndex == 3 && playerRow == 1 && playerCol == 0) ||
               (currentFloorIndex == 4 && playerRow == 7 && playerCol == 3);
    }
    
    /**
     * Handles the interaction when the player moves through a door to another floor.
     */
    private static void handleDoorInteraction() {
        if (currentFloorIndex == 0 && playerRow == 4 && playerCol == 2) {
            moveToFloor(1);
        } else if (currentFloorIndex == 1 && playerRow == 0 && playerCol == 1) {
            moveToFloor(0);
        } else if (currentFloorIndex == 1 && playerRow == 3 && playerCol == 2) {
            moveToFloor(2);
        } else if (currentFloorIndex == 2 && playerRow == 3 && playerCol == 0) {
            moveToFloor(1);
        } else if (currentFloorIndex == 2 && playerRow == 3 && playerCol == 4) {
            moveToFloor(3);
        } else if (currentFloorIndex == 3 && playerRow == 1 && playerCol == 0) {
            moveToFloor(2);
        } else if (currentFloorIndex == 2 && playerRow == 0 && playerCol == 2) {
            moveToFloor(4);
        } else if (currentFloorIndex == 4 && playerRow == 7 && playerCol == 3) {
            moveToFloor(2);
        }
    }

    /**
     * Moves the player to the specified target floor index.
     *
     * @param targetFloorIndex the index of the target floor
     */
    private static void moveToFloor(int targetFloorIndex) {
        if (targetFloorIndex >= 0 && targetFloorIndex < floors.length) {
            int previousFloorIndex = currentFloorIndex;
            currentFloorIndex = targetFloorIndex;
            currentFloor = floors[currentFloorIndex];

            System.out.print("\033\143");

            if (previousFloorIndex < currentFloorIndex) {
                setPlayerPositionForAscending();
            } else {
                setPlayerPositionForDescending();
            }
    
            System.out.println("Moving to Floor " + (currentFloorIndex + 1) + "...");
            pauseForMessage();
            System.out.print("\033\143");
        } else {
            System.out.println("Invalid floor index.");
        }
    }
    
    /**
    * Sets the player position for ascending to a higher floor.
    * The player position is adjusted based on the current floor index.
    */
    private static void setPlayerPositionForAscending() {
        // This switch is based on the target floor (currentFloorIndex)
        switch (currentFloorIndex) {
            case 1:
                playerRow = 0;
                playerCol = 1;
                break;
            case 2:
                playerRow = 3;
                playerCol = 0;
                break;
            case 3:
                playerRow = 1;
                playerCol = 0;
                break;
            case 4:
                playerRow = 7;
                playerCol = 3;
                break;
        }
    }    

    /**
    * Sets the player position for descending to a lower floor.
    * The player position is adjusted based on the current floor index.
    */
    private static void setPlayerPositionForDescending() {
    
        switch (currentFloorIndex) {
            case 0:
                playerRow = 4;
                playerCol = 2;
                break;
            case 1:
                playerRow = 3;
                playerCol = 2;
                break;
            case 2:
                if (playerRow == 1 && playerCol == 0){
                    playerRow = 3;
                    playerCol = 4;
                    break;
                } else if (playerRow == 7 && playerCol == 3){
                    playerRow = 0;
                    playerCol = 2;
                    break;
                }
    }
}
    
    /**
     * Sets the character instance for the area.
     *
     * @param characterInstance the character instance to set
     */
    public static void setCharacter(Character characterInstance) {
        character = characterInstance;
    }

    /**
     * Sets the area interaction listener instance.
     *
     * @param listenerInstance the listener instance to set
     */
    public static void setAreaInteractionListener(AreaInteractionListener listenerInstance) {
        listener = listenerInstance;
    }

    /**
     * Pauses the execution for displaying messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

import java.util.Scanner;
import java.util.Random;

/**
 * The Area1Grid class represents the grid-based game area in The Elden Throne.
 * It allows players to navigate through floors, interact with objects, and encounter enemies.
 */
public class Area3Grid {
    private static int areaIndex = 3;
    private static Character character;
    private static Enemy enemy;
    private static AreaInteractionListener listener;
    private static String[][] currentFloor;
    private static int playerRow = 8;
    private static int playerCol = 1;
    private static boolean shouldExitArea = false;
    private static String[][] floor1Data = {
        {"|     |", "|  D  |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  F  |", "|     |"}
    };
    private static String[][] floor2Data = {
        {"|  X  |", "|     |", "|     |", "|  D  |", "|     |","|     |","|  X  |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|  B  |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|  X  |", "|     |", "|     |", "|  D  |", "|     |","|     |","|  X  |",}
    };
    private static String[][] floor3Data = {
        {"|     |", "|  C  |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|  D  |", "|     |",}
    };
    private static String[][] initialfloor1Data = {
        {"|     |", "|  D  |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  ?  |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  F  |", "|     |"}
    };
    private static String[][] initialfloor2Data = {
        {"|  X  |", "|     |", "|     |", "|  D  |", "|     |","|     |","|  X  |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|  B  |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|     |", "|     |", "|     |", "|     |", "|     |","|     |","|     |",},
        {"|  X  |", "|     |", "|     |", "|  D  |", "|     |","|     |","|  X  |",}
    };
    private static String[][] initialfloor3Data = {
        {"|     |", "|  C  |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|     |", "|     |",},
        {"|  ?  |", "|     |", "|  ?  |",},
        {"|     |", "|  D  |", "|     |",}
    };

    private static String[][][] floors = {floor1Data, floor2Data, floor3Data};
    private static int currentFloorIndex = 0;
    
    private static final int[][] startingPositions = {
        {8, 1},
        {6, 3},
        {8, 1}
    };

    private static void resetFloorData() {
        for (int i = 0; i < floor1Data.length; i++) {
            floor1Data[i] = initialfloor1Data[i].clone();
        }
        for (int i = 0; i < floor2Data.length; i++) {
            floor2Data[i] = initialfloor2Data[i].clone();
        }
        for (int i = 0; i < floor3Data.length; i++) {
            floor3Data[i] = initialfloor3Data[i].clone();
        }
    }


     /**
     * Starts the area by initializing the floor, player position, and processing player actions.
     */
    public static void startArea(Scanner input) {
        character.getEffectiveHealth();
        shouldExitArea = false;
        currentFloorIndex = 0;
        resetFloorData();
        currentFloor = floors[currentFloorIndex];
       
        playerRow = startingPositions[currentFloorIndex][0];
        playerCol = startingPositions[currentFloorIndex][1];

        System.out.println("The Elden Throne");
        pauseForMessage();
        System.out.print("\033\143");
        
        boolean exitArea = false;
        while (!exitArea && !shouldExitArea) {
            displayFloor();
            System.out.println("Enter action (WASD to move, E to interact): ");
            String action = input.nextLine().toUpperCase();
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
            System.out.println("Exiting The Elden Throne...");
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
        System.out.println("Health: " + character.getEffectiveHealth());
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
            if (!currentFloor[newRow][newCol].trim().equals("|  X  |")) {
            playerRow = newRow;
            playerCol = newCol;
            } else {
                System.out.print("\033\143");
                System.out.println("You cannot there. It is out of bounds.");
                pauseForMessage();
                System.out.print("\033\143");
            }
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
            
            int runesGained = areaIndex * (rand.nextInt(101) + 50);
            character.addRunes(runesGained);
            System.out.print("\033\143");
            System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
            pauseForMessage();
            System.out.print("\033\143");
            currentFloor[playerRow][playerCol] = "|     |";
            
        } else if ("|  B  |".equals(currentTile)) {
            System.out.print("\033\143");
            System.out.println("You have found the Boss of The Elden Throne !!!");
            System.out.println("\n[ The Elden Beast ]");
            System.out.println("HP: 800");
            pauseForMessage();
            System.out.print("\033\143");
            enemy = EnemyStats.generateEldenBeast();
            Battle battle = new Battle(character, enemy, areaIndex);
            battle.startBattle();
            pauseForMessage();
            System.out.print("\033\143");
            if (character.getEffectiveHealth() != 0){
                currentFloor[playerRow][playerCol] = "|     |";
            } else if (character.getEffectiveHealth() == 0){            
            pauseForMessage();
            System.out.print("\033\143");
            shouldExitArea = true;
            }
        } else if ("|  C  |".equals(currentTile)) {
            System.out.print("\033\143");
            System.out.println("================================== THANK YOU FOR PLAYING ! =================================");
            System.out.println(" _______  _        ______   _______  _          _______  _______  _______           _______ ");
            System.out.println("(  ____ \\( \\      (  __  \\ (  ____ \\( (    /|  (  ____ )(  ___  )(  ____ \\|\\     /|(  ____ \\");
            System.out.println("| (    \\/| (      | (  \\  )| (    \\/|  \\  ( |  | (    )|| (   ) || (    \\/| )   ( || (    \\/");
            System.out.println("| (__    | |      | |   ) || (__    |   \\ | |  | (____)|| |   | || |      | |   | || (__    ");
            System.out.println("|  __)   | |      | |   | ||  __)   | (\\ \\) |  |     __)| |   | || | ____ | |   | ||  __)   ");
            System.out.println("| (      | |      | |   ) || (      | | \\   |  | (\\ (   | |   | || | \\_  )| |   | || (      ");
            System.out.println("| (____/\\| (____/\\| (__/  )| (____/\\| )  \\  |  | ) \\ \\__| (___) || (___) || (___) || (____/\\");
            System.out.println("(_______/(_______/(______/ (_______/|/    )_)  |/   \\__/(_______)(_______)(_______)(_______/");
            System.out.println("\n                                         DEVELOPERS                                         ");
            System.out.println("============================================================================================");
            System.out.println("                                   MANSUETO, MARIA ALYSAA                                   ");
            System.out.println("                                   SARMIENTO IV, ABRAHAM                                    ");
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
        return (currentFloorIndex == 0 && playerRow == 0 && playerCol == 1) ||
               (currentFloorIndex == 1 && playerRow == 0 && playerCol == 3) ||
               (currentFloorIndex == 1 && playerRow == 6 && playerCol == 3) ||
               (currentFloorIndex == 2 && playerRow == 8 && playerCol == 1);
    }
    
    /**
     * Handles the interaction when the player moves through a door to another floor.
     */
    private static void handleDoorInteraction() {
        if (currentFloorIndex == 0 && playerRow == 0 && playerCol == 1) {
            moveToFloor(1);
        } else if (currentFloorIndex == 1 && playerRow == 0 && playerCol == 3) {
            moveToFloor(2);
        } else if (currentFloorIndex == 1 && playerRow == 6 && playerCol == 3) {
            moveToFloor(0);
        } else if (currentFloorIndex == 2 && playerRow == 8 && playerCol == 1) {
            moveToFloor(1);
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
                setPlayerPositionForDescending();
            } else {
                setPlayerPositionForAscending();
            }
    
            System.out.println("Moving to Floor " + (currentFloorIndex + 1) + "...");
            pauseForMessage();
            System.out.print("\033\143");
        } else {
            System.out.println("Invalid floor index.");
        }
    }
    
    /**
    * Sets the player position for descending to a lower floor.
    * The player position is adjusted based on the current floor index.
    */
    private static void setPlayerPositionForDescending() {
        switch (currentFloorIndex) {
            case 1:
                playerRow = 6;
                playerCol = 3;
                break;
            case 2:
                playerRow = 8;
                playerCol = 1;
                break;
        }
    }

    /**
    * Sets the player position for ascending to a higher floor.
    * The player position is adjusted based on the current floor index.
    */
    private static void setPlayerPositionForAscending() {
        switch (currentFloorIndex) {
            case 0:
                playerRow = 0;
                playerCol = 1;
                break;
            case 1:
                playerRow = 0;
                playerCol = 3;
                break;
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
            Thread.sleep(0500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

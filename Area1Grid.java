import java.util.Scanner;
import java.util.Random;

/**
 * The Area1Grid class represents the grid-based game area in Stormveil Castle.
 * It allows players to navigate through floors, interact with objects, and battle with the mobs and boss.
 */
public class Area1Grid {
    private static int areaIndex = 1;
    private static boolean isBossDead = false;
    public static boolean isAreaDone = false;
    private static Character character;
    private static Enemy enemy;
    private static AreaInteractionListener listener;
    private static String[][] currentFloor;
    private static int playerRow = 6;
    private static int playerCol = 2;
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
    private static String[][] initialfloor1Data = {
        {"|     |", "|  D  |", "|     |"},
        {"|  ?  |", "|     |", "|  ?  |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |"},
        {"|     |", "|  F  |", "|     |"}
    };
    private static String[][] initialfloor2Data = {
        {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|  ?  |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|  ?  |", "|     |", "|  ?  |", "|  ?  |", "|  ?  |", "|     |", "|  ?  |"},
        {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
        {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|     |"},
        {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"}
    };
    private static String[][] initialfloor3Data = {
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
    
    private static final int[][] startingPositions = {
        {6, 1},
        {6, 3},
        {6, 2}
    };

    /**
     * Resets tiles to their original state.
     */
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
     * 
     * @param input the player's choice
     */
    public static void startArea(Scanner input) {
        character.getEffectiveHealth();
        shouldExitArea = false;
        currentFloorIndex = 0;
        resetFloorData();
        currentFloor = floors[currentFloorIndex];
       
        playerRow = startingPositions[currentFloorIndex][0];
        playerCol = startingPositions[currentFloorIndex][1];

        System.out.println(" _______ _________ _______  _______  _______           _______ _________ _          _______  _______  _______ _________ _        _______ ");
        System.out.println("(  ____ \\\\__   __/(  ___  )(  ____ )(       )|\\     /|(  ____ \\\\__   __/( \\        (  ____ \\(  ___  )(  ____ \\\\__   __/( \\      (  ____ \\");
        System.out.println("| (    \\/   ) (   | (   ) || (    )|| () () || )   ( || (    \\/   ) (   | (        | (    \\/| (   ) || (    \\/   ) (   | (      | (    \\/");
        System.out.println("| (_____    | |   | |   | || (____)|| || || || |   | || (__       | |   | |        | |      | (___) || (_____    | |   | |      | (__    ");
        System.out.println("(_____  )   | |   | |   | ||     __)| |(_)| |( (   ) )|  __)      | |   | |        | |      |  ___  |(_____  )   | |   | |      |  __)   ");
        System.out.println("      ) |   | |   | |   | || (\\ (   | |   | | \\ \\_/ / | (         | |   | |        | |      | (   ) |      ) |   | |   | |      | (      ");
        System.out.println("/\\____) |   | |   | (___) || ) \\ \\__| )   ( |  \\   /  | (____/\\___) (___| (____/\\  | (____/\\| )   ( |/\\____) |   | |   | (____/\\| (____/\\");
        System.out.println("\\_______)   )_(   (_______)|/   \\__/|/     \\|   \\_/   (_______/\\_______/(_______/  (_______/|/     \\|\\_______)   )_(   (_______/(_______/");
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
            System.out.println("Exiting Stormveil Castle...");
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
            if (currentFloorIndex == 2 && isBossDead == false){
                System.out.println("Great enemy has not yet fallen! Fast travel is not accessible.");
                pauseForMessage();
                System.out.print("\033\143");
            } else if (currentFloorIndex == 2 && isBossDead == true){
                if (listener != null) {
                    listener.onFastTravel();
                    shouldExitArea = true;
                } else {
                    System.out.println("Fast travel point activated. Returning to game lobby...");
                    shouldExitArea = true; 
                }
            } else if (currentFloorIndex == 0 && isBossDead == false || currentFloorIndex == 0 && isBossDead == true){
                if (listener != null) {
                    listener.onFastTravel();
                    shouldExitArea = true;
                } else {
                    System.out.println("Fast travel point activated. Returning to game lobby...");
                    shouldExitArea = true; 
                }
            }
        } else if ("|  ?  |".equals(currentTile)) {
            Random rand = new Random();
            double encounterChance = rand.nextDouble();
            String[] enemies = {"Godrick Soldier", "Godrick Archer", "Godrick Knight"};
            String encounteredEnemy = enemies[rand.nextInt(enemies.length)];

            switch (encounteredEnemy) {
                case "Godrick Soldier":
                    enemy = EnemyStats.generateEnemyType1(areaIndex);
                    break;
                case "Godrick Archer":
                    enemy = EnemyStats.generateEnemyType2(areaIndex);
                    break;
                case "Godrick Knight":
                    enemy = EnemyStats.generateEnemyType3(areaIndex);
                    break;
                default:
                    return;
            }
    
            if (encounterChance < 0.75) {
                System.out.print("\033\143");
                System.out.println("You encounter an enemy!");

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
            } else {
                int runesGained = areaIndex * (rand.nextInt(101) + 50);
                character.addRunes(runesGained);
                System.out.print("\033\143");
                System.out.println("You found " + runesGained + " runes! Total runes: " + character.getRunes());
                pauseForMessage();
                System.out.print("\033\143");
                currentFloor[playerRow][playerCol] = "|     |";
            }
        } else if ("|  B  |".equals(currentTile)) {
            System.out.print("\033\143");
            System.out.println("You have found the Boss of Stormveil Castle !!!");
            System.out.println("\n[ Godrick The Grafted ]");
            System.out.println("HP: 200");
            pauseForMessage();;
            System.out.print("\033\143");
            enemy = EnemyStats.generateGodrickBoss();
            Battle battle = new Battle(character, enemy, areaIndex);
            battle.startBattle();
            pauseForMessage();
            System.out.print("\033\143");
            if (character.getEffectiveHealth() != 0){
                currentFloor[playerRow][playerCol] = "|     |";
                isBossDead = true;
                isAreaDone = true;
            } else if (character.getEffectiveHealth() == 0){            
            pauseForMessage();
            System.out.print("\033\143");
            shouldExitArea = true;
            }
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
               (currentFloorIndex == 2 && playerRow == 6 && playerCol == 2);
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
        } else if (currentFloorIndex == 2 && playerRow == 6 && playerCol == 2) {
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
                playerRow = 6;
                playerCol = 2;
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
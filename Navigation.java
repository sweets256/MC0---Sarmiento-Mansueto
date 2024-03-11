import java.util.Scanner;


/**
 * The Navigation class manages the navigation flow of the game,
 * including transitions between different game states and areas.
 */
public class Navigation implements AreaInteractionListener {
    private Character player;
    private GameLobby gameLobby;
    private Scanner obj;
    private enum GameState { TITLE_SCREEN, GAME_LOBBY, IN_AREA, EXIT }
    private GameState currentState;
    private String currentArea = "Game Lobby";

    /**
    * The Navigation class manages the navigation flow of the game,
    * including transitions between different game states and areas.
    */
    public Navigation() {
        obj = new Scanner(System.in);
        currentState = GameState.TITLE_SCREEN;
        runGameLoop();
    }

    /**
     * Starts the game loop, managing transitions between different game states.
     */
    private void runGameLoop() {
        while (currentState != GameState.EXIT) {
            switch (currentState) {
                case TITLE_SCREEN:
                    titleScreen();
                    break;
                case GAME_LOBBY:
                    gameLobby();
                    break;
                case IN_AREA:
                    Area1Grid.setCharacter(player);
                    Area1Grid.setAreaInteractionListener(this);
                    Area1Grid.startArea();
                    currentState = GameState.GAME_LOBBY;
                    break;
                case EXIT:
                    System.out.println("You have exited the game.");
                    break;
            }
        }
        obj.close();
    }

    /**
     * Displays the title screen and prompts the player for input.
     */
    private void titleScreen() {
        System.out.println(" _______  _        ______   _______  _          _______  _______  _______           _______ ");
        System.out.println("(  ____ \\( \\      (  __  \\ (  ____ \\( (    /|  (  ____ )(  ___  )(  ____ \\|\\     /|(  ____ \\");
        System.out.println("| (    \\/| (      | (  \\  )| (    \\/|  \\  ( |  | (    )|| (   ) || (    \\/| )   ( || (    \\/");
        System.out.println("| (__    | |      | |   ) || (__    |   \\ | |  | (____)|| |   | || |      | |   | || (__    ");
        System.out.println("|  __)   | |      | |   | ||  __)   | (\\ \\) |  |     __)| |   | || | ____ | |   | ||  __)   ");
        System.out.println("| (      | |      | |   ) || (      | | \\   |  | (\\ (   | |   | || | \\_  )| |   | || (      ");
        System.out.println("| (____/\\| (____/\\| (__/  )| (____/\\| )  \\  |  | ) \\ \\__| (___) || (___) || (___) || (____/\\");
        System.out.println("(_______/(_______/(______/ (_______/|/    )_)  |/   \\__/(_______)(_______)(_______)(_______/");
        
        
        System.out.println("\n\t\t\t\t[Please choose your option]");
        System.out.println("\n\t\t\t\t\t[1] Start");
        System.out.println("\t\t\t\t\t[2] Exit");
        System.out.print("\n\t\t\t\t\t    ");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine();

        if (choice == 1) {
            player = new Character();
            if (player.createCharacter(obj)) {
                gameLobby = new GameLobby(this, player);
                currentState = GameState.GAME_LOBBY;
            }
        } else if (choice == 2) {
            currentState = GameState.EXIT;
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            pauseBeforeCleaningScreen();
            System.out.print("\033\143");
        }
    }

    /**
     * Pauses the execution for a short duration before clearing the screen.
     */
    private void pauseBeforeCleaningScreen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
 
    /**
     * Displays the game lobby menu and handles player input.
     */
    private void gameLobby() {
        boolean inGameLobby = true;
        while (inGameLobby) {
            
            System.out.println("============ " + currentArea + " =============");
            System.out.println("[1] Fast Travel");
            System.out.println("[2] Level Up");
            System.out.println("[3] Quit Game");
            
            player.displayStats();
            System.out.print("\nPlease choose an option: ");
    
            int choice = obj.hasNextInt() ? obj.nextInt() : -1;
            obj.nextLine(); 
    
            switch (choice) {
                case 1:
                    System.out.print("\033\143");
                    gameLobby.fastTravel();
                    break;
                case 2:
                    System.out.print("\033\143");
                    gameLobby.levelUp();
                    break;
                case 3:
                    System.out.print("\033\143");
                    System.out.println("Going back to the Main Menu...");
                    pauseForMessage();
                    System.out.print("\033\143");
                    inGameLobby = false;
                    currentState = GameState.TITLE_SCREEN;
                    currentArea = "Game Lobby";
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("Please choose a valid option.");
                    pauseForMessage();
                    System.out.print("\033\143");
                    break;
            }
        }
    }
    
    /**
     * Sets the current area in the game.
     *
     * @param area the name of the current area
     */
    public void setCurrentArea(String area) {
        this.currentArea = area;
    }
    
    /**
     * Retrieves the name of the current area in the game.
     *
     * @return the name of the current area
     */
    public String getCurrentArea() {
        return this.currentArea;
    }
        
    public void enterArea(String areaName) {
        if ("Stormveil Castle".equals(areaName)) {
            Area1Grid.setCharacter(player);
            Area1Grid.startArea();
        } else if ("Raya Lucaria Academy".equals(areaName)) {
            Area2Grid.setCharacter(player);
            Area2Grid.startArea();
        }
        // Handle other areas similarly
    }
    
    /**
     * Handles the fast travel action by transitioning the game state to the game lobby.
     */
    @Override
    public void onFastTravel() {
        currentState = GameState.GAME_LOBBY;
        setCurrentArea("Game Lobby");
    }

    /**
     * Placeholder method for handling area change events.
     *
     * @param newArea the name of the new area
     */
    @Override
    public void onChangeArea(String newArea) {
    }
    
    /**
     * Pauses the execution for a short duration to display messages.
     */
    private static void pauseForMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

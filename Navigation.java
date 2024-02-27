import java.util.Scanner;

public class Navigation {
    private Character player;
    private GameLobby gameLobby;
    private Scanner obj;
    private enum GameState { TITLE_SCREEN, GAME_LOBBY, IN_AREA, EXIT }
    private GameState currentState;
    private String currentArea = "Game Lobby";

    public Navigation() {
        obj = new Scanner(System.in);
        currentState = GameState.TITLE_SCREEN;
        runGameLoop();
    }

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
                    // Ensure Area1Grid has access to the Character instance.
                    Area1Grid.setCharacter(player);
                    Area1Grid.startArea();
                    currentState = GameState.GAME_LOBBY; // Return to lobby after gameplay.
                    break;
                case EXIT:
                    System.out.println("You have exited the game.");
                    break;
            }
        }
        obj.close();
    }

    private void titleScreen() {
        System.out.println("========== Elden Rogue ==========");
        System.out.println("Please choose your option:");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine(); // Consume the newline character after number input.

        if (choice == 1) {
            // Create a new character and enter the game lobby if character creation is successful.
            player = new Character(); // Ensure you have a Character class that can handle character creation.
            if (player.createCharacter(obj)) {
                // Pass this Navigation instance to GameLobby to allow for back navigation.
                gameLobby = new GameLobby(this, player);
                currentState = GameState.GAME_LOBBY;
            }
        } else if (choice == 2) {
            currentState = GameState.EXIT; // Exit the game.
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }
    }

    private void gameLobby() {
        System.out.println("========== " + currentArea + " ==========");
        System.out.println("[1] Fast Travel");
        System.out.println("[2] Level Up");
        System.out.println("[3] Quit Game");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine(); // Consume the newline character after number input.

        switch (choice) {
            case 1:
                // Assuming fastTravel method doesn't automatically change currentState.
                gameLobby.fastTravel(); // Present fast travel options.
                break;
            case 2:
                gameLobby.levelUp(); // Allow the player to level up.
                break;
            case 3:
                System.out.println("Going back to the Main Menu...");
                currentState = GameState.TITLE_SCREEN; // Return to the title screen.
                currentArea = "Game Lobby"; // Reset the current area to the game lobby.
                break;
            default:
                System.out.println("Please choose a valid option.");
                break;
        }
    }
    
    public void setCurrentArea(String area) {
        this.currentArea = area; // Update the current area based on game actions.
    }
    
    public String getCurrentArea() {
        return this.currentArea; // Retrieve the current area.
    }

    // Method to trigger entering an area like Area1Grid from the game lobby.
    public void enterArea() {
       currentState = GameState.IN_AREA;
    }
}

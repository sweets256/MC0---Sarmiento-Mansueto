import java.util.Scanner;

public class Navigation {
    private Character player;
    private Scanner obj;
    private enum GameState { TITLE_SCREEN, GAME_LOBBY, EXIT }
    private GameState currentState;

    public Navigation() {
        obj = new Scanner(System.in);
        currentState = GameState.TITLE_SCREEN; // Start at the title screen
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
                case EXIT:
                    break;
            }
        }
        System.out.println("You have exited the game.");
        obj.close(); // Close the scanner before exiting the game
    }

    private void titleScreen() {
        System.out.println("========== Elden Rogue ==========");
        System.out.println("Please choose your option:");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine(); // Consume newline regardless of input to clear the buffer

        if (choice == 1) {
            player = new Character();
            if (player.createCharacter(obj)) {
                currentState = GameState.GAME_LOBBY;
            } 
        } else if (choice == 2) {
            currentState = GameState.EXIT;
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }
    }

    private void gameLobby() {
        System.out.println("========== Game Lobby ==========");
        System.out.println("[1] Fast Travel");
        System.out.println("[2] Level Up");
        System.out.println("[3] Quit Game");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine(); // Consume newline regardless of input to clear the buffer

        switch (choice) {
            case 1:
                System.out.println("AREA 1: Stormveil Castle");
                // Implement fast travel functionality
                break;
            case 2:
                System.out.println("Level up screen");
                // Implement level up functionality
                break;
            case 3:
                currentState = GameState.TITLE_SCREEN; // Return to title screen
                break;
            default:
                System.out.println("Please choose a valid option");
        }
    }
}

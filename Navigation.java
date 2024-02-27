import java.util.Scanner;

public class Navigation implements AreaInteractionListener {
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

    private void titleScreen() {
        System.out.println("========== Elden Rogue ==========");
        System.out.println("Please choose your option:");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

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
        }
    }

    private void gameLobby() {
        System.out.println("========== " + currentArea + " ==========");
        System.out.println("[1] Fast Travel");
        System.out.println("[2] Level Up");
        System.out.println("[3] Quit Game");

        int choice = obj.hasNextInt() ? obj.nextInt() : -1;
        obj.nextLine();

        switch (choice) {
            case 1:
                gameLobby.fastTravel();
                break;
            case 2:
                gameLobby.levelUp();
                break;
            case 3:
                System.out.println("Going back to the Main Menu...");
                currentState = GameState.TITLE_SCREEN;
                currentArea = "Game Lobby";
                break;
            default:
                System.out.println("Please choose a valid option.");
                break;
        }
    }

    public void setCurrentArea(String area) {
        this.currentArea = area;
    }

    public String getCurrentArea() {
        return this.currentArea;
    }

    public void enterArea() {
        Area1Grid.setCharacter(player);
        Area1Grid.setAreaInteractionListener(this); // 'this' refers to the Navigation instance
        Area1Grid.startArea();
    }

    @Override
    public void onFastTravel() {
        currentState = GameState.GAME_LOBBY;
        setCurrentArea("Game Lobby");
    }

    @Override
    public void onChangeArea(String newArea) {
    }
}

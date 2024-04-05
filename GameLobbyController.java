import java.util.ArrayList;

/**
 * The controller class for managing the game lobby.
 */
public class GameLobbyController {
    private MainController mainController;
    private GameLobbyView view;
    private GameLobby gameLobby;
    private Character character;

    /**
     * Constructs a GameLobbyController with the specified main controller and character.
     * 
     * @param mainController The main controller of the application.
     * @param character The character associated with this game lobby.
     */
    public GameLobbyController(MainController mainController, Character character) {
        this.mainController = mainController;
        this.character = character;
        this.view = new GameLobbyView(this);
        this.gameLobby = new GameLobby(this);
    }

    /**
     * Displays or hides the game lobby view.
     * 
     * @param state The state indicating whether to show or hide the view.
     */
    public void showView(Boolean state){
        view.showView(state);
    }

    /**
     * Signals the completion of a process to the main controller.
     * 
     * @param controller The controller to navigate to after finishing the process.
     */
    public void finishProcess(String controller){
        mainController.navTo(controller);   
    }

    /**
     * Retrieves information about the associated character.
     * 
     * @return An ArrayList containing information about the character.
     */
    public ArrayList<String> getCharInfo(){
        return character.getCharacterInfo();
    }
}

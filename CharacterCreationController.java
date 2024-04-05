/**
 * The controller class for managing character creation.
 */
public class CharacterCreationController {
    private MainController mainController;
    private CharacterCreationView view;
    private Character character;

    /**
     * Constructs a CharacterCreationController with the specified main controller.
     * 
     * @param mainController The main controller of the application.
     */
    public CharacterCreationController(MainController mainController) {
        this.mainController = mainController;
        this.view = new CharacterCreationView(this);
        this.character = new Character(this);
    }

    /**
     * Displays or hides the character creation view.
     * 
     * @param state The state indicating whether to show or hide the view.
     */
    public void showView(Boolean state) {
        view.showView(state);
    }

    /**
     * Signals the completion of a process to the main controller.
     * 
     * @param controller The controller to navigate to after finishing the process.
     */
    public void finishProcess(String controller) {
        mainController.navTo(controller);
    }

    /**
     * Retrieves the player's name and selected class from the view and sends it to the character model.
     * 
     * @param playerName The name of the player.
     * @param selectedClass The selected class for the character.
     */
    public void retrieveAndSend(String playerName, int selectedClass) {
        character.setCharacter(playerName, selectedClass);
    }

    /**
     * Creates a game lobby using the character information and informs the main controller.
     */
    public void createGameLobby() {
        mainController.createGameLobby(character);
    }

    /**
     * Retrieves the character's statistics.
     * 
     * @return An array containing the character's statistics.
     */
    public int[] getStats() {
        return character.getStats();
    }

    /**
     * Retrieves the name of the character.
     * 
     * @return The name of the character.
     */
    public String getCharacterName() {
        return character.getCharacterName();
    }

    /**
     * Retrieves the class of the character.
     * 
     * @return The class of the character.
     */
    public int getJobClass() {
        return character.getJobClass();
    }
}

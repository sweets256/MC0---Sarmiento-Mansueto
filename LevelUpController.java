/**
 * The LevelUpController class controls the logic behind the level up screen 
 * and acts as the intermediary between the model and the view.
 */
public class LevelUpController {
    private MainController mainController;
    private LevelUpView view;
    private Character character;
    private GameLobby gameLobby;

    /**
     * Constructor for LevelUpController.
     *
     * @param mainController instance of the main controller class
     */
    public LevelUpController(MainController mainController) {
        this.mainController = mainController;
        this.view = new LevelUpView(this);
    }

    /**
     * Displays or hides the level up view.
     *
     * @param state If true, the view is displayed; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        view.showView(state);
    }

    /**
     * Finishes the level up process and navigates to the specified controller.
     *
     * @param controller the controller to navigate to
     */
    public void finishProcess(String controller){
        mainController.navTo(controller);
    }
}

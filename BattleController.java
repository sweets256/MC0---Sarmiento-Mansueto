/**
 * Controller class for managing battles.
 */
public class BattleController {
    private MainController mainController;
    private BattleView view;

    /**
     * Constructs a BattleController with the specified main controller.
     * 
     * @param mainController The main controller of the application.
     */
    public BattleController(MainController mainController) {
        this.mainController = mainController;
        this.view = new BattleView(this);
    }

    /**
     * Displays or hides the battle view.
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
}

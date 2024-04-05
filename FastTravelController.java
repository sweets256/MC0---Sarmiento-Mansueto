/**
 * The controller class for managing fast travel functionality.
 */
public class FastTravelController {
    private MainController mainController;
    private FastTravelView view;
    
    /**
     * Constructs a FastTravelController with the specified main controller.
     * 
     * @param mainController The main controller of the application.
     */
    public FastTravelController(MainController mainController) {
        this.mainController = mainController;
        this.view = new FastTravelView(this);
    }

    /**
     * Displays or hides the fast travel view.
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
}

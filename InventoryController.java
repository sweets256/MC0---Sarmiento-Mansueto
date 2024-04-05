/**
 * The InventoryController class controls the behavior and interactions of the title screen view.
 */
public class InventoryController {
    private MainController mainController;
    private InventoryView view;

    /**
     * Constructs a new TitleController with a reference to the main controller.
     *
     * @param mainController the main controller instance
     */
    public InventoryController(MainController mainController) {
        this.mainController = mainController;
        this.view = new InventoryView(this);
    }

    /**
     * Finishes the current process and navigates to the specified controller.
     *
     * @param controller the name of the controller to navigate to
     */
    public void finishProcess(String controller) {
        mainController.navTo(controller);
    }

    /**
     * Shows or hides the title screen view based on the provided state.
     *
     * @param state true to show the view, false to hide it
     */
    public void showView(Boolean state) {
        view.showView(state);
    }
}
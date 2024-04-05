/**
 * The ShopController class handles the logic for the shop functionality.
 * It interacts with the MainController and ShopView to facilitate navigation
 * and display of the shop interface.
 */
public class ShopController {
    private MainController mainController;
    private ShopView view;
    private Character character;

    /**
     * Constructs a new ShopController with a reference to the main controller.
     *
     * @param mainController the main controller instance
     */
    public ShopController(MainController mainController) {
        this.mainController = mainController;
        this.view = new ShopView(this);
    }

    /**
     * Shows or hides the shop view.
     *
     * @param state If true, the shop view is visible; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        view.showView(state);
    }

    /**
     * Finishes the current process and navigates to the specified controller.
     *
     * @param controller the controller to navigate to
     */
    public void finishProcess(String controller){
        mainController.navTo(controller);
    }
}

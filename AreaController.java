/**
 * The AreaController class controls the behavior and interactions of the title screen view.
 */
public class AreaController {
    private MainController mainController;
    private Area1View view1;
    private Area2View view2;
    private Area3View view3;

    /**
     * Constructs a new TitleController with a reference to the main controller.
     *
     * @param mainController the main controller instance
     */
    public AreaController(MainController mainController) {
        this.mainController = mainController;
        this.view1 = new Area1View(this);
        this.view2 = new Area2View(this);
        this.view3 = new Area3View(this);
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
    public void showView1(Boolean state) {
        view1.showView(state);
    }

    /**
     * Shows or hides the title screen view based on the provided state.
     *
     * @param state true to show the view, false to hide it
     */
    public void showView2(Boolean state) {
        view2.showView(state);
    }

    /**
     * Shows or hides the title screen view based on the provided state.
     *
     * @param state true to show the view, false to hide it
     */
    public void showView3(Boolean state) {
        view3.showView(state);
    }
}
public class SelectJobClassController {
    private MainController mainController;
    private SelectJobClassView view;
    private Character character;

    public SelectJobClassController(MainController mainController) {
        this.mainController = mainController;
        this.view = new SelectJobClassView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}
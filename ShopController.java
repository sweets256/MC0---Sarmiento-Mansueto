public class ShopController {
    private MainController mainController;
    private ShopView view;
    private Character character;

    public ShopController(MainController mainController) {
        this.mainController = mainController;
        this.view = new ShopView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}
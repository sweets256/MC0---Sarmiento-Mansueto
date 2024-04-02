public class FastTravelController {
    private MainController mainController;
    private FastTravelView view;
    //private GameLobby gameLobby;

    public FastTravelController(MainController mainController) {
        this.mainController = mainController;
        this.view = new FastTravelView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}
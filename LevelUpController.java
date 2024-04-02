public class LevelUpController {
    private MainController mainController;
    private LevelUpView view;
    private Character character;
    private GameLobby gameLobby;

    public LevelUpController(MainController mainController) {
        this.mainController = mainController;
        this.view = new LevelUpView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}
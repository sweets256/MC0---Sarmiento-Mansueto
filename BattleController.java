public class BattleController {
    private MainController mainController;
    private BattleView view;
    private Battle battle;
    private Character character;
    private Area1Grid area1;
    private Area2Grid area2;
    private Area3Grid area3;

    public BattleController(MainController mainController) {
        this.mainController = mainController;
        this.view = new BattleView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}
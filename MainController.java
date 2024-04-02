public class MainController {
    //TitleScreenView
    //Shopview
    //SelectJobClasView /ok
    //CharacterCreationView
    //FastTravelView /ok
    //GameLobbyView
    //InventoryView
    //LevelUpView
    //Area1View
    //Area2View
    //Area3View
    //BattleView

    public TitleController titleController;
    public CharacterCreationController charCreationController;
    public GameLobbyController gameLobbyController;
    public FastTravelController fastTravelController;

    public MainController(){
        this.titleController = new TitleController(this);
        this.charCreationController = new CharacterCreationController(this);
        this.gameLobbyController = new GameLobbyController(this);
        this.fastTravelController = new FastTravelController(this);
    }


    public void navTo(String controller){   
        switch(controller){
            case "EXIT" -> TitleController.showView(true); //ok na
            case "CHAR_CREATION" -> CharacterCreationController.showView(true); //ok na
            case "GAME_LOBBY" -> GameLobbyController.showView(true); //ok na
            case "FAST_TRAVEL" -> FastTravelController.showView(true); //ok na
            case "JOB_SELECT" -> FastTravelController.showView(true); //ok na
            case "LEVEL_UP" -> LevelUpController.showView(true);
            case "SHOP" -> ShopController.showView(true);
            case "BACK" -> TitleController.showView(true);
            case "AREA_1" -> Area1Controller.showView(true);
            case "AREA_2" -> Area2Controller.showView(true);
            case "AREA_3" -> Area3Controller.showView(true);
            case "BATTLE" -> BattleController.showView(true);

        }
    }
}
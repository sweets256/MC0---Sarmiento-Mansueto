public class MainController {
    
    public TitleController titleController;
    public CharacterCreationController characterCreationController;
    public GameLobbyController gameLobbyController;
    public FastTravelController fastTravelController; 
    public LevelUpController levelUpController;
    public ShopController shopController;

    public MainController(){
        this.titleController = new TitleController(this);
        this.characterCreationController = new CharacterCreationController(this);
        // this.gameLobbyController = new GameLobbyController(this);
        // this.fastTravelController = new FastTravelController(this);
        // this.levelUpController = new LevelUpController(this);
        // this.shopController = new ShopController(this);
    }


    public void navTo(String controller){   
        switch(controller){
            case "EXIT" -> titleController.showView(true);
            case "CHAR_CREATION" -> characterCreationController.showView(true);
            case "GAME_LOBBY" -> gameLobbyController.showView(true);
            // case "FAST_TRAVEL" -> fastTravelController.showView(true); //ok na
            // case "LEVEL_UP" -> levelUpController.showView(true); //ok na
            // case "SHOP" -> shopController.showView(true); //ok na
            // case "BACK" -> titleController.showView(true); //ok na
            // case "AREA_1" -> Area1Controller.showView(true);
            // case "AREA_2" -> Area2Controller.showView(true);
            // case "AREA_3" -> Area3Controller.showView(true);
            // case "BATTLE" -> BattleController.showView(true);

        }
    }
    public void createGameLobby(Character character){
        this.gameLobbyController = new GameLobbyController(this, character);
        navTo("GAME_LOBBY");
    }
}
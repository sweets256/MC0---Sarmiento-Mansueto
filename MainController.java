/**
 * The MainController class manages navigation between different screens
 * and controllers in the application. It serves as the central hub for
 * controlling the flow of the program.
 */
public class MainController {
    
    private Character character;
    public TitleController titleController;
    public CharacterCreationController characterCreationController;
    public GameLobbyController gameLobbyController;
    public FastTravelController fastTravelController;
    public LevelUpController levelUpController;
    public ShopController shopController;
    public InventoryController inventoryController;
    public AreaController areaController;

    /**
     * Constructs a new MainController and initializes the controllers.
     */
    public MainController(){
        this.titleController = new TitleController(this);
        this.characterCreationController = new CharacterCreationController(this);
        //this.gameLobbyController = new GameLobbyController(this, character);
        this.fastTravelController = new FastTravelController(this);
        this.levelUpController = new LevelUpController(this);
        this.inventoryController = new InventoryController(this);
        this.shopController = new ShopController(this);
        this.areaController = new AreaController(this);
    }

    /**
     * Navigates to the specified controller.
     *
     * @param controller the controller to navigate to
     */
    public void navTo(String controller){   
        switch(controller){
            case "EXIT" -> titleController.showView(true);
            case "CHAR_CREATION" -> characterCreationController.showView(true);
            case "GAME_LOBBY" -> gameLobbyController.showView(true);
            case "FAST_TRAVEL" -> fastTravelController.showView(true);
            case "LEVEL_UP" -> levelUpController.showView(true);
            case "INVENTORY" -> inventoryController.showView(true);
            case "SHOP" -> shopController.showView(true);
            case "BACK" -> titleController.showView(true);
            case "AREA_1" -> areaController.showView(true);
            case "AREA_2" -> areaController.showView(true); 
            case "AREA_3" -> areaController.showView(true);
            // case "BATTLE" -> BattleController.showView(true);

        }
    }

    /**
     * Creates a game lobby with the specified character and navigates to it.
     *
     * @param character the character for the game lobby
     */
    public void createGameLobby(Character character){
        this.gameLobbyController = new GameLobbyController(this, character);
        navTo("GAME_LOBBY");
    }
}

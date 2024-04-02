public class MainController {
    //TitleScreenView
    //Shopview
    //SelectJobClasView
    //CharacterCreationView
    //FastTravelView
    //GameLobbyView
    //InventoryView
    //LevelUpView
    //Area1View
    //Area2View
    //Area3View
    //BattleView

    public TitleController titleController;
    public CharacterCreationController charCreationController;

    public MainController(){
        this.titleController = new TitleController(this);
        this.charCreationController = new CharacterCreationController(this);
    }


    public void navTo(String controller){   
        switch(controller){
            case "CHAR_CREATION" -> CharacterCreationController.showView(true);
            case "GAME_LOBBY" -> GamelobbyController.showView(true);
        }
    }
}
public class GameLobbyController {
    private MainController mainController;
    private GameLobbyView view;
    private GameLobby gameLobby;

    public GameLobbyController(MainController mainController) {
        this.mainController = mainController;
        this.view = new GameLobbyView(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
        
    }
}


// public class CharacterCreationController{
//     //ALL of the other shit na nilagay, included contstructor tamad ako


//     public void showView(Boolean state){
//         view.showView(state);
//     }

    
// }
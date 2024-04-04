import java.util.ArrayList;

public class GameLobbyController {
    private MainController mainController;
    private GameLobbyView view;
    private GameLobby gameLobby;
    private Character character;

    public GameLobbyController(MainController mainController, Character character) {
        this.mainController = mainController;
        this.character = character;
        this.view = new GameLobbyView(this);
        this.gameLobby = new GameLobby(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);   
    }

    public ArrayList<String> getCharInfo(){
        return character.getCharacterInfo();
    }
}

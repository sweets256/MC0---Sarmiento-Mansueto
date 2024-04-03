public class CharacterCreationController {
    private MainController mainController;
    private CharacterCreationView view;
    private Character character;

    public CharacterCreationController(MainController mainController) {
        this.mainController = mainController;
        this.view = new CharacterCreationView(this);
        this.character = new Character(this);
    }

    public void showView(Boolean state){
        view.showView(state);
    }

    public void finishProcess(String controller){
        mainController.navTo(controller);
    }

    public void retrieveAndSend(String playerName, String selectedClass){
        character.setCharacter(playerName, selectedClass);
        mainController.createGameLobby(character);
    }
}


// public class CharacterCreationController{
//     //ALL of the other shit na nilagay, included contstructor tamad ako


//     public void showView(Boolean state){
//         view.showView(state);
//     }

    
// }
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

    public void retrieveAndSend(String playerName, int selectedClass){
        character.setCharacter(playerName, selectedClass);
    }

    public void createGameLobby(){
        mainController.createGameLobby(character);
    }

    public int[] getStats(){
        return character.getStats();
    }

    public String getCharacterName(){
        return character.getCharacterName();
    }

    public int getJobClass(){
        return character.getJobClass();
    }
}
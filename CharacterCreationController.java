public class CharacterCreationController {
    private MainController mainController;
    private CharacterCreationView view;

    public CharacterCreationController(MainController mainController) {
        this.mainController = mainController;
        this.view = new CharacterCreationView(this);
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
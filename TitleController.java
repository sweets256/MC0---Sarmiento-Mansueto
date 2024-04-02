public class TitleController {
    private MainController mainController;
    private TitleScreenView view;

    public TitleController(MainController mainController) {
        this.mainController = mainController;
        this.view = new TitleScreenView(this);
    }


    public void finishProcess(String controller){
        
        mainController.navTo(controller);
        
    }

    public void showView(Boolean state){
        view.showView(state);
    }
}


// public class CharacterCreationController{
//     //ALL of the other shit na nilagay, included contstructor tamad ako


//     public void showView(Boolean state){
//         view.showView(state);
//     }

    
// }
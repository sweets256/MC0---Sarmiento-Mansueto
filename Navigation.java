import java.util.Scanner;

public class Navigation {

    public Navigation(){
        titleScreen();
    }

    public void titleScreen() {
        Scanner obj = new Scanner(System.in);
    
        try {
            while (true) {
                System.out.println("Please choose your option:");
                System.out.println("[1] Start");
                System.out.println("[2] Exit");
    
                if (obj.hasNextInt()) {
                    int choice = obj.nextInt();
    
                    switch (choice) {
                        case 1:
                            characterCreation();
                            break;
                        case 2:
                            System.exit(0);
                        default:
                            System.out.println("Please choose a valid option.");
                    }
                    break; // Exit the loop if a valid choice is made
                } else {
                    System.out.println("Please enter aninteger.");
                    obj.nextLine(); // Clear the input buffer
                }
            }
        } finally {
            obj.close();
        }
    }
    
    public void characterCreation() {
        
        new CharacterCreation();
    }

    public void gameLobby(){
        Scanner obj = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("[1] Fast Travel");
                System.out.println("[2] Level Up");
                System.out.println("[3] Quit Game");

                if (obj.hasNextInt()) {
                    int choice = obj.nextInt();

                    switch (choice){
                        case 1:
                            System.out.println("AREA 1: Stormveil Castle");
                            break;
                        case 2:
                            System.out.println("Level up screen");
                            break;
                        case 3:
                            System.out.println("Quit to TITLE");
                            break;
                        default:
                            System.out.println("Please choose a valid option");
                    }
                    break; // Exit the loop if a valid choice is made
                } else {
                    System.out.println("Please enter an integer");
                    obj.nextLine(); // Clear the input buffer
                } 
            }
        } finally {
            obj.close();
        }
    }
}
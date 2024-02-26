import java.util.Scanner;

public class Navigation {
    Character player;
    private Scanner obj; // Declare Scanner object at class level to reuse it

    public Navigation() {
        obj = new Scanner(System.in); // Initialize Scanner object here
        titleScreen();
        gameLobby();
        obj.close(); // Close the Scanner at the end of the game
    }

    public void titleScreen() {
        while (true) {
            System.out.println("Please choose your option:");
            System.out.println("[1] Start");
            System.out.println("[2] Exit");

            if (obj.hasNextInt()) {
                int choice = obj.nextInt();
                obj.nextLine(); // Consume newline after integer input

                switch (choice) {
                    case 1:
                        player = new Character(obj); // Pass Scanner object to Character
                        return; // Return to proceed to gameLobby
                    case 2:
                        System.out.println("You have exited the game");
                        System.exit(0);
                    default:
                        System.out.println("Please choose a valid option.");
                }
            } else {
                System.out.println("Please enter an integer.");
                obj.nextLine(); // Clear the input buffer
            }
        }
    }

    public void gameLobby() {
        while (true) {
            System.out.println("[1] Fast Travel");
            System.out.println("[2] Level Up");
            System.out.println("[3] Quit Game");

            if (obj.hasNextInt()) {
                int choice = obj.nextInt();
                obj.nextLine(); // Consume newline after integer input

                switch (choice) {
                    case 1:
                        System.out.println("AREA 1: Stormveil Castle");
                        return; // Assuming you want to proceed to another method or return to a menu
                    case 2:
                        System.out.println("Level up screen");
                        return; // Same assumption as above
                    case 3:
                        System.out.println("Quit to TITLE");
                        titleScreen(); // Return to the title screen
                        return;
                    default:
                        System.out.println("Please choose a valid option");
                }
            } else {
                System.out.println("Please enter an integer.");
                obj.nextLine(); // Clear the input buffer
            }
        }
    }
}

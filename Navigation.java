import java.util.Scanner;

public class Navigation {

    public void titleScreen(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose your option");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

        int choice = readChoice(obj.nextLine());

        switch (choice){
            case 1 -> System.out.println("Welcome to the Game Lobby");
            case 2 -> System.out.println("Goodbye");
            default -> System.out.println("Please choose a valid option");
        }

        obj.close(); // scanner closer
    }

    public void characterCreation(){
        Scanner obj = new Scanner(System.in);
        System.out.println("[1] Please input your name");
        System.out.println("[2] Select Job Class");
        System.out.println("[3] Confirm");
        System.out.println("[4] Back");

    }

    public void gameLobby(){
        Scanner obj = new Scanner(System.in);
        System.out.println("[1] Fast Travel");
        System.out.println("[2] Level Up");
        System.out.println("[3] Quit Game");

        int choice = readChoice(obj.nextLine());

        obj.close(); // scanner closer

        switch (choice){
            case 1 -> System.out.println("AREA 1: Stormveil Castle");
            case 2 -> System.out.println("Level up screen");
            case 3 -> System.out.println("Quit to TITLE");
            default -> System.out.println("Please choose a valid option");
        }

    }

    public int readChoice(String choice){
        return Integer.parseInt(choice);
    }
}

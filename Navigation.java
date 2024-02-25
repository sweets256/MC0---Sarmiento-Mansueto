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

    public int readChoice(String choice){
        return Integer.parseInt(choice);
    }
}

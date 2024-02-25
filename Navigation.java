import java.util.Scanner;

public class Navigation {
    public Navigation(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose your option");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

        int choice = Integer.parseInt(obj.nextLine());

        switch (choice){
            case 1 -> System.out.println("Welcome to the Game Lobby");
            case 2 -> System.out.println("Goodbye");
            default -> System.out.println("Please choose a valid option");
        }

        obj.close(); // scanner closer
    }
}
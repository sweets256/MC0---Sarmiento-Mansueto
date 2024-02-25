import java.util.Scanner;

public class Navigation {

    public Navigation(){
        titleScreen();
    }

    public void titleScreen(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose your option");
        System.out.println("[1] Start");
        System.out.println("[2] Exit");

        int choice = readChoice(obj.nextLine());

        obj.close(); // scanner closer

        switch (choice){
            case 1 -> characterCreation();
            case 2 -> System.exit(0);
            default -> System.out.println("Please choose a valid option");
        }

    }

    public void characterCreation(){
        Scanner obj = new Scanner(System.in);
        System.out.println("[1] Please input your name");
        System.out.println("[2] Select Job Class");
        System.out.println("[3] Confirm");
        System.out.println("[4] Back");

        int choice = readChoice(obj.nextLine());

        obj.close(); // scanner closer

        switch (choice){
            case 1 -> System.out.println("Name");
            case 2 -> System.out.println("Selected Job Class");
            case 3 -> System.out.println("Character created, welcome to Elden Rogue");
            case 4 -> System.out.println("You have returned to the title screen");
            default -> System.out.println("Please choose a valid option");
        }

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

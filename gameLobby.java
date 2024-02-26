import java.util.Scanner;

public class GameLobby{
    private Character player;

    public GameLobby(Character player){
        this.player = player;
    }

    public void fastTravel(){
        Scanner input = new Scanner(System.in);

        System.out.println("Available areas:");
        System.out.println("[1] Stormveil Castle");
        System.out.println("[2] **Locked**"); 
        System.out.println("[3] **Locked**");
    
        boolean validChoice = false;
        int areaChoice;
    
        //checking if user inputted
        do {
            System.out.print("Enter your choice (1): ");
            areaChoice = input.nextInt();
    
            if (areaChoice == 1) {
                validChoice = true;
                System.out.println("Teleporting to Stormveil Castle...");
                // insert calling of area here (when area 1 is made na)
            } else {
                System.out.println("Invalid area. Please choose a valid option.");
            }
        } while (!validChoice);

        input.close();
    }
    

    public void levelUp(){
        Scanner input = new Scanner(System.in);

        //get stats from Character class
        int health = player.getStatValue(1);
        int dexterity = player.getStatValue(2);
        int intelligence = player.getStatValue(3);
        int endurance = player.getStatValue(4);
        int strength = player.getStatValue(5);
        int faith = player.getStatValue(6);

        System.out.println("Available stats to level up:");
        System.out.println("[1] Strength (Current Level: " + health + ")");
        System.out.println("[2] Dexterity (Current Level: " + dexterity + ")");
        System.out.println("[3] Strength (Current Level: " + intelligence + ")");
        System.out.println("[4] Dexterity (Current Level: " + endurance + ")");
        System.out.println("[5] Strength (Current Level: " + strength + ")");
        System.out.println("[6] Dexterity (Current Level: " + faith + ")");

        int statChoice = input.nextInt();

        String confirmation; //checks if player confirms their stat choice
        do{
            System.out.println("Are you sure you want to level up " + (statChoice) + "? (Y/N)");
            confirmation = input.nextLine().toUpperCase();
        } while (!confirmation.equals("Y") && !confirmation.equals("N"));

        if (confirmation.equals("Y")){
            int levelUpCost = (player.getLevel() * 100) / 2;

            if (player.getRunes() >= levelUpCost){
                player.setRunes(player.getRunes() - levelUpCost);

                switch (statChoice){
                    case 1:
                        player.increaseStat(1);
                        break;
                    case 2:
                        player.increaseStat(2);
                        break;
                    case 3:
                        player.increaseStat(3);
                        break;
                    case 4:
                        player.increaseStat(4);
                        break;  
                    case 5:
                        player.increaseStat(5);
                        break; 
                    case 6:
                        player.increaseStat(6); 
                        break;
                }

                player.setLevel(player.getLevel() + 1); //levels up player level

                System.out.println("Stat increased successfully!");
                System.out.println("New player level: " + player.getLevel());
            }
        }

        input.close();
    }

    public void quitGame(){
        System.out.println("Quitting to title screen..."); //idk how to quit to title :''')

    }
}
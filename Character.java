import java.util.Scanner;

public class Character {
    private String characterName;
    private String jobClass;
    private String[][] characterClasses = {
        {"Vagabond", "9", "15", "13", "9", "11", "14", "9"},
        {"Samurai", "9", "12", "15", "9", "13", "12", "8"},
        {"Warrior", "8", "11", "16", "10", "11", "10", "8"},
        {"Hero", "7", "14", "9", "7", "12", "16", "8"},
        {"Astrologer", "6", "9", "12", "16", "9", "8", "7"},
        {"Prophet", "7", "10", "10", "7", "8", "11", "16"}
    };

    public Character(Scanner input) {
        createCharacter(input);
    }

    public void createCharacter(Scanner input) {
        System.out.println("========== Character Creation ==========");
        while (true) {
            System.out.println("What is your choice?");
            System.out.println("[1] Character Name");
            System.out.println("[2] Job Class");
            System.out.println("[3] Go back to the Main Menu");
            System.out.print("Enter choice: ");
            int choice = getValidIntegerInput(input);

            switch (choice) {
                case 1:
                    enterCharacterName(input);
                    enterJobClass(input);
                    break;
                case 2:
                    enterJobClass(input);
                    enterCharacterName(input);
                    break;
                case 3:
                    return; // Exit the method to go back to the main menu
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            System.out.println("Are you sure you want to create this character? (Y/N)");
            if (input.next().trim().equalsIgnoreCase("Y")) {
                System.out.println("Character created successfully!");
                System.out.println("Character name: " + characterName);
                System.out.println("Job class: " + jobClass);
                input.nextLine(); // Consume newline left after the confirmation
                break; // Exit the loop after character creation
            } else {
                System.out.println("Character creation cancelled. Starting over.");
                input.nextLine(); // Consume newline left after the confirmation
            }
        }
    }

    private void enterCharacterName(Scanner input) {
        System.out.print("Enter character name: ");
        characterName = input.nextLine();
        if (characterName.length() > 25) {
            characterName = characterName.substring(0, 25);
            System.out.println("Character name cannot be longer than 25 characters. Name truncated.");
        }
    }

    private void enterJobClass(Scanner input) {
        System.out.println("Select a job class:");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.printf("[%d] %s - Level: %s, Health: %s, Dexterity: %s, Intelligence: %s, Endurance: %s, Strength: %s, Faith: %s%n", 
                              i + 1, characterClasses[i][0], characterClasses[i][1], characterClasses[i][2], characterClasses[i][3],
                              characterClasses[i][4], characterClasses[i][5], characterClasses[i][6], characterClasses[i][7]);
        }

        while (true) {
            System.out.print("Enter your choice: ");
            int classChoice = getValidIntegerInput(input);
            if (classChoice >= 1 && classChoice <= characterClasses.length) {
                jobClass = characterClasses[classChoice - 1][0];
                break; // Valid choice made, exit loop
            } else {
                System.out.println("Invalid choice. Please select a valid job class.");
            }
        }
    }

    private int getValidIntegerInput(Scanner input) {
        while (true) {
            try {
                int number = Integer.parseInt(input.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            new Character(input);
        } finally {
            input.close(); // Close the scanner after the character creation process is done.
        }
    }
}

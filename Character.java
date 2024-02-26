import java.util.InputMismatchException;
import java.util.Scanner;

public class Character {
    private String characterName;
    private String jobClass;
    private String[] characterClasses = {
        "Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"
    };

    public Character() {
        createCharacter();
    }

    private int runes = 0;

    public void createCharacter() {
        System.out.println("========== Character Creation ==========");
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("What is your choice?");
                System.out.println("[1] Character Name");
                System.out.println("[2] Job Class");
                System.out.println("[3] Go back to the Main Menu");
                System.out.print("Enter choice: ");
                int choice = getValidIntegerInput(input);
                input.nextLine(); // Consume the newline left-over

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
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                        continue;
                }

                System.out.println("Are you sure you want to create this character? (Y/N)");
                input.nextLine(); // Consume the newline left-over
                if (input.nextLine().trim().equalsIgnoreCase("Y")) {
                    System.out.println("Character created successfully!");
                    System.out.println("Character name: " + characterName);
                    System.out.println("Job class: " + jobClass);
                    break;
                } else {
                    System.out.println("Character creation cancelled. Starting over.");
                }
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
            System.out.println("[" + (i + 1) + "] " + characterClasses[i]);
        }

        while (true) {
            int classChoice = getValidIntegerInput(input);
            if (classChoice >= 1 && classChoice <= characterClasses.length) {
                jobClass = characterClasses[classChoice - 1];
                break;
            } else {
                System.out.println("Invalid choice. Please pick from 1 to " + characterClasses.length + ".");
            }
        }
    }

    private int getValidIntegerInput(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Consume the invalid input
            }
        }
    }

    public static void main(String[] args) {
        new Character();
    }
}
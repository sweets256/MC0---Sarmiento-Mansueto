import java.util.Scanner;

public class Character {
    private String characterName;
    private String jobClass;

    public Character() {
        createCharacter();
    }

    private String[] characterClasses = {
            "Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"
    };

    private String[][] classStats = {
            {"Vagabond", "9", "15", "13", "9", "11", "14", "9"},
            {"Samurai", "9", "12", "15", "9", "13", "12", "8"},
            {"Warrior", "8", "11", "16", "10", "11", "10", "8"},
            {"Hero", "7", "14", "9", "7", "12", "16", "8"},
            {"Astrologer", "6", "9", "12", "16", "9", "8", "7"},
            {"Prophet", "7", "10", "10", "7", "8", "11", "16"}
    };

    public void createCharacter() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("========== Character Creation ==========");

            do {
                // Get name first
                System.out.printf("Enter character name: ");
                characterName = input.nextLine();

                if (characterName.length() > 25) {
                    characterName = characterName.substring(0, 25);
                    System.out.println("Character name cannot be longer than 25 characters. Please try again.");
                }

                // Then proceed with job class selection
                System.out.println("");
                System.out.println("Select a job class: ");

                int i;
                for (i = 0; i < characterClasses.length && i < classStats.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + characterClasses[i] + " [Level: " + classStats[i][1]
                            + ", HP: " + classStats[i][2] + ", Dexterity: " + classStats[i][3] + ", Intelligence: " + classStats[i][4]
                            + ", Endurance: " + classStats[i][5] + ", Strength: " + classStats[i][6] + ", Faith: " + classStats[i][7] + "]");
                }

                int choice = input.nextInt();
                if (choice > 0 && choice <= characterClasses.length) {
                    jobClass = characterClasses[choice - 1];

                    System.out.println("Are you sure you want to create this character? (Y/N)");
                    String confirmation = input.next().toUpperCase();

                    if (confirmation.equals("Y")) {
                        System.out.println("Character created successfully!");
                        System.out.println("Character name: " + characterName);
                        System.out.println("Job class: " + jobClass);
                        break;
                    } else if (confirmation.equals("N")) {
                        System.out.println("Character creation cancelled.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                    }
                } else {
                    System.out.println("Invalid choice. Please pick from 1 to 6.");
                }
            } while (true); // loop until character is confirmed

            input.close();
        }
    }
}

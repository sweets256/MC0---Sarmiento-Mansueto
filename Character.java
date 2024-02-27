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

    public Character() {
    }

    public boolean createCharacter(Scanner input) {
        System.out.println("========== Character Creation ==========");
        System.out.print("Enter character name (or type 'back' to return to the main menu): ");
        String nameInput = input.nextLine();
        if ("back".equalsIgnoreCase(nameInput.trim())) {
            return false; // User chose to go back
        }
        this.characterName = nameInput;

        System.out.println("Select a job class (or type 'back' to return to the main menu):");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.printf("[%d] %s - Level: %s, Health: %s, Dexterity: %s, Intelligence: %s, Endurance: %s, Strength: %s, Faith: %s%n",
                              i + 1, characterClasses[i][0], characterClasses[i][1], characterClasses[i][2], characterClasses[i][3],
                              characterClasses[i][4], characterClasses[i][5], characterClasses[i][6], characterClasses[i][7]);
        }
        while (true) {
            String classInput = input.nextLine();
            if ("back".equalsIgnoreCase(classInput.trim())) {
                return false; // User chose to go back
            }
            try {
                int classChoice = Integer.parseInt(classInput);
                if (classChoice >= 1 && classChoice <= characterClasses.length) {
                    jobClass = characterClasses[classChoice - 1][0];
                    System.out.println("Character created successfully!");
                    System.out.println("Character name: " + characterName);
                    System.out.println("Job class: " + jobClass);
                    System.out.println("Confirm this character? (Y/N)");
                    while (true){
                        String confirmation = input.nextLine().trim().toUpperCase();
                        if ("Y".equals(confirmation)) {
                            System.out.println("Character created successfully!");
                            return true; // proceed to game lobby
                        } else if ("N".equals(confirmation)){
                            return false;
                        } else {
                            System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to redo character creation.");
                        }
                    }
                } else {
                    System.out.println("Invalid choice. Please select a valid job class or type 'back'.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'back'.");
            }
        }
    }
}

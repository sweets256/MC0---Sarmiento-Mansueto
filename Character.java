import java.util.Scanner;

public class Character {
    private String characterName;
    private String jobClass;
    private int level = 1; // Default starting level
    private int runes = 1000; // Default starting runes
    private int[] stats = new int[6]; // Array to hold stats: Health, Dexterity, Intelligence, Endurance, Strength, Faith
    private static final String[][] characterClasses = {
        // JobClass, Level, Health, Dexterity, Intelligence, Endurance, Strength, Faith
        {"Vagabond", "9", "15", "13", "9", "11", "14", "9"},
        {"Samurai", "9", "12", "15", "9", "13", "12", "8"},
        {"Warrior", "8", "11", "16", "10", "11", "10", "8"},
        {"Hero", "7", "14", "9", "7", "12", "16", "8"},
        {"Astrologer", "6", "9", "12", "16", "9", "8", "7"},
        {"Prophet", "7", "10", "10", "7", "8", "11", "16"}
    };

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public boolean createCharacter(Scanner input) {
        boolean nameSet = false, classSet = false;
    
        while (!nameSet || !classSet) {
            System.out.print("\033\143"); // Clear the screen at the start of each loop iteration
            System.out.println("========== Character Creation ==========");
            System.out.println("Select the field you want to input:");
            System.out.println("[1] Character Name");
            System.out.println("[2] Job Class");
            System.out.println("Type 'back' at any time to return to the title screen.");
            System.out.print("Enter your choice: ");
    
            String choice = input.nextLine().trim();
            
            if ("back".equalsIgnoreCase(choice)) {
                System.out.print("\033\143"); // Clear the screen before returning to the title screen
                return false; // Exit character creation and return to the title screen
            }
    
            switch (choice) {
                case "1":
                    inputCharacterName(input); // Call a method to handle name input
                    nameSet = this.characterName != null && !this.characterName.isEmpty();
                    break;
                case "2":
                    selectJobClass(input); // Call a method to handle job class selection
                    classSet = this.jobClass != null && !this.jobClass.isEmpty();
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    pause(2000); // Pause for 2 seconds to let the user read the error message
                    break;
            }
        }
    
        // At this point, both fields are filled out, ask for confirmation
        System.out.print("\033\143");
        System.out.println("========== Character Summary ==========");
        System.out.println("Character name: " + characterName);
        System.out.println("Job class: " + jobClass);
        // Display stats including the starting level of the chosen job class
        System.out.println("Starting Level: " + level);
        System.out.println("===Stats===");
        System.out.println("Health: " + stats[0]);
        System.out.println("Dexterity: " + stats[1]);
        System.out.println("Intelligence: " + stats[2]);
        System.out.println("Endurance: " + stats[3]);
        System.out.println("Strength: " + stats[4]);
        System.out.println("Faith: " + stats[5]);
        
        System.out.println("Confirm this character? (Y/N): ");
    
        String confirmation = input.nextLine().trim().toUpperCase();
        while (!"Y".equals(confirmation) && !"N".equals(confirmation)) {
            System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to redo character creation.");
            confirmation = input.nextLine().trim().toUpperCase();
        }
        if ("Y".equals(confirmation)) {
            System.out.print("\033\143");
            System.out.println("Character created successfully!");
            return true; // proceed to game lobby
        } else {
            System.out.print("\033\143");
            // Restart character creation process
            return createCharacter(input); // Optionally, you might want to reset nameSet and classSet instead of recursion
        }
    }    
    
    private void inputCharacterName(Scanner input) {
        System.out.print("\033\143"); // Clear the screen before showing the name input prompt
        System.out.println("========== Character Creation ==========");
        System.out.println("Enter character name (or type 'back' to return to the main menu): ");
        String nameInput = input.nextLine();
        if (!"back".equalsIgnoreCase(nameInput.trim())) {
            this.characterName = nameInput;
        } else {
            System.out.print("\033\143"); // Clear the screen if 'back' is chosen
        }
    }
    
    private void selectJobClass(Scanner input) {
        System.out.print("\033\143"); // Clear the screen before showing the job class selection
        System.out.println("========== Character Creation ==========");
        System.out.println("Select a job class (or type 'back' to return to the main menu)");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.printf("[%d] %s - Level: %s, Health: %s, Dexterity: %s, Intelligence: %s, Endurance: %s, Strength: %s, Faith: %s%n",
                              i + 1, characterClasses[i][0], characterClasses[i][1], characterClasses[i][2], characterClasses[i][3],
                              characterClasses[i][4], characterClasses[i][5], characterClasses[i][6], characterClasses[i][7]);
        }
        while (true) {
            String classInput = input.nextLine();
            if ("back".equalsIgnoreCase(classInput.trim())) {
                return; // User chose to go back without setting the job class
            }
            try {
                int classChoice = Integer.parseInt(classInput) - 1;
                if (classChoice >= 0 && classChoice < characterClasses.length) {
                    this.jobClass = characterClasses[classChoice][0];
                    setInitialStats(classChoice); // Initialize stats based on the chosen job class
                    return; // Job class set successfully
                } else {
                    System.out.println("Invalid choice. Please select a valid job class or type 'back'.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'back'.");
            }
        }
    }
        
    
    private void setInitialStats(int classIndex) {
        // Set the character's level based on the job class selected
        this.level = Integer.parseInt(characterClasses[classIndex][1]); // Update this line to set the level
    
        // Update the character's stats based on the job class selected
        for (int i = 0; i < stats.length; i++) {
            // The stats array starts from index 2 in the characterClasses definition,
            // so we add 2 to the index when fetching stat values.
            stats[i] = Integer.parseInt(characterClasses[classIndex][i + 2]);
        }
    }
    
    public void increaseStat(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            stats[statIndex - 1]++; // Increase the specified stat
        } else {
            System.out.println("Invalid stat choice."); // Handle invalid stat choice
        }
    }

    public int getStatValue(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            return stats[statIndex - 1]; // Return the value of the specified stat
        } else {
            System.out.println("Invalid stat index."); // Handle invalid stat index
            return -1; // Indicate an error
        }
    }

    public void addRunes(int additionalRunes) {
        this.runes += additionalRunes;
        System.out.println("Gained " + additionalRunes + " runes. Total now: " + this.runes);
    }

    public int getRunes() {
        return this.runes;
    }

    public void setRunes(int newRunes) {
        this.runes = newRunes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
}

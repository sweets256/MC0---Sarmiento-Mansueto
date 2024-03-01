import java.util.Scanner;

public class Character {
    private String characterName;
    private String jobClass;
    private int level = 1;
    private int runes = 0;
    private int[] stats = new int[6];
    private static final String[][] characterClasses = {
        
        {"Vagabond", "9", "15", "13", "9", "11", "14", "9"},
        {"Samurai", "9", "12", "15", "9", "13", "12", "8"},
        {"Warrior", "8", "11", "16", "10", "11", "10", "8"},
        {"Hero", "7", "14", "9", "7", "12", "16", "8"},
        {"Astrologer", "6", "9", "12", "16", "9", "8", "7"},
        {"Prophet", "7", "10", "10", "7", "8", "11", "16"}
    };
    
    /** 
     * @param milliseconds
     */
    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /** 
     * @param input
     * @return boolean
     */
    public boolean createCharacter(Scanner input) {
        boolean nameSet = false, classSet = false;
    
        while (!nameSet || !classSet) {
            System.out.print("\033\143");
            System.out.println("========== Character Creation ==========");
            System.out.println("Select the field you want to input:");
            System.out.println("[1] Character Name");
            System.out.println("[2] Job Class");
            System.out.println("Type 'back' at any time to return to the title screen.");
            System.out.print("Enter your choice: ");
    
            String choice = input.nextLine().trim();
            
            if ("back".equalsIgnoreCase(choice)) {
                System.out.print("\033\143");
                return false;
            }
    
            switch (choice) {
                case "1":
                    inputCharacterName(input);
                    nameSet = this.characterName != null && !this.characterName.isEmpty();
                    break;
                case "2":
                    selectJobClass(input);
                    classSet = this.jobClass != null && !this.jobClass.isEmpty();
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    pause(2000);
                    break;
            }
        }
        
        System.out.print("\033\143");
        System.out.println("========== Character Summary ==========");
        System.out.println("Character name: " + characterName);
        System.out.println("Job class: " + jobClass);
        System.out.println("Starting Level: " + level);
        System.out.println("\n===Stats===");
        System.out.println("Health: " + stats[0]);
        System.out.println("Dexterity: " + stats[1]);
        System.out.println("Intelligence: " + stats[2]);
        System.out.println("Endurance: " + stats[3]);
        System.out.println("Strength: " + stats[4]);
        System.out.println("Faith: " + stats[5]);
        
        System.out.print("\nConfirm this character? (Y/N): ");
    
        String confirmation = input.nextLine().trim().toUpperCase();
        while (!"Y".equals(confirmation) && !"N".equals(confirmation)) {
            System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to redo character creation.");
            confirmation = input.nextLine().trim().toUpperCase();
        }
        if ("Y".equals(confirmation)) {
            System.out.print("\033\143");
            System.out.println("Character created successfully!");
            pauseForMessage();
            System.out.print("\033\143");
            return true;
        } else {
            System.out.print("\033\143");
            return createCharacter(input);
        }
    }    
    
    /** 
     * @param input
     */
    private void inputCharacterName(Scanner input) {
        System.out.print("\033\143");
        System.out.println("========== Character Creation ==========");
        System.out.println("Enter character name (or type 'back' to return to the main menu): ");
        String nameInput = input.nextLine();
        if (!"back".equalsIgnoreCase(nameInput.trim())) {
            this.characterName = nameInput;
        } else {
            System.out.print("\033\143");
        }
    }
    
    /** 
     * @param input
     */
    private void selectJobClass(Scanner input) {
        System.out.print("\033\143");
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
                return;
            }
            try {
                int classChoice = Integer.parseInt(classInput) - 1;
                if (classChoice >= 0 && classChoice < characterClasses.length) {
                    this.jobClass = characterClasses[classChoice][0];
                    setInitialStats(classChoice);
                    return;
                } else {
                    System.out.println("Invalid choice. Please select a valid job class or type 'back'.");
                    pauseForMessage();
                    System.out.print("\033\143");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'back'.");
                pauseForMessage();
                System.out.print("\033\143");
            }
        }
    }
    
    /** 
     * @param classIndex
     */
    private void setInitialStats(int classIndex) {
        this.level = Integer.parseInt(characterClasses[classIndex][1]);
        for (int i = 0; i < stats.length; i++) {
            stats[i] = Integer.parseInt(characterClasses[classIndex][i + 2]);
        }
    }
    
    
    public void displayStats() {
        System.out.println("\n========== Character Stats ==========");
        System.out.println("Name: " + characterName);
        System.out.println("Job Class: " + jobClass);
        System.out.println("Level: " + level);
        System.out.println("Runes: " + runes);
        System.out.println("=====================================");
    }
    
    /** 
     * @param statIndex
     */
    public void increaseStat(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            stats[statIndex - 1]++;
        } else {
            System.out.println("Invalid stat choice.");
        }
    }
    
    /** 
     * @param statIndex
     * @return int
     */
    public int getStatValue(int statIndex) {
        if (statIndex >= 1 && statIndex <= stats.length) {
            return stats[statIndex - 1];
        } else {
            System.out.println("Invalid stat index.");
            return -1;
        }
    }
    
    /** 
     * @param additionalRunes
     */
    public void addRunes(int additionalRunes) {
        this.runes += additionalRunes;
        System.out.println("Gained " + additionalRunes + " runes. Total now: " + this.runes);
    }
    
    /** 
     * @return int
     */
    public int getRunes() {
        return this.runes;
    }
    
    /** 
     * @param newRunes
     */
    public void setRunes(int newRunes) {
        this.runes = newRunes;
    }
    
    /** 
     * @return int
     */
    public int getLevel() {
        return level;
    }
    
    /** 
     * @param newLevel
     */
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
    
    /** 
     * @return int
     */
    public int getCurrentHealth() {
        return 100 + (5 * stats[0]);
    }

    private static void pauseForMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

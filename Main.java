/**
 * This was made in requirement of our CCPROG3 major course output, MCO1.
 * This code is meant to run a game called "Elden Rouge", a 2-D text-based game based on "Elden Ring".
 * The code enables the player to traverse the game options by creating a character of their choice and 
 * selecting options in the game lobby to either fast travel or level up. The only accessible area for 
 * this phase of the project via fast travel is Area 1: Stormveil Castle, where the player will be able 
 * to encounter mobs and runes whilst exploring and interacting with the map. However, they will not be 
 * able to attack these mobs and will only be shown the mobs' name and health stat.
 * 
 * author               MANSUETO, Maria Alyssa S.
 * author               SARMIENTO, Abraham Iv M.
 * version              1.0
 * since                February 16, 2024
 * acknowledgement      https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20 (ASCII art)
 */


/**
 * The Main class serves as the entry point for the game application.
 * It initializes the game's navigation system and starts the game loop.
 */
public class Main {
    
    /**
     * The main method initializes the game's navigation system and starts the game loop.
     *
     * @param args
     */
    public static void main(String[] args) {
        TitleScreenView titleScreenView = new TitleScreenView();
        Navigation navigation = new Navigation();

        // Create controller and connect view with model
        new TitleController(titleScreenView, navigation);
    }
}
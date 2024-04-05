/**
 * This was made in requirement of our CCPROG3 major course output, MCO2.
 * This code is meant to run a game called "Elden Rouge", a game based on "Elden Ring".
 * The code enables the player to traverse the game options by creating a character of their choice and 
 * selecting options in the game lobby to either fast travel, level up, check their inventory, or buy weapons from the
 * Shop. All areas are accesible for this phase of the project via fast travel, in these areas the player will be able to 
 * encounter mobs and battle them as well as find runes whilst exploring and interacting with the map. 
 * However, for the GUI (general user interface) version of the game, the game will only function until the game lobby 
 * and it's subsequent screens such as level up, inventory and shop.
 * We will include both the completed 2-D text based version and the incomplete GUI version of the game in the package.
 * 
 * author               MANSUETO, Maria Alyssa S.
 * author               SARMIENTO, Abraham IV M.
 * version              2.0
 * since                February 16, 2024
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
        MainController mainController = new MainController();
    }
}
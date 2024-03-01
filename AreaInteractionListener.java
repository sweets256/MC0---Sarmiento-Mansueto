/**
 * The AreaInteractionListener interface defines methods for handling area interactions.
 * Implementing classes can listen for specific events triggered within the game area.
 */
public interface AreaInteractionListener {

    /**
     * Called when the player initiates fast travel within the area.
     */
    void onFastTravel();

    /**
     * Called when the player changes to a new area within the game.
     *
     * @param newArea the identifier of the new area
     */
    void onChangeArea(String newArea);
}
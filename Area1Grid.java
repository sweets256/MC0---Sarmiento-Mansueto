public class Area1Grid {

    public static String[][] createFloor(String[][] areaData) {
        return areaData;
    }

    public static void displayFloor(String[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Define map data for each floor using descriptive variable names
        String[][] floor1Data = {
            // D = DOOR, ? = INTERACTABLE TILE, F = FAST TRAVEL, B = BOSS
            {"W","|     |","|  D  |","|     |","W"},
            {"W","|  ?  |","|     |","|  ?  |","W"},
            {"W","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","W"},
            {"W","|     |","|  F  |","|     |","W"}
        };
        String[][] floor2Data = {
            // add code for making interactable tiles (?)
            {"W","|     |","|     |","|     |","|  D  |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|  ?  |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|  ?  |","|     |","|  ?  |","|  ?  |","|  ?  |","|     |","|  ?  |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|  ?  |","|     |","|  ?  |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|  D  |","|     |","|     |","|     |","W"},
        };
        String[][] floor3Data = {
            // add code for making interactable tiles (?)
            {"W","|     |","|     |","|  F  |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|  B  |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|     |","|     |","|     |","W"},
            {"W","|     |","|     |","|  D  |","|     |","|     |","W"},
        };

        // floors
        String[][] floor1 = createFloor(floor1Data);
        String[][] floor2 = createFloor(floor2Data);
        String[][] floor3 = createFloor(floor3Data);

        // floor to display
        String[][] currentFloor = floor1; // starting floor here

        // Print the chosen floor (aka starting floor muna)
        displayFloor(currentFloor);

        // implementation for teleportation between floors not included yet
    }
}
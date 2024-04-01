import javax.swing.*;
import java.awt.*;

public class Area1View extends JFrame {

    public Area1View() {
        setTitle("Map View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add panels for each floor
        tabbedPane.addTab("Floor 1", createMapPanel(floor1Data));
        tabbedPane.addTab("Floor 2", createMapPanel(floor2Data));
        tabbedPane.addTab("Floor 3", createMapPanel(floor3Data));

        add(tabbedPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to create a panel for a floor with given map data
    private JPanel createMapPanel(String[][] mapData) {
        JPanel mapPanel = new JPanel(new GridLayout(mapData.length, mapData[0].length));
        mapPanel.setPreferredSize(new Dimension(50 * mapData[0].length, 50 * mapData.length));

        for (String[] row : mapData) {
            for (String tile : row) {
                JLabel label = new JLabel(tile, SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mapPanel.add(label);
            }
        }

        return mapPanel;
    }

    // Sample map data
    private static String[][] floor1Data = {
            {"|     |", "|  D  |", "|     |"},
            {"|  ?  |", "|     |", "|  ?  |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|  F  |", "|     |"}
    };

    private static String[][] floor2Data = {
            {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|  ?  |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|  ?  |", "|     |", "|  ?  |", "|  ?  |", "|  ?  |", "|     |", "|  ?  |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"}
    };

    private static String[][] floor3Data = {
            {"|     |", "|     |", "|  F  |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|  B  |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|  D  |", "|     |", "|     |"}
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Area1View();
            }
        });
    }
}

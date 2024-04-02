import javax.swing.*;
import java.awt.*;

public class Area3View extends JFrame {

    public Area3View() {
        setTitle("Map View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Floor tabbed panes
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Floor 1", createMapPanel(floor1Data));
        tabbedPane.addTab("Floor 2", createMapPanel(floor2Data));
        tabbedPane.addTab("Floor 3", createMapPanel(floor3Data));

        // Player stats thing
        JPanel playerStatsPanel = createPlayerStatsPanel();

        // Split pane to divide frame into map view and player stats panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, playerStatsPanel);
        splitPane.setResizeWeight(0.875); // Map view occupies 7/8 of the width
        splitPane.setContinuousLayout(true);
        getContentPane().add(splitPane);

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

    // Create player stats panel method
    private JPanel createPlayerStatsPanel() {
        JPanel playerStatsPanel = new JPanel(new GridLayout(3, 1));
        playerStatsPanel.setPreferredSize(new Dimension(200, getHeight())); // Adjust width as needed

        JLabel titleLabel = new JLabel("Player Stats", SwingConstants.CENTER);
        playerStatsPanel.add(titleLabel);

        // Create and add player stats labels
        String[] statLabels = {"Health:", "Level:", "Runes:"};
        for (String label : statLabels) {
            JLabel statLabel = new JLabel(label, SwingConstants.CENTER);
            playerStatsPanel.add(statLabel);
        }

        return playerStatsPanel;
    }

    // Map data
    private static String[][] floor1Data = {
            {"|     |", "|  D  |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|  ?  |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |"},
            {"|     |", "|  F  |", "|     |"}
    };

    private static String[][] floor2Data = {
            {"|  X  |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|  X  |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|  B  |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|  X  |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|  X  |"}
    };

    private static String[][] floor3Data = {
            {"|     |", "|  C  |", "|     |",},
            {"|  ?  |", "|     |", "|  ?  |",},
            {"|     |", "|     |", "|     |",},
            {"|  ?  |", "|     |", "|  ?  |",},
            {"|     |", "|     |", "|     |",},
            {"|  ?  |", "|     |", "|  ?  |",},
            {"|     |", "|     |", "|     |",},
            {"|  ?  |", "|     |", "|  ?  |",},
            {"|     |", "|  D  |", "|     |",}
    };
}

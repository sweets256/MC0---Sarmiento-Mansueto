import javax.swing.*;
import java.awt.*;

public class Area1View extends JFrame {
    // Define player stats labels
    private JLabel healthLabel;
    private JLabel levelLabel;
    private JLabel runesLabel;

    public Area1View() {
        setTitle("Area 1 View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create tabbed pane for floors
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Floor 1", createMapPanel(floor1Data));
        tabbedPane.addTab("Floor 2", createMapPanel(floor2Data));
        tabbedPane.addTab("Floor 3", createMapPanel(floor3Data));

        // Create player stats panel
        JPanel playerStatsPanel = createPlayerStatsPanel();

        // Create split pane to divide frame into map view and player stats panel
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

    // Method to create player stats panel
    private JPanel createPlayerStatsPanel() {
        JPanel playerStatsPanel = new JPanel(new GridLayout(4, 1));
        playerStatsPanel.setPreferredSize(new Dimension(200, getHeight())); // Adjust width as needed

        // Create and add player stats labels
        healthLabel = new JLabel("Health: ");
        levelLabel = new JLabel("Level: ");
        runesLabel = new JLabel("Runes: ");

        playerStatsPanel.add(new JLabel("Player Stats", SwingConstants.CENTER));
        playerStatsPanel.add(healthLabel);
        playerStatsPanel.add(levelLabel);
        playerStatsPanel.add(runesLabel);

        return playerStatsPanel;
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

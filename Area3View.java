import javax.swing.*;
import java.awt.*;

public class Area3View extends JFrame {

    public Area3View() {
        setTitle("Map View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panels for map and player stats
        JPanel mapPanel = createMapPanel(floor1Data); // Displaying floor1Data by default
        JPanel playerStatsPanel = createPlayerStatsPanel();

        // Set the size of playerStatsPanel to occupy 1/8th of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int playerStatsWidth = screenSize.width / 8;
        playerStatsPanel.setPreferredSize(new Dimension(playerStatsWidth, screenSize.height));

        // Create a split pane to display map and player stats side by side
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapPanel, playerStatsPanel);
        splitPane.setResizeWeight(0.875); // Map panel occupies 7/8ths of the screen

        add(splitPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to create a panel for a floor with given map data
    private JPanel createMapPanel(String[][] mapData) {
        JPanel mapPanel = new JPanel(new GridLayout(mapData.length, mapData[0].length));
        mapPanel.setPreferredSize(new Dimension(7 * 50 * mapData[0].length / 8, 50 * mapData.length));

        for (String[] row : mapData) {
            for (String tile : row) {
                JLabel label = new JLabel(tile, SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mapPanel.add(label);
            }
        }

        return mapPanel;
    }

    // Method to create a panel for player stats
    private JPanel createPlayerStatsPanel() {
        JPanel playerStatsPanel = new JPanel(new GridLayout(3, 1));
        playerStatsPanel.setBackground(Color.LIGHT_GRAY);

        JLabel healthLabel = new JLabel("Health: ");
        healthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerStatsPanel.add(healthLabel);

        JLabel levelLabel = new JLabel("Level: ");
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerStatsPanel.add(levelLabel);

        JLabel runesLabel = new JLabel("Runes: ");
        runesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerStatsPanel.add(runesLabel);

        return playerStatsPanel;
    }

    // Sample map data
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Area3View();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;

/**
 * The view class for Area 3.
 */
public class Area3View extends JFrame {

    /**
     * Constructs an Area3View.
     */
    public Area3View() {
        setTitle("Map View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Floor 1", createMapPanel(floor1Data));
        tabbedPane.addTab("Floor 2", createMapPanel(floor2Data));
        tabbedPane.addTab("Floor 3", createMapPanel(floor3Data));

        JPanel playerStatsPanel = createPlayerStatsPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, playerStatsPanel);
        splitPane.setResizeWeight(0.875);
        splitPane.setContinuousLayout(true);
        getContentPane().add(splitPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates a panel displaying the map.
     * 
     * @param mapData The data representing the map.
     * @return A panel displaying the map.
     */
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

    /**
     * Creates a panel displaying player stats.
     * 
     * @return A panel displaying player stats.
     */
    private JPanel createPlayerStatsPanel() {
        JPanel playerStatsPanel = new JPanel(new GridLayout(3, 1));
        playerStatsPanel.setPreferredSize(new Dimension(200, getHeight()));

        JLabel titleLabel = new JLabel("Player Stats", SwingConstants.CENTER);
        playerStatsPanel.add(titleLabel);

        String[] statLabels = {"Health:", "Level:", "Runes:"};
        for (String label : statLabels) {
            JLabel statLabel = new JLabel(label, SwingConstants.CENTER);
            playerStatsPanel.add(statLabel);
        }

        return playerStatsPanel;
    }

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

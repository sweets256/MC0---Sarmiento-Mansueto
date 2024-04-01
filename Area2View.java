import javax.swing.*;
import java.awt.*;

public class Area2View extends JFrame {

    public Area2View() {
        setTitle("Map View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add panels for each floor
        tabbedPane.addTab("Floor 1", createMapPanel(floor1Data));
        tabbedPane.addTab("Floor 2", createMapPanel(floor2Data));
        tabbedPane.addTab("Floor 3", createMapPanel(floor3Data));
        tabbedPane.addTab("Floor 4", createMapPanel(floor4Data));
        tabbedPane.addTab("Floor 5", createMapPanel(floor5Data));

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
            {"|     |", "|     |", "|  F  |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
            {"|     |", "|     |", "|  D  |", "|     |", "|     |"}
    };

    private static String[][] floor2Data = {
            {"|     |", "|  D  |", "|     |",},
            {"|  ?  |", "|     |", "|     |",},
            {"|     |", "|     |", "|     |",},
            {"|  ?  |", "|     |", "|  D  |",},
            {"|     |", "|     |", "|     |",},
            {"|  ?  |", "|     |", "|     |",},
            {"|     |", "|     |", "|     |",}
    };

    private static String[][] floor3Data = {
            {"|  X  |", "|     |", "|  D  |", "|     |", "|  X  |"},
            {"|  X  |", "|     |", "|  ?  |", "|     |", "|  X  |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|  D  |", "|     |", "|     |", "|     |", "|  D  |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|  X  |", "|     |", "|  ?  |", "|     |", "|  X  |"},
            {"|  X  |", "|     |", "|     |", "|     |", "|  X  |"}
    };

    private static String[][] floor4Data = {
            {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
            {"|  D  |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"}
    };

    private static String[][] floor5Data = {
            {"|  X  |", "|  X  |", "|     |", "|  F  |", "|     |", "|  X  |", "|  X  |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|  ?  |", "|     |", "|  ?  |", "|     |", "|  ?  |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|  ?  |", "|     |", "|  B  |", "|     |", "|  ?  |", "|     |"},
            {"|     |", "|     |", "|     |", "|     |", "|     |", "|     |", "|     |"},
            {"|     |", "|  ?  |", "|     |", "|     |", "|     |", "|  ?  |", "|     |"},
            {"|     |", "|     |", "|     |", "|  D  |", "|     |", "|     |", "|     |"}
    };


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Area2View();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The view class for Area 1.
 */
public class Area1View extends JFrame implements ActionListener{
    private JLabel healthLabel;
    private JLabel levelLabel;
    private JLabel runesLabel;
    private JButton backButton;
    private AreaController controller;

    /**
     * Constructs an Area1View.
     */
    public Area1View(AreaController controller) {

        this.controller = controller;

        setTitle("Area 1 View");
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
        addButtonListener();
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
        JPanel playerStatsPanel = new JPanel(new GridLayout(4, 1));
        playerStatsPanel.setPreferredSize(new Dimension(200, getHeight()));

        healthLabel = new JLabel("Health: ");
        levelLabel = new JLabel("Level: ");
        runesLabel = new JLabel("Runes: ");

        playerStatsPanel.add(new JLabel("Player Stats", SwingConstants.CENTER));
        playerStatsPanel.add(healthLabel);
        playerStatsPanel.add(levelLabel);
        playerStatsPanel.add(runesLabel);

        backButton = new JButton("Back");
        playerStatsPanel.add(backButton);

        return playerStatsPanel;
    }

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

    /**
     * Handles actionPerformed event for the buttons.
     *
     * @param e The ActionEvent generated.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        } 
    }

    /**
     * Adds ActionListener to the buttons.
     */
    public void addButtonListener(){
        backButton.addActionListener(this);
    }

    /**
     * Shows or hides the view.
     *
     * @param state If true, the view is visible; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        setVisible(state);
    }
}

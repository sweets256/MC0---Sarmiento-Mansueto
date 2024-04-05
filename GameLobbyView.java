import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The GameLobbyView class represents the graphical user interface for the game lobby.
 * It displays buttons for various game functions and information about the character.
 */
public class GameLobbyView extends JFrame {
    private JLabel titleLabel;
    private JButton fastTravelButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton shopButton;
    private JButton exitButton;
    private GameLobbyController controller;

    /**
     * Constructs a new GameLobbyView with the specified controller.
     *
     * @param controller The GameLobbyController associated with this view.
     */
    public GameLobbyView(GameLobbyController controller) {
        this.controller = controller;

        setTitle("Game Lobby");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Game Lobby", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 100, 20, 100));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.CENTER);

        fastTravelButton = new JButton("Fast Travel");
        fastTravelButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(fastTravelButton);

        levelUpButton = new JButton("Level Up");
        levelUpButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(levelUpButton);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(inventoryButton);

        shopButton = new JButton("Shop");
        shopButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(shopButton);

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(exitButton);

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200, getHeight()));
        sidePanel.setBackground(Color.LIGHT_GRAY);
        sidePanel.setLayout(new GridLayout(0, 1));
        ArrayList<String> CharInfo = controller.getCharInfo();
        for (String info : CharInfo){
            JLabel label = new JLabel(info);
            label.setHorizontalAlignment(JLabel.CENTER);
            sidePanel.add(label);
        }
        add(sidePanel, BorderLayout.WEST);

        setLocationRelativeTo(null);
        showView(false);
    }

    /**
     * Method to add action listener to the fast travel button
     *
     */
    public void addFastTravelButtonListener(ActionListener listener) {
        fastTravelButton.addActionListener(listener);
    }

    /**
     * Method to add action listener to the level up button
     *
     */
    public void addLevelUpButtonListener(ActionListener listener) {
        levelUpButton.addActionListener(listener);
    }

    /**
     * Method to add action listener to the inventory button
     *
     */
    public void addInventoryButtonListener(ActionListener listener) {
        inventoryButton.addActionListener(listener);
    }

    /**
     * Method to add action listener to the shop button
     *
     */
    public void addShopButtonListener(ActionListener listener) {
        shopButton.addActionListener(listener);
    }

    /**
     * Method to add action listener to the exit button
     *
     */
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    /**
     * Displays or hides the view.
     *
     * @param state If true, the view is visible; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        setVisible(state);
    }
}

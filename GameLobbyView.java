import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class GameLobbyView extends JFrame {
    private JLabel titleLabel;
    private JButton fastTravelButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton shopButton;
    private JButton exitButton;

    public GameLobbyView() {
        setTitle("Game Lobby");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Game Lobby", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 100, 20, 100)); // Add padding
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 100, 20, 100)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and center fast travel button
        fastTravelButton = new JButton("Fast Travel");
        fastTravelButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(fastTravelButton);

        // Create and center level up button
        levelUpButton = new JButton("Level Up");
        levelUpButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(levelUpButton);

        // Create and center inventory button
        inventoryButton = new JButton("Inventory");
        inventoryButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(inventoryButton);

        // Create and center shop button
        shopButton = new JButton("Shop");
        shopButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(shopButton);

        // Create and center exit button
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(exitButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class LevelUpView extends JFrame {
    private JLabel titleLabel;
    private JButton chooseStatButton;
    private JButton exitButton;
    private JPanel newStatsPanel;

    public LevelUpView() {
        setTitle("Level Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Level Up", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170)); // Add padding
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and center choose stat button
        chooseStatButton = new JButton("Choose Stat to Level Up");
        chooseStatButton.setFont(new Font("Arial", Font.BOLD, 30));
        chooseStatButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(chooseStatButton);

        // Create and center exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(180, 30)); // Set preferred size
        buttonPanel.add(exitButton);

        // Create new stats panel
        newStatsPanel = new JPanel();
        newStatsPanel.setLayout(new BorderLayout());
        JLabel newStatsLabel = new JLabel("New Stats", SwingConstants.CENTER);
        newStatsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newStatsPanel.add(newStatsLabel, BorderLayout.NORTH);
        // Add any additional components for new stats panel here

        // Add new stats panel but make it invisible initially
        newStatsPanel.setVisible(false);
        add(newStatsPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LevelUpView();
            }
        });
    }
   
}

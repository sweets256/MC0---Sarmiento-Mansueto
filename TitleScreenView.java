import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TitleScreenView extends JFrame {
    private JLabel titleLabel; // Added titleLabel field
    private JButton startButton;
    private JButton exitButton;

    public TitleScreenView() {
        setTitle("Elden Rogue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and center start button
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(startButton);

        // Create and center exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(exitButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Test the view
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TitleScreenView();
            }
        });
    }
}

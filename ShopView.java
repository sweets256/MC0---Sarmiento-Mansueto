import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShopView extends JFrame {
    private JLabel titleLabel;
    private JLabel playerRunesLabel;
    private JButton[] shopButtons;

    public ShopView() {
        setTitle("Shop");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Shop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 10, 10)); // 6 rows, 4 columns, with 10px horizontal and vertical gap
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create buttons array
        shopButtons = new JButton[24];
        for (int i = 0; i < 24; i++) {
            // Create button with image icon
            shopButtons[i] = new JButton(new ImageIcon("image_" + (i + 1) + ".png"));
            buttonPanel.add(shopButtons[i]); // Add button to panel
        }

        // Create and add player runes label
        playerRunesLabel = new JLabel("Player Runes: ", SwingConstants.CENTER);
        add(playerRunesLabel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Test the view
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShopView();
            }
        });
    }
}

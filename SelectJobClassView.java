import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SelectJobClassView extends JFrame {
    private JLabel titleLabel;
    private JButton vagabondButton;
    private JButton samuraiButton;
    private JButton warriorButton;
    private JButton heroButton;
    private JButton astrologerButton;
    private JButton prophetButton;

    public SelectJobClassView() {
        setTitle("Select Job Class");
        setSize(600, 400); // Adjusted size for better visibility of buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Select Job Class", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns, with 10px horizontal and vertical gap
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and add buttons
        vagabondButton = new JButton("Vagabond", new ImageIcon("vagabond_image.png"));
        samuraiButton = new JButton("Samurai", new ImageIcon("samurai_image.png"));
        warriorButton = new JButton("Warrior", new ImageIcon("warrior_image.png"));
        heroButton = new JButton("Hero", new ImageIcon("hero_image.png"));
        astrologerButton = new JButton("Astrologer", new ImageIcon("astrologer_image.png"));
        prophetButton = new JButton("Prophet", new ImageIcon("prophet_image.png"));

        // Add buttons to the panel
        buttonPanel.add(vagabondButton);
        buttonPanel.add(samuraiButton);
        buttonPanel.add(warriorButton);
        buttonPanel.add(heroButton);
        buttonPanel.add(astrologerButton);
        buttonPanel.add(prophetButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SelectJobClassView();
            }
        });
    }
}

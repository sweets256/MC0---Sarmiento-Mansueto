import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BattleView extends JFrame {
    private JLabel titleLabel;
    private JLabel playerSpriteLabel;
    private JLabel enemySpriteLabel;
    private JTextArea systemMessagesTextArea;
    private JComboBox<String> attackTypeComboBox;
    private JButton dodgeButton;

    public BattleView() {
        setTitle("Battle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Battle has commenced!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for top fields
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(20, 20, 10, 20)); // Add padding
        add(topPanel, BorderLayout.CENTER);

        // Create and add player sprite label
        playerSpriteLabel = new JLabel(new ImageIcon("playersprite_image.png"));
        topPanel.add(playerSpriteLabel, BorderLayout.EAST);

        // Create and add enemy sprite label
        enemySpriteLabel = new JLabel(new ImageIcon("enemysprite_image.png"));
        topPanel.add(enemySpriteLabel, BorderLayout.WEST);

        // Create panel for bottom fields
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with 10px horizontal and vertical gap
        bottomPanel.setBorder(new EmptyBorder(10, 20, 20, 20)); // Add padding
        add(bottomPanel, BorderLayout.SOUTH);

        // Create and add system messages text area
        systemMessagesTextArea = new JTextArea();
        systemMessagesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(systemMessagesTextArea);
        bottomPanel.add(scrollPane);

        // Create and add attack type combo box
        String[] attackTypes = {"Physical Damage", "Sorcery Damage", "Incantation Damage"};
        attackTypeComboBox = new JComboBox<>(attackTypes);
        bottomPanel.add(attackTypeComboBox);

        // Create and add dodge button
        dodgeButton = new JButton("Dodge");
        bottomPanel.add(dodgeButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Test the view
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BattleView();
            }
        });
    }
}

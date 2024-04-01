import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryView extends JFrame {
    private JLabel titleLabel;
    private JLabel equippedWeaponLabel;
    private JLabel weaponLabel;
    private JTextArea characterWeaponsArea; // Field to display character's weapons
    private JButton backButton; // Back button

    public InventoryView() {
        setTitle("Inventory");
        setSize(400, 350); // Increased height to accommodate the back button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Inventory", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for fields with padding
        JPanel fieldPanel = new JPanel(new GridLayout(3, 1, 0, 5));
        fieldPanel.setBorder(new EmptyBorder(10, 50, 10, 50)); // Add padding
        add(fieldPanel, BorderLayout.CENTER);

        // Create and add equipped weapon label
        equippedWeaponLabel = new JLabel("Equipped Weapon ");
        fieldPanel.add(equippedWeaponLabel);

        // Create and add weapon label
        weaponLabel = new JLabel("Weapon: ");
        fieldPanel.add(weaponLabel);

        // Create and add character's weapons area
        characterWeaponsArea = new JTextArea();
        characterWeaponsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(characterWeaponsArea);
        fieldPanel.add(scrollPane);

        // Create panel for back button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InventoryView();
            }
        });
    }
}

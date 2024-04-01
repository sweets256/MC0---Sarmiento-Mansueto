import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryView extends JFrame {
    private JLabel titleLabel;
    private JLabel weaponLabel;
    private JTextField chooseWeaponTextField;
    private JButton confirmButton;
    private JTextArea characterWeaponsArea; // Field to display character's weapons
    private JButton backButton; // Back button

    public InventoryView() {
        setTitle("Inventory");
        setSize(400, 400); // Adjusted height to accommodate new components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Inventory", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for fields with padding
        JPanel fieldPanel = new JPanel(new GridLayout(4, 1));
        fieldPanel.setBorder(new EmptyBorder(10, 50, 10, 50)); // Add padding
        add(fieldPanel, BorderLayout.CENTER);

        // Create and add weapon label
        weaponLabel = new JLabel("Current Weapon: ");
        fieldPanel.add(weaponLabel);

        // Create panel for choosing a weapon to equip
        JPanel chooseWeaponPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.add(chooseWeaponPanel);

        // Create label for "Choose a weapon to equip"
        JLabel chooseWeaponLabel = new JLabel("Choose a weapon to equip: ");
        chooseWeaponPanel.add(chooseWeaponLabel);

        // Create text field for choosing a weapon
        chooseWeaponTextField = new JTextField(15); // Set columns to limit the width
        chooseWeaponPanel.add(chooseWeaponTextField);

        // Create confirm button
        confirmButton = new JButton("Confirm");
        chooseWeaponPanel.add(confirmButton);

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

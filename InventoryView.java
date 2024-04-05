import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The InventoryView class represents the graphical user interface
 * for the inventory screen.
 */
public class InventoryView extends JFrame {
    private JLabel titleLabel;
    private JLabel weaponLabel;
    private JTextField chooseWeaponTextField;
    private JButton confirmButton;
    private JTextArea characterWeaponsArea;
    private JButton backButton;
    private JLabel currentWeaponText;

    /**
     * Constructs an InventoryView object.
     */
    public InventoryView() {
        setTitle("Inventory");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Inventory", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel fieldPanel = new JPanel(new GridLayout(4, 1));
        fieldPanel.setBorder(new EmptyBorder(10, 50, 10, 50));
        add(fieldPanel, BorderLayout.CENTER);

        weaponLabel = new JLabel("Current Weapon: ");
        fieldPanel.add(weaponLabel);

        currentWeaponText = new JLabel("pweter!");
        fieldPanel.add(currentWeaponText);

        JPanel chooseWeaponPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.add(chooseWeaponPanel);

        JLabel chooseWeaponLabel = new JLabel("Choose a weapon to equip: ");
        chooseWeaponPanel.add(chooseWeaponLabel);

        chooseWeaponTextField = new JTextField(15);
        chooseWeaponPanel.add(chooseWeaponTextField);

        confirmButton = new JButton("Confirm");
        chooseWeaponPanel.add(confirmButton);

        characterWeaponsArea = new JTextArea();
        characterWeaponsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(characterWeaponsArea);
        fieldPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        showView(false);

        addListeners();
    }

    /**
     * Adds action listeners to the buttons.
     */
    private void addListeners() {
        confirmButton.addActionListener(e -> onConfirmButtonClicked());
        backButton.addActionListener(e -> onBackButtonClicked());
    }

    /**
     * Handles when the confrim button is clicked.
     */
    private void onConfirmButtonClicked() {
        // Add ction for confirm button
        dispose();
    }

    /**
     * Handles when the back button is clicked.
     */
    private void onBackButtonClicked() {
        // Add action for back button
        dispose();
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

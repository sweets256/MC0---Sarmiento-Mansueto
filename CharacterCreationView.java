import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterCreationView extends JFrame {
    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton selectJobClassButton;
    private JButton confirmCharacterButton;
    private CharacterCreationController controller;

    public CharacterCreationView(CharacterCreationController controller) {

        this.controller = controller;

        setTitle("Character Creation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Character Creation", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for components with padding
        JPanel componentPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        componentPanel.setBorder(new EmptyBorder(20, 100, 20, 100)); // Add padding
        add(componentPanel, BorderLayout.CENTER);

        // Create and center text field with label and button
        JPanel namePanel = new JPanel(new BorderLayout());
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameTextField = new JTextField();
        namePanel.add(new JLabel("Name: "), BorderLayout.WEST);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        JButton enterButton = new JButton("Enter");
        namePanel.add(enterButton, BorderLayout.EAST);
        componentPanel.add(namePanel);

        // Create and center select job class button
        selectJobClassButton = new JButton("Select Job Class");
        selectJobClassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        componentPanel.add(selectJobClassButton);

        // Create and center confirm character button
        confirmCharacterButton = new JButton("Confirm Character Created");
        confirmCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        componentPanel.add(confirmCharacterButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        //setVisible(true);
    }

    public void showView(Boolean state) {
        setVisible(state);
    }

    // Method to add listener for confirm character button
    public void addConfirmCharacterButtonListener(ActionListener listener) {
        confirmCharacterButton.addActionListener(listener);
    }

    // Method to add listener for select job class button
    public void addSelectJobClassButtonListener(ActionListener listener) {
        selectJobClassButton.addActionListener(listener);
    }

    // Method to add listener for name text field
    public void addNameTextFieldListener(ActionListener listener) {
        nameTextField.addActionListener(listener);
    }
}

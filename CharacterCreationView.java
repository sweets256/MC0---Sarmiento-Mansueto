import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreationView extends JFrame {
    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton selectJobClassButton;
    private JButton confirmCharacterButton;

    public CharacterCreationView() {
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
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for enter button here
            }
        });
        namePanel.add(enterButton, BorderLayout.EAST);
        componentPanel.add(namePanel);

        // Create and center select job class button
        selectJobClassButton = new JButton("Select Job Class");
        selectJobClassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectJobClassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for select job class button here
            }
        });
        componentPanel.add(selectJobClassButton);

        // Create and center confirm character button
        confirmCharacterButton = new JButton("Confirm Character Created");
        confirmCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmCharacterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for confirm character button here
            }
        });
        componentPanel.add(confirmCharacterButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

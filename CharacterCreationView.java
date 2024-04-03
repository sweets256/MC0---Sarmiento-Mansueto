import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterCreationView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTextField nameTextField;
    private JButton selectJobClassButton;
    private JButton confirmCharacterButton;
    private JPanel jobClassPanel;
    private JButton vagabondButton;
    private JButton samuraiButton;
    private JButton warriorButton;
    private JButton heroButton;
    private JButton astrologerButton;
    private JButton prophetButton;
    private ImageIcon vagabondIcon;
    private ImageIcon samuraiIcon;
    private ImageIcon warriorIcon;
    private ImageIcon heroIcon;
    private ImageIcon astrologerIcon;
    private ImageIcon prophetIcon;
    private String selectedClass;
    private CharacterCreationController controller;

    public CharacterCreationView(CharacterCreationController controller) {
        this.controller = controller;

        setTitle("Character Creation");
        setSize(800, 600); // Adjusted size to accommodate both panels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Character Creation", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for components with padding
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding
        add(mainPanel, BorderLayout.CENTER);

        // Create panel for character creation components
        JPanel charCreationPanel = new JPanel(new BorderLayout());
        charCreationPanel.setBorder(new EmptyBorder(0, 0, 20, 0)); // Add padding to the bottom
        mainPanel.add(charCreationPanel, BorderLayout.NORTH);

        // Create and center text field with label and button
        JPanel namePanel = new JPanel(new BorderLayout());
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameTextField = new JTextField();
        namePanel.add(new JLabel("Name: "), BorderLayout.WEST);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        charCreationPanel.add(namePanel, BorderLayout.NORTH);

        // Create and center select job class button
        selectJobClassButton = new JButton("Select Job Class");
        selectJobClassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        charCreationPanel.add(selectJobClassButton, BorderLayout.CENTER);

        // Create and center confirm character button
        confirmCharacterButton = new JButton("Confirm Character Created");
        confirmCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmCharacterButton.setEnabled(false);
        charCreationPanel.add(confirmCharacterButton, BorderLayout.SOUTH);

        // Create panel for job class buttons
        jobClassPanel = new JPanel(new GridLayout(2, 3, 100, 100)); // 2 rows, 3 columns, with 100px horizontal and vertical gap
        jobClassPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Add padding to the top
        jobClassPanel.setVisible(false); // Initially hide the job class panel
        mainPanel.add(jobClassPanel, BorderLayout.CENTER);

        // Load image icons
        vagabondIcon = new ImageIcon("vagabond.png");
        samuraiIcon = new ImageIcon("samurai.png");
        warriorIcon = new ImageIcon("warrior.png");
        heroIcon = new ImageIcon("hero.png");
        astrologerIcon = new ImageIcon("astrologer.png");
        prophetIcon = new ImageIcon("prophet.png");

        // Create and add buttons
        vagabondButton = createImageButton(vagabondIcon, "Vagabond");
        jobClassPanel.add(vagabondButton);
        
        samuraiButton = createImageButton(samuraiIcon, "Samurai");
        jobClassPanel.add(samuraiButton);
        
        warriorButton = createImageButton(warriorIcon, "Warrior");
        jobClassPanel.add(warriorButton);
        
        heroButton = createImageButton(heroIcon, "Hero");
        jobClassPanel.add(heroButton);
        
        astrologerButton = createImageButton(astrologerIcon, "Astrologer");
        jobClassPanel.add(astrologerButton);
        
        prophetButton = createImageButton(prophetIcon, "Prophet");
        jobClassPanel.add(prophetButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        addButtonListener(); 
        setVisible(false);
    }

    private JButton createImageButton(ImageIcon icon, String buttonText) {
        JButton button = new JButton(icon);
        button.setText("");
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        button.setContentAreaFilled(false); // Make the button transparent
        button.setBorderPainted(false); // Remove the border
        button.addActionListener(this); // Add ActionListener
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmCharacterButton){
            controller.retrieveAndSend(nameTextField.getText(), selectedClass);
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        } else if (e.getSource() == selectJobClassButton){
            showJobClassPanel(true); // Show job class panel
        } else if (e.getSource() == vagabondButton || e.getSource() == samuraiButton ||
                   e.getSource() == warriorButton || e.getSource() == heroButton ||
                   e.getSource() == astrologerButton || e.getSource() == prophetButton) {
            JButton clickedButton = (JButton)e.getSource();
            String buttonText = clickedButton.getText();
            switch (buttonText){
                case "Vagabond":
                    selectedClass = "1";
                    break;
                case "Samurai":
                    selectedClass = "2";
                    break;
                case "Warrior":
                    selectedClass = "3";
                    break;
                case "Hero":
                    selectedClass = "4";
                    break;
                case "Astrologer":
                    selectedClass = "5";
                    break;
                case "Prophet":
                    selectedClass = "6";
                    break;
                default:
                    selectedClass = "0";
                    break;
            }
            showJobClassPanel(false);
            controller.finishProcess("CHAR_CREATION");
            checkFields();
        }
    }

    private void checkFields(){
        if (!nameTextField.getText().isEmpty() && selectedClass != null){
            confirmCharacterButton.setEnabled(true);
        } else{
            confirmCharacterButton.setEnabled(false);
        }
    }

    public void addButtonListener(){
        confirmCharacterButton.addActionListener(this);
        selectJobClassButton.addActionListener(this);
    }

    public void showView(Boolean state){
        setVisible(state);
    }

    public void showJobClassPanel(boolean state) {
        jobClassPanel.setVisible(state);
    }
}

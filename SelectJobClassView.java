import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectJobClassView extends JFrame implements ActionListener{
    private JLabel titleLabel;
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
    private SelectJobClassController controller;

    public SelectJobClassView(SelectJobClassController controller) {

        this.controller = controller;

        setTitle("Select Job Class");
        setSize(600, 400); // Adjusted size for better visibility of buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        

        // Create and center the title label
        titleLabel = new JLabel("Select Job Class", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 100, 100)); // 2 rows, 3 columns, with 100px horizontal and vertical gap
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Load and resize image icons
        vagabondIcon = resizeImageIcon("vagabond.png", 150, 150);
        samuraiIcon = resizeImageIcon("samurai.png", 150, 150);
        warriorIcon = resizeImageIcon("warrior.png", 150, 150);
        heroIcon = resizeImageIcon("hero.png", 150, 150);
        astrologerIcon = resizeImageIcon("astrologer.png", 150, 150);
        prophetIcon = resizeImageIcon("prophet.png", 150, 150);

        // Create and add buttons
        JButton vagabondButton = createImageButton(vagabondIcon);
        buttonPanel.add(vagabondButton);
        
        JButton samuraiButton = createImageButton(samuraiIcon);
        buttonPanel.add(samuraiButton);
        
        JButton warriorButton = createImageButton(warriorIcon);
        buttonPanel.add(warriorButton);
        
        JButton heroButton = createImageButton(heroIcon);
        buttonPanel.add(heroButton);
        
        JButton astrologerButton = createImageButton(astrologerIcon);
        buttonPanel.add(astrologerButton);
        
        JButton prophetButton = createImageButton(prophetIcon);
        buttonPanel.add(prophetButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        showView(true);
        addButtonListener(); 
    }

    private JButton createImageButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setText(null); // Set text to null to remove it
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        button.setContentAreaFilled(false); // Make the button transparent
        button.setBorderPainted(false); // Remove the border
        return button;
    }

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    // Method to add listener for Vagabond button
    public void addVagabondButtonListener(ActionListener listener) {
        JButton vagabondButton = (JButton) getContentPane().getComponent(0);
        vagabondButton.addActionListener(listener);

        setVisible(false);
        controller.finishProcess("CHAR_CREATION");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vagabondButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == samuraiButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == warriorButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == heroButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == astrologerButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == prophetButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        }
    }

    public void addButtonListener(){
        vagabondButton.addActionListener(this);
        samuraiButton.addActionListener(this);
        warriorButton.addActionListener(this);
        heroButton.addActionListener(this);
        astrologerButton.addActionListener(this);
        prophetButton.addActionListener(this);
    }

    public void showView(Boolean state){
        setVisible(state);
    }
}

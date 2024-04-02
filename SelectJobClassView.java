import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectJobClassView extends JFrame implements ActionListener {
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
        setSize(600, 400);
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

        // Load image icons
        vagabondIcon = new ImageIcon("vagabond.png");
        samuraiIcon = new ImageIcon("samurai.png");
        warriorIcon = new ImageIcon("warrior.png");
        heroIcon = new ImageIcon("hero.png");
        astrologerIcon = new ImageIcon("astrologer.png");
        prophetIcon = new ImageIcon("prophet.png");

        // Create and add buttons
        vagabondButton = createImageButton(vagabondIcon);
        buttonPanel.add(vagabondButton);
        
        samuraiButton = createImageButton(samuraiIcon);
        buttonPanel.add(samuraiButton);
        
        warriorButton = createImageButton(warriorIcon);
        buttonPanel.add(warriorButton);
        
        heroButton = createImageButton(heroIcon);
        buttonPanel.add(heroButton);
        
        astrologerButton = createImageButton(astrologerIcon);
        buttonPanel.add(astrologerButton);
        
        prophetButton = createImageButton(prophetIcon);
        buttonPanel.add(prophetButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        addButtonListener(); 
        setVisible(true);
    }

    private JButton createImageButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        button.setContentAreaFilled(false); // Make the button transparent
        button.setBorderPainted(false); // Remove the border
        button.addActionListener(this); // Add ActionListener
        return button;
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
        // No need to add listeners here as they are added in createImageButton method
    }

    public void showView(Boolean state){
        setVisible(state);
    }
}

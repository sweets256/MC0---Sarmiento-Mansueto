import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectJobClassView extends JFrame {
    private JLabel titleLabel;
    private ImageIcon vagabondIcon;
    private ImageIcon samuraiIcon;
    private ImageIcon warriorIcon;
    private ImageIcon heroIcon;
    private ImageIcon astrologerIcon;
    private ImageIcon prophetIcon;

    public SelectJobClassView() {
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

        /* Make sure the images are in the directory which the program is being loaded 
        from or just copy the direct path but make sure to use double back slashes "\\" when typing the path
        example: "D:\\School Stuff\\CCPROG3\\Github\\MC01 - DUWAHUIDH\\vagabond.png" <- please use this exact formatting
        "D:\\School Stuff\\CCPROG3\\Github\\MC01 - DUWAHUIDH" being the directory.
        Cannot upload files directly to github repository as the directory which the program is being run from is the file containing
        the repository but not the repository itself.
        */

        // Will include the images in submission
        // Load and resize image icons

        vagabondIcon = resizeImageIcon("vagabond.png", 150, 150);
        samuraiIcon = resizeImageIcon("samurai.png", 150, 150);
        warriorIcon = resizeImageIcon("warrior.png", 150, 150);
        heroIcon = resizeImageIcon("hero.png", 150, 150);
        astrologerIcon = resizeImageIcon("astrologer.png", 150, 150);
        prophetIcon = resizeImageIcon("prophet.png", 150, 150);
        

        // Create and add buttons
        JButton vagabondButton = createImageButton(vagabondIcon);
        vagabondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for vagabond button here
            }
        });
        buttonPanel.add(vagabondButton);
        
        JButton samuraiButton = createImageButton(samuraiIcon);
        samuraiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for samurai button here
            }
        });
        buttonPanel.add(samuraiButton);
        
        JButton warriorButton = createImageButton(warriorIcon);
        warriorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for warrior button here
            }
        });
        buttonPanel.add(warriorButton);
        
        JButton heroButton = createImageButton(heroIcon);
        heroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for hero button here
            }
        });
        buttonPanel.add(heroButton);
        
        JButton astrologerButton = createImageButton(astrologerIcon);
        astrologerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for astrologer button here
            }
        });
        buttonPanel.add(astrologerButton);
        
        JButton prophetButton = createImageButton(prophetIcon);
        prophetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action for prophet button here
            }
        });
        buttonPanel.add(prophetButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
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
}

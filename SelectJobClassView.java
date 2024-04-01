import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

        // Load and resize image icons
        // Make sure the images are in the directory which the program is being loaded from or just copy the direct path but make sure to use double back slashes "\\" when typing the path
        vagabondIcon = resizeImageIcon("vagabond.png", 150, 150);
        samuraiIcon = resizeImageIcon("samurai.png", 150, 150);
        warriorIcon = resizeImageIcon("warrior.png", 150, 150);
        heroIcon = resizeImageIcon("hero.png", 150, 150);
        astrologerIcon = resizeImageIcon("astrologer.png", 150, 150);
        prophetIcon = resizeImageIcon("prophet.png", 150, 150);
        

        // Create and add buttons
        buttonPanel.add(createImageButton(vagabondIcon));
        buttonPanel.add(createImageButton(samuraiIcon));
        buttonPanel.add(createImageButton(warriorIcon));
        buttonPanel.add(createImageButton(heroIcon));
        buttonPanel.add(createImageButton(astrologerIcon));
        buttonPanel.add(createImageButton(prophetIcon));

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SelectJobClassView();
            }
        });
    }
}

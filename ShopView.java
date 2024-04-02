import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopView extends JFrame {
    private JLabel titleLabel;
    private JLabel playerRunesLabel;
    private JButton[] shopButtons;
    private JButton nextPageButton;
    private JButton prevPageButton;
    private int currentPage = 0; // Current page index
    private int itemsPerPage = 4; // Number of items per page
    private int totalButtons = 24; // Total number of buttons

    public ShopView() {
        setTitle("Shop");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Shop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // 1 row, 4 columns, with 10px horizontal and vertical gap
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Load and resize image icons
        shopButtons = new JButton[itemsPerPage];
        for (int i = 0; i < itemsPerPage; i++) {
            // Create button with image icon
            ImageIcon icon = resizeImageIcon("image_" + (i + 1) + ".png", 200, 500);
            if (icon != null) {
                shopButtons[i] = createImageButton(icon);
                buttonPanel.add(shopButtons[i]); // Add button to panel
            }
        }

        // Create and add player runes label
        playerRunesLabel = new JLabel("Player Runes: ", SwingConstants.CENTER);
        add(playerRunesLabel, BorderLayout.SOUTH);

        // Create next and previous page buttons
        createPageButtons();

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to resize image icon
    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage();
            Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImg);
        } catch (Exception ex) {
            System.out.println("Error resizing image: " + ex.getMessage());
            return null;
        }
    }

    // Method to create image button
    private JButton createImageButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setText(null); // Set text to null to remove it
        button.setContentAreaFilled(false); // Make the button transparent
        button.setBorderPainted(false); // Remove the border
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Set preferred size to match image dimensions
        return button;
    }

    // Create next and previous page buttons along with an exit button
    private void createPageButtons() {
        nextPageButton = new JButton("Next Page");
        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPage++;
                refreshButtons();
            }
        });

        prevPageButton = new JButton("Previous Page");
        prevPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPage--;
                refreshButtons();
            }
        });

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame
            }
        });

        // Add next and previous page buttons to bottom panel based on current page
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align buttons to the left
        bottomPanel.add(exitButton); // Add exit button
        if (currentPage > 0) {
            bottomPanel.add(prevPageButton);
        }
        if (currentPage < totalButtons / itemsPerPage - 1) {
            bottomPanel.add(nextPageButton);
        }
        add(bottomPanel, BorderLayout.SOUTH);
    }


    // Refresh buttons based on current page
    private void refreshButtons() {
        // Remove existing buttons
        getContentPane().removeAll();

        // Add components again
        add(titleLabel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        add(buttonPanel, BorderLayout.CENTER);
        for (int i = currentPage * itemsPerPage; i < (currentPage + 1) * itemsPerPage && i < totalButtons; i++) {
            ImageIcon icon = resizeImageIcon("image_" + (i + 1) + ".png", 200, 500);
            if (icon != null) {
                JButton button = createImageButton(icon);
                buttonPanel.add(button);
            }
        }
        add(playerRunesLabel, BorderLayout.SOUTH);
        createPageButtons();

        // Refresh the frame
        revalidate();
        repaint();
    }

    // Method to add listener for next page button
    public void addNextPageButtonListener(ActionListener listener) {
        nextPageButton.addActionListener(listener);
    }

    // Method to add listener for previous page button
    public void addPrevPageButtonListener(ActionListener listener) {
        prevPageButton.addActionListener(listener);
    }
}

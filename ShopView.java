import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The ShopView class represents the graphical user interface for the shop screen.
 */
public class ShopView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel playerRunesLabel;
    private JButton[] shopButtons;
    private JButton nextPageButton;
    private JButton prevPageButton;
    private JButton exitButton;
    private int currentPage = 0;
    private int itemsPerPage = 4;
    private int totalButtons = 24;
    private ShopController controller;

    /**
     * Constructs a new ShopView with a reference to the shop controller.
     *
     * @param controller the shop controller instance
     */
    public ShopView(ShopController controller) {
        this.controller = controller;

        setTitle("Shop");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Shop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        add(buttonPanel, BorderLayout.CENTER);

        shopButtons = new JButton[itemsPerPage];
        for (int i = 0; i < itemsPerPage; i++) {
            ImageIcon icon = resizeImageIcon("image_" + (i + 1) + ".png", 200, 500);
            if (icon != null) {
                shopButtons[i] = createImageButton(icon);
                buttonPanel.add(shopButtons[i]);
            }
        }

        playerRunesLabel = new JLabel("Player Runes: ", SwingConstants.CENTER);
        add(playerRunesLabel, BorderLayout.SOUTH);

        createPageButtons();

        setLocationRelativeTo(null);
        showView(false);
    }

    /**
     * Resizes the specified image icon to the given dimensions.
     *
     * @param imagePath the path of the image
     * @param width     the desired width
     * @param height    the desired height
     * @return the resized image icon
     */
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

    /**
     * Creates a button with the specified image icon.
     *
     * @param icon the image icon for the button
     * @return the created button
     */
    private JButton createImageButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setText(null);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        return button;
    }

    /**
     * Creates next and previous page buttons along with an exit button.
     */
    private void createPageButtons() {
        nextPageButton = new JButton("Next Page");
        prevPageButton = new JButton("Previous Page");
        exitButton = new JButton("Exit");

        nextPageButton.addActionListener(this);
        prevPageButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(exitButton);
        if (currentPage > 0) {
            bottomPanel.add(prevPageButton);
        }
        if (currentPage < totalButtons / itemsPerPage - 1) {
            bottomPanel.add(nextPageButton);
        }
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Refreshes the buttons based on the current page.
     */
    private void refreshButtons() {
        getContentPane().removeAll();

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

        revalidate();
        repaint();
    }

    /**
     * Handles actions performed on buttons.
     *
     * @param e the ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextPageButton) {
            currentPage++;
            refreshButtons();
        } else if (e.getSource() == prevPageButton) {
            currentPage--;
            refreshButtons();
        } else if (e.getSource() == exitButton) {
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        }
    }

    /**
     * Displays or hides the shop view.
     *
     * @param state true to show the view, false to hide it
     */
    public void showView(Boolean state) {
        setVisible(state);
    }
}

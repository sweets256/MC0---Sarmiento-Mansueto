import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class FastTravelView extends JFrame {
    private JLabel titleLabel;
    private JButton area1Button;
    private JButton area2Button;
    private JButton area3Button;
    private JButton backButton;
    private FastTravelController controller;

    public FastTravelView(FastTravelController fastTravelController) {

        this.controller = controller;

        setTitle("Fast Travel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Fast Travel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 200, 20, 200)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and center area 1 button
        area1Button = new JButton("Area 1");
        area1Button.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(area1Button);

        // Create and center area 2 button
        area2Button = new JButton("Area 2");
        area2Button.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(area2Button);

        // Create and center area 3 button
        area3Button = new JButton("Area 3");
        area3Button.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(area3Button);

        // Create and back button
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        buttonPanel.add(backButton);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to add action listener to the area 1 button
    public void addArea1ButtonListener(ActionListener listener) {
        area1Button.addActionListener(listener);

        setVisible(false);
        controller.finishProcess("AREA_1");
    }

    // Method to add action listener to the area 2 button
    public void addArea2ButtonListener(ActionListener listener) {
        area2Button.addActionListener(listener);

        setVisible(false);
        controller.finishProcess("AREA_2");
    }

    // Method to add action listener to the area 3 button
    public void addArea3ButtonListener(ActionListener listener) {
        area3Button.addActionListener(listener);

        setVisible(false);
        controller.finishProcess("AREA_3");
    }

    // Method to add action listener to the back button
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);

        setVisible(false);
        controller.finishProcess("EXIT");
    }

    public void showView(Boolean state){
        setVisible(state);
    }
}

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastTravelView extends JFrame implements ActionListener{
    private JLabel titleLabel;
    private JButton area1Button;
    private JButton area2Button;
    private JButton area3Button;
    private JButton backButton;
    private FastTravelController controller;

    public FastTravelView(FastTravelController controller) {

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
        showView(false);
        addButtonListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == area1Button){
            showView(false);
            controller.finishProcess("AREA_1");
        } else if (e.getSource() == area2Button){
            showView(false);
            controller.finishProcess("AREA_2");
        } else if (e.getSource() == area3Button){
            showView(false);
            controller.finishProcess("AREA_3");
        } else if (e.getSource() == backButton){
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        }
    }

    public void addButtonListener(){
        area1Button.addActionListener(this);
        area2Button.addActionListener(this);
        area3Button.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void showView(Boolean state){
        setVisible(state);
    }

}

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpView extends JFrame implements ActionListener{
    private JLabel titleLabel;
    private JButton chooseStatButton;
    private JButton exitButton;
    private JPanel newStatsPanel;
    private LevelUpController controller;

    public LevelUpView(LevelUpController controller) {

        this.controller = controller;

        setTitle("Level Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and center the title label
        titleLabel = new JLabel("Level Up", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170)); // Add padding
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // Create panel for buttons with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // Create and center choose stat button
        chooseStatButton = new JButton("Choose Stat to Level Up");
        chooseStatButton.setFont(new Font("Arial", Font.BOLD, 30));
        chooseStatButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(chooseStatButton);

        // Create and center exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(180, 30)); // Set preferred size
        buttonPanel.add(exitButton);

        // Create new stats panel
        newStatsPanel = new JPanel();
        newStatsPanel.setLayout(new BorderLayout());
        JLabel newStatsLabel = new JLabel("New Stats", SwingConstants.CENTER);
        newStatsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newStatsPanel.add(newStatsLabel, BorderLayout.NORTH);
        // Add any additional components for new stats panel here

        // Add new stats panel but make it invisible initially
        newStatsPanel.setVisible(false);
        add(newStatsPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        showView(true);
        addButtonListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseStatButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == exitButton){
            System.out.println("Exit Button Pressed");
        }
    }

    public void addButtonListener(){
        chooseStatButton.addActionListener(this);
        exitButton.addActionListener(this);
    }


    public void showView(Boolean state){
        setVisible(state);
    }
}

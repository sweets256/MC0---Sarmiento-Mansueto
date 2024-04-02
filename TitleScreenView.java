import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TitleScreenView extends JFrame {
    private JLabel titleLabel;
    private JButton startButton;
    private JButton exitButton;
    private TitleController controller;

    public TitleScreenView(TitleController controller) {

        this.controller = controller;

        setTitle("Elden Rogue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // center title
        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        // button panel with padding
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200)); // Add padding
        add(buttonPanel, BorderLayout.CENTER);

        // start button
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(startButton);

        // exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        buttonPanel.add(exitButton);


        // center frame
        setLocationRelativeTo(null);
        temp();
    }

    public void temp(){
        setVisible(true);
    }

    // Listener for the start button
    public void addStartButtonListener (ActionListener listener) {
        startButton.addActionListener(listener);

        //nav to char create
        setVisible(false);
        controller.finishProcess("CHAR_CREATION");

    }

    // Listener for the exit button
    public void addExitButtonListener (ActionListener listener) {
        exitButton.addActionListener(listener);
    }


    public void showView(Boolean state){
        setVisible(state);
    }
   


    // view tester
}
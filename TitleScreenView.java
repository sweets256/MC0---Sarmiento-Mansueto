import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TitleScreenView class formats the GUI of the title screen 
 * and contains all of the java swing functions, it also serves as
 * the View portion as part of the MVC (model, view, controller)
 * architecture for GUI
 */
public class TitleScreenView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton startButton;
    private JButton exitButton;
    private TitleController controller;

    /**
     * Constructs a new TitleScreenView with a reference to the title controller.
     *
     * @param controller the title controller instance
     */
    public TitleScreenView(TitleController controller) {

        this.controller = controller;

        setTitle("Elden Rogue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200));
        add(buttonPanel, BorderLayout.CENTER);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setPreferredSize(new Dimension(80, 30));
        buttonPanel.add(startButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(80, 30));
        buttonPanel.add(exitButton);

        setLocationRelativeTo(null);
        showView(true);
        addButtonListener();
    }

    /**
     * Handles actionPerformed event for the buttons.
     *
     * @param e The ActionEvent generated.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton){
            showView(false);
            controller.finishProcess("CHAR_CREATION");
        } else if (e.getSource() == exitButton){
            showView(false);
            System.exit(0);
        }
    }

    /**
     * Adds ActionListener to the buttons.
     */
    public void addButtonListener(){
        startButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    /**
     * Shows or hides the view.
     *
     * @param state If true, the view is visible; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        setVisible(state);
    }
}

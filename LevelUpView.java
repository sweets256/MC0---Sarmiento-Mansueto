import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The LevelUpView class formats the GUI of the level up screen 
 * and contains all of the java swing functions, it also serves as
 * the View portion as part of the MVC (model, view, controller)
 * architecture for GUI.
 */
public class LevelUpView extends JFrame implements ActionListener{
    private JLabel titleLabel;
    private JButton chooseStatButton;
    private JButton exitButton;
    private JPanel newStatsPanel;
    private LevelUpController controller;

    /**
     * Constructor for LevelUpView.
     *
     * @param controller instance of the level up controller class
     */
    public LevelUpView(LevelUpController controller) {

        this.controller = controller;

        setTitle("Level Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Level Up", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(70, 170, 0, 170));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        buttonPanel.setBorder(new EmptyBorder(30, 200, 100, 200));
        add(buttonPanel, BorderLayout.CENTER);

        chooseStatButton = new JButton("Choose Stat to Level Up");
        chooseStatButton.setFont(new Font("Arial", Font.BOLD, 30));
        chooseStatButton.setPreferredSize(new Dimension(80, 30));
        buttonPanel.add(chooseStatButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 30));
        exitButton.setPreferredSize(new Dimension(180, 30));
        buttonPanel.add(exitButton);

        newStatsPanel = new JPanel();
        newStatsPanel.setLayout(new BorderLayout());
        JLabel newStatsLabel = new JLabel("New Stats", SwingConstants.CENTER);
        newStatsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newStatsPanel.add(newStatsLabel, BorderLayout.NORTH);

        newStatsPanel.setVisible(false);
        add(newStatsPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        showView(false);
        addButtonListener();
    }

    /**
     * Handles actionPerformed event for the buttons.
     *
     * @param e The ActionEvent generated.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseStatButton){
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        } else if (e.getSource() == exitButton){
            showView(false);
            controller.finishProcess("GAME_LOBBY");
        }
    }

    /**
     * Adds ActionListener to the buttons.
     */
    public void addButtonListener(){
        chooseStatButton.addActionListener(this);
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

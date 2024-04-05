import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The view class for fast travel functionality.
 */
public class FastTravelView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton area1Button;
    private JButton area2Button;
    private JButton area3Button;
    private JButton backButton;
    private FastTravelController controller;

    /**
     * Constructs a FastTravelView with the specified controller.
     * 
     * @param controller The controller associated with this view.
     */
    public FastTravelView(FastTravelController controller) {

        this.controller = controller;

        setTitle("Fast Travel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Fast Travel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 200, 20, 200));
        add(buttonPanel, BorderLayout.CENTER);

        area1Button = new JButton("Area 1");
        area1Button.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(area1Button);

        area2Button = new JButton("Area 2");
        area2Button.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(area2Button);

        area3Button = new JButton("Area 3");
        area3Button.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(area3Button);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(backButton);

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

    /**
     * Adds action listeners to the buttons.
     */
    public void addButtonListener(){
        area1Button.addActionListener(this);
        area2Button.addActionListener(this);
        area3Button.addActionListener(this);
        backButton.addActionListener(this);
    }

    /**
     * Displays or hides the view.
     * 
     * @param state The state indicating whether to show or hide the view.
     */
    public void showView(Boolean state){
        setVisible(state);
    }
}

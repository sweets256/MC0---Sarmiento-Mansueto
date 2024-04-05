import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The GameLobbyView class represents the graphical user interface for the game lobby.
 * It displays buttons for various game functions and information about the character.
 */
public class GameLobbyView extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton fastTravelButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton shopButton;
    private JButton exitButton;
    private GameLobbyController controller;

    /**
     * Constructs a new GameLobbyView with the specified controller.
     *
     * @param controller The GameLobbyController associated with this view.
     */
    public GameLobbyView(GameLobbyController controller) {
        this.controller = controller;

        setTitle("Game Lobby");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Game Lobby", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 100, 20, 100));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.CENTER);

        fastTravelButton = new JButton("Fast Travel");
        fastTravelButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(fastTravelButton);

        levelUpButton = new JButton("Level Up");
        levelUpButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(levelUpButton);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(inventoryButton);

        shopButton = new JButton("Shop");
        shopButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(shopButton);

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(exitButton);

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200, getHeight()));
        sidePanel.setBackground(Color.LIGHT_GRAY);
        sidePanel.setLayout(new GridLayout(0, 1));
        ArrayList<String> CharInfo = controller.getCharInfo();
        for (String info : CharInfo){
            JLabel label = new JLabel(info);
            label.setHorizontalAlignment(JLabel.CENTER);
            sidePanel.add(label);
        }
        add(sidePanel, BorderLayout.WEST);

        setLocationRelativeTo(null);
        showView(false);
        addButtonListener();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == fastTravelButton){
            showView(false);
            controller.finishProcess("FAST_TRAVEL");
        } else if(e.getSource() == levelUpButton){
            showView(false);
            controller.finishProcess("LEVEL_UP");
        } else if(e.getSource() == inventoryButton){
            showView(false);
            controller.finishProcess("INVENTORY");
        } else if(e.getSource() == shopButton){
            showView(false);
            controller.finishProcess("SHOP");
        } else if(e.getSource() == exitButton){
            showView(false);
            controller.finishProcess("TITLE_SCREEN");
        }
    }

    public void addButtonListener(){
        fastTravelButton.addActionListener(this);
        levelUpButton.addActionListener(this);
        inventoryButton.addActionListener(this);
        shopButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    /**
     * Displays or hides the view.
     *
     * @param state If true, the view is visible; otherwise, it is hidden.
     */
    public void showView(Boolean state){
        setVisible(state);
    }
}

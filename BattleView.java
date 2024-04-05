import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The view class for battles.
 */
public class BattleView extends JFrame implements ActionListener{
    private JLabel titleLabel;
    private JLabel playerSpriteLabel;
    private JLabel enemySpriteLabel;
    private JTextArea systemMessagesTextArea;
    private JButton attackButton;
    private JButton dodgeButton;
    private BattleController controller;

    /**
     * Constructs a BattleView with the specified controller.
     * 
     * @param controller The controller associated with this view.
     */
    public BattleView(BattleController controller) {

        this.controller = controller;

        setTitle("Battle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Battle has commenced!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        add(topPanel, BorderLayout.CENTER);

        playerSpriteLabel = new JLabel(new ImageIcon("playersprite_image.png"));
        topPanel.add(playerSpriteLabel, BorderLayout.EAST);

        enemySpriteLabel = new JLabel(new ImageIcon("enemysprite_image.png"));
        topPanel.add(enemySpriteLabel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        add(bottomPanel, BorderLayout.SOUTH);

        systemMessagesTextArea = new JTextArea();
        systemMessagesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(systemMessagesTextArea);
        bottomPanel.add(scrollPane);

        attackButton = new JButton("Select Attack Type");
        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAttackTypeWindow();
            }
        });
        bottomPanel.add(attackButton);

        dodgeButton = new JButton("Dodge");
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add action for dodge button
            }
        });
        bottomPanel.add(dodgeButton);

        setLocationRelativeTo(null);
        showView(true);
    }

    private void openAttackTypeWindow() {
        JFrame attackTypeWindow = new JFrame("Select Attack Type");
        attackTypeWindow.setSize(300, 150);
        attackTypeWindow.setLayout(new GridLayout(1, 3));

        JButton physicalButton = new JButton("Physical Damage");
        physicalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle physical damage action
                systemMessagesTextArea.append("Physical Damage selected.\n");
                attackTypeWindow.dispose();
            }
        });
        attackTypeWindow.add(physicalButton);

        JButton sorceryButton = new JButton("Sorcery Damage");
        sorceryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle sorcery damage action
                systemMessagesTextArea.append("Sorcery Damage selected.\n");
                attackTypeWindow.dispose();
            }
        });
        attackTypeWindow.add(sorceryButton);

        JButton incantationButton = new JButton("Incantation Damage");
        incantationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle incantation damage action
                systemMessagesTextArea.append("Incantation Damage selected.\n");
                attackTypeWindow.dispose();
            }
        });
        attackTypeWindow.add(incantationButton);

        attackTypeWindow.setLocationRelativeTo(null);
        attackTypeWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attackButton){
            showView(false);
            
        } else if (e.getSource() == dodgeButton){
            System.out.println("Exit Button Pressed");
        }
    }

    /**
     * Adds action listeners to the buttons.
     */
    public void addButtonListener(){
        attackButton.addActionListener(this);
        dodgeButton.addActionListener(this);
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

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * The MainMenu class shows the main menu screen
 * 
 * @author Andrea Cen and Alexandria Yau
 * @version 06.10.2022
 * 
 */

public class MainMenu extends JPanel implements ActionListener {
    /** stores the buttons that the player can press */
    private JButton newGame;
    private JButton instructions;
    private JButton exit;

    /**stores the next screen */
    public String screen;

    /**stores whether or not the level is completed */
    public boolean isCompleted;

    /**
     * the constructor of the class where buttons are created
     */
    public MainMenu() {
        setLayout(null);
        newGame = new JButton();
        newGame.addActionListener(this);
        newGame.setBounds(350, 175, 30, 30);

        instructions = new JButton();
        instructions.addActionListener(this);
        instructions.setBounds(350, 285, 30, 30);

        exit = new JButton();
        exit.addActionListener(this);
        exit.setBounds(350, 400, 30, 30);
    }

    /**
     * changes the screen
     * 
     * @param g the graphics to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String fileName = "images/screenMainMenu.png";
        BufferedImage image = Phamalee.imageFromFile(fileName);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        add(newGame);
        add(instructions);
        add(exit);
    }

    /**
     * sees which button was pressed and reacts to it correspondingly
     * 
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            screen = "newGame";
        } else if (e.getSource() == instructions) {
            screen = "instructions";
        } else {
            screen = "exit";
        }
        remove(newGame);
        remove(instructions);
        remove(exit);
        isCompleted = true;
    }

    /**
     * shows the main menu 
     * 
     * @return the next screen
     */
    public String start() {
        revalidate();
        repaint();

        while (!isCompleted) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        return screen;
    }
}

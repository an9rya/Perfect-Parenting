
/**
 * The ScreenPassed1 class is the screen when the player passes level 1
 * 
 * @author Andrea Cen and Alexandria Yau
 * @version 06.10.2022
 * 
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ScreenPassed2 extends JPanel implements ActionListener {

    /** variables stores the button */
    private JButton nextButton;

    /** stores whether or not the level has been completed */
    public boolean isCompleted;

    /**
     * the constructor of the class where buttons are created
     */
    public ScreenPassed2() {
        setLayout(null);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setBounds(550, 600, 75, 25);
    }

    /**
     * changes the screen
     * 
     * @param g the graphics to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String fileName = "images/screenPassedLvl2.png";
        BufferedImage image = Phamalee.imageFromFile(fileName);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        add(nextButton);
    }

    /**
     * sees which button was pressed and reacts to it correspondingly
     * 
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            isCompleted = true;
        }
        repaint();
    }

    /**
     * shows the level 2 passed screen
     */
    public void start() {
        revalidate();
        repaint();

        while (!isCompleted) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
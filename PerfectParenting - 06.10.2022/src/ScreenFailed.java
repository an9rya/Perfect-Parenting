
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

public class ScreenFailed extends JPanel implements ActionListener {

    /** stores the buttons */
    private JButton nextButton;
    private JButton retryButton;

    /** stores whether or not the level has been completed */
    public boolean isCompleted;

    /** stores which button was pressed */
    public String buttonPressed;

    /**
     * the constructor of the class where buttons are created
     */
    public ScreenFailed() {
        setLayout(null);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setBounds(550, 600, 75, 25);

        retryButton = new JButton("Retry");
        retryButton.addActionListener(this);
        retryButton.setBounds(450, 600, 75, 25);
    }

    /**
     * changes the screen
     * 
     * @param g the graphics to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String fileName = "images/screenFailed.png";
        BufferedImage image = Phamalee.imageFromFile(fileName);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        if (!isCompleted) {
            add(nextButton);
            add(retryButton);
        }
    }

    /**
     * sees which button was pressed and reacts to it correspondingly
     * 
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            buttonPressed = "next";
        } else if (e.getSource() == retryButton) {
            buttonPressed = "retry";
        }
        isCompleted = true;

        repaint();

    }

    /**
     * shows the level failed screen
     * 
     * @return the button that was pressed
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
        return buttonPressed;
    }
}
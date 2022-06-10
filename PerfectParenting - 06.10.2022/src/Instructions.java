
/**
 * The Instructions class is the instructions on how to play the game and its levels
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

public class Instructions extends JPanel implements ActionListener {

    /** stores the button */
    private JButton nextButton;

    public boolean isCompleted;

    /**
     * the constructor of the class where buttons are created
     */
    public Instructions() {
        setLayout(null);
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setBounds(550, 600, 75, 25);
    }

    /**
     * This method changes the screen
     * 
     * @param g the graphics to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String fileName = "images/screenInstructions.png";
        BufferedImage image = Phamalee.imageFromFile(fileName);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        if (!isCompleted) {
            add(nextButton);
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
            isCompleted = true;
            remove(nextButton);
        }
        repaint();
    }

    /**
     * shows the instructions screen
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
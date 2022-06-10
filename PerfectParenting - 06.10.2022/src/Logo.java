
/**
 * The Logo class shows the logo of our company
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

public class Logo extends JPanel implements ActionListener {

    /** the JButton variables stores the button */
    private JButton nextButton;

    public boolean isCompleted;

    /**
     * the constructor of the class where buttons are created
     */
    public Logo() {
        setLayout(null);
        nextButton = new JButton("Start");
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

        String fileName = "images/logo.png";
        BufferedImage image = Phamalee.imageFromFile(fileName);
        g.drawImage(image, 300, 0, 600, 600, null);
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
     * shows the logo of our company
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
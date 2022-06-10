
/**
 * The Level2 class is the second level of the game
 * 
 * @author Alexandria Yau and Andrea Cen
 * @version 06.10.2022
 * 
 */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Level2 extends JPanel implements ActionListener {

	/** stores the screen number */
	private int screen;

	/** stores the buttons */
	private JButton nextButton;
	private JButton yesButton;
	private JButton noButton;

	/**
	 * stores whether or not the entire level has been completed
	 */
	private boolean isCompleted;

	/**
	 * stores whether or not the player has chosen the correct answer
	 */
	private String isCorrect;

	/**
	 * the constructor of the class where instance variables are initiated and buttons are created
	 */
	public Level2() {
		screen = 1;

		yesButton = new JButton("Yes");
		yesButton.addActionListener(this);
		yesButton.setBounds(500, 600, 75, 25);

		noButton = new JButton("No");
		noButton.addActionListener(this);
		noButton.setBounds(600, 600, 75, 25);

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setBounds(550, 600, 75, 25);

		isCorrect = "";
	}

	/**
	 * This method draws the different screens
	 * 
	 * @param g the graphics to draw
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		String fileName = "images/screen2" + screen + isCorrect + ".png";
		BufferedImage image = Phamalee.imageFromFile(fileName);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if (screen == 1 && isCorrect.equals("")) {
			add(yesButton);
			add(noButton);
		}
	}

	/**
	 * This method sees which button was pressed and reacts to it correspondingly
	 * 
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		isCorrect = "";
		remove(yesButton);
		remove(noButton);
		remove(nextButton);
		if (e.getSource() == nextButton) {
			if (screen == 15) {
				isCompleted = true;
			}
			if (screen < 15) {
				add(yesButton);
				add(noButton);
				screen++;
			}
		} else if (e.getSource() == yesButton && screen != 8 && screen != 11 && screen != 14) {
			isCorrect = "true";
			add(nextButton);
		} else if (e.getSource() == yesButton && (screen == 8 || screen == 11 || screen == 14)) {
			isCorrect = "false";
			add(nextButton);
		} else if (e.getSource() == noButton && (screen == 8 || screen == 11 || screen == 14)) {
			isCorrect = "true";
			add(nextButton);
		} else if (e.getSource() == noButton && screen != 8 && screen != 11 && screen != 14) {
			isCorrect = "false";
			add(nextButton);
		}
		repaint();
	}

	/**
	 * this method starts level 2 of the game
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
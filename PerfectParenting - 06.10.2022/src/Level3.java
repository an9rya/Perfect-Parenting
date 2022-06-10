
/**
 * The Level3 class is the first level of the game
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

public class Level3 extends JPanel implements ActionListener {
	/** stores the screen number */
	private int screen;

	/** this int variable stores the player's score */
	private int score;

	/** stores the button */
	private JButton button1;
	private JButton button2;
	private JButton button3;

	/** stores whether or not the level has been completed */
	private boolean isCompleted;

	/**
	 * the constructor of the class where instance variables are initiated and buttons are created
	 */
	public Level3() {
		screen = 1;

		setLayout(null);

		button1 = new JButton("");
		button1.addActionListener(this);
		button1.setBounds(600, 235, 25, 25);

		button2 = new JButton("");
		button2.addActionListener(this);
		button2.setBounds(600, 330, 25, 25);

		button3 = new JButton("");
		button3.addActionListener(this);
		button3.setBounds(600, 445, 25, 25);
	}

	/**
	 * this method draws the screens
	 * 
	 * @param g the graphics to be drawn
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		String fileName = "images/screen3" + screen + ".png";
		BufferedImage image = Phamalee.imageFromFile(fileName);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if (!isCompleted) {
			add(button1);
			add(button2);
			add(button3);
		}
	}

	/**
	 * determines if the player clicked the correct button
	 * 
	 * @param screen        the screen that the player is currently on
	 * @param buttonPressed the button that the player pressed
	 * @return if the player clicked the right one
	 */
	public boolean isCorrect(int screen, int buttonPressed) {
		boolean isCorrect = false;
		if (screen == 1) {
			if (buttonPressed == 2) {
				isCorrect = true;
			}
		} else if (screen == 2) {
			if (buttonPressed == 1) {
				isCorrect = true;
			}
		} else if (screen == 3) {
			if (buttonPressed == 1) {
				isCorrect = true;
			}

		} else if (screen == 4) {
			if (buttonPressed == 1) {
				isCorrect = true;
			}
		} else if (screen == 5) {
			if (buttonPressed == 1) {
				isCorrect = true;
			}
		} else if (screen == 6) {
			if (buttonPressed == 3) {
				isCorrect = true;
			}
		} else if (screen == 7) {
			if (buttonPressed == 1) {
				isCorrect = true;
			}
		} else if (screen == 8) {
			if (buttonPressed == 3) {
				isCorrect = true;
			}
		} else if (screen == 9) {
			if (buttonPressed == 2) {
				isCorrect = true;
			}
		} else if (screen == 10) {
			if (buttonPressed == 2) {
				isCorrect = true;
			}
		}
		return isCorrect;
	}

	/**
	 * starts the third level of the game
	 * 
	 * @return the player's score
	 */
	public int start() {
		revalidate();
		repaint();

		while (!isCompleted) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
		return score;
	}

	/**
	 * determines if the player's score is greater than 8 (passed level)
	 * 
	 * @return if the player passed the third level
	 */
	public boolean passedTest() {
		return score >= 8;
	}

	/**
	 * determines what button was pressed, and adds to the score if the
	 * correct button was pressed
	 * 
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int buttonPressed = 0;
		if (e.getSource() == button1) {
			buttonPressed = 1;
		} else if (e.getSource() == button2) {
			buttonPressed = 2;
		} else if (e.getSource() == button3) {
			buttonPressed = 3;
		}

		if (isCorrect(screen, buttonPressed)) {
			score++;
		}
		if (screen == 10) {
			remove(button1);
			remove(button2);
			remove(button3);

			isCompleted = true;
		}
		if (!isCompleted) {
			screen++;
		}
		repaint();
	}

}


/**
 * The Level3 class is the first level of the game
 * 
 * @author Andrea (and Ally)
 * @version 05.27.2022
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Level3 extends JPanel implements ActionListener {
	/** this int variable stores the screen number */
	private int screen;

	/** this int variable stores the player's score */
	private int score;

	/** the following JButton variables stores the button */
	private JButton button1;
	private JButton button2;
	private JButton button3;

	/** this boolean variable stores whether or not the level has been completed */
	private boolean isCompleted;

	/**
	 * the constructor of the class where Level3 is constructed instance variables
	 * are initialized -- buttons are added but not added onto the frame yet
	 */
	public Level3() {
		screen = 1;

		setLayout(null);

		button1 = new JButton("");
		button1.addActionListener(this);
		button1.setBounds(425, 215, 25, 25);

		button2 = new JButton("");
		button2.addActionListener(this);
		button2.setBounds(425, 375, 25, 25);

		button3 = new JButton("");
		button3.addActionListener(this);
		button3.setBounds(425, 525, 25, 25);
	}

	/**
	 * this method draws the screens
	 * 
	 * @param g the graphics to be drawn
	 */
	public void paintComponent(Graphics g) {
		String fileName = "screen3" + screen + ".png";
		BufferedImage image = ParentingLessons.imageFromFile(fileName);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		add(button1);
		add(button2);
		add(button3);
		if (screen == 10) {
			isCompleted = true;
		}
	}

	/**
	 * this method determines if the player clicked the correct button
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
			if (buttonPressed == 3) {
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
			if (buttonPressed == 3) {
				isCorrect = true;
			}
		} else if (screen == 6) {
			if (buttonPressed == 2) {
				isCorrect = true;
			}
		} else if (screen == 7) {
			if (buttonPressed == 3) {
				isCorrect = true;
			}
		} else if (screen == 8) {
			if (buttonPressed == 2) {
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
	 * this method starts the third level of the game
	 */
	public void start() {
		revalidate();
		repaint();

		while (!isCompleted) {

		}
	}

	/**
	 * this method determines if the player's score is greater than 8 (passed level)
	 * 
	 * @return if the player passed the third level
	 */
	public boolean passedTest() {
		return score >= 8;
	}

	/**
	 * this method determins what button was pressed, and adds to the score if the
	 * correct button was pressed -- also goes to the next screen
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
		if (!isCompleted) {
			screen++;
		}
		repaint();
	}

}

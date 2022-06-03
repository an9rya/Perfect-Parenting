package FinalProject;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.FileNameMap;

import javax.swing.*;

/**
 * The Level1 class is the first level of the game
 * 
 * @author Andrea (and Ally)
 * @version 05.20.2022
 * 
 */

public class Level1 extends JPanel implements ActionListener {
	/** this int variable stores the screen number */
	private int screen;

	/** the following JButton variables stores the buttons */
	private JButton nextButton;
	private JButton backButton;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton blobButton;

	/**
	 * the following boolean variables stores whether or not each button was pressed
	 */
	private boolean btn1Pressed;
	private boolean btn2Pressed;
	private boolean btn3Pressed;
	private boolean btn4Pressed;
	private boolean btn5Pressed;
	private boolean btn6Pressed;
	private boolean btn7Pressed;

	/**
	 * determines if the next screen should have text
	 */
	private boolean isText;

	/**
	 * determins if the player has already found the blob button for screen 2; the
	 * player does not need to find it again
	 */
	private boolean passedScreen2;

	/** this boolean variable stores whether or not the level has been completed */
	private boolean isCompleted;

	/**
	 * the constructor of the class where Level1 is constructed instance variables
	 * are initialized -- buttons are added but not added onto the frame yet
	 */
	public Level1() {
		screen = 1;

		setLayout(null);

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setBounds(500, 600, 180, 80);

		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(500, 600, 180, 80);

		button1 = new JButton("");
		button1.addActionListener(this);
		button1.setBounds(100, 50, 25, 25);

		button2 = new JButton("");
		button2.addActionListener(this);
		button2.setBounds(1000, 75, 25, 25);

		button3 = new JButton("");
		button3.addActionListener(this);
		button3.setBounds(50, 450, 25, 25);

		button4 = new JButton("");
		button4.addActionListener(this);
		button4.setBounds(200, 600, 25, 25);

		button5 = new JButton("");
		button5.addActionListener(this);
		button5.setBounds(800, 400, 25, 25);

		button6 = new JButton("");
		button6.addActionListener(this);
		button6.setBounds(1100, 300, 25, 25);

		button7 = new JButton("");
		button7.addActionListener(this);
		button7.setBounds(550, 150, 25, 25);

		blobButton = new JButton("");
		blobButton.addActionListener(this);
	}

	public void addBlobButton(int screen) {
		if (screen == 1) {
			blobButton.setBounds(520, 45, 10, 10);
		} else if (screen == 2) {
			if (!passedScreen2) {
				blobButton.setBounds(85, 255, 10, 10);
				passedScreen2 = true;
			}
		} else if (screen == 3) {
			blobButton.setBounds(1113, 410, 10, 10);
		} else if (screen == 4) {
			blobButton.setBounds(810, 675, 10, 10);
		} else if (screen == 5) {
			blobButton.setBounds(50, 450, 10, 10);
		} else if (screen == 6) {
			blobButton.setBounds(1125, 300, 10, 10);
		} else if (screen == 7) {
			blobButton.setBounds(55, 320, 10, 10);
		} else if (screen == 8) {
			blobButton.setBounds(85, 470, 10, 10);
		} else if (screen == 9) {
			blobButton.setBounds(1130, 460, 10, 10);
		} else if (screen == 10) {
			blobButton.setBounds(150, 400, 10, 10);
		} else if (screen == 11) {
			blobButton.setBounds(445, 75, 10, 10);
		} else if (screen == 12) {
			blobButton.setBounds(705, 105, 10, 10);
		}

		if (!isText) {
			add(blobButton);
		}
		if (screen == 1) {
			if (isText) {
				add(nextButton);
				remove(blobButton);
			}
		} else if (screen >= 3 && screen <= 9) {
			if (isText) {
				add(backButton);
				remove(blobButton);
			}
		}
	}

	/**
	 * this method draws the screens
	 * 
	 * @param g the graphics to be drawn
	 */
	public void paintComponent(Graphics g) {
		String fileName = "images/screen1" + screen;
		if (isText) {
			fileName += "text.png";
		} else {
			fileName += ".png";
		}
		BufferedImage image = ParentingLessons.imageFromFile(fileName);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if (screen == 1) {
			addBlobButton(screen);
		} else if (screen == 2) {
			if (!passedScreen2) {
				addBlobButton(screen);
			} else {
				isText = true;
			}
			remove(backButton);
			if (isText) {
				add(button1);
				add(button2);
				add(button3);
				add(button4);
				add(button5);
				add(button6);
				add(button7);
			}

			if (areButtonsPressed()) {
				add(nextButton);
			} else {
				remove(nextButton);
			}
		} else {
			if (screen <= 9) {
				if (!isText) {
					addBlobButton(screen);
				} else {
					add(backButton);
				}
				remove(nextButton);
			} else {
				addBlobButton(screen);
				if (isText) {
					add(nextButton);
				} else {
					remove(nextButton);
				}
			}
			remove(button1);
			remove(button2);
			remove(button3);
			remove(button4);
			remove(button5);
			remove(button6);
			remove(button7);
		}

		if (screen == 12) {
			isCompleted = true;
		}

	}

	/**
	 * this method starts the first level of the game
	 */
	public void start() {
		revalidate();
		repaint();

		while (!isCompleted) {

		}
	}

	/**
	 * this method checks to see if all of the buttons have been pressed
	 * 
	 * @return whether or not all the buttons have been pressed
	 */
	public boolean areButtonsPressed() {
		return btn1Pressed && btn2Pressed && btn3Pressed && btn4Pressed && btn5Pressed && btn6Pressed && btn7Pressed;
	}

	/**
	 * this method switches from one screen to the next -- sets the btn#Pressed
	 * value to be true -- if the button pressed was the back button, returns to
	 * screen 2 (where all the buttons are) - when all the buttons on screen 2 have
	 * been pressed, when the player presses the next button, it goes to screen10
	 * 
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		isText = false;
		if (e.getSource() == blobButton) {
			isText = true;
			remove(blobButton);
		} else if (e.getSource() == nextButton) {
			if (screen == 2) {
				screen = 10;
			} else if (screen < 1299) {
				screen++;
			}
		} else if (e.getSource() == backButton) {
			screen = 2;
		} else if (e.getSource() == button1) {
			screen = 3;
			btn1Pressed = true;
		} else if (e.getSource() == button2) {
			screen = 4;
			btn2Pressed = true;
		} else if (e.getSource() == button3) {
			screen = 5;
			btn3Pressed = true;
		} else if (e.getSource() == button4) {
			screen = 6;
			btn4Pressed = true;
		} else if (e.getSource() == button5) {
			screen = 7;
			btn5Pressed = true;
		} else if (e.getSource() == button6) {
			screen = 8;
			btn6Pressed = true;
		} else if (e.getSource() == button7) {
			screen = 9;
			btn7Pressed = true;
		}

		repaint();
	}
}
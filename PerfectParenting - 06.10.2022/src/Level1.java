
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * The Level1 class is the first level of the game
 * 
 * @author Andrea Cen and Alexandria Yau
 * @version 06.10.2022
 * 
 */

public class Level1 extends JPanel implements ActionListener {
	/** this int variable stores the screen number */
	private int screen;

	/**stores the buttons */
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
	 *stores whether or not each button was pressed
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
	 * determines if the player has already found the blob button for screen 2
	 */
	private boolean passedScreen2;

	/**
	 * determines if the buttons pressed were set to false yet
	 */
	private boolean removeButtonsPressed;

	/**
	 * determines if the user has passed the first part of the level; the back
	 * button should go to screen 10 instead of 2 if true
	 */
	private boolean passedPart1;

	/** stores whether or not the level has been completed */
	private boolean isCompleted;

	/**
	 * the constructor of the class where buttons are created
	 */
	public Level1() {
		screen = 1;

		setLayout(null);

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setBounds(550, 600, 75, 25);

		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(550, 600, 75, 25);

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

	/**
	 * adds the buttons that shows the blob
	 * @param screen the current screen
	 */
	public void addBlobButton(int screen) {
		if (screen == 1) {
			blobButton.setBounds(520, 45, 20, 20);
		} else if (screen == 2) {
			if (!passedScreen2) {
				blobButton.setBounds(85, 255, 20, 20);
				passedScreen2 = true;
			}
		} else if (screen == 3) {
			blobButton.setBounds(1113, 410, 20, 20);
		} else if (screen == 4) {
			blobButton.setBounds(810, 675, 20, 20);
		} else if (screen == 5) {
			blobButton.setBounds(50, 450, 20, 20);
		} else if (screen == 6) {
			blobButton.setBounds(1125, 300, 20, 20);
		} else if (screen == 7) {
			blobButton.setBounds(55, 320, 20, 20);
		} else if (screen == 8) {
			blobButton.setBounds(85, 470, 20, 20);
		} else if (screen == 9) {
			blobButton.setBounds(1130, 460, 20, 20);
		} else if (screen == 11) {
			blobButton.setBounds(80, 625, 20, 20);
		} else if (screen == 12) {
			blobButton.setBounds(405, 70, 20, 20);
		} else if (screen == 13) {
			blobButton.setBounds(65, 460, 20, 20);
		} else if (screen == 14) {
			blobButton.setBounds(80, 170, 20, 20);
		} else if (screen == 15) {
			blobButton.setBounds(75, 55, 20, 20);
		} else if (screen == 16) {
			blobButton.setBounds(585, 90, 20, 20);
		} else if (screen == 17) {
			blobButton.setBounds(1075, 430, 20, 20);
		}
		if (!isText) {
			add(blobButton);
		}
		if (screen == 1) {
			if (isText) {
				add(nextButton);
				remove(blobButton);
			}
		} else if ((screen >= 3 && screen <= 9) || (screen >= 11 && screen <= 17)) {
			if (isText) {
				add(backButton);
				remove(blobButton);
			}
		}
	}

	/**
	 * draws the screens
	 * 
	 * @param g the graphics to be drawn
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (isCompleted) {
			return;
		}

		String fileName = "images/screen1" + screen;
		if (isText) {
			fileName += "text.png";
		} else {
			fileName += ".png";
		}
		BufferedImage image = Phamalee.imageFromFile(fileName);
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
				passedPart1 = true;
			} else {
				remove(nextButton);
			}
		} else if (screen == 10) {
			remove(backButton);
			remove(nextButton);
			if (!removeButtonsPressed) {
				btn1Pressed = false;
				btn2Pressed = false;
				btn3Pressed = false;
				btn4Pressed = false;
				btn5Pressed = false;
				btn6Pressed = false;
				btn7Pressed = false;
				removeButtonsPressed = true;

				button1.setBackground(Color.WHITE);
				button2.setBackground(Color.WHITE);
				button3.setBackground(Color.WHITE);
				button4.setBackground(Color.WHITE);
				button5.setBackground(Color.WHITE);
				button6.setBackground(Color.WHITE);
				button7.setBackground(Color.WHITE);
			}
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(button5);
			add(button6);
			add(button7);
			if (areButtonsPressed()) {
				add(nextButton);
			}
		} else if (screen == 18) {
			remove(blobButton);
			add(nextButton);
			remove(button1);
			remove(button2);
			remove(button3);
			remove(button4);
			remove(button5);
			remove(button6);
			remove(button7);
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
	}

	/**
	 * starts the first level of the game
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

	/**
	 * checks to see if all of the buttons have been pressed
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
			} else if (screen == 10) {
				screen = 18;
			} else if (screen == 18) {
				isCompleted = true;
			} else {
				screen++;
			}
		} else if (e.getSource() == backButton) {
			if (!passedPart1) {
				screen = 2;
			} else {
				screen = 10;
			}
		} else if (e.getSource() == button1) {
			if (!passedPart1) {
				screen = 3;
			} else {
				screen = 11;
			}
			btn1Pressed = true;
			button1.setBackground(Color.GREEN);
		} else if (e.getSource() == button2) {
			if (!passedPart1) {
				screen = 4;
			} else {
				screen = 12;
			}
			btn2Pressed = true;
			button2.setBackground(Color.GREEN);
		} else if (e.getSource() == button3) {
			if (!passedPart1) {
				screen = 5;
			} else {
				screen = 13;
			}
			btn3Pressed = true;
			button3.setBackground(Color.GREEN);
		} else if (e.getSource() == button4) {
			if (!passedPart1) {
				screen = 6;
			} else {
				screen = 14;
			}
			btn4Pressed = true;
			button4.setBackground(Color.GREEN);
		} else if (e.getSource() == button5) {
			if (!passedPart1) {
				screen = 7;
			} else {
				screen = 15;
			}
			btn5Pressed = true;
			button5.setBackground(Color.GREEN);
		} else if (e.getSource() == button6) {
			if (!passedPart1) {
				screen = 8;
			} else {
				screen = 16;
			}
			btn6Pressed = true;
			button6.setBackground(Color.GREEN);
		} else if (e.getSource() == button7) {
			if (!passedPart1) {
				screen = 9;
			} else {
				screen = 17;
			}
			btn7Pressed = true;
			button7.setBackground(Color.GREEN);
		}

		repaint();
	}
}
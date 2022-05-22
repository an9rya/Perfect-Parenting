import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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

	/** the following JButton variables stores the button */
	private JButton nextButton;
	private JButton backButton;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;

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

	/** this boolean variable stores whether or not the level has been completed */
	private boolean isCompleted;

	/**
	 * the constructor of the class where Level1 is constructed instance variables
	 * are initialized -- buttons are added but not added onto the frame yet
	 */
	public Level1() {
		screen = 1;

		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		nextButton.setBounds(550, 800, 180, 80);

		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(550, 800, 180, 80);

		button1 = new JButton("");
		button1.addActionListener(this);
		button1.setBounds(100, 50, 25, 25);

		button2 = new JButton("");
		button2.addActionListener(this);
		button2.setBounds(1200, 75, 25, 25);

		button3 = new JButton("");
		button3.addActionListener(this);
		button3.setBounds(50, 450, 25, 25);

		button4 = new JButton("");
		button4.addActionListener(this);
		button4.setBounds(200, 800, 25, 25);

		button5 = new JButton("");
		button5.addActionListener(this);
		button5.setBounds(850, 700, 25, 25);

		button6 = new JButton("");
		button6.addActionListener(this);
		button6.setBounds(1100, 300, 25, 25);

		button7 = new JButton("");
		button7.addActionListener(this);
		button7.setBounds(600, 150, 25, 25);
	}

	/**
	 * this method draws the screens
	 * 
	 * @param g the graphics to be drawn
	 */
	public void paintComponent(Graphics g) {
		String fileName = "screen1" + screen + ".png";
		BufferedImage image = ParentingLessons.imageFromFile(fileName);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		if (screen == 1) {
			add(nextButton);
		} else if (screen == 2) {
			remove(backButton);

			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(button5);
			add(button6);
			add(button7);

			if (areButtonsPressed()) {
				add(nextButton);
			} else {
				remove(nextButton);
			}
		} else {
			if (screen <= 9) {
				add(backButton);
				remove(nextButton);
			} else {
				add(nextButton);
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
		if (e.getSource() == nextButton) {
			if (screen == 2) {
				screen = 10;
			} else if (screen < 12) {
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

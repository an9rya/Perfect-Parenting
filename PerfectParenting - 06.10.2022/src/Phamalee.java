
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * this class runs the program
 * 
 * @author Andrea Cen and Alexandria Yau
 * @version 06.10.2022
 */
public class Phamalee {

	/** stores the level that the player is on */
	public static int level;

	/** the frame that the player will play on */
	public static JFrame frame;

	/**
	 * initialize the JFrame
	 */
	private static void initializeFrame() {
		frame = new JFrame();
		frame.setSize(1200, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * gets the image from the file
	 * 
	 * @param path the path of the image
	 * @return the buffered image of the image from file
	 */
	public static BufferedImage imageFromFile(String path) {
		try {
			java.net.URL resource = Phamalee.class.getResource(path);
			if (resource == null)
				throw new NullPointerException();
			return ImageIO.read(resource);
		} catch (IOException | NullPointerException e) {
			System.err.println("There was an error retrieving " + path);
		}
		return null;
	}

	/**
	 * main method that runs the game
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		initializeFrame();

		Logo logo = new Logo();
		frame.add(logo);
		logo.start();
		frame.remove(logo);

		while (frame.isVisible()) {
			// main menu screen
			MainMenu mainMenu = new MainMenu();
			frame.add(mainMenu);
			String screen = mainMenu.start();

			if (screen.equals("instructions")) { // instructions screen
				frame.remove(mainMenu);
				Instructions instructions = new Instructions();
				frame.add(instructions);
				instructions.start();
				frame.remove(instructions);
			} else if (screen.equals("newGame")) { // start the game
				Level1Instructions lvl1i = new Level1Instructions(); // level 1 instructions
				frame.add(lvl1i);
				lvl1i.start();
				frame.remove(lvl1i);

				Level1 lvl1 = new Level1(); // start level 1
				frame.add(lvl1);
				lvl1.start();
				frame.remove(lvl1);

				ScreenPassed1 passed1 = new ScreenPassed1(); // passed level 1
				frame.add(passed1);
				passed1.start();
				frame.remove(passed1);

				Level2Instructions lvl2i = new Level2Instructions(); // level 2 instructions
				frame.add(lvl2i);
				lvl2i.start();
				frame.remove(lvl2i);

				Level2 lvl2 = new Level2(); // start level 2
				frame.add(lvl2);
				lvl2.start();
				frame.remove(lvl2);

				ScreenPassed2 passed2 = new ScreenPassed2(); // passed level 2
				frame.add(passed2);
				passed2.start();
				frame.remove(passed2);

				boolean next = false; // stays in level 3
				do {
					Level3Instructions lvl3i = new Level3Instructions(); // level 3 instructions
					frame.add(lvl3i);
					lvl3i.start();
					frame.remove(lvl3i);

					Level3 lvl3 = new Level3(); // start level 3
					frame.add(lvl3);
					if (lvl3.start() >= 8) {
						ScreenPassed3 passed3 = new ScreenPassed3(); // passed level 3
						frame.add(passed3);
						passed3.start();
						frame.remove(passed3);
						next = true; // the game continues (does not stay in level 3)
					} else {
						ScreenFailed failed = new ScreenFailed(); // failed level 3
						frame.add(failed);
						if (failed.start().equals("next")) { // the player clicked next
							next = true;
						}
						frame.remove(failed);
					}
					frame.remove(lvl3);
				} while (!next); // stays in level 3
			} else if (screen.equals("exit")) { // exit screen
				Exit exit = new Exit();
				frame.add(exit);
				exit.start();
				frame.dispose(); // closes the program
			}
		}

	}

}
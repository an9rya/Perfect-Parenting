/**
 * The Level2 class is the second level of the game
 * 
 * @author Alexandria Yau (and Andrea Cen)
 * @version 05.20.2022
 * 
 */
 
/** Import statements */
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Level2 extends JPanel implements ActionListener {

   /** This int variable stores the screen number */
   private int screen;
   
   /** the following JButton variables stores the button */
   private JButton nextButton;
   private JButton yesButton;
   private JButton noButton;
   
   /** This boolean variable stores whether or not the entire level has been completed */
   private boolean isCompleted;
   
   /** This String variable stores whether or not the answer is correct */
   private String isCorrect;
   
   /**
     * The constructor of the class where Level2 is constructed and instance variables
     * are initialized -- buttons are added but not added onto the frame yet
     */
   public Level2(){
      screen = 1;
      
      yesButton = new JButton("Yes");
      yesButton.addActionListener(this);
      yesButton.setBounds(550, 800, 180, 80);
   
      noButton = new JButton("No");
      noButton.addActionListener(this);
      noButton.setBounds(550, 800, 180, 80);
      
      nextButton = new JButton("Next");
      nextButton.addActionListener(this);
      nextButton.setBounds(550, 800, 180, 80);
      
      isCorrect=null;
   }
   
   /**
	 * This method draws the different screens
	 * @param g the graphics to draw
	 */
   @Override
    public void paintComponent(Graphics g) {
      String fileName = "screen2" + screen + isCorrect +".png";
      BufferedImage image = ParentingLessons.imageFromFile(fileName);
      g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
      
      if (screen <= 15){
         add(yesButton);
         add(noButton);
         add(nextButton); 
      } 
         
      if (screen == 15) {
         isCompleted = true;
      }
   }
   
   /**
	 * This method sees which button was pressed and reacts to
	 * it correspondingly
	 * @param e the action event
	 */
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == nextButton) {
         isCorrect=null;
         if (screen<15) {
            screen++;
         }
      } else if(e.getSource() == yesButton&&screen!=8&&screen!=11&&screen!=14){
         yesButton.setEnabled(false);
         noButton.setEnabled(false);
         isCorrect="y";
         add(nextButton);
      }else if(e.getSource() == yesButton&&(screen==8||screen==11||screen==14)){
         yesButton.setEnabled(false);
         noButton.setEnabled(false);
         isCorrect="n";
         add(nextButton);
      } else if(e.getSource() == noButton&&(screen==8||screen==11||screen==14)){
         yesButton.setEnabled(false);
         noButton.setEnabled(false);
         isCorrect="y";
         add(nextButton);
      } else if(e.getSource() == noButton&&screen!=8&&screen!=11&&screen!=14){
         yesButton.setEnabled(false);
         noButton.setEnabled(false);
         isCorrect="n";
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
      
      }
   }
   
} //The Level2 Class
import javax.swing.*;

/**
 * This Class serves as the driver and window/frame creator 
 * for our Dodgy Bird Game
 *
 * @author Essayas Kassa
 * @author Oluwademilade Dammy Adisa
 * 
 */
public class Frame2 extends JFrame
{
    public static void main(String []args)//Main Method
    {
      //JFrame Class Call   
      JFrame frame= new JFrame("Dodgy Pipe Game");
      
      //Sets Window Size
      frame.setSize(1400,1000);
      
      //Class Call
      LandScape2 landscape= new LandScape2();
      frame.add(landscape);//Adds the Landscape object to the frame
        
      frame.setResizable(false);//Prevents users from changing the window size
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}

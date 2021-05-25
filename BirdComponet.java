import javax.swing.*;
import java.awt.*;

/**
 * This Class helps keep track of our Bird.
 * Determines how high it jumps and 
 * how fast it falls
 *
 * @author Essayas Kassa
 * @author Oluwademilade Dammy Adisa
 * 
 */
public class BirdComponet
{
    // instance variables/fields
    private int x,y;
    private  int JUMP=-5;
    private final static int FAILING_RATE=1;
    private static int height=100;
    private static int width=100;
    private final  int increase=-10;
    private ImageIcon image;
    
    /**
     * Constructor for objects of class BirdComponet
     */
    public BirdComponet(int startx, int starty)
    {
        x= startx;
        y= starty;
        image= new ImageIcon("bird.gif");//Gets the bird image file in the Project
    }
    
    public void draw(Graphics g, JComponent comp)
    {
        image.paintIcon(comp,g,x,y);
    }
    
    //Setter/Mutator Methods
    public void jump()
    {
        JUMP=increase;
    }
    
    public void update()
    {
       y=y+JUMP;
       
       JUMP+=FAILING_RATE;
       if(JUMP>FAILING_RATE)
       {
           JUMP =FAILING_RATE;
        }
    }
    
    //Getter/Accessor Methods
    public int getY()
    {
        return y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getHeight()
    {
       return height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public Rectangle getBoundingBox()
    {
        return new Rectangle(x,y,width,height);
    }
    
    

    
}

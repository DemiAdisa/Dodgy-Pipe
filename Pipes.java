import java.awt.*;
import java.awt.Rectangle.*;

/**
 * This Class Helps create pipes to serve as the Obstacles 
 * for our Bird
 *
 * @author Essayas Kassa
 * @author Oluwademilade Dammy Adisa
 * 
 */
public class Pipes
{
    // instance variables
    private final int DELTA=-2;
    private final int WIDTH=100;
    private Polygon upper;
    private Polygon lower;
    private Polygon middle;
    private boolean check;
    int upX;
    
    /**
     * Constructor for objects of class Pipes
     */
    public Pipes(int xPostition)
    {
        // initialise instance variables
        check= true;
        upX=xPostition;
        
        int upY=0;
        int space=300;
        int newHeight=(int)(Math.random()*400)+40;
        
        //Arrays to Serve as Points on the Polygons
        int []upXs= {upX,upX+WIDTH,upX+WIDTH,upX};
        int []upYs = {-10,-10,newHeight,newHeight};
        int []dnXs= {upX,upX+WIDTH,upX+WIDTH,upX};
        int []dnYs= {newHeight+space,newHeight+space,1200,1200};  
        
        int[]midXs={upX,upX+WIDTH,upX+WIDTH,upX};
        int []midYs={newHeight,newHeight,newHeight+space,newHeight+space};
        
        
        //Supplying the Polygon objects with the Array Points
        upper= new Polygon(upXs, upYs,upXs.length);
        lower= new Polygon(dnXs, dnYs,dnXs.length);
        middle= new Polygon(midXs,midYs,midXs.length);
        
    }
    
    public void moveLeft()
    {
        upper.translate(DELTA,0);
        middle.translate(DELTA,0);
        
        lower.translate(DELTA,0);
    }
    
    //Draws and Fills polygons to serve as pipe obstacles
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN.darker());
        g.fillPolygon(upper);
        g.fillPolygon(lower);
    }
    
    /*
     * return true if either upper or lower pipes intersects with the rectangle r
     */
    public boolean collidesWith(Rectangle r)
    {
        r.translate(10,0);
        if(upper.intersects(r))
        {
            return true;
            
        }
        else if(lower.intersects(r))
        {
            return true;
        }
        else if(r.y<0 || r.y>1000)
        {
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
    
    //Helps Keep track of the Players Score when he goes through the Pipe Obstacles
    public boolean checkScore(Rectangle r)
    {
        if(middle.intersects(r)&& check)
        {
            check=false;
            return true;
        }
        else
        {
          return false;
        }
    }
        
    
}

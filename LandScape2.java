import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This Class helps put everything in place to create
 * or simulate the Dodgy Bird Game Environment
 *
 * @author Essayas Kassa
 * @author Oluwademilade Dammy Adisa
 */
public class LandScape2 extends JPanel
{
    // instance variables
    private int x=700;
    private int space=500;
    private BirdComponet bird;
    private Pipes obstacle;
    private ArrayList<Pipes>stones;
    private boolean Start;
    private boolean restart;
    private Timer t;
    private int Score;
    private int HighScore; 
    boolean firsttime=true;
    
    /**
     * Constructor for objects of class LandScape2
     */
    public LandScape2()
    {

        Start=false;
        stones= new ArrayList();
        bird= new BirdComponet(200,100);

        //obstacle= new Pipes(700);
        for(int i=0; i<4; i++)
        {
            Pipes pipe= new Pipes(x);
            stones.add(pipe);
            x=x+space;
        }
        loadHighScore();

        ActionListener listener= new TimerListener();
        t= new Timer(10,listener);
        
        //Creates and Registers a Mouse Listener
        MouseListener mouseListener= new MouseListener();
        addMouseListener(mouseListener);

        
    }
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(restart)
                {
                    t.start();
                    restart=false;
                }
            bird.update();
            
            for(Pipes pipe: stones)
            {
                //int i =pipe.x;
                if(pipe.collidesWith(bird.getBoundingBox()))
                {
                    t.stop();
                    saveHighScore(HighScore);
                    Start=false;
                    restart=true;
                    stones.clear();
                    Score=0;
                    x=700;
                    for(int i=0; i<4; i++)
                    {
                        Pipes anotherpipe= new Pipes(x);
                        stones.add(anotherpipe);
                        x=x+space;
                       
                    }
                    
                    repaint();
                }
                
                
                
                pipe.moveLeft();
                
                if(pipe.checkScore(bird.getBoundingBox()))
                {
                    Score++;
                    if(Score>HighScore)
                    {
                        HighScore=Score;
                    }
                    
                 }
                //if(bird.getY();
                
            }

            
            Pipes newObstacle= new Pipes(x);
            stones.add(newObstacle);
            x=x+space;

            //obstacle.moveLeft();
            repaint();

        }
    }
    
    //Helps Simulate a "Click to Start" function in the game
    class MouseListener extends MouseAdapter 
    {

        public void mousePressed(MouseEvent e)
        {
            if(!Start)
            {
                t.start();
                Start=true;
            }
            else if(Start)
            {
                bird.jump();
            }
        }

    }
    
    public void paintComponent(Graphics  g)
    {
      
        super.paintComponent(g);
        if(restart)
        {
          g.setColor(Color.WHITE);
          g.setFont(new Font("Arial", 1, 100));
          g.drawString("Tap to play agian",400,400);
        }
        setBackground(Color.CYAN);
        bird.draw(g,this);
        g.setFont(new Font("Arial", 1, 25));
        g.drawString("Score:"+Score,20,20);
        g.drawString("High Score:"+HighScore,1050,20);
        
        for(Pipes pipe: stones)
        {
            pipe.draw(g);
        }
        //obstacle.draw(g);
    }

    //Helps Display the HighScore on the Game
    public void loadHighScore() 
    {
        try
        {
            int newHighScore; 
            File infile= new File("highscore.txt");
            Scanner in= new Scanner(infile);
            while(in.hasNextInt())
            {
                HighScore= in.nextInt();
            }
            
        }catch( FileNotFoundException e){}
    }

    //Helps Store the HighScore in a File
    public void saveHighScore(int highscore)
    {
        try
        {
            File file= new File("highscore.txt");
            PrintWriter writer= new PrintWriter("highscore.txt");
            writer.println(""+highscore);
            writer.close();

        }catch(FileNotFoundException e){}
    }
}

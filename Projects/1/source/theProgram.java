
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;



public final class theProgram extends JFrame implements KeyListener {
    
    public static int[] x;
    public static int[] y;
    public static Graphics2D theG;

    public theProgram() {
        super("Tree Drawer");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setVisible(true);
        addKeyListener(this);
    }
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // Main Logic (Startup)
        theProgram theProgram = new theProgram();
        x = new int[30];
        y = new int[30];
        
        //Root X, Y
        x[0] = 150;
        y[0] = 250;
        x[1] = 140 + (int)(Math.random() * ((160 - 140) + 1));;
        y[1] = 140 + (int)(Math.random() * ((200 - 140) + 1));
        
        //half-root X, Y, 2
        for(int f = 2; f < 19; f += 2) {
            
            if(f < 7) { //Half Tree Root
                x[f] = x[1];
                y[f] = y[1];
                x[f + 1] = (x[f] - 50) + (int)(Math.random() * (((x[f] + 50) - (x[f] - 50)) + 1));
                y[f + 1] = (y[f] - 30) + (int)(Math.random() * (((y[f] - 60) - (y[f] - 30)) + 1));
            }else if(f < 11) { //1st Quarter
                x[f] = x[3];
                y[f] = y[3];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 20) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 20)) + 1));
            }else if(f < 15) { //2nd Quarter
                x[f] = x[5];
                y[f] = y[5];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 20) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 20)) + 1));
            }
            else if(f < 19) { //3rd Quarter
                x[f] = x[7];
                y[f] = y[7];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 20) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 20)) + 1));
            }
        }
    }
    
    @Override
    public void paint(Graphics g2) {
        theG = (Graphics2D) g2;

        //Draw the background
        theG.setColor(Color.BLACK);
        theG.fillRect(0, 0, getWidth(), getHeight());

        //Draw the tree root
        theG.setColor(Color.GREEN);
        for(int i = 0; i < 20; i += 2) {
            if(i < 2) {
                theG.setColor(Color.orange);
            }else{
                theG.setColor(Color.green);
            }
            theG.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }
        theG.setColor(Color.WHITE);
        theG.drawString("Press W to refresh", 20, 50);
    }
    
    @SuppressWarnings("empty-statement")
    public void drawTree() {
        System.out.println("Drawed tree!");
        
        //Draw the tree
        x[0] = 150;
        y[0] = 250;
        x[1] = 140 + (int)(Math.random() * ((160 - 140) + 1));;
        y[1] = 140 + (int)(Math.random() * ((200 - 140) + 1));
        
        //half-root X, Y, 2
        for(int f = 2; f < 19; f += 2) {
            
            if(f < 7) { //Half Tree Root
                x[f] = x[1];
                y[f] = y[1];
                x[f + 1] = (x[f] - 80) + (int)(Math.random() * (((x[f] + 80) - (x[f] - 80)) + 1));
                y[f + 1] = (y[f] - 30) + (int)(Math.random() * (((y[f] - 60) - (y[f] - 30)) + 1));
            }else if(f < 11) { //1st Quarter
                x[f] = x[3];
                y[f] = y[3];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 40) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 40)) + 1));
            }else if(f < 15) { //2nd Quarter
                x[f] = x[5];
                y[f] = y[5];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 40) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 40)) + 1));
            }
            else if(f < 19) { //3rd Quarter
                x[f] = x[7];
                y[f] = y[7];
                x[f + 1] = (x[f] - 20) + (int)(Math.random() * (((x[f] + 20) - (x[f] - 20)) + 1));
                y[f + 1] = (y[f] - 40) + (int)(Math.random() * (((y[f] - 30) - (y[f] - 40)) + 1));
            }
        }
        
        //Repaint!
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_W) {
            drawTree();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

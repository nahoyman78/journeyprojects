
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Ab extends JLabel implements KeyListener {
    
    public Ab() {
        requestFocusInWindow();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       System.out.println("Pressed!");
       if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           try {
               Aa.tcmd();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Ab.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed! 2");
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           try {
               Aa.tcmd();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Ab.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

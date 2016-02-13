
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class A {

    
    public static void main(String[] args) {
        //Initiate Frame
        Aa fr = new Aa();
        
        //Create Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        menuBar.add(menu1);
        menuBar.add(menu2);
        JMenuItem menuItem1 = new JMenuItem("Exit");
        JMenuItem menuItem2 = new JMenuItem("Load Text File");
        JMenuItem menuItem3 = new JMenuItem("Save Current Text");
        JMenuItem menuItem4 = new JMenuItem("Clear Text");
        
        //Add the Menu Items
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu2.add(menuItem4);
        fr.setJMenuBar(menuBar);
        
        //Actions Listener for Menus
        menuItem1.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        menuItem2.addActionListener((ActionEvent e) -> {
            Aa.readFile();
            JOptionPane.showMessageDialog(fr,
            "Text Loaded!");
        });
        menuItem3.addActionListener((ActionEvent e) -> {
            try {
                Aa.savetext();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(fr,
                "ERROR: File not found!");
            }
            JOptionPane.showMessageDialog(fr,
            "Text Successfully Saved!");
        });
        menuItem4.addActionListener((ActionEvent e) -> {
            Aa.cltext();
            JOptionPane.showMessageDialog(fr,
            "Text Cleared!");
        });
        
        //Set the Frame Visible
        fr.setVisible(true);
    }
    
}

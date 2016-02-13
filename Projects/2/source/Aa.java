
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Aa extends JFrame implements ActionListener {
    private static JTextField fild;
    private static JTextArea tArea;
    private static String cText;
    public static int counttimes;
    public Boolean on = true;
    public static Ab f;
    public static JButton cmd;
    
    public Aa() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        //THE FRAME
        setIconImage(null);
        setTitle("Simple Input Editor");
        setSize(400, 400);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setFocusable(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       
        //JPanels
        
        //Requests "Enter" Command File
        f = new Ab();
        f.requestFocusInWindow();
        this.addKeyListener(f);
        
        //TextField where you write
        fild = new JTextField("");
        fild.setBorder(blackline);
        fild.setBounds(120, 10, 250, 20);
        
        //Text to show where to input
        JLabel daText = new JLabel();
        daText.setOpaque(true);
        daText.setText("Input Command:");
        daText.setBackground(Color.white);
        daText.setBounds(10, 10, 100, 20);
        
        //Enter Text Button
        cmd = new JButton("Enter");
        cmd.setVerticalTextPosition(AbstractButton.CENTER);
        cmd.setHorizontalTextPosition(AbstractButton.CENTER);
        cmd.setBounds(299, 35, 70, 20);
        cmd.setActionCommand("send");
        cmd.addActionListener(this);
        cmd.setBorder(blackline);
        cmd.setBackground(Color.black);
        cmd.setForeground(Color.white);
        cmd.setToolTipText("Enter Command");
        
        //Text Area
        tArea = new JTextArea();
        tArea.setBounds(10, 100, 360, 230);
        tArea.setOpaque(true);
        tArea.setBorder(blackline);
        tArea.setEditable(false);
        
        //Add Component
        add(fild);
        add(daText);
        add(cmd);
        add(tArea);
    }
    
    //Command to append input to text
    public static void tcmd() throws FileNotFoundException {
        
        //If Input is not NULL
        if(!fild.getText().equals("")) {
            
            System.out.println("ACTION: Entered Command");
            cText = tArea.getText(); //Get text from Text Area
            
            //Check if there is less than 14 Lines
            if(counttimes < 14) {
                //Check if there is no text in Text Area
                if(!tArea.getText().equals("")) {
                    tArea.append("\n" + fild.getText());
                }else{
                    tArea.append(fild.getText());
                }
                counttimes += 1;
            }else{
                //Save the Current Text
                try (PrintStream out = new PrintStream(new FileOutputStream("gettext.txt"))) {
                    out.print(tArea.getText());
                }
                counttimes = 0;
                counttimes += 1;
                tArea.setText(fild.getText());
            }
            fild.setText("");
        }else{
            System.out.println("ERROR: Command Bar not entered");
        }
    }
    
    //Command to read the file
    public static void readFile() {
        redit();
    }
    
    //Function to read to file
    private static void redit() {
        
        //Check if the file exist
        try(BufferedReader br = new BufferedReader(new FileReader("gettext.txt"))) {
            
            
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
            tArea.setText(sb.toString());
            System.out.println(sb.toString());
            
        //Exceptions
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Aa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Clear the Text
    public static void cltext() {
        tArea.setText("");
    }
    
    //Save Text
    public static void savetext() throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream("gettext.txt"))) {
            out.print(tArea.getText());
        }
    }

    //The Button Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //If Input button is Clicked
        if ("send".equals(e.getActionCommand())) {
            try {
                tcmd();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Aa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

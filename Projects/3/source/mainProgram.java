
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * If you want to use these codes.
 * JUST USE THEM! (But please do contact me to check your projects)!
 * 
 *  SIMPLE CALCULATOR (2016) from Yohan Joo
 *  Use it for learning purposes!
 *  Contact me: nahoyman78@gmail.com, if you want to contact me.
 * 
 *  - Variables
 *  - Window Function
 *  - Initiate Button
 *  - Main Function
 *  - Actions preformed
 * 
 * @author Yohan Joo
 */
public final class mainProgram extends JFrame implements ActionListener {
    
    //Load Buttons
    public JButton[] enterButton;
    public JButton[] effectButton;
    
    //Load Text Field
    public JTextField inputBar;
    
    //Black Border
    Border blackline = BorderFactory.createLineBorder(Color.black);
    
    //The Magics
    public String firstNumb, secondNumb, effectFunc;
    public double resultNumb;
    public int iFirstNumb, iSecondNumb;
    
    //Checker which term it is
    public boolean first = true, second = false, result = false;

    //MainProgram - Function
    public mainProgram() {
        //Initiate MainProgram Window
        super("Calculator");
        setSize(185, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //Call the Funtion: InitiateButtons
        InitiateButtons();
        
        //Text Field - Show what's happening
        inputBar = new JTextField("");
        inputBar.setBorder(blackline);
        inputBar.setOpaque(true);
        inputBar.setBounds(10, 10, 155, 45);
        inputBar.setEditable(false);
        inputBar.setBackground(Color.white);
        inputBar.setHorizontalAlignment(JTextField.RIGHT);
        add(inputBar);
        
        //Load The Addition, Subtraction, Multiplication.
        effectButton = new JButton[3];
        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                effectButton[i] = new JButton("+");
                effectButton[i].setActionCommand("plus");
                effectButton[i].addActionListener(this);
            }else if(i == 1) {
                effectButton[i] = new JButton("-");
                effectButton[i].setActionCommand("minus");
                effectButton[i].addActionListener(this);
            }else if(i == 2) {
                effectButton[i] = new JButton("X");
                effectButton[i].setActionCommand("multi");
                effectButton[i].addActionListener(this);
            }
            effectButton[i].setVerticalTextPosition(AbstractButton.CENTER);
            effectButton[i].setHorizontalTextPosition(AbstractButton.CENTER);
            effectButton[i].setBackground(Color.white);
            effectButton[i].setBorder(blackline);
            effectButton[i].setBounds(10 + (i * 55), 210, 45, 45);
            add(effectButton[i]);
        }
        
    }
    
    public void InitiateButtons() {
        //Make enterButton Arrays have max 9 buttons
        enterButton = new JButton[9];
        
        //Create the Buttons
        for(int i = 0; i < 9; i++) {
            String ButtonName = Integer.toString(i + 1);
            
            enterButton[i] = new JButton(ButtonName);
            enterButton[i].setVerticalTextPosition(AbstractButton.CENTER);
            enterButton[i].setHorizontalTextPosition(AbstractButton.CENTER);
            enterButton[i].setActionCommand("" + ButtonName);
            enterButton[i].setBackground(Color.white);
            enterButton[i].setBorder(blackline);
            enterButton[i].addActionListener(this);
            
            if(i < 3) {
                enterButton[i].setBounds(10 + (i * 55), 60, 45, 45);
            }else if(i < 6) {
                enterButton[i].setBounds(10 + ((i - 3) * 55), 110, 45, 45);
            }else if(i < 9) {
                enterButton[i].setBounds(10 + ((i - 6) * 55), 160, 45, 45);
            }
            
            add(enterButton[i]);
            
        }
    }
    
    //Main function - WITHOUT THIS, NOTHING HAPPENS DUDE
    public static void main(String[] args) {
        //Load Main Program
        mainProgram mainProgram = new mainProgram();
        mainProgram.setVisible(true);
    }

    //Action Command commands goes here
    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {
        
        //Check if there has already been a result
        if(!result) {
            if (null != e.getActionCommand()) switch (e.getActionCommand()) {
                case "1":
                    inputBar.setText(inputBar.getText() + "1");
                    break;
                case "2":
                    inputBar.setText(inputBar.getText() + "2");
                    break;
                case "3":
                    inputBar.setText(inputBar.getText() + "3");
                    break;
                case "4":
                    inputBar.setText(inputBar.getText() + "4");
                    break;
                case "5":
                    inputBar.setText(inputBar.getText() + "5");
                    break;
                case "6":
                    inputBar.setText(inputBar.getText() + "6");
                    break;
                case "7":
                    inputBar.setText(inputBar.getText() + "7");
                    break;
                case "8":
                    inputBar.setText(inputBar.getText() + "8");
                    break;
                case "9":
                    inputBar.setText(inputBar.getText() + "9");
                    break;
            }
        }else{
            inputBar.setText("");
            first = true;
            second = false;
            result = false;
            
            if (null != e.getActionCommand()) switch (e.getActionCommand()) {
                case "1":
                    inputBar.setText(inputBar.getText() + "1");
                    break;
                case "2":
                    inputBar.setText(inputBar.getText() + "2");
                    break;
                case "3":
                    inputBar.setText(inputBar.getText() + "3");
                    break;
                case "4":
                    inputBar.setText(inputBar.getText() + "4");
                    break;
                case "5":
                    inputBar.setText(inputBar.getText() + "5");
                    break;
                case "6":
                    inputBar.setText(inputBar.getText() + "6");
                    break;
                case "7":
                    inputBar.setText(inputBar.getText() + "7");
                    break;
                case "8":
                    inputBar.setText(inputBar.getText() + "8");
                    break;
                case "9":
                    inputBar.setText(inputBar.getText() + "9");
                    break;
            }
        }
        
        //If addition, subtraktion or multiplication is pressed
        if("plus".equals(e.getActionCommand()) || "minus".equals(e.getActionCommand()) || "multi".equals(e.getActionCommand())) {
            String theEffect = e.getActionCommand();
            
            //Check if it's the first term.
            if(first) {
                
                //Check if there is null
                if(!"".equals(inputBar.getText())) {
                    if(null != theEffect) switch (theEffect) {
                        case "plus":
                            effectFunc = "plus";
                            break;
                        case "minus":
                            effectFunc = "minus";
                            break;
                        case "multi":
                            effectFunc = "multi";
                            break;
                    }
                    iFirstNumb = Integer.parseInt(inputBar.getText());
                    inputBar.setText("");
                    first = false;
                    second = true;
                    result = false;
                }
            }
            
            //Check if it's the second term
            if(second) {
                if(!"".equals(inputBar.getText())) {
                    int resulty = 0;
                    iSecondNumb = Integer.parseInt(inputBar.getText());
                    
                    //Check if there is null
                    if(null != effectFunc) switch (effectFunc) {
                        case "plus":
                            resulty = iFirstNumb + iSecondNumb;
                            break;
                        case "minus":
                            resulty = iFirstNumb - iSecondNumb;
                            break;
                        case "multi":
                            resulty = iFirstNumb * iSecondNumb;
                            break;
                    }

                    //Show Results!
                    inputBar.setText("" + resulty);
                    first = false;
                    second = false;
                    result = true;
                }
            }
        }
    }
    
}

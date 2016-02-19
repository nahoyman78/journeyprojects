
import java.util.Scanner;

/**
 * Simple Quadratic Formula and Zeropoints
 * @author Yohan Joo
 */
public class mainProgram {
    
    //Variables
    public static double Y, P, Q;
    
    public static void main(String[] args) {
        //Main Function
        writeTheNumbers();
    }
    
    //The Main Function
    public static void writeTheNumbers() {
        
        //Load the Input class Scanner.
        Scanner scan = new Scanner(System.in);
        
        //Input the Variables
        System.out.println("P Value Here:");
        P = scan.nextDouble();
        System.out.println("Q Value Here:");
        Q = scan.nextDouble();
        
        //List every Y value from -5 to 5
        for(int i = -5; i < 6; i++) {
            Y = (i * i) + (P*i) + Q;
            System.out.println("When X is " + i + "; Y is " + Y);
        }
        
        //Load the array Zeropoints
        double[] zeropoint;
        zeropoint = new double[2];
        
        //Calculate the Zeropoints
        zeropoint[0] = -(P/2) + Math.sqrt(((P/2) * (P/2)) - Q);
        zeropoint[1] = -(P/2) - Math.sqrt(((P/2) * (P/2)) - Q);
        
        //Print the Zero Values
        for(int point = 0; point < 2; point++) {
            System.out.println("Zerpoint: " + zeropoint[point]);
        }
        
    }
}

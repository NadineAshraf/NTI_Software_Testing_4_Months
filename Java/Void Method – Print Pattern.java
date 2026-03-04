import java.util.Scanner;

public class MathUtils {
    // Method to add two integers
    public static void astrk() {
    Scanner input = new Scanner(System.in);

        int row;
        System.out.println("Enter number of rows: ");
        row = input.nextInt();
        
        for (int i = 0; i < row; i++) {
            for (int j=0; j<i+1; j++)
            {
                System.out.print("*");
            }
           System.out.print("\n");
            
        }
       
    }

    public static void main(String[] args) {
        astrk();
        
    }

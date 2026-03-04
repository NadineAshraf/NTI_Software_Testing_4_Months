import java.util.Scanner;

public class MathUtils {
    // Method to add two integers
    public static int largest() {
    Scanner input = new Scanner(System.in);

        int[] numbers = new int[3];
        int max = -1;
        // Taking 5 integers from the user
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
         for (int i = 0; i < 3; i++)
         {   if ((i+1) < 3)
             {
                if(numbers[i] > numbers[i+1])
                {
                 max = numbers[i];
                }
                else
                {
                    max = numbers[i+1];
                }
            }
         }
         return max;
    }

    public static void main(String[] args) {
        int result = largest();
        System.out.println("Result: " + result);  // Output: 8
    }
}

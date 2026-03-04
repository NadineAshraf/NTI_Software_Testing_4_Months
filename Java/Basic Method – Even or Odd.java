import java.util.Scanner;

public class MathUtils {
    // Method to add two integers
    public static boolean isEven(int num) {
        boolean flag;
        if(num%2 == 0)
        {
            flag = true;
        }
        else
        {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        boolean result = isEven(5);
        System.out.println("Result: " + result);  // Output: 8
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        float sum=0,avg=0;

        int[] numbers = new int[size];

        // Taking input from user
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Printing numbers separated by space
       
        for (int i = 0; i < size; i++) {
            sum+=numbers[i];
           
        }
         System.out.println("Sum =" + sum );
         System.out.print("Average = " + sum/size);

        input.close();
    }
}

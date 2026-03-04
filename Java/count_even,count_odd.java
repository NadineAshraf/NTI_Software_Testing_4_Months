import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];
        int count_even = 0, count_odd = 0;
        // Taking 5 integers from the user
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            if (numbers[i]%2 == 0)
            {
                count_even+=1;
            }
            else
            {
                count_odd+=1;
            }
        }
         System.out.println("Number of even numbers = " + count_even);
         System.out.println("Number of odd numbers = " + count_odd);
       

        input.close();
    }
}

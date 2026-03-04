import java.util.Scanner;
public class reverse {

    public static void reverse() {
        Scanner input = new Scanner(System.in);
        int i=0;
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        

        int[] arr = new int[size];

        // Taking input from user
        for (i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
        System.out.print("The reversed array: ");
        for(i=size-1; i>=0 ; i--)
        {
            System.out.print(arr[i]+ " ");
        }
        
       
    }

    public static void main(String[] args) {
        
        reverse();
    }
}

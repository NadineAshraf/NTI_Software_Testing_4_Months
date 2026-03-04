import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    int[] arr = {12, 45, 67, 23, 9, 54, 81, 36};
    int flag=0,i=0;
        System.out.println("Please enter the needed number for search: ");
        int number = input.nextInt();
        
        for(i=0; i<8; i++)
        {
            if(number == arr[i])
            {
                flag=1;
                break;
                
                
            }
            else
            {
                flag=0;
               
            }
        }
       if (flag ==1)
       {
         System.out.println("Number " + number + " is found at index " + i);  
       }
       else
       {
            System.out.println("Not found");
       }
       

        input.close();
    }
}

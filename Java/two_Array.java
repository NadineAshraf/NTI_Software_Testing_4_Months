public class Main {
    public static void main(String[] args) {

        int[][] original = { {1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12} };
                             
       int sum=0;
       for(int i=0; i<3; i++)
       {
           for(int j=0; j<4; j++)
           {
               sum+=original[i][j];
           }
       }
       System.out.println("Sum = " + sum);
                             
    }
    
}

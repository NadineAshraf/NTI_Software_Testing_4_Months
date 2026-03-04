public class swap {

    public static void swap(int x, int y) {
       int temp;
       temp=x;
       x=y;
       y=temp;
       System.out.print("The first number = " + x + "\nThe second number = " + y);
       
    }

    public static void main(String[] args) {
        int l = 5 , n=2;
        swap(l,n);
    }
}

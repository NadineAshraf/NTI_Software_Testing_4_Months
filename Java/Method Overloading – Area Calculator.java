import java.util.Scanner;

public class MathUtils {

    public static double Area_Calculator(double radius) {
        // Area of circle
        return 3.14 * radius * radius;
    }

    public static double Area_Calculator(double length, double width) {
        // Area of rectangle
        return length * width;
    }

    // Changed method name to avoid duplicate signature
    public static double Area_Triangle(double base, double height) {
        // Area of triangle
        return 0.5 * base * height;
    }

    public static void main(String[] args) {

        double shape, rec, triangle;

        shape = Area_Calculator(5.0);
        rec = Area_Calculator(3.0, 5.0);
        triangle = Area_Triangle(4.0, 3.0);

        System.out.println("Area of the circle = " + shape);
        System.out.println("Area of the rectangle = " + rec);
        System.out.println("Area of the triangle = " + triangle);
    }
}

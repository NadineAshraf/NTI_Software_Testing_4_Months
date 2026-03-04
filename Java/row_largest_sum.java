import java.util.Scanner;

public class RowLargestSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[3][3];

        // Input values
        System.out.println("Enter 9 integers (row by row):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter value for position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Find row with largest sum
        int maxSum = 0;
        int maxIndex = 0;

        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += matrix[i][j];
            }

            if (i == 0 || rowSum > maxSum) {
                maxSum = rowSum;
                maxIndex = i;
            }
        }

        // Output result
        System.out.println("Row with the largest sum: " + maxIndex);
        System.out.println("Largest sum: " + maxSum);

        scanner.close();
    }
}

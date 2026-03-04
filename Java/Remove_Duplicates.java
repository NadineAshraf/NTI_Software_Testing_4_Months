public class Main {
    public static void main(String[] args) {

        int[] original = {4, 2, 4, 5, 2, 3, 1, 5};
        int[] temp = new int[original.length]; // temporary array

        int uniqueCount = 0;

        // Loop through original array
        for (int i = 0; i < original.length; i++) {

            boolean isDuplicate = false;

            // Check if already exists in temp array
            for (int j = 0; j < uniqueCount; j++) {
                if (original[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not duplicate, add to temp
            if (!isDuplicate) {
                temp[uniqueCount] = original[i];
                uniqueCount++;
            }
        }

        // Print unique values
        System.out.print("Array without duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}

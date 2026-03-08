public class RotateArray {

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        // Step 1: reverse whole array
        reverse(arr, 0, n - 1);

        // Step 2: reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: reverse remaining elements
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        rotateArray(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

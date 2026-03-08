public class Two_Sum {

    public static void Two_Sum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) { // start j from i+1
                if ((arr[i] + arr[j]) == target) {
                    System.out.println("The indices = [" + i + ", " + j + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int tar = 9;
        Two_Sum(arr, tar);
    }
}

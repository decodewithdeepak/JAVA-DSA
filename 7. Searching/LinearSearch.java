// Linear Search -> Based on Traversal
// Time Complexity: O(n) - Linear Time

public class LinearSearch {

    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {32, 59, 26, 41, 58};
        int target = 41;
        System.out.println(linearSearch(arr, target));
    }
}

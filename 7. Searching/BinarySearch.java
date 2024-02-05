// Notes: https://drive.google.com/file/d/1-_3LdbJOTIcKsc8OI9oDJ5Jv_do38dZv/view

// Binary Search -> Based on Divide and Conquer
// Time Complexity: O(log n) [Iterative or Recursive]
// Space Complexity: O(1) [Iterative] or O(log n) [Recursive]

public class BinarySearch {

    static int binarySearch(int[] arr, int target) { // TC = O(log n), SC = O(1)
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Find the middle element
            int mid = start + (end - start) / 2; // To avoid integer overflow -> Better than (start + end) / 2

            // Check if the middle element is the target
            if (target == arr[mid]) {
                return mid;
            }

            // If the target is greater than the middle element -> Ignore the left half
            if (target > arr[mid]) {
                start = mid + 1;
            } 
            // If the target is less than the middle element -> Ignore the right half
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Recursive Binary Search
    static int binarySearchRec(int[] arr, int target, int start, int end) { // TC = O(log n), SC = O(log n)
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        } 
        else if (target > arr[mid]) {
            return binarySearchRec(arr, target, mid + 1, end);
        } 
        else {
            return binarySearchRec(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {26, 32, 41, 58, 59}; // Sorted array
        int target = 41;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchRec(arr, target, 0, arr.length - 1));
    }
}

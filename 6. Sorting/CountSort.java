// Notes: https://drive.google.com/file/d/18OIaCIAd2aVi-Oj3sSohzAoQuZnZQDU8/view

// Count Sort Algorithm: - Based on the concept of counting the occurrences of each element in the array
// Non-comparison based sorting algorithm
// Range of elements should be known (1-100)

// Count the occurrences of each element in the array
// Rearrange the array in such a way that all elements are sorted in increasing order

// Example: Given array: 4 3 1 5 3 1 3 5
// Count array: 0 2 0 3 1 2
//              0 1 2 3 4 5
// Answer array: 1 1 3 3 3 4 5 5

// Time Complexity:-
// Worst Case: O(n + k) -> When the range of elements is very large (k is the range of elements)
// Best Case: O(n) -> When the range of elements is very small
// Average Case: O(n + k) -> When the range of elements is very large

// Space Complexity:-
// Worst Case: O(n + k) -> for the count array and output array

// Count Sort is a stable sort, as it preserves the relative order of equal elements.
// Count Sort is not an in-place sort, as it requires extra space for the count array.

public class CountSort {

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void countSort(int[] arr) {
        int n = arr.length;
        int [] output = new int[n];

        // Find the maximum element in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) { // TC -> n
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a count array to store the frequency of each element
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) { // TC -> n
            count[arr[i]]++;
        }

        // Make prefix sum of the count array
        for (int i = 1; i <= max; i++) { // TC -> max
            count[i] += count[i - 1];
        }

        // Find the index of each element in the original array and put it in the output array
        for (int i = n - 1; i >= 0; i--) { // TC -> n
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < n; i++) { // TC -> n
            arr[i] = output[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 5, 3, 1, 3, 5 };
        System.out.print("Before Sorting: ");
        printArray(arr);

        countSort(arr);
        System.out.print("\nAfter Sorting: ");
        printArray(arr);
    }
}

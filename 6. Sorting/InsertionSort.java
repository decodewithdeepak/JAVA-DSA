// Notes: https://drive.google.com/file/d/1PGPsEd0Fi7aZiGPWFvy-KHBZ-oAncP-5/view

// Insertion Sort Algorithm: - Based on inserting the current element in the sorted part of the array
// We do a certain number of passes through the array, and in each pass, we insert the current element in the sorted part of the array.

// Example: Given array: 5 4 1 2 3 0
// Pass 1: 4 5 1 2 3 0
// Pass 2: 1 4 5 2 3 0
// Pass 3: 1 2 4 5 3 0
// Pass 4: 1 2 3 4 5 0
// Pass 5: 0 1 2 3 4 5 -> Sorted array

// Time Complexity:-
// Worst Case: O(n^2) -> When the array is in reverse order
// Best Case: O(n) -> When the array is already sorted
// Average Case: O(n^2) -> When the array is randomly sorted

// Space Complexity: O(1) -> No extra space/memory is used

// In-place Sorting: Insertion Sort is an in-place sort, as it doesn't require any extra space.
// Stable Sorting: Insertion Sort is a stable sort, as it preserves the relative order of equal elements.

public class InsertionSort {

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) { // Start from the second element
            int key = arr[i]; // Current element to be inserted in the sorted part of the array
            int j = i - 1; // Last element of the sorted part of the array
            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2, 3, 0 };
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

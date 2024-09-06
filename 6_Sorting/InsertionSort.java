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

    static void insertionSort1(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) { // start from 2nd element
            int j = i; // current index
            // insert a[i] in the sorted left part 0...i-1
            while (j > 0 && a[j] < a[j - 1]) {
                // swap a[j] and a[j-1]
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }

    static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) { // start from 2nd element
            int key = a[i]; // current element to be inserted
            int j = i - 1; // index of the last element in the sorted part
            // Move elements greater than key to one position ahead of their current position
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j]; // shift elements to the right
                j--;
            }
            a[j + 1] = key; // insert the key at the correct position
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

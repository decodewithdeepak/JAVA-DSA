// Notes: https://drive.google.com/file/d/1H8zd4XZweI8S7d2dnmoRQPd89cpTzw5s/view

// Selection Sort Algorithm: - Based on finding the minimum element and putting it in the sorted part of the array
// We do a certain number of passes through the array, and in each pass, we find the minimum element and put it in the sorted part of the array.
// In each pass, the minimum element will be put in the sorted part of the array.
// The number of passes required is n-1, where n is the number of elements in the array.

// Example: Given array: 5 4 1 2 3 0
// Pass 1: 0 4 1 2 3 5
// Pass 2: 0 1 4 2 3 5
// Pass 3: 0 1 2 4 3 5
// Pass 4: 0 1 2 3 4 5
// Pass 5: 0 1 2 3 4 5 -> Sorted array

// Time Complexity:-
// Worst Case: O(n^2) -> When the array is in reverse order
// Best Case: O(n^2) -> When the array is already sorted
// Average Case: O(n^2) -> When the array is randomly sorted

// Space Complexity: O(1) -> No extra space/memory is used

// Unstable Sorting: Selection Sort is an unstable sort, as it doesn't preserve the relative order of equal elements.
// In-place Sorting: Selection Sort is an in-place sort, as it doesn't require any extra space.

public class SelectionSort {
    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) { // i represent the current index
            int minIndex = i;
            for (int j = i + 1; j < n; j++) { // find minimum in unsorted part
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // swap -> current element and minimum element -> a[i] and a[minIndex]
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2, 3, 0 };
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

// Notes: https://drive.google.com/file/d/1RVxmt2ed2XMhzzmJmxu-BaE9DMfRs8rF/view

// Quick Sort Algorithm: - Based on the concept of partitioning
// Choose a pivot element from the array - start or end or middle or random
// Rearrange the array in such a way that all elements less than the pivot are to the left of the pivot, and all elements greater than the pivot are to the right of the pivot.
// Recursively sort the two sub-arrays to the left and right of the pivot.

// Example: https://i.ibb.co/0X0CtLF/quicksort-example.jpg
// Given array: 7 -2 4 1 6 5 0 -4 2 -> Pivot: 2
// Pass 1: -2 1 0 -4 | 2 | 7 4 6 5 -> Pivot: -4, 5
// Pass 2: -4 -2 1 0 | 2 | 4 5 7 6 -> Pivot: 0, 6
// Pass 3: -4 -2 0 1 | 2 | 4 5 6 7 -> Sorted array

// Time Complexity:-
// Worst Case: O(n^2) -> When the array is already sorted or in reverse order
// Best Case: O(n log n) -> When the pivot is the median of the array - for optimized quick sort
// Average Case: O(n log n) -> When the pivot is the median of the array

// Space Complexity:-
// Worst Case: O(n) 
// Best Case: O(log n) -> for the recursive calls

// Quick Sort is an unstable sort, as it doesn't preserve the relative order of equal elements.
// Quick Sort is an in-place sort, as it doesn't require any extra space.

public class QuickSort {

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void swap(int[] arr, int i, int j) { // O(1)
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) { // O(n)
        int pivot = arr[high]; // last element as pivot
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return; // base condition
        int pi = partition(arr, low, high); // pi is partitioning index
        quickSort(arr, low, pi - 1); // before pi
        quickSort(arr, pi + 1, high); // after pi
    }

    public static void main(String[] args) {
        int[] arr = { 7, -2, 4, 1, 6, 5, 0, -4, 2 };
        System.out.print("Before Sorting: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);
        System.out.print("\nAfter Sorting: ");
        printArray(arr);
    }
}

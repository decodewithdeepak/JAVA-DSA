// Notes: https://drive.google.com/file/d/1dnrR6jxZ0lY7GeDh2-XzeMLJKDsbzBUS/view

// Bubble Sort Algorithm: - Based on swapping adjacent elements
// We do a certain number of passes through the array, and in each pass, we compare adjacent elements and swap them if they are in the wrong order.
// In each pass, the largest element will be bubbled up to the end of the array.
// The number of passes required is n-1, where n is the number of elements in the array.

// Example: Given array: 5 4 1 2 3 0
// Pass 1: 4 1 2 3 0 5
// Pass 2: 1 2 3 0 4 5
// Pass 3: 1 2 0 3 4 5
// Pass 4: 1 0 2 3 4 5
// Pass 5: 0 1 2 3 4 5 -> Sorted array

// Time Complexity:- 
// Worst Case: O(n^2) -> When the array is in reverse order
// Best Case: O(n) -> When the array is already sorted - for optimized bubble sort
// Average Case: O(n^2) -> When the array is randomly sorted

// Space Complexity: O(1) -> No extra space/memory is used

// Max Number of Swaps: n*(n-1)/2 -> When the array is in reverse order
// Optimized Bubble Sort: If the array is already sorted, then we don't need to do any more passes. 
// We can use a flag to check if any swapping has happened in the current pass. If no swapping has happened, then the array is already sorted, and we can return.

// Stable and Unstable Sort: Bubble Sort is a stable sort, as it preserves the relative order of equal elements.
// In-place and Not-in-place Sort: Bubble Sort is an in-place sort, as it doesn't require any extra space.

public class BubbleSort {
    static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) { // n-1 iterations/passes
            boolean flag = false; // has any swapping happened -> for optimization
            
            for (int j = 0; j < n - 1 - i; j++) { // last i elements are already at correct sorted positions, so no need to check them
                if (a[j] > a[j + 1]) {
                    // swap -> a[j] and a[j+1]
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true; // some swap has happened
                }
            }

            if (!flag) { // have any swaps happened?
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2, 3, 0 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
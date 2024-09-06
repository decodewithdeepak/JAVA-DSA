// Merge Sort Algorithm:- Based on the divide and conquer strategy
// Divide the array into two equal halves(sub-arrays).
// Sort the two sub-arrays recursively.
// Merge the two sorted sub-arrays to produce the sorted array.

// Example: Given array: 5 4 1 2 3 0
// Pass 1: 5 4 1 | 2 3 0
// Pass 2: 5 4 | 1 | 2 3 | 0
// Pass 3: 5 | 4 | 1 | 2 | 3 | 0
// Merge Pass 1: 4 5 | 1 | 2 3 | 0
// Merge Pass 2: 1 4 5 | 2 3 | 0
// Merge Pass 3: 1 2 3 4 5 | 0
// Merge Pass 4: 0 1 2 3 4 5 -> Sorted array

// Time Complexity: O(n log n) -> for all cases - worst, best, average
// Space Complexity: O(n) -> for the temporary arrays used for merging

// Merge Sort is a stable sort, as it preserves the relative order of equal elements.
// Merge Sort is not an in-place sort, as it requires extra space for the temporary arrays used for merging.

public class MergeSort {
    
    static void merge(int[] arr, int l, int m, int r) { // O(n)
        int n1 = m - l + 1; // size of left sub-array
        int n2 = r - m; // size of right sub-array

        int[] L = new int[n1]; // left sub-array - temp arrays
        int[] R = new int[n2]; // right sub-array - temp arrays

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2)
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        while (i < n1) 
            arr[k++] = L[i++];
        while (j < n2) 
            arr[k++] = R[j++];
        
    }

    static void mergeSort(int[] arr, int l, int r) { // O(n log n)
        if (l >= r) return; // base condition
        int m = (l + r) / 2; // middle index - mid
        mergeSort(arr, l, m); 
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void main(String[] args) {
        
        int[] arr = { 5, 4, 1, 2, 3, 0 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}

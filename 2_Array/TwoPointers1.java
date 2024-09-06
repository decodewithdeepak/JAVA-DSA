// 1. Union of Two Sorted Arrays (GFG)
// 2. Intersection of Two Sorted Arrays (GFG) 

import java.util.ArrayList;

public class TwoPointers1 {

    // 1. Union of Two Sorted Arrays (GFG)
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0; // two pointers

        // traverse both arrays simultaneously
        while (i < n && j < m) {

            // skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            // skip duplicates in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // add smaller element to union
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } 
            else { // if both elements are same
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        // add remaining elements of arr1
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1]) { // skip duplicates
                union.add(arr1[i]);
            }
            i++;
        }

        // add remaining elements of arr2
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    // 2. Intersection of Two Sorted Arrays (GFG)
    public static ArrayList<Integer> printIntersection(int arr1[], int arr2[]) {
        ArrayList<Integer> intersection = new ArrayList<>();
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0; // two pointers

        // traverse both arrays simultaneously
        while (i < n && j < m) {

            // skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            // skip duplicates in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // if both elements are same, add to intersection and move both pointers
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } 
            // move pointer of smaller element
            else if (arr1[i] < arr2[j]) {
                i++;
            } 
            else {
                j++;
            }
        }

        // if intersection is empty
        if (intersection.size() == 0) intersection.add(-1);

        return intersection;
    }

    public static void main(String[] args) {
        // 1. Union of Two Sorted Arrays (GFG)
        // int n = 7, arr1[] = {1, 1, 3, 4, 5, 5, 8};  
        // int m = 6, arr2[] = {2, 3, 3, 6, 7, 7};
        // System.out.println(findUnion(arr1, arr2, n, m)); // [1, 2, 3, 4, 5, 6, 7, 8]

        // 2. Intersection of Two Sorted Arrays (GFG)
        int arr1[] = {1, 2, 2, 3, 4};
        int arr2[] = {6, 7, 8};
        System.out.println(printIntersection(arr1, arr2)); // [2, 4]
    }
}

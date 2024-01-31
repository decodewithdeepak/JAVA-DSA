// Notes: https://drive.google.com/file/d/1f19ksDybA-h8x7-vAM2BNY5Enu12xIEr/view

// Recursion on Arrays | Linear Search | Find all indices

// 1: Print whether x exists in the array or not.
// 2: Return index (first) if x exists in the array.
// 3: Return all indices if x exists in the array.
// 4: Return all indices as Array List if x exists in the array. 
// 5: Find last index of x in the array.
// 6: Implement isSorted() method.

import java.util.ArrayList;

public class RecursionOnArrays1 {

    static boolean find(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx >= arr.length) return false; // base case
        if (arr[idx] == x) return true; // self work
        return find(arr, idx + 1, x); // recursive call
    }

    static int findIndex(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx >= arr.length) return -1; // base case
        if (arr[idx] == x) return idx; // self work
        return findIndex(arr, idx + 1, x); // recursive call
    }

    static void findAllIndices(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx >= arr.length) return; // base case
        if (arr[idx] == x) System.out.print(idx + " "); // self work
        findAllIndices(arr, idx + 1, x); // recursive call
    }

    static ArrayList<Integer> allIndices(int[] arr, int idx, int x) {
        if (idx >= arr.length) return new ArrayList<>(); // return empty array list
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr[idx] == x) ans.add(idx); // ans -> {2}
        ArrayList<Integer> smallAns = allIndices(arr, idx + 1, x); // smallAns -> {5, 6}
        ans.addAll(smallAns); // ans -> {2, 5, 6}
        return ans;
    }
    
    static int lastIndex(int[] arr, int idx, int x) {
        // base case
        if (idx == arr.length) return -1;
        // recursive call
        int smallAns = lastIndex(arr, idx + 1, x);
        // self work
        if (smallAns == -1 && arr[idx] == x) return idx;
        return smallAns;
    }

    static boolean isSorted(int[] arr, int idx) {
        if (idx >= arr.length - 1) return true; // base case
        if (arr[idx] > arr[idx + 1]) return false; // self work
        return isSorted(arr, idx + 1); // recursive call
    }

    public static void main(String[] args) {
        
        int[] arr = { 10, 30, 20, 50, 40, 20, 20 };
        int x = 20;

        // 1: Print whether x exists in the array or not.
        boolean isFound = find(arr, 0, x);
        System.out.println(isFound);

        // 2: Return index if x exists in the array.
        System.out.println(findIndex(arr, 0, x));

        // 3: Return all indices if x exists in the array.
        findAllIndices(arr, 0, x);

        // 4: Return all indices as Array List if x exists in the array. 
        ArrayList<Integer> indicesList = allIndices(arr, 0, x);
        System.out.println(indicesList);
        // for (Integer i : indicesList) 
        //     System.out.print(i + " ");


        // 5: Find last index of x in the array.
        System.out.println(lastIndex(arr, 0, x));

        // 6: Implement isSorted() method.
        arr = new int[] { 10, 20, 30, 40, 50 };
        System.out.println(isSorted(arr, 0));

    }

}

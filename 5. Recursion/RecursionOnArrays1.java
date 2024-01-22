// Notes: https://drive.google.com/file/d/1f19ksDybA-h8x7-vAM2BNY5Enu12xIEr/view

// Recursion on Arrays | Linear Search | Find all indices

// 1: Print whether x exists in the array or not.
// 2: Return index if x exists in the array.
// 3: Return all indices if x exists in the array.
// 4: Return all indices as Array List if x exists in the array. 

import java.util.ArrayList;

public class RecursionOnArrays1 {

    static boolean find(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return false; // base case
        if (arr[idx] == x) return true; // self work
        return find(arr, idx + 1, x); // recursive call
    }

    static int findIndex(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return -1; // base case
        if (arr[idx] == x) return idx; // self work
        return findIndex(arr, idx + 1, x); // recursive call
    }

    static int[] findAllIndices(int[] arr, int idx, int x, int fsf) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return new int[fsf]; // base case
        if (arr[idx] == x) fsf++; // self work
        int[] indices = findAllIndices(arr, idx + 1, x, fsf); // recursive call
        if (arr[idx] == x) indices[fsf - 1] = idx; // self work
        return indices; // self work
    }

    static ArrayList<Integer> findAllIndices(int[] arr, int idx, int x) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return new ArrayList<>(); // base case
        ArrayList<Integer> indices = findAllIndices(arr, idx + 1, x); // recursive call
        if (arr[idx] == x) indices.add(idx); // self work
        return indices; // self work
    }
    
    public static void main(String[] args) {
        
        int[] arr = { 10, 30, 20, 50, 40, 20, 20 };
        int x = 20;

        // 1: Print whether x exists in the array or not.
        boolean isFound = find(arr, 0, x);
        System.out.println(isFound);

        // 2: Return index if x exists in the array.
        int index = findIndex(arr, 0, x);
        System.out.println(index);

        // 3: Return all indices if x exists in the array.
        int[] indices = findAllIndices(arr, 0, x, 0);
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i] + " ");
        }

        // 4: Return all indices as Array List if x exists in the array. 
        ArrayList<Integer> indicesList = findAllIndices(arr, 0, x);
        System.out.println(indicesList);


    }

}

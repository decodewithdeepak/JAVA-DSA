// Notes 15 : https://drive.google.com/file/d/1y7CQQ3frtPvJRDbLxqc63WFRJ7NUeGmJ/view

// Reversing and Rotating an Array

import java.util.Scanner;

public class ReverseAndRotate {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] revArr = new int[n];
        int j = 0;

        // Traverse the original array in reverse order
        for (int i = n - 1; i >= 0; i--) {
            revArr[j] = arr[i];
            j++;
        }

        return revArr; // Return the reversed array
    }

    static void reverseArrayInPlace(int[] arr) {
        int i = 0, j = arr.length - 1;

        // Swap the elements of the array using two-pointer approach
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; 
            j--;
        }
    }

    static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // If k is greater than n
        int [] rotArr = new int[n];
        int j = 0;

        for (int i = n - k; i < n; i++) { // Copy the last k elements to the rotated array
            rotArr[j] = arr[i];
            j++;
        }

        for (int i = 0; i < n - k; i++) { // Copy the first n-k elements to the rotated array
            rotArr[j] = arr[i];
            j++;
        }

        return rotArr;

    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; 
            j--;
        }
    }
    
    static void rotateArrayInPlace(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n-k-1); // Reverse the first n-k elements
        reverse(arr, n-k, n-1); // Reverse the last k elements
        reverse(arr, 0, n-1); // Reverse the whole array
        
    }


    public static void main(String[] args) {

        int [] arr = {1, 2, 3, 4, 5};

        // // Reverse an array of integers
        // int[] reversedArr = reverseArray(arr);
        // printArray(reversedArr);

        // // Reverse an array of integers without using another array (in-place)
        // reverseArrayInPlace(arr);
        // printArray(arr);

        // Rotate an array of integers by k times (k is non-negative and can be greater than the size of the array)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();

        // int[] rotatedArr = rotateArray(arr, k);
        // printArray(rotatedArr);

        // Rotate an arrayby k times without using another array (in-place)
        rotateArrayInPlace(arr, k);
        printArray(arr);

        sc.close();

    }
}

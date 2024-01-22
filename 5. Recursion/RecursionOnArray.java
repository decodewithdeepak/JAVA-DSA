// Notes : https://drive.google.com/file/d/1SP-rKFcancGeM8WlvIROE-bIemt-Z8gk/view

// Recursion on Arrays | Traverse Array | Max Value | Sum of Arrays

public class RecursionOnArray {
    
    // reccurence relation -> print(arr[0...n-1]) = print(arr[0]) + print(arr[1...n-1])
    static void printArray(int[] arr, int idx) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return; // base case
        System.out.println(arr[idx]); // self work - meeting expectation
        printArray(arr, idx + 1); // smaller problem - recursive call - faith
    }

    // reccurence relation -> max(arr[0...n-1]) = max(arr[0], max(arr[1...n-1]))
    static int maxOfArray(int[] arr, int idx) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length - 1) return arr[idx]; // base case
        // int maxOfSmallerArray = maxOfArray(arr, idx + 1); // recursive call
        // return Math.max(arr[idx], maxOfSmallerArray); // self work

        return Math.max(arr[idx], maxOfArray(arr, idx + 1)); // self work + recursive call - one liner
    }

    // reccurence relation -> sum(arr[0...n-1]) = arr[0] + sum(arr[1...n-1])
    static int sumOfArray(int[] arr, int idx) { // T(n) = O(n) | S(n) = O(n)
        if (idx == arr.length) return 0; // base case
        // int sumOfSmallerArray = sumOfArray(arr, idx + 1); //recursive call
        // return arr[idx] + sumOfSmallerArray; // self work

        return arr[idx] + sumOfArray(arr, idx + 1); // one liner
    }


    public static void main(String[] args) {
        
        // Given an array, print all elements of array using recursion
        int[] arr = { 10, 30, 20, 50, 40 };
        printArray(arr, 0);

        // Given a non-empty array, find its maximum element using recursion
        int max = maxOfArray(arr, 0);
        System.out.println("Max: " + max);

        // Given an array, find its sum of element using recursion
        int sum = sumOfArray(arr, 0);
        System.out.println("Sum: " + sum);
        
    

    }

}

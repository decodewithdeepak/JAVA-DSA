// Notes : https://drive.google.com/file/d/1xS2ZjsGVgyAUtb9jU3-ubp19E6SYVYL3/view
// Time and Space Complexity
// Asymptotic Analysis

// Time Complexity : Number of operations performed by the algorithm as a function of input size
// Space Complexity : Extra memory/space used by the algorithm as a function of input size

// Types of Time Complexity :
// 1. Worst Case Time Complexity : Maximum number of operations performed by the algorithm for any input size
// 2. Average Case Time Complexity : Average number of operations performed by the algorithm for any input size
// 3. Best Case Time Complexity : Minimum number of operations performed by the algorithm for any input size

// Asymptotic Notations : Big O, Big Omega, Big Theta
// Worst Case : Big O (O)
// Best Case : Big Omega (Ω)
// Average Case : Big Theta (Θ)

// Time Complexity : O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) < O(N^3) < O(2^N) < O(N!) < O(N^N)
// Where N is the input size

// By default, we consider the worst case time complexity

// Running Time of an Algorithm : Time taken (seconds) by the algorithm to run in the system

// Time Limit : 1 sec => 10^8 operations
// Time Limit Exceeded => TLE => 10^8 + operations

// Assumption: 1 operation takes 1 unit time

import java.util.Scanner;

public class TimeAndSpaceComplexity {

    static void sumOfN(int n) {
        int sum = 0; // 1
        for (int i = 1; i <= n; i++) { // 1 + 3n = n
            sum += i;
        }
        System.out.println(sum); // 1
        
        // Input Size n -> 1 <= n <= 10^8

        // Time Complexity : 3n + 3 => O(n)
        // It depends on the input size n
    }

    static void sumOfN2(int n) {
        int sum = n * (n + 1) / 2; // 4
        System.out.println(sum); // 1
        // Time Complexity : 5 => O(1)
        // It does not depend on the input size n
    }

    static int findIndex(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;

        // Worst Case Time Complexity : O(n) => When x is not present or present at the last index of the array
        // Best Case Time Complexity : Ω(1) => When x is present at the first index of the array
        // Average Case Time Complexity : Θ(n) => When x is present at the middle of the array 

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

        // Time Complexity : O(n)
        // Space Complexity : O(n) as we are creating a new array of size n
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

        // Time Complexity : O(n)
        // Space Complexity : O(1) as we are not creating any new array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Find sum of first n natural numbers
        // int n = sc.nextInt();

        // sumOfN(n);
        // sumOfN2(n);


        // Find the index of an element in an array
        // int[] arr = {1, 2, 3, 4, 5};
        // int x = sc.nextInt();
        // System.out.println(findIndex(arr, x));


        // Calculate the time complexity for traversing an array of length n
        // int[] arr = {1, 2, 3, 4, 5};
        // int n = arr.length; // 1
        // for (int i = 0; i < n; i++) { // 1 + 3n = n
        //     System.out.println(arr[i]);
        // }
        
        // Time Complexity : O(n)
        
        
        // Calculate the time complexity when traversing two arrays of length m and n
        // int [] arr1 = {1, 2, 3, 4, 5};
        // int [] arr2 = {6, 7, 8, 9, 10};
        // int m = arr1.length;
        // int n = arr2.length;

        // for (int i = 0; i < m; i++) { // 1 + 3m = m
        //     System.out.println(arr1[i]);
        // }

        // for (int i = 0; i < n; i++) { // 1 + 3n = n
        //     System.out.println(arr2[i]);
        // }

        // Time Complexity : O(m + n)


        // Calculate the time complexity for nested loops
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) { // n operations
            for (int j = 1; j <= n; j++) { // n operations
                System.out.println(i + " " + j);
            }
        }

        // n*n operations => n^2
        // Time Complexity : O(n^2)

        for (int i = 1; i <= n; i++) { // n operations
            for (int j = 1; j <= i; j++) { // i operations
                System.out.println(i + " " + j);
            }
        }

        // 1 + 2 + 3 + ... + n => n(n + 1) / 2 => n^2 / 2 + n / 2 => n^2
        // Time Complexity : O(n^2)


        for (int i = 1; i <= n; i++) { // n operations
            for (int j = 1; j <= Math.sqrt(n); j += i) { // √n operations
                System.out.println("Hello");
            }
        }

        // n * √n operations => n√n
        // Time Complexity : O(n√n)

        // Space Complexity Analysis if we created extra 2D array of size n x m
        // Space Complexity : O(n * m)


        
        sc.close();

    }
}
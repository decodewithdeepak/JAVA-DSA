// Notes 14 : https://drive.google.com/file/d/1gUwunT_xZErL7SufZ2mQa91ec59SIWQy/view

// Sum of all elements in array'
// Find the largest element in array
// Find the smallest element in array
// Find the second largest element in array
// Find the second smallest element in array
// Check if an element is present in array or not
// Find the sum of all even elements in array
// Find the sum of all odd elements in array
// Find the count of all even elements in array
// Find the count of all odd elements in array
// Search an element in array (Linear Search)
// Find the frequency of an element in array
// Find the last occurrence of an element in array
// Find the first occurrence of an element in array
// Count the number of elements strictly greater than value x
// Check if an array is sorted or not
// For a given array, print an array such that its first element is smallest and second element is largest
// Target Sum - Find the total number of pairs in array whose sum is equal to given target
// Count the number of triplets in array whose sum is equal to given target
// Array Manipulation - Find the unique number in a given array where all numbers except one, are present twice.
// Given an array consisting of integers. Find the first value which is repeated. If no values are repeated, print "-1".

import java.util.Arrays;

public class BasicArrayQuestions {
    public static void main(String[] args) {

        int[] arr = { 3, 2, 1, 5, 4 };
        // index :    0  1  2  3  4

        // Sum of all elements in array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // sum += arr[i];
        }

        System.out.println("Sum of all elements in array is: " + sum);

        // Find the largest element in array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     max = Math.max(arr[i], max);
        // }

        System.out.println("Largest element in array is: " + max);

        // Find the smallest element in array
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Smallest element in array is: " + min);

        // Find the second largest element in array
        int secondMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] < max)
                secondMax = arr[i];
        }

        System.out.println("Second largest element in array is: " + secondMax);

        // Find the second smallest element in array
        int secondMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < secondMin && arr[i] > min)
                secondMin = arr[i];
        }

        System.out.println("Second smallest element in array is: " + secondMin);

        // Check if an element is present in array or not
        int element = 5;
        boolean isPresent = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                isPresent = true;
                break;
            }
        }

        if (isPresent)
            System.out.println("Element " + element + " is present in array");
        else
            System.out.println("Element " + element + " is not present in array");


        // Find the sum of all even elements in array
        int evenSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                evenSum += arr[i]; // evenSum = evenSum + arr[i];
        }

        System.out.println("Sum of all even elements in array is: " + evenSum);

        // Find the sum of all odd elements in array
        int oddSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddSum += arr[i]; // oddSum = oddSum + arr[i];
        }

        System.out.println("Sum of all odd elements in array is: " + oddSum);

        // Find the count of all even elements in array
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                evenCount++;
        }

        System.out.println("Count of all even elements in array is: " + evenCount);

        // Find the count of all odd elements in array
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddCount++;
        }

        System.out.println("Count of all odd elements in array is: " + oddCount);


        // Search an element in array (Linear Search)
        arr = new int[] { 3, 2, 1, 5, 4 }; // re-initialize the array using new keyword

        int searchElement = 5;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                index = i;
                break;
            }
        }

        System.out.println("Element " + searchElement + " found at index " + index);
        
        // Find the frequency of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        int freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                freq++;
        }

        System.out.println("Frequency of " + element + " is: " + freq);

        
        // Find the last occurrence of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
            }
        }

        System.out.println("Last occurrence of " + element + " is at index " + index);

        // Find the first occurrence of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        System.out.println("First occurrence of " + element + " is at index " + index);


        // Count the number of elements strictly greater than value x
        arr = new int[] { 1, 3, 3, 2, 4, 5};
        int x = 2;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x)
                count++;
        }

        System.out.println("Number of elements strictly greater than " + x + " is: " + count);


        // Check if an array is sorted or not
        arr = new int[] { 1, 2, 3, 4, 5 };
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted)
            System.out.println("Array is sorted");
        else
            System.out.println("Array is not sorted");


        // For a given array, print an array such that its first element is smallest and second element is largest
        arr = new int[] { 5, 8, 1, 3, 6, 2 };
        Arrays.sort(arr);
        System.out.println("Sorted array is: " + Arrays.toString(arr));

        System.out.println("Smallest element: " + arr[0]);
        System.out.println("Largest element: " + arr[arr.length - 1]);

        int [] ans = { arr[0], arr[arr.length - 1] };
        System.out.println("Array[Smallest, Largest]: " + Arrays.toString(ans));

        
        // Target Sum - Find the total number of pairs in array whose sum is equal to given target
        arr = new int[] { 4, 6, 3, 5, 8, 2 };
        int target = 7;
        int pairCount = 0;
        for (int i = 0; i < arr.length; i++) { // first number
            for (int j = i + 1; j < arr.length; j++) { // second number
                if (arr[i] + arr[j] == target)
                    pairCount++;
            }
        }

        System.out.println("Total number of pairs in the array whose sum is equal to " + target + " is: " + pairCount);


        // Count the number of triplets in array whose sum is equal to given target
        arr = new int[] { 4, 6, 3, 5, 8, 2 };
        target = 12;
        int tripletCount = 0;
        for (int i = 0; i < arr.length; i++) { // first number
            for (int j = i + 1; j < arr.length; j++) { // second number
                for (int k = j + 1; k < arr.length; k++) { // third number
                    if (arr[i] + arr[j] + arr[k] == target)
                        tripletCount++;
                }
            }
        }

        System.out.println("Total number of triplets in the array whose sum is equal to " + target + " is: " + tripletCount);


        // Array Manipulation - Find the unique number in a given array where all numbers except one, are present twice.
        arr = new int[] { 1, 2, 3, 4, 2, 1, 3 };
        int uniqueNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = -1;
                    arr[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                uniqueNumber = arr[i];
                break;
            }
        }

        System.out.println("Unique number in the array is: " + uniqueNumber);


        // Given an array consisting of integers. Find the first value which is repeated. If no values are repeated, print "-1".
        arr = new int[] { 1, 3, 5, 4, 6, 3, 4 };
        int firstRepeatedValue = -1;
        for (int i = 0; i < arr.length; i++) { // first number
            for (int j = i + 1; j < arr.length; j++) { // second number
                if (arr[i] == arr[j]) {
                    firstRepeatedValue = arr[i];
                    break;
                }
            }
            if (firstRepeatedValue != -1)
                break;
        }

        System.out.println("First repeated value in the array is: " + firstRepeatedValue);

    


    }
}

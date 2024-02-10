// Notes 14 : https://drive.google.com/file/d/1gUwunT_xZErL7SufZ2mQa91ec59SIWQy/view

// 1 Sum of all elements in array'
// 2 Find the largest element in array
// 3 Find the smallest element in array
// 4 Find the second largest element in array
// 5 Find the second smallest element in array
// 6 Check if an element is present in array or not
// 7 Find the sum of all even elements in array
// 8 Find the sum of all odd elements in array
// 9 Find the count of all even elements in array
// 10 Find the count of all odd elements in array
// 11 Search an element in array (Linear Search)
// 12 Find the frequency of an element in array
// 13 Find the last occurrence of an element in array
// 14 Find the first occurrence of an element in array
// 15 Count the number of elements strictly greater than value x
// 16 Check if an array is sorted or not
// 17 For a given array, print an array such that its first element is smallest and second element is largest
// 18 Target Sum - Find the total number of pairs in array whose sum is equal to given target
// 19 Count the number of triplets in array whose sum is equal to given target
// 20 Array Manipulation - Find the unique number in a given array where all numbers except one, are present twice.
// 21 Given an array consisting of integers. Find the first value which is repeated. If no values are repeated, print "-1".

import java.util.Arrays;

public class BasicArrayQuestions {

    
    // 1. Sum of all elements in array
    static int sumOfElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 2. Find the largest element in array
    static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     max = Math.max(arr[i], max);
        // }
        
        return max;
    }

    // 3. Find the smallest element in array
    static int findSmallest(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 4. Find the second largest element in array
    static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // 5. Find the second smallest element in array
    static int findSecondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] != min) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }

    // 6. Check if an element is present in array or not
    static boolean isPresent(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // 7. Find the sum of all even elements in array
    static int sumOfEvenElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    // 8. Find the sum of all odd elements in array
    static int sumOfOddElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    // 9. Find the count of all even elements in array
    static int countOfEvenElements(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 10. Find the count of all odd elements in array
    static int countOfOddElements(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // 11. Search an element in array (Linear Search)
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 12. Find the frequency of an element in array
    static int frequencyOfElement(int[] arr, int target) {
        int freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                freq++;
            }
        }
        return freq;
    }

    // 13. Find the last occurrence of an element in array
    static int lastOccurrence(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
            }
        }
        return index;
    }

    // 14. Find the first occurrence of an element in array
    static int firstOccurrence(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    
    // 15. Count the number of elements strictly greater than value x
    static int countElementsGreaterThanX(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                count++;
            }
        }
        return count;
    }

    // 16. Check if an array is sorted or not
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 17. For a given array, print an array such that its first element is smallest and second element is largest
    static int[] firstAndLast(int[] arr) {
        Arrays.sort(arr);
        int[] result = {arr[0], arr[arr.length - 1]};
        return result;
    }

    // 18. Target Sum - Find the total number of pairs in array whose sum is equal to given target
    static int countPairsWithSum(int[] arr, int target) {
        int pairCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    // 19. Count the number of triplets in array whose sum is equal to given target
    static int countTripletsWithSum(int[] arr, int target) {
        int tripletCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        tripletCount++;
                    }
                }
            }
        }
        return tripletCount;
    }

    // 20. Array Manipulation - Find the unique number in a given array where all numbers except one, are present twice.
    static int findUnique(int[] arr) {
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

        return uniqueNumber;
    }

    // 21. Given an array consisting of integers. Find the first value which is repeated. If no values are repeated, print "-1".
    static int firstRepeatedValue(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }


    // 22. Two Sum - Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    static int[] twoSum(int[] arr, int target) {

       // Iterate through all possible pairs of numbers
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j }; // Return the indices of the pair
                }
            }
        }
        
        // If no such pair is found then return an empty array
        return new int[0];
    }


    // Main method

    public static void main(String[] args) {

        int[] arr = { 3, 2, 1, 5, 4 };
        // index :    0  1  2  3  4

        // 1. Sum of all elements in array
        System.out.println("Sum of all elements: " + sumOfElements(arr));

        // 2. Find the largest element in array
        System.out.println("Largest element: " + findLargest(arr));

        // 3. Find the smallest element in array
        System.out.println("Smallest element: " + findSmallest(arr));

        // 4. Find the second largest element in array
        System.out.println("Second largest element: " + findSecondLargest(arr));

        // 5. Find the second smallest element in array
        System.out.println("Second smallest element: " + findSecondSmallest(arr));

        // 6. Check if an element is present in array or not
        int element = 5;
        if (isPresent(arr, element))
            System.out.println("Element " + element + " is present in array");
        else
            System.out.println("Element " + element + " is not present in array");


        // 7. Find the sum of all even elements in array
        System.out.println("Sum of all even elements: " + sumOfEvenElements(arr));

        // 8. Find the sum of all odd elements in array
        System.out.println("Sum of all odd elements: " + sumOfOddElements(arr));

        // 9. Find the count of all even elements in array
        System.out.println("Count of all even elements: " + countOfEvenElements(arr));

        // 10. Find the count of all odd elements in array
        System.out.println("Count of all odd elements: " + countOfOddElements(arr));


        // 11. Search an element in array (Linear Search)
        arr = new int[] { 3, 2, 1, 5, 4, 5 }; // re-initialize the array using new keyword
        element = 5;
        int index = linearSearch(arr, element);
        if (index != -1)
            System.out.println("Element " + element + " is present at index " + index);
        else
            System.out.println("Element " + element + " is not present in array");

        
        // 12. Find the frequency of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        System.out.println("Frequency of " + element + " is: " + frequencyOfElement(arr, element));

        
        // 13 Find the last occurrence of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        System.out.println("Last occurrence of " + element + " is at index " + lastOccurrence(arr, element));

        // 14. Find the first occurrence of an element in array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        System.out.println("First occurrence of " + element + " is at index " + firstOccurrence(arr, element));

        // 15. Count the number of elements strictly greater than value x
        arr = new int[] { 1, 3, 3, 2, 4, 5};
        int x = 2;
        System.out.println("Number of elements strictly greater than " + x + " is: " + countElementsGreaterThanX(arr, x));


        // 16. Check if an array is sorted or not
        arr = new int[] { 1, 2, 3, 4, 5 };
        if (isSorted(arr))
            System.out.println("Array is sorted");
        else
            System.out.println("Array is not sorted");


        // 17. For a given array, print an array such that its first element is smallest and second element is largest
        arr = new int[] { 5, 8, 1, 3, 6, 2 };
        System.out.println("First element is smallest and second element is largest: " + Arrays.toString(firstAndLast(arr)));

        
        // 18. Target Sum - Find the total number of pairs in array whose sum is equal to given target
        arr = new int[] { 4, 6, 3, 5, 8, 2 };
        int target = 10;
        System.out.println("Total number of pairs in the array whose sum is equal to " + target + " is: " + countPairsWithSum(arr, target));


        // 19. Count the number of triplets in array whose sum is equal to given target
        arr = new int[] { 4, 6, 3, 5, 8, 2 };
        target = 12;
        System.out.println("Total number of triplets in the array whose sum is equal to " + target + " is: " + countTripletsWithSum(arr, target));


        // 20. Array Manipulation - Find the unique number in a given array where all numbers except one, are present twice.
        arr = new int[] { 1, 2, 3, 4, 2, 1, 3 };
        System.out.println("Unique number in the array is: " + findUnique(arr));


        // 21. Given an array consisting of integers. Find the first value which is repeated. If no values are repeated, print "-1".
        arr = new int[] { 1, 3, 5, 4, 6, 3, 4 };
        System.out.println("First value which is repeated is: " + firstRepeatedValue(arr));


        // 22. Two Sum - Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        arr = new int[] { 2, 7, 11, 15 };
        target = 9;
        int[] indices = twoSum(arr, target);
        System.out.println("Indices of the numbers that add up to " + target + " are: " + Arrays.toString(indices));        
    


    }
}

// Binary Search Problems

// 1. Find the first occurrence of a given element.
// 2. Find the last occurrence of a given element.
// 3. Find First and Last Position of Element in Sorted Array in an array. - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 4. Find the sqaure root of a given number. - https://leetcode.com/problems/sqrtx/

import java.util.Arrays;

public class BinSearchProblems1 {

    // 1. Find the first occurrence of a given element.
    static int findFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int firstOccurrence = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                firstOccurrence = mid;
                end = mid - 1;
            } 
            else if (target > arr[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return firstOccurrence;
    }

    // 2. Find the last occurrence of a given element.
    static int findLastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int lastOccurrence = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                lastOccurrence = mid;
                start = mid + 1; // Main difference
            } 
            else if (target > arr[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return lastOccurrence;
    }

    // 3. Find First and Last Position of Element in Sorted Array in an array.
    static int[] searchRange(int[] arr, int target) {
        int[] ans = {-1, -1};
        ans[0] = findFirstOccurrence(arr, target);
        ans[1] = findLastOccurrence(arr, target);
        return ans;
    }

    // 4. Find the sqaure root of a given number.
    static int findSquareRoot(int num) {
        int start = 1, end = num;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid <= num / mid) {
                ans = mid;
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 20, 30, 40, 50};
        int target = 20;
        System.out.println(findFirstOccurrence(arr, target)); // 1
        System.out.println(findLastOccurrence(arr, target)); // 3
        System.out.println(Arrays.toString(searchRange(arr, target))); // [1, 3]

        int num = 49;
        System.out.println(findSquareRoot(num)); // 7
    }
    
}

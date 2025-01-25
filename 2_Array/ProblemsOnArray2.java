// 1. Largest Subarray with 0 Sum - GFG [https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1]
// 2. Count Subarrays with XOR equals 'k' - GFG [https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/0]
// 3. Merge Overlapping Intervals - LeetCode 56 [https://leetcode.com/problems/merge-intervals/]
// 4. Find the repeating and the missing number - GFG [https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1]
// 5. Count Inversions - GFG [https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1]
// 6. Reverse Pairs - LeetCode 493 [https://leetcode.com/problems/reverse-pairs/]

import java.util.*;

public class ProblemsOnArray2 {
    // 1. Largest Subarray with 0 Sum - GFG
    public static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key: prefix sum, value: index
        int prefSum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefSum += arr[i];
            if (map.containsKey(prefSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefSum));
            } else {
                map.put(prefSum, i);
            }
        }
        return maxLen;
    }

    // 2. Count Subarrays with XOR equals 'k' - GFG
    public long subarrayXor(int arr[], int k) {
        // Note: XOR of a number with itself is 0
        //       XOR of a number with 0 is the number itself

        // // Brute Force Approach- O(n^2)
        // int n = arr.length;
        // long count = 0;
        // for (int i = 0; i < n; i++) {
        //     int xor = 0;
        //     for (int j = i; j < n; j++) {
        //         xor = xor ^ arr[j];
        //         if (xor == k)
        //             count++;
        //     }
        // }
        // return count;

        // Optimized Approach - O(n)
        // Using the concept of prefix XOR just like prefix sum

        int n = arr.length;
        int prefXOR = 0;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefXOR = prefXOR ^ arr[i];
            if (prefXOR == k)
                count++;
            if (map.containsKey(prefXOR ^ k))
                count += map.get(prefXOR ^ k);
            map.put(prefXOR, map.getOrDefault(prefXOR, 0) + 1);
        }
        return count;
    }
    
    // 3. Merge Overlapping Intervals - LeetCode 56
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Sort by ascending start point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] currInterval = intervals[0];
        // Add the first interval to the list
        list.add(currInterval);

        for (int[] interval : intervals) {   
            // 0 -> start, 1 -> end         
            if (interval[0] <= currInterval[1]) {
                // Overlapping intervals, update the end if needed
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }
            else {
                // Disjoint intervals, add the new interval to the list
                currInterval = interval;
                list.add(currInterval);
            }
        }

        // Convert List<int[]> to int[][]
        return list.toArray(new int[list.size()][]);
    }

    // 4. Find the repeating and the missing number - GFG

    // 5. Count Inversions - GFG
    public static int inversionCount(int arr[]) {
        // Brute Force Approach - O(n^2)
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) count++;
            }
        }
        return count;

        // Optimized Approach - O(nlogn)
        // return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // 6. Reverse Pairs - LeetCode 493
    public int reversePairsBrute(int[] nums) {
        // Brute Force Approach - O(n^2) - TLE
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // if (nums[i] > 2 * nums[j]) cnt++;
                if ((long) nums[i] > 2L * nums[j]) cnt++; // typecasting to long to avoid overflow
            }
        }

        return cnt;
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        // Count reverse pairs across the two halves
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        // Merge step
        merge(nums, left, mid, right);
        
        return count;
    }
    
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
    
}
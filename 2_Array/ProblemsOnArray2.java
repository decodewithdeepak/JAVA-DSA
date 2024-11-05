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

    // 6. Reverse Pairs - LeetCode 493
    

}

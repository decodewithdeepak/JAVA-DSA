// 1. Two Sum - LeetCode #1 (https://leetcode.com/problems/two-sum/)
// 2. Valid Anagram - LeetCode #242 (https://leetcode.com/problems/valid-anagram/)
// 3. Isomorphic Strings - LeetCode #205 (https://leetcode.com/problems/isomorphic-strings/)
// 4. Largest SubArray with 0 Sum - GFG (https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)
// 5. Longest Sub-Array with Sum K - GFG (https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)
// 6. Count frequency of array elements - GFG (https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/0)

import java.util.*;

public class HashMapProblems {

    // 1. Two Sum - LeetCode #1
    public static int[] twoSum(int[] nums, int target) {
        // Using nested for loops - O(n^2)
        // Iterate through all possible pairs of numbers
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }
        // return new int[] {};
        
        // Using HashMap - O(n)
        // Key - Number, Value - Index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }


    // 2. Valid Anagram - LeetCode #242
    public static boolean isAnagram(String s, String t) {
        // Using Sorting - TC: O(nlogn)
        // if (s.length() != t.length()) return false;
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // return Arrays.equals(sArr, tArr);

        // Using two HashMaps - O(n)
        // if (s.length() != t.length()) return false;
        // Map<Character, Integer> map1 = new HashMap<>();
        // Map<Character, Integer> map2 = new HashMap<>();
        // for (char c : s.toCharArray()) {
        //     if (map1.containsKey(c)) {
        //         map1.put(c, map1.get(c) + 1);
        //     } else {
        //         map1.put(c, 1);
        //     }
        // }
        // for (char c : t.toCharArray()) {
        //     if (map2.containsKey(c)) {
        //         map2.put(c, map2.get(c) + 1);
        //     } else {
        //         map2.put(c, 1);
        //     }
        // }
        // return map1.equals(map2);

        // Using one HashMap - O(n)
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // Increment frequency of character if present
                map.put(c, map.get(c) + 1);
            } else { // Add character to map with frequency 1 if not present
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) { // Decrement frequency of character if present
                map.put(c, map.get(c) - 1); 
                if (map.get(c) == 0) { // Remove character if frequency becomes 0
                    map.remove(c);
                }
            } else { // Return false if character not present in map
                return false;
            }
        }
        return true;

    }


    // 3. Isomorphic Strings - LeetCode #205
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        // Key - Character from s, Value - Character from t
        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (map.containsKey(sch)) {
                if (map.get(sch) != tch) return false; // Check if sch is already mapped to another character
            } 
            else if (map.containsValue(tch)) return false; // Check if tch is already mapped to another character
            else map.put(sch, tch); // Add mapping of characters
        }
        return true;
    }


    // 4. Largest SubArray with 0 Sum - GFG
    public static int maxLen(int arr[], int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key - Prefix Sum, Value - Index
        int prefSum = 0; // Prefix Sum
        int maxLen = 0;
        map.put(0, -1); // Initialize map with 0 sum at index -1
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

    // 5. Longest Sub-Array with Sum K - GFG
    public static int lenOfLongSubarr (int A[], int N, int K) {

        // // Brute Force - O(n^2) - Time Limit Exceeded
        // int maxLen = 0;
        // for(int i=0; i<N; i++){
        //     int sum = 0;
        //     for(int j=i; j<N; j++){
        //         sum = sum + A[j];
        //         if(sum == K){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //     }
        // }
        // return maxLen;

        // Using HashMap - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key - Prefix Sum, Value - Index
        int maxLen = 0;
        int prefSum = 0; // Prefix Sum
        map.put(0, -1); // Initialize map with 0 sum at index -1
        for(int i=0; i<N; i++){
            prefSum = prefSum + A[i];
            if(map.containsKey(prefSum - K)){
                maxLen = Math.max(maxLen, i - map.get(prefSum - K));
            }
            if(!map.containsKey(prefSum)){
                map.put(prefSum, i);
            }
        }
        return maxLen;
    }

    // 6. Count frequency of array elements - GFG
    public static void frequencyCount(int arr[], int N, int P) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key - Element, Value - Frequency
        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (map.containsKey(i + 1)) {
                arr[i] = map.get(i + 1);
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        
        // 1. Two Sum - LeetCode #1
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));


        // 2. Valid Anagram - LeetCode #242
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));


        // 3. Isomorphic Strings - LeetCode #205
        String s1 = "paper";
        String t1 = "title";
        System.out.println(isIsomorphic(s1, t1));


        // 4. Largest SubArray with 0 Sum - GFG
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = arr.length;
        System.out.println(maxLen(arr, n));
        

    
    }
    
}

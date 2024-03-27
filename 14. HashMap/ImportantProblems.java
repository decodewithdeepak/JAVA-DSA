// 1. Two Sum - LeetCode #1 (https://leetcode.com/problems/two-sum/)
// 2. Valid Anagram - LeetCode #242 (https://leetcode.com/problems/valid-anagram/)
// 3. Isomorphic Strings - LeetCode #205 (https://leetcode.com/problems/isomorphic-strings/)
// 4. Largest SubArray with 0 Sum - GFG (https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)

import java.util.*;

public class ImportantProblems {

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
        Map<Integer, Integer> map = new HashMap<>();
        // Key - Prefix Sum, Value - Index
        int sum = 0; // Prefix Sum
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLen == 0) maxLen = 1;
            if (sum == 0) maxLen = i + 1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
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

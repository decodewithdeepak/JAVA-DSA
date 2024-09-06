// Permutations - LeetCode #46 [https://leetcode.com/problems/permutations/]
// Using Backtracking

import java.util.*;

public class Permutations {

    // Permutations - LeetCode #46
    // Method 1 : Using Auxilary List

    // Permutations - LeetCode #46
    // Method 1 : Using Auxiliary List 
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store all permutations
        List<Integer> curr = new ArrayList<>(); // Auxiliary List to store current permutation
        boolean[] isUsed = new boolean[nums.length]; // Array(initially False) to keep track of used elements
        helper(nums, curr, ans, isUsed);
        return ans;
    }

    public static void helper(int[] nums, List<Integer> curr, List<List<Integer>> ans, boolean[] isUsed) {
        if (curr.size() == nums.length) { // Base Case
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == false) {
                curr.add(nums[i]);
                isUsed[i] = true;
                helper(nums, curr, ans, isUsed); // Recursive Call

                // Backtrack
                isUsed[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

    // Method 2 : In-Place
    public static List<List<Integer>> permuteInPlace(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store all permutations
        helperInPlace(nums, 0, ans);
        return ans;
    }

    public static void helperInPlace(int[] nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.length) { // Base Case
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            ans.add(l);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            helperInPlace(nums, idx + 1, ans); // Recursive Call
            swap(nums, idx, i); // Backtrack
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        System.out.println(permuteInPlace(nums)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2]

    }
}

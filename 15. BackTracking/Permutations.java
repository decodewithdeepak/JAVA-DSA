// LeeCode Problems
// Permutations - LeetCode #46 [https://leetcode.com/problems/permutations/]

import java.util.*;

public class Permutations {

    // Permutations - LeetCode #46
    // Method 1 : Using Auxilary List
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, permutation, used, result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> result) {
        // Base case: If the current permutation is of the same length as nums, add it to the result
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        // Recursive step: Try adding each unused number to the permutation
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                backtrack(nums, permutation, used, result);
                
                // Backtrack: Remove the last element to try other possibilities
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }

    // Method 2 : In-place permutation generation
    public static List<List<Integer>> permuteInPlace(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackInPlace(nums, 0, result);
        return result;
    }

    private static void backtrackInPlace(int[] nums, int start, List<List<Integer>> result) {
        // Base case: If start reaches the end of the array, add the current permutation to result
        if (start == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        // Recursive step: Swap each element with start index and continue recursion
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrackInPlace(nums, start + 1, result);
            swap(nums, start, i); // Backtrack: restore the array to its original state
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        // Permutations - LeetCode #46
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        System.out.println(permuteInPlace(nums)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2]

    }
}

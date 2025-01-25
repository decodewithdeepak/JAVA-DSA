// 1. Subsets - LeetCode 78 (https://leetcode.com/problems/subsets/)
// 2. Subsets II - LeetCode 90 (https://leetcode.com/problems/subsets-ii/)

import java.util.*;

public class BacktrackingProblems{

    // 1. Subsets - LeetCode 78
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, res);
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> res){
        if(idx == nums.length){ // if we reach the end of the array
            res.add(new ArrayList<>(subset));
            return;
        }

        // add the current element
        subset.add(nums[idx]);
        backtrack(nums, idx+1, subset, res);

        // dont add the current element
        subset.remove(subset.size()-1);
        backtrack(nums, idx+1, subset, res);
    }


    // 2. Subsets II - LeetCode 90

}
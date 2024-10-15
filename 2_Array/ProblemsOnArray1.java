// 1. Array Leaders - GFG (https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1)
// 2. Longest Consecutive Sequence - LeetCode 128 (https://leetcode.com/problems/longest-consecutive-sequence/)
// 3. Subarray Sum Equals K - LeetCode 560 (https://leetcode.com/problems/subarray-sum-equals-k/)
// 4. Next Permutation - LeetCode 31 (https://leetcode.com/problems/next-permutation/)
// 5. Find All Duplicates in an Array - LeetCode 442 (https://leetcode.com/problems/find-all-duplicates-in-an-array/)
// 6. Two Sum - LeetCode 1 (https://leetcode.com/problems/two-sum/)
// 15. 3Sum - LeetCode 15 (https://leetcode.com/problems/3sum/)
// 16. 3Sum Closest - LeetCode 16 (https://leetcode.com/problems/3sum-closest/)
// 18. 4Sum - LeetCode 18 (https://leetcode.com/problems/4sum/)
// 26. Remove Duplicates from Sorted Array - LeetCode 26 (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

import java.util.*;

public class ProblemsOnArray1 {

    // 1. Array Leaders - GFG
    public static ArrayList<Integer> findLeaders(int[] arr, int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = arr[n-1];
        leaders.add(max);
        for(int i=n-2; i>=0; i--){
            if(arr[i] > max){
                max = arr[i];
                leaders.add(max);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }


    // 2. Longest Consecutive Sequence - LeetCode 128
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxStreak = 0;
        for(int num : set){
            if(!set.contains(num-1)){ // num is starting point of a sequence
                int currNum = num;
                int currStreak = 1; // length of current consecutive sequence
                while(set.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }

    // 3. Subarray Sum Equals K - LeetCode 560
    public int subarraySum(int[] nums, int k) {
        // // Brute Force Approach- O(n^2)
        // int n = nums.length;
        // int count = 0;
        // for(int start=0; start<n; start++){
        //     int sum = 0;
        //     for(int end=start; end<n; end++){
        //         sum = sum + nums[end];
        //         if(sum == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // Optimized Approach- O(n)
        // Using the concept of Prefix Sum
        int n = nums.length;
        int prefSum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // Key - Prefix Sum, Value - Frequency
        map.put(0, 1); // 0 sum has occurred 1 time
        for(int i=0; i<n; i++){
            prefSum = prefSum + nums[i];
            if(map.containsKey(prefSum - k)){
                count = count + map.get(prefSum - k);
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return count;
    }

    // 4. Next Permutation - LeetCode 31    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n-1;
            while(j>=0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }


    // 5. Find All Duplicates in an Array - LeetCode 442
    public List<Integer> findDuplicates(int[] nums) {
        // // Using Sorting - O(nlogn) time, O(1) space
        // Arrays.sort(nums);
        // List<Integer> dup = new ArrayList<>();
        // for(int i=1; i<nums.length; i++){
        //     if(nums[i] == nums[i-1]){
        //         dup.add(nums[i]);
        //     }
        // }
        // return dup;

        // // Using Hashing - O(n) time, O(n) space
        // List<Integer> dup = new ArrayList<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // for(int num : map.keySet()){
        //     if(map.get(num) == 2){
        //         dup.add(num);
        //     }
        // }
        // return dup;

        // // Using HashSet - O(n) time, O(n) space
        // List<Integer> dup = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     if(set.contains(num)){
        //         dup.add(num);
        //     }
        //     set.add(num);
        // }
        // return dup;

        // Using Negation - O(n) time, O(1) space
        List<Integer> dup = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1; // index of no nums[i]
            if(nums[idx] < 0){ // if no is already negated then it is duplicate
                dup.add(Math.abs(nums[i])); // add duplicate no to list
            }
            nums[idx] = -nums[idx]; // mark no as visited by negating
        }
        return dup;

    }

    // 6. Two Sum - LeetCode 1
    public int[] twoSum(int[] nums, int target) {
        // Brute Force Approach - O(n^2)
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return null;

        // Using Hashing - O(n) time, O(n) space
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key - number nums[i], Value - index i
        for(int i=0; i<n; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    // 26. Remove Duplicates from Sorted Array - LeetCode 26
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j=1; j<n; j++){
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }


}

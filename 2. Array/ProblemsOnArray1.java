// 1. Array Leaders - GFG (https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1)
// 2. Longest Consecutive Sequence - LeetCode 128 (https://leetcode.com/problems/longest-consecutive-sequence/)
// 3. Subarray Sum Equals K - LeetCode 560 (https://leetcode.com/problems/subarray-sum-equals-k/)
// 4. Next Permutation - LeetCode 31 (https://leetcode.com/problems/next-permutation/)

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
}

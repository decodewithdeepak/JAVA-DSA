// 1. Array Leaders - GFG (https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1)
// 2. Longest Consecutive Sequence - LeetCode 128 (https://leetcode.com/problems/longest-consecutive-sequence/)
// 3. Count Subarrays with Sum Equals K - LeetCode 560 (https://leetcode.com/problems/subarray-sum-equals-k/)
// 4. Next Permutation - LeetCode 31 (https://leetcode.com/problems/next-permutation/)
// 5. Find All Duplicates in an Array - LeetCode 442 (https://leetcode.com/problems/find-all-duplicates-in-an-array/)
// 6. Two Sum - LeetCode 1 (https://leetcode.com/problems/two-sum/)
// 7. Two Sum II - Input Array is Sorted - LeetCode 167 (https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

// 8. 3Sum - LeetCode 15 (https://leetcode.com/problems/3sum/)
// 9. 3Sum Closest - LeetCode 16 (https://leetcode.com/problems/3sum-closest/)
// 10. 4Sum - LeetCode 18 (https://leetcode.com/problems/4sum/)


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

    // 3. Count Subarrays with Sum Equals K - LeetCode 560
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

        // Step 1: Find the break point
        int idx = -1; // index of break point
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        // If break point not exists then reverse the array
        if(idx == -1){
            reverse(nums, 0, n-1);
            return;
        }

        // Step 2: Find the next greater element and swap it with break point nums[idx]
        for(int i=n-1; i>idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        // Step 3: Reverse the righthalf of array from idx+1 to n-1
        reverse(nums, idx+1, n-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
                return new int[]{i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 7. Two Sum II - Input Array is Sorted - LeetCode 167
    public int[] twoSumII(int[] numbers, int target) {
        // Using Two Pointers - O(n) time, O(1) space
        int n = numbers.length;
        int i = 0, j = n-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[] {i+1, j+1}; // 1-based index
            if (sum<target) i++;
            else j--;
        }
        return null;
    }

    // 8. 3Sum - LeetCode 15
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); 
        // so that we can appply two pointer technique and skip duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            // a+b+c = 0 => b+c = -a = target
            if (i == 0 || nums[i] != nums[i - 1]) { // skip duplicate a
                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];

                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);

                        // skip duplicate b
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        // skip duplicate c
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return res;
    }

    // 9. 3Sum Closest - LeetCode 16
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<n-2; i++){
            int low = i+1;
            int high = n-1;

            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                // if sum matches target then return sum
                if(sum == target) return sum;
                // if sum is closer to target then update closestSum
                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                // if sum is less than target then move low pointer
                if(sum < target) low++;
                // if sum is greater than target then move high pointer
                else high--;
            }
        }
        return closestSum;
    }

    // 10. 4Sum - LeetCode 18
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        // a+b+c+d = target => b+c+d = target-a => c+d = target-a-b = newTarget

        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue; // skip duplicate a
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue; // skip duplicate b
                int low = j+1;
                int high = nums.length-1;
                long newTarget = (long) target - nums[i] - nums[j];

                while(low < high){
                    int sum = nums[low] + nums[high];
                    if(sum == newTarget){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);

                        while(low < high && nums[low] == nums[low+1]) low++; // skip duplicate c
                        while(low < high && nums[high] == nums[high-1]) high--; // skip duplicate d

                        low++;
                        high--;
                    } else if(sum < newTarget){
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }



}

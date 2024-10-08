// 1. Missing Number - LeetCode 268 (https://leetcode.com/problems/missing-number/)
// 2. Max Consecutive Ones - LeetCode 485 (https://leetcode.com/problems/max-consecutive-ones/)
// 3. Single Number - LeetCode 136 (https://leetcode.com/problems/single-number/)
// 4. Sort Colors - LeetCode 75 (https://leetcode.com/problems/sort-colors/)
// 5. Majority Element - LeetCode 169 (https://leetcode.com/problems/majority-element/)
// 6. Maximum Sum Subarray - LeetCode 53 (https://leetcode.com/problems/maximum-subarray/)
// 7. Maximum Product Subarray - LeetCode 152 (https://leetcode.com/problems/maximum-product-subarray/)
// 8. Maximum Score from Subarray Minimums - GFG (https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0)
// 9. Best Time to Buy and Sell Stock - LeetCode 121 (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
// 10. Rearrange Array Elements by Sign - LeetCode 2149 (https://leetcode.com/problems/rearrange-array-elements-by-sign/)
// 11. Rotate Array - LeetCode 189 (https://leetcode.com/problems/rotate-array/)
// 12. Majority Element II - LeetCode 229 (https://leetcode.com/problems/majority-element-ii/)
// 13. Product of Array Except Self - LeetCode 238 (https://leetcode.com/problems/product-of-array-except-self/)


import java.util.*;

public class ProblemsOnArray {
    // 1. Missing Number - LeetCode 268
    public int missingNumber(int[] nums) {
        // Missing no. = Actual sum - Calculated sum
        int n = nums.length;
        int sum = 0; // calc sum
        for(int i=0; i<n; i++){
            sum = sum + nums[i];
        }
        int actualSum = (n*(n+1))/2;
        int missingNum = actualSum - sum;
        return missingNum;
    }

    // 2. Max Consecutive Ones - LeetCode 485
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0, maxCount = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    // 3. Single Number - LeetCode 136
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = ans ^ nums[i]; // XOR operation
        }
        return ans;
    }

    // 4. Sort Colors - LeetCode 75
    public void sortColors(int[] nums) {
        // O(2n) approach
        // int n = nums.length;
        // int count0 = 0, count1 = 0, count2 = 0;
        // for(int i=0; i<n; i++){
        //     if(nums[i] == 0) count0++;
        //     else if(nums[i] == 1) count1++;
        //     else count2++;
        // }
        // for (int i = 0; i < count0; i++) {
        //     nums[i] = 0;
        // }
        // for (int i = count0; i < count0 + count1; i++) {
        //     nums[i] = 1;
        // }
        // for (int i = count0 + count1; i < n; i++) {
        //     nums[i] = 2;
        // }

        // O(n) approach - Dutch National Flag Algorithm
        // Rules-
        // [0, low-1] -> 0 (extreme left)
        // [low, mid-1] -> 1
        // [mid, high] -> 0/1/2 unsorted
        // [high+1, n-1] -> 2 (extreme right)
        
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high){
            // 0 -> swap with low, low++, mid++
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            // 1 -> mid++
            else if(nums[mid] == 1){
                mid++;
            }
            // 2 -> swap with high, high--
            else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    // 5. Majority Element - LeetCode 169
    public int majorityElement(int[] nums) {

        // Bruteforce approach - O(n^2) - TLE
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     int count = 0;
        //     for(int j=0; j<n; j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        //     if(count > n/2){
        //         return nums[i];
        //     }
        // }
        // return -1; // no majority element

        // O(nlogn) approach - Sorting
        // Arrays.sort(nums);
        // return nums[nums.length/2];

        // O(n) approach - HashMap
        // int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // // key -> element, value -> frequency
        // for(int i=0; i<n; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) > n/2){
        //         return key;
        //     }
        // }
        // return -1; // no majority element

        // O(n) approach - Moore's Voting Algorithm
        // Rules-
        // 1. Find candidate to be majority element
        // 2. Check if candidate is majority element

        int n = nums.length;
        int candidate = 0, count = 0;
        for(int i=0; i<n; i++){
            if(count == 0) candidate = nums[i]; // new candidate
            if(candidate == nums[i]) count++; // same candidate
            else count--; // different candidate
        }
        return candidate;
    }

    // 6. Maximum Subarray - LeetCode 53
    public int maxSubArray(int[] nums) {

        // Bruteforce approach - O(n^2) - TLE
        // int n = nums.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0; i<n; i++){
        //     int sum = 0;
        //     for(int j=i; j<n; j++){
        //         sum = sum + nums[j];
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;

        // O(n) approach - Kadane's Algorithm
        // Rules-
        // 1. Calculate sum of subarray
        // 2. Update maxSum
        // 3. If sum < 0, reset sum to 0

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    // 7. Maximum Product Subarray - LeetCode 152
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1, suff = 1, ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            pre = pre * nums[i];
            suff = suff * nums[n-i-1];
            ans = Math.max(ans, Math.max(pre, suff));
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;
        }
        return ans;
    }

    // 8. Maximum Score from Subarray Minimums - GFG
    public int pairWithMaxSum(List<Integer> arr) {
        if(arr.size() < 2) return 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.size()-1; i++){
            int sum = arr.get(i) + arr.get(i+1);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // 9. Best Time to Buy and Sell Stock - LeetCode 121 
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0], maxProfit = 0;
        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // 10. Rearrange Array Elements by Sign - LeetCode 2149
    public int[] rearrangeArray(int[] nums) {
        // Bruteforce approach - Tc: O(2n), Sc: O(n)
        // int n = nums.length;
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();

        // for(int i=0;i<n;i++){
        //     if(nums[i]>=0){
        //         pos.add(nums[i]);
        //     } else {
        //         neg.add(nums[i]);
        //     }
        // }

        // for(int i=0;i<n/2;i++){
        //     nums[2*i]=pos.get(i);
        //     nums[2*i+1]=neg.get(i);
        // }

        // return nums;

        // Optimal approach - Tc: O(n), Sc: O(1)
        int n = nums.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1; // two pointers
        for(int i=0; i<n; i++){
            if(nums[i] >= 0){
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }
    
    // 11. Rotate Array - LeetCode 189
    public void rotate(int[] nums, int k) { // Input => nums = [1,2,3,4,5,6,7], k = 3
        int n = nums.length; // n = 7
        k = k % n; // to handle k > n => k = 3
        reverse(nums, 0, n-1); // reverse whole array => [7,6,5,4,3,2,1]
        reverse(nums, 0, k-1); // reverse 1st part => [5,6,7,4,3,2,1]
        reverse(nums, k, n-1); // reverse 2nd part => [5,6,7,1,2,3,4] <= Output
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            // swap start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 12. Majority Element II - LeetCode 229
    public List<Integer> majorityElementII(int[] nums) {

        // // Bruteforce approach - O(n^2) - TLE
        // int n = nums.length;
        // List<Integer> ans = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     int count = 0;
        //     for(int j=0; j<n; j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        //     if(count > n/3 && !ans.contains(nums[i])){
        //         ans.add(nums[i]);
        //     }
        // }
        // return ans;

        // // Using Sorting - O(nlogn)
        // Arrays.sort(nums);
        // List<Integer> ans = new ArrayList<>();
        // int n = nums.length;
        // int count = 1;
        // for(int i=1; i<n; i++){
        //     if(nums[i] == nums[i-1]){
        //         count++;
        //     } else {
        //         if(count > n/3){
        //             ans.add(nums[i-1]);
        //         }
        //         count = 1;
        //     }
        // }
        // if(count > n/3){
        //     ans.add(nums[n-1]);
        // }
        // return ans;

        // // Using HashMap - O(n)
        // List<Integer> ans = new ArrayList<>();
        // int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<n; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) > n/3){
        //         ans.add(key);
        //     }
        // }
        // return ans;
        
        // Extended Moore's Voting Algorithm - O(n)
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Find potential candidates
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for (int i = 0; i < n; i++) {
            // same candidate
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } 
            // new candidate
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } 
            // different candidate
            else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) count1++;
            else if (nums[i] == candidate2) count2++;
        }

        // Add valid candidates to the result
        if (count1 > n / 3) ans.add(candidate1);
        if (count2 > n / 3) ans.add(candidate2);

        return ans;
    }
    

    // 13. Product of Array Except Self - LeetCode 238
    public int[] productExceptSelf(int[] nums) {
        // // Bruteforce approach - TC : O(n^2), SC : O(n) - TLE
        // int n = nums.length;
        // int ans[] = new int[n];
        
        // for(int i = 0; i < n; i++) {
        //     int pro = 1;
        //     for(int j = 0; j < n; j++) {
        //         if(i == j) continue;
        //         pro *= nums[j];
        //     }
        //     ans[i] = pro;
        // }
        
        // return ans;

        // // Using Sufix and Prefix Arrays - TC : O(n), SC : O(n)
        // int n = nums.length;
        // int pre[] = new int[n];
        // int suff[] = new int[n];
        
        // pre[0] = 1;
        // for(int i = 1; i < n; i++) {
        //     pre[i] = pre[i - 1] * nums[i - 1];
        // }

        // suff[n - 1] = 1;
        // for(int i = n - 2; i >= 0; i--) {
        //     suff[i] = suff[i + 1] * nums[i + 1];
        // }

        // int ans[] = new int[n];
        // for(int i = 0; i < n; i++) {
        //     ans[i] = pre[i] * suff[i];
        // }

        // return ans;

        // Using Constant Space - TC : O(n), SC : O(1)
        int n = nums.length;
        int ans[] = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }




}

// 1. Intersection of Two Arrays - LeetCode 349 (https://leetcode.com/problems/intersection-of-two-arrays/)
// 2. Intersection of Two Arrays II - LeetCode 350 (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
// 3. Contains Duplicate - LeetCode 217 (https://leetcode.com/problems/contains-duplicate/)
// 4. Contains Duplicate II - LeetCode 219 (https://leetcode.com/problems/contains-duplicate-ii/)
// 5. Contains Duplicate III - LeetCode 220 (https://leetcode.com/problems/contains-duplicate-iii/)

import java.util.*;

public class HashSetProblems {

    // 1. Intersection of Two Arrays - LeetCode 349
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for(int val : nums1){
            set.add(val);
        }

        HashSet<Integer> ans = new HashSet<>();
        for(int val : nums2){
            if(set.contains(val)){
                ans.add(val);
            }
        }

        int[] arr = new int[ans.size()];
        int idx = 0;
        for(int val : ans){
            arr[idx++] = val;
        }

        return arr;
    }

    // 2. Intersection of Two Arrays II - LeetCode 350
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums1){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int val : nums2){
            if(map.containsKey(val) && map.get(val) > 0){
                list.add(val);
                map.put(val, map.get(val) - 1);
            }
        }

        int[] arr = new int[list.size()];
        int idx = 0;
        for(int val : list){
            arr[idx++] = val;
        }

        return arr;
    }

    // 3. Contains Duplicate - LeetCode 217
    public boolean containsDuplicate(int[] nums) {
        // Brute Force - O(n^2) - TLE
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            if(!set.add(val)){ // if val is already present in set then add() will return false
                return true;
            }
        }
        return false;
    }

    // 4. Contains Duplicate II - LeetCode 219
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }


    // 5. Contains Duplicate III - LeetCode 220
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);
            if((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])){
                return true;
            }
            set.add((long)nums[i]);
            if(i >= k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

}

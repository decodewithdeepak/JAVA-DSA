// 1. Search in Rotated Sorted Array - Leetcode 33 (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// 2. Search in Rotated Sorted Array II - Leetcode 81 (https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
// 3. Find Minimum in Rotated Sorted Array - Leetcode 153 (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// 4. Find out how many times has an array been rotated - GFG (https://www.geeksforgeeks.org/problems/rotation4723/1)
// 5. Single Element in a Sorted Array - Leetcode 540 (https://leetcode.com/problems/single-element-in-a-sorted-array/)
// 6. Find Peak Element - Leetcode 162 (https://leetcode.com/problems/find-peak-element/)
// 7. Peak Index in a Mountain Array - Leetcode 852 (https://leetcode.com/problems/peak-index-in-a-mountain-array/)

import java.util.List;

public class d_BinarySearchOn1DArrays {

    // 1. Search in Rotated Sorted Array - Leetcode 33
    public int searchRotated(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid; // target found
            
            // right half (mid to end) is sorted
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1; // search in right half
                else end = mid - 1; // search in left half
            }
            // left half (start to mid) is sorted
            else {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1; // search in left half
                else start = mid + 1; // search in right half
            }
        }
        return -1; // not found
    }

    // 2. Search in Rotated Sorted Array II - Leetcode 81
    public boolean searchRotatedDuplicate(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true; // target found

            // skip duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // right half (mid to end) is sorted
            else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1; // search in right half
                else end = mid - 1; // search in left half
            }
            // left half (start to mid) is sorted
            else {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1; // search in left half
                else start = mid + 1; // search in right half
            }
        }
        return false; // not found
    }

    // 3. Find Minimum in Rotated Sorted Array - Leetcode 153
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
               
        while (start < end) {
            int mid = start + (end - start) / 2;
            // right half is sorted
            if (nums[mid] <= nums[end]) {
                end = mid; // minimum in left half including mid
            }
            // left half is sorted
            else { // nums[mid] > nums[end]
                start = mid + 1; // minimum in right half
            }
        }
        return nums[start]; // start == end, minimum found
    }

    // 4. Find out how many times has an array been rotated - GFG
    public int findKRotation(List<Integer> arr) {
        // Logic - index of minimum element will give the number of rotations
        int low = 0, high = arr.size()-1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            // right half is sorted
            if (arr.get(mid) <= arr.get(high)) {
                high = mid; // minimum in left half including mid
            }
            // left half is sorted
            else { // nums[mid] > nums[end]
                low = mid + 1; // minimum in right half
            }
        }
        return low; // low == high
    }

    // 5. Single Element in a Sorted Array - Leetcode 540
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        // first occurence of every element is at even index if there is no single element
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--; // make mid even
            if (nums[mid] != nums[mid + 1]) end = mid; // single element in left half including mid
            else if (nums[mid] == nums[mid + 1]) start = mid + 2; // single element in right half
        }
        return nums[start]; // start == end, single element found
    }

    // 6. Find Peak Element - Leetcode 162
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) start = mid + 1; // peak in right half
            else end = mid; // peak in left half including mid
        }
        return start; // start == end, peak found
    }

    // 7. Peak Index in a Mountain Array - Leetcode 852
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) start = mid + 1; // peak in right half
            else end = mid; // peak in left half including mid
        }
        return start; // start == end, peak found
    }

}

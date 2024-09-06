// 1. Binary Search - Leetcode 704 (https://leetcode.com/problems/binary-search/)
// 2. Search Insert Position - Leetcode 35 (https://leetcode.com/problems/search-insert-position/)
// 3. Find First and Last Position of Element in Sorted Array - Leetcode 34 (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// 4. Number of occurrence in a sorted array - GFG (https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1)
// 5. Implement Lower Bound - Coding Ninjas (https://www.naukri.com/code360/problems/lower-bound_8165382)
// 6. Implement Upper Bound - Coding Ninjas (https://www.naukri.com/code360/problems/upper-bound_8165383)
// 7. Floor in a Sorted Array - GFG (https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1)
// 8. Ceil in a Sorted Array

public class c_BinarySearchOn1DArrays {

    
    // 1. Binary Search - Leetcode 704
    public int search(int[] nums, int target) {
        int start = 0; // start(s) or low(l) or left(l) pointer
        int end = nums.length - 1; // end(e) or high(h) or right(r) pointer

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid; // Target found
            else if (target > nums[mid]) start = mid + 1; // Target is in the right half
            else if (target < nums[mid]) end = mid - 1; // Target is in the left half
        }
        return -1; // Target not found
    }

    // 2. Search Insert Position - Leetcode 35
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid; // Target found
            else if (target > nums[mid]) start = mid + 1; // Target is in the right half
            else end = mid - 1; // Target is in the left half
        }
        return start; // Target not found, return the insert position
    }

    // 3. Find First and Last Position of Element in Sorted Array - Leetcode 34
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                index = mid;
                end = mid - 1; // Continue searching in left half
            } else if (target > nums[mid]) { // search in right half
                start = mid + 1;
            } else if (target < nums[mid]) { // search in left half
                end = mid - 1;
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                index = mid;
                start = mid + 1; // Continue searching in right half
            } else if (target > nums[mid]) { // search in right half
                start = mid + 1;
            } else if (target < nums[mid]) { // search in left half
                end = mid - 1;
            }
        }
        return index;
    }


    // 4. Number of occurrence in a sorted array - GFG
    public int count(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        if (first == -1 || last == -1) return 0;
        return last - first + 1;
    }
    
    // 5. Implement Lower Bound in a Sorted Array - Coding Ninjas
    public static int lowerBound(int []arr, int n, int x) {
        // smallest index such that arr[idx] >= target
        int low = 0, high = n-1;
        int idx = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x) {
                idx = mid;
                high = mid - 1; // search in left half
            } else {
                low = mid + 1; // search in right half
            }
        }
        return idx;
    }

    // 6. Implement Upper Bound in a Sorted Array - Coding Ninjas
    public static int upperBound(int []arr, int n, int x) {
        // smallest index such that arr[idx] > target
        int low = 0, high = n-1;
        int idx = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > x) {
                idx = mid;
                high = mid - 1; // search in left half
            } else {
                low = mid + 1; // search in right half
            }
        }
        return idx;
    }

    // 7. Return the Floor element in a Sorted Array - GFG
    public static int findFloor(int arr[], int n, int x) {
        // Floor - largest element <= target
        int low = 0, high = n-1;
        int floor = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1; // search in right half
            } else {
                high = mid - 1; // search in left half
            }
        }
        return floor;
    }

    // 8. Return the Ceil element in a Sorted Array
    public static int findCeil(int arr[], int n, int x) {
        // Ceil - smallest element >= target => (similar to lower bound)
        int low = 0, high = n-1;
        int ceil = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1; // search in left half
            } else {
                low = mid + 1; // search in right half
            }
        }
        return ceil;
    }



}

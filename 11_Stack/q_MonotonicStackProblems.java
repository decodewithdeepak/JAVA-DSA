// Monotonic Stack Problems: - Stack with a specific order (either increasing or decreasing)
// 1. Next Greater Element (GFG) - [https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1]
// 2. Next Greater Element I (LeetCode 496) - [https://leetcode.com/problems/next-greater-element-i/]
// 3. Next Greater Element II (LeetCode 503) - [https://leetcode.com/problems/next-greater-element-ii/]
// 4. Next Smaller Element (InterviewBit) - [https://www.interviewbit.com/problems/nearest-smaller-element/]
// 5. Number of NGEs to the right (GFG) - [https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1]

// 6. Trapping Rain Water (LeetCode 42) - [https://leetcode.com/problems/trapping-rain-water/]
// 7. Container With Most Water (LeetCode 11) - [https://leetcode.com/problems/container-with-most-water/]
// 8. Asteroid Collision (LeetCode 735) - [https://leetcode.com/problems/asteroid-collision/]
// 9. Remove K Digits (LeetCode 402) - [https://leetcode.com/problems/remove-k-digits/]

// 10. Sum of Subarray Minimums (LeetCode 907) - [https://leetcode.com/problems/sum-of-subarray-minimums/]
// 11. Sum of Subarray Ranges (LeetCode 2104) - [https://leetcode.com/problems/sum-of-subarray-ranges/]
// 12. Largest Rectangle in Histogram (LeetCode 84) - [https://leetcode.com/problems/largest-rectangle-in-histogram/]
// 13. Maximal Rectangle (LeetCode 85) - [https://leetcode.com/problems/maximal-rectangle/]

import java.util.*;

public class q_MonotonicStackProblems {

    // 1. Next Greater Element (GFG)
    public static long[] nextLargerElement(long[] arr, int n) {

        // Brute Force Approach - O(n^2) - TLE
        // long[] ans = new long[n];
        // for (int i = 0; i < n; i++) {
        //     ans[i] = -1;
        //     for (int j = i + 1; j < n; j++) {
        //         if (arr[j] > arr[i]) {
        //             ans[i] = (int) arr[j];
        //             break;
        //         }
        //     }
        // }
        // return ans;

        // Using Stack - O(n) - Optimal

        long[] ans = new long[n];
        Stack<Long> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // remove all smaller elements
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            // if stack is empty, no next greater element
            if (st.isEmpty()) ans[i] = -1;
            // if top element is greater, it is next greater element
            else ans[i] = st.peek();
            // push the current element
            st.push(arr[i]);
        }
        return ans;
    }


    // 2. Next Greater Element I (LeetCode 496)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums1: query array, nums2: source array (next greater element in nums2 for each element in nums1)

        HashMap<Integer, Integer> hm = new HashMap<>(); // key: element, value: next greater element
        Stack<Integer> st = new Stack<>(); // stack to store elements in decreasing order
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) hm.put(nums2[i], -1);
            else hm.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        
        return ans;
    }


    // 3. Next Greater Element II (LeetCode 503)
    public int[] nextGreaterElements(int[] nums) {
        // // Brute Force Approach - O(n^2)
        // int n = nums.length;
        // int[] ans = new int[n];
        // for (int i = 0; i < n; i++) {
        //     ans[i] = -1;
        //     for (int j = i + 1; j < i + n; j++) {
        //         if (nums[j % n] > nums[i]) { // j%n to handle circular array
        //             ans[i] = nums[j % n];
        //             break;
        //         }
        //     }
        // }
        // return ans;

        // Using Stack - O(n)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2*(n-1); i >= 0; i--) {
            while (!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) ans[i % n] = -1;
            else ans[i % n] = st.peek();
            st.push(nums[i % n]);
        }

        return ans;
    }


    // 4. Next Smaller Element (InterviewBit)
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        // Using Stack - O(n)
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A.get(i) <= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.push(A.get(i));
        }

        return ans;
    }


    // 5. Number of NGEs to the right (GFG)
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] ans = new int[queries];

        for(int i = 0; i < queries; i++) {
            int count = 0;
            int idx = indices[i];
            int curr = arr[idx];

            for (int j = idx + 1; j < N; j++) {
                if (arr[j] > curr) {
                    count++;
                }
            }

            ans[i] = count;
        }
        
        return ans;
    }


    // 6. Trapping Rain Water (LeetCode 42)
    public int trap(int[] height) {
        // create two arrays left and right
        // left[i] = max height from 0 to i
        // right[i] = max height from i to n-1
        // ans[i] = min(left[i], right[i]) - height[i]
        // sum of all ans[i] is the answer

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;

        // TC- O(n), SC- O(n)
    }

    
    // 7. Container With Most Water (LeetCode 11)
    public int maxArea(int[] height) {
        // Two Pointer Approach - O(n)
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h*w);

            // move the pointer with smaller height
            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }


    // 8. Asteroid Collision (LeetCode 735)
    public int[] asteroidCollision(int[] asteroids) {
        // -ve -> towards left, +ve -> towards right
        // for collision -> left is +ve and right is -ve
        // if left is smaller, left is destroyed
        // if right is smaller, right is destroyed
        // if both are equal, both are destroyed

        Stack<Integer> s = new Stack<>();
        for (int ast : asteroids) {
            while(!s.isEmpty() && ast < 0 && s.peek() > 0) {
                int sum = ast + s.peek();
                if (sum < 0) { // sum < 0 -> left is destroyed
                    s.pop();
                } else if (sum > 0) { // sum > 0 -> right is destroyed
                    ast = 0;
                } else { // sum = 0 -> both are destroyed
                    s.pop();
                    ast = 0;
                }
            }
            if (ast != 0) s.push(ast); // if ast is not destroyed
        }

        // convert stack to array
        int[] ans = new int[s.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }


    // 9. Remove K Digits (LeetCode 402)
    public String removeKdigits(String num, int k) {

        // keep smallest digits at the start
        // get rid of k largest digits

        int n = num.length();
        Stack<Character> st = new Stack<>();

        // remove k largest digits
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // if k is still left, remove the largest digits from the end
        while (k > 0) {
            st.pop();
            k--;
        }

        // create the answer string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        // reverse the string
        sb.reverse();

        // remove leading zeroes
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // if string is empty, return "0"
        if (sb.length() == 0) return "0";

        return sb.toString();
    }


    // 10. Sum of Subarray Minimums (LeetCode 907)
    public int sumSubarrayMins(int[] arr) {

        // // O(n^2) solution - TLE
        // int n = arr.length;
        // int mod = (int)1e9 + 7;
        // long sum = 0;
        // for (int i = 0; i < n; i++) {
        //     int min = arr[i];
        //     for (int j = i; j < n; j++) {
        //         min = Math.min(min, arr[j]);
        //         sum = (sum + min) % mod;
        //     }
        // }
        // return (int)sum;

        //  O(n) solution - Using Stack and concept of Next Smaller Element (NSE) on left and right
        int n = arr.length;
        int mod = (int)1e9 + 7; // to avoid overflow
        long sum = 0; // to store the sum of all subarray minimums

        int[] left = new int[n]; // stores index of NSE on left
        int[] right = new int[n]; // stores index of NSE on right

        Stack<Integer> st = new Stack<>(); // to store indices in decreasing order

        // calculate NSE on left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // clear the stack
        st.clear();

        // calculate NSE on right
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // calculate the sum of all subarray minimums
        for (int i = 0; i < n; i++) {
            sum = (sum + (long)arr[i] * (i - left[i]) * (right[i] - i)) % mod;
        }

        return (int)sum;
    }


    // 10. Sum of Subarray Range (LeetCode 2104)
    public long subArrayRanges(int[] nums) {
        // // brute force - O(n^2)
        // long sum = 0;
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {
        //     int min = nums[i];
        //     int max = nums[i];
        //     for (int j = i; j < n; j++) {
        //         min = Math.min(min, nums[j]);
        //         max = Math.max(max, nums[j]);
        //         sum += max - min;
        //     }
        // }

        // return sum;

        // Using Stack - O(n)

        // ∑ (max - min) = ∑ max - ∑ min
        // ∑ max = sum of subarray maximums
        // ∑ min = sum of subarray minimums

        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Process for maximums
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int j = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                sum += (long) arr[j] * (j - left) * (i - j);
            }
            st.push(i);
        }

        // Clear remaining elements in the stack
        while (!st.isEmpty()) {
            int j = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            sum += (long) arr[j] * (j - left) * (n - j);
        }

        return sum;
    }

    private long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Process for minimums
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int j = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                sum += (long) arr[j] * (j - left) * (i - j);
            }
            st.push(i);
        }

        // Clear remaining elements in the stack
        while (!st.isEmpty()) {
            int j = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            sum += (long) arr[j] * (j - left) * (n - j);
        }

        return sum;
    }


    // 12. Largest Rectangle in Histogram (LeetCode 84)
    public int largestRectangleArea(int[] heights) {

        // // Brute Force Approach - O(n^2) - TLE
        // int n = heights.length;
        // int maxArea = 0;
        
        // for (int i = 0; i < n; i++) {
        //     int h = heights[i];
        //     int left = i, right = i;
        //     while (left >= 0 && heights[left] >= h) {
        //         left--;
        //     }
        //     while (right < n && heights[right] >= h) {
        //         right++;
        //     }
        //     int currArea = h * (right - left - 1); 
        //     // (right - left - 1) -> width of rectangle
        //     maxArea = Math.max(maxArea, currArea);
        // }
        // return maxArea;

        // Using Stack - O(n) - Concept of NSE and PSE
        int maxArea = 0;
        
        int[] ps = prevSmaller(heights); // previous smaller element on left
        int[] ns = nextSmaller(heights); // next smaller element on right

        for (int i = 0; i < heights.length; i++) {
            int currArea = heights[i] * (ns[i] - ps[i] - 1);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    // Helper function to find next smaller element on right (NSE)
    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return right;
    }

    // Helper function to find previous smaller element on left (PSE)
    private int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return left;
    }
    

    // 13. Maximal Rectangle (LeetCode 85)
    public int maximalRectangle(char[][] matrix) {
        // Using Stack - O(n*m) - Concept of Largest Rectangle in Histogram
        if (matrix.length == 0) return 0;
        
        int r = matrix.length; // rows
        int c = matrix[0].length; // columns
        int maxArea = 0;

        int[] heights = new int[c];
        for (int i = 0; i < r; i++) {
            // calculate heights array
            for (int j = 0; j < c; j++) {
                // If matrix[i][j] is '1'-> increase the height; otherwise reset to 0
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            // calculate max area
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
    // Use helper function largestRectangleArea() from above


    // Next Greater Element (NGE)
    // Next Smaller Element (NSE)
    // Previous Greater Element (PGE)
    // Previous Smaller Element (PSE)


}
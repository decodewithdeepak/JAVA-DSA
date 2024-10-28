// Implementation Problems: -
// 1. Sliding Window Maximum (LeetCode 239) - [https://leetcode.com/problems/sliding-window-maximum/]
// 2. Stock Span Problem (LeetCode 901) - [https://leetcode.com/problems/online-stock-span/]
// 3. Celebrity Problem (LeetCode 277) - [https://leetcode.com/problems/find-the-celebrity/]
// 4. LRU Cache (LeetCode 146) - [https://leetcode.com/problems/lru-cache/]
// 5. LFU Cache (LeetCode 460) - [https://leetcode.com/problems/lfu-cache/]

import java.util.*;

public class r_ImplementationProblems {

    // 1. Sliding Window Maximum (LeetCode 239)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // // Brute Force: TC: O(n-k+1 * k) => O(n*k) | SC: O(n-k+1) => O(n)
        // int n = nums.length;
        // int[] ans = new int[n - k + 1];
        // for (int i = 0; i <= n - k; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i + k; j++) {
        //         max = Math.max(max, nums[j]);
        //     }
        //     ans[i] = max;
        // }
        // return ans;

        // // Using Stack: O(n)
        // int n = nums.length;
        // int[] ans = new int[n - k + 1];
        // Stack<Integer> st = new Stack<>();
        // for (int i = 0; i < n; i++) {
        //     while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
        //         st.pop();
        //     }
        //     st.push(i);
        //     if (i - k + 1 >= 0) {
        //         ans[i - k + 1] = nums[st.get(0)];
        //     }
        //     if (i - k + 1 >= st.get(0)) {
        //         st.remove(0);
        //     }
        // }
        // return ans;

        // Using Deque: O(n)
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        // dq stores the index of the elements in the window
        for (int i = 0; i < n; i++) {
            // Remove the elements which are out of the window
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.removeFirst();
            }
            // Remove the elements which are smaller than the current element
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            // Add the current element
            dq.addLast(i);
            // If the window is completely formed
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

    // 2. Stock Span Problem (LeetCode 901)

    // 3. Celebrity Problem (LeetCode 277)

    // 4. LRU Cache (LeetCode 146)

    // 5. LFU Cache (LeetCode 460)
}

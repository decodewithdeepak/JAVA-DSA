// Stacks : Interview Questions | Leetcode Problems

// 1. Balanced Parentheses - Leetcode 20 (https://leetcode.com/problems/valid-parentheses)
// 2. Minimum no. of brackets to be added to make the string balanced - Leetcode 921 (https://leetcode.com/problems/minimum-add-to-make-parentheses-valid)
// 3. Minimum Number of Swaps to Make the String Balanced - Leetcode 1963 (https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced)
// 4. Remove Adjacent Duplicates - Leetcode 1047 (https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string)
// 5. Next Greater Element - GFG (https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
// 6. Next Greater Element II (Circular Case) - Leetcode 503 (https://leetcode.com/problems/next-greater-element-ii)
// 7. Stock Span Problem - GFG (https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1)
// OR Stock Span Problem - Leetcode 901 (https://leetcode.com/problems/online-stock-span)
// 8. Largest Area Histogram - Leetcode 84 (https://leetcode.com/problems/largest-rectangle-in-histogram)
// 9. Min Stack - Leetcode 155 (https://leetcode.com/problems/min-stack)

import java.util.Stack;

public class InterviewProblems {

    // 1. Balanced Parentheses - Leetcode 20
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Push opening brackets to stack
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            // Pop closing brackets from stack if they match with top of stack
            else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } 
            else if (c == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } 
            else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } 
            // If closing bracket does not match with top of stack, return false
            else {
                return false;
            }
        }
        // If stack is empty at the end, return true
        return st.isEmpty();
    }

    // 2. Minimum no. of brackets to be added to make the string balanced - Leetcode 921
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Push opening brackets to stack
            if (c == '(') {
                st.push(c);
            } 
            // Pop closing brackets from stack if they match with top of stack
            else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } 
            // If closing bracket does not match with top of stack, push it to stack
            else if (c == ')') {
                st.push(c);
            }
        }
        // Return the size of stack as it contains the minimum no. of brackets to be added
        return st.size();
    }

    // 3. Minimum Number of Swaps to Make the String Balanced - Leetcode 1963
    public static int minSwaps(String s) {
        int unbalanced = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If opening bracket, increment unbalanced
            if (c == '[') {
                unbalanced++;
            } 
            // If closing bracket, decrement unbalanced
            else if (c == ']' && unbalanced > 0) {
                unbalanced--;
            } 
            // If closing bracket and unbalanced is 0, increment ans
            else if (c == ']' && unbalanced == 0) {
                ans++;
            }
        }
        return (ans + 1) / 2; // Return ans/2 as each swap will balance 2 brackets, and add 1 to ans if ans is odd
    }

    // 4. Remove Adjacent Duplicates - Leetcode 1047
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If stack is not empty and top of stack is equal to current character, pop the top of stack
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } 
            // Else push the current character to stack
            else {
                st.push(c);
            }
        }
        // Convert the stack to string and return
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    // 5. Next Greater Element - GFG
    public static int[] nextLargerElement(int[] arr, int n) {
        // Without using Stack - TC-O(n^2) - Time Limit Exceeded
        // int[] ans = new int[n];
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

        // Using Stack - TC-O(n)
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    // 6. Next Greater Element II (Circular Case) - Leetcode 503
    public static int[] nextGreaterElements(int[] nums) {

        // Without using Stack - TC-O(n^2)
        // int n = nums.length;
        // int[] ans = new int[n];
        // for (int i = 0; i < n; i++) {
        //     ans[i] = -1;
        //     for (int j = i + 1; j < n + i; j++) { // i is added to n to handle circular case
        //         if (nums[j % n] > nums[i]) { // n is modded to handle circular case
        //             ans[i] = nums[j % n];
        //             break;
        //         }
        //     }
        // }
        // return ans;

        // Using Stack - TC-O(n)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();
            }
            ans[i % n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }
        return ans;
    }

    // 7. Stock Span Problem - GFG
    public static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && price[i] >= price[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        return ans;
    }

    // 8. Largest Area Histogram - Leetcode 84
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }

    // 9. Min Stack - Leetcode 155
    public static class MinStack {
        Stack<Integer> st;
        int min;

        public MinStack() {
            st = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if (val <= min) {
                st.push(min);
                min = val;
            }
            st.push(val);
        }

        public void pop() {
            if (st.pop() == min) {
                min = st.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {

        // 1. Balanced Parentheses - Leetcode 20
        // System.out.println(isValid("()")); // true
        // System.out.println(isValid("()[]{}")); // true
        // System.out.println(isValid("(]")); // false
        // System.out.println(isValid("([)]")); // false
        // System.out.println(isValid("{[]}")); // true


        // 2. Minimum no. of brackets to be added to make the string balanced - Leetcode 921
        // System.out.println(minAddToMakeValid("())")); // 1
        // System.out.println(minAddToMakeValid("(((")); // 3
        // System.out.println(minAddToMakeValid("()")); // 0
        // System.out.println(minAddToMakeValid("()))((")); // 4


        // 3. Minimum Number of Swaps to Make the String Balanced - Leetcode 1963
        // System.out.println(minSwaps("[]")); // 0
        // System.out.println(minSwaps("][][")); // 1
        // System.out.println(minSwaps("][[]")); // 1
        // System.out.println(minSwaps("]]][[[")); // 2
        // System.out.println(minSwaps("]]][[[[]")); // 2


        // 4. Remove Adjacent Duplicates - Leetcode 1047
        // System.out.println(removeDuplicates("abbaca")); // ca
        // System.out.println(removeDuplicates("azxxzy")); // ay
        // System.out.println(removeDuplicates("a")); // a
        // System.out.println(removeDuplicates("aa")); // ""


        // 5. Next Greater Element - GFG
        // int[] ans = nextLargerElement(new int[] {4, 5, 2, 10, 8}, 5);
        // for (int i : ans) System.out.print(i + " "); // 5 10 10 -1 -1


        // 6. Next Greater Element II (Circular Case) - Leetcode 503
        // int[] ans = nextGreaterElements(new int[] {4, 5, 2, 10, 8});
        // for (int i : ans) System.out.print(i + " "); // 5 10 10 -1 10

        // 7. Stock Span Problem - GFG
        // int[] ans = calculateSpan(new int[] {100, 80, 60, 70, 60, 75, 85}, 7);
        // for (int i : ans) System.out.print(i + " "); // 1 1 1 2 1 4 6

        // 8. Largest Area Histogram - Leetcode 84
        // System.out.println(largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3})); // 10
        // System.out.println(largestRectangleArea(new int[] {2, 4})); // 4

        // 9. Min Stack - Leetcode 155
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // -3
        obj.pop();
        System.out.println(obj.top()); // 0
        System.out.println(obj.getMin()); // -2





    }
}

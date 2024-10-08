// 1. Implement Stack using Array (GFG) - [https://www.geeksforgeeks.org/problems/implement-stack-using-array/1]
// 2. Implement Stack using Queue (LeetCode 225) - [https://leetcode.com/problems/implement-stack-using-queues/] 
// 3. Implement Stack using Linked List (GFG) - [https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1]
// 4. Check for Valid Parentheses (LeetCode 20) - [https://leetcode.com/problems/valid-parentheses/]
// 5. Implement Min Stack (LeetCode 155) - [https://leetcode.com/problems/min-stack/]

import java.util.Stack;

public class o_StackProblems {

    // 1. Implement Stack using Array (GFG) - [https://www.geeksforgeeks.org/problems/implement-stack-using-array/1]
    class MyStack {
        private int[] arr;
        private int top;
    
        public MyStack() {
            arr = new int[1000];
            top = -1;
        }
    
        public void push(int x) {
            arr[++top] = x;
        }
    
        public int pop() {
            if (top == -1) {
                return -1;
            }
            return arr[top--];
        }
    }

    // 2. Implement Stack using Queue (LeetCode 225) - [https://leetcode.com/problems/implement-stack-using-queues/]
    class MyStack {
        Queue<Integer> q; // Using a single queue
    
        public MyStack() {
            q = new LinkedList<>();
        }
    
        public void push(int x) {
            q.add(x); // add new element
            for (int i = 0; i < q.size() - 1; i++) { // rotate queue
                q.add(q.remove());
            }
        }
    
        public int pop() {
            return q.remove();
        }
    
        public int top() {
            return q.peek();
        }
    
        public boolean empty() {
            return q.isEmpty();
        }
    }

    // 3. Implement Stack using Linked List (GFG) - [https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1]
    class MyStack {
        // class StackNode {
        //     int data;
        //     StackNode next;
        //     StackNode(int a) {
        //         data = a;
        //         next = null;
        //     }
        // }
        StackNode top;
    
        // Function to push an integer into the stack.
        void push(int a) {
            StackNode temp = new StackNode(a); // create a new node
            temp.next = top; // point the new node to the top
            top = temp; // move the top pointer to the new node
        }
    
        // Function to remove an item from top of the stack.
        int pop() {
            if (top == null) return -1; // stack is empty
            int val = top.data; // store the top element
            top = top.next; // move the top pointer to the next element
            return val;
        }
    }

    // 4. Check for Valid Parentheses (LeetCode 20) - [https://leetcode.com/problems/valid-parentheses/]
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // push opening brackets to stack
            if (c == '(' || c == '{' || c == '[')  st.push(c);
            // pop corresponding opening bracket if closing bracket is found at top
            else if (c == ')' && !st.isEmpty() && st.peek() == '(') st.pop();
            else if (c == '}' && !st.isEmpty() && st.peek() == '{') st.pop();
            else if (c == ']' && !st.isEmpty() && st.peek() == '[') st.pop();
            // closing bracket found at top but no corresponding opening bracket
            else return false;
        }
        // stack should be empty if all brackets are balanced
        return st.isEmpty();
    }

    // 5. Implement Min Stack (LeetCode 155) - [https://leetcode.com/problems/min-stack/]
    class MinStack {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();

        public MinStack() {
            // constructor
        }
        
        public void push(int val) {
            if (st.size() == 0) {
                st.push(val);
                minSt.push(val);
            }
            else {
                st.push(val);
                if (val < minSt.peek()) minSt.push(val);
                else minSt.push(minSt.peek());
            }
        }
        
        public void pop() {
            st.pop();
            minSt.pop();
        }
        
        public int top() {
            return st.peek();
        }
        
        public int getMin() {
            return minSt.peek();
        }
    }

    
}

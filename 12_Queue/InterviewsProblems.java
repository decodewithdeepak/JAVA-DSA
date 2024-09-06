// https://drive.google.com/file/d/1LiPG5kMYgPiIWDk6AnRFf-JDgxRnWzLf/view

// Queues - Interview Questions | Leetcode Problems

// 1. Reverse first k elements of a queue - GFG - (https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1)
// 2. Implement a Stack using Queues - Leetcode #225 - (https://leetcode.com/problems/implement-stack-using-queues/)
// 3. Implement a Queue using Stacks - Leetcode #232 - (https://leetcode.com/problems/implement-queue-using-stacks/)
// 4. Design Circular Queue - Leetcode #622 - (https://leetcode.com/problems/design-circular-queue/)
// 5. Design Circular Deque - Leetcode #641 - (https://leetcode.com/problems/design-circular-deque/)
// 6. First negative integer in every window of size k - GFG - (https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)
// 7. Interleave the First Half of the Queue with Second Half - GFG - (https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1)

import java.util.*;

public class InterviewsProblems {

    // 1. Reverse first k elements of a queue - GFG
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> ans = new LinkedList<>();

        // Create a stack
        Stack<Integer> st = new Stack<>();

        // Push the first k elements into a stack
        for (int i = 0; i < k; i++) {
            st.push(q.poll());
            // st.push(q.remove());
        }

        // Pop the elements from the stack and add them to the queue
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        // Add the remaining elements of the queue to the queue
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }

    // 2. Implement a Stack using Queues - Leetcode #225
    static class MyStack {
        Queue<Integer> q; // Using a single queue

        public MyStack() { // Constructor
            q = new LinkedList<>();
        }

        public void push(int x) { // O(n)
            // Add new element to the rear
            q.add(x);
            // Rotate the queue size-1 times so that the new element is at the front
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.remove()); // Remove the front element and add it to the rear
            }
        }

        public int pop() { // O(1)
            return q.remove();
        }

        public int top() { // O(1)
            return q.peek();
        }

        public boolean empty() { // O(1)
            return q.isEmpty();
        }
    }


    // 3. Implement a Queue using Stacks - Leetcode #232
    static class MyQueue {
        Stack<Integer> s1; // Main stack
        Stack<Integer> s2; // Auxiliary stack

        public MyQueue() { // Constructor
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) { // O(1)
            // Add new element to the main stack
            s1.push(x);
        }

        public int pop() { // O(n)
            // Transfer all elements from s1 to s2
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // Pop the front element from s2
            return s2.pop();
        }

        public int peek() { // O(n)
            // Transfer all elements from s1 to s2
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // Peek the front element from s2
            return s2.peek();
        }

        public boolean empty() { // O(1)
            // Check if both stacks are empty
            return s1.isEmpty() && s2.isEmpty();
        }
    }


    // 4. Design Circular Queue - Leetcode #622
    static class MyCircularQueue {
        int[] q;
        int front, rear, size, capacity;

        public MyCircularQueue(int k) { // Constructor
            q = new int[k];
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
        }

        public boolean enQueue(int value) { // O(1)
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % capacity;
            q[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() { // O(1)
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return q[front];
        }

        public int Rear() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return q[rear];
        }

        public boolean isEmpty() { // O(1)
            return size == 0;
        }

        public boolean isFull() { // O(1)
            return size == capacity;
        }
    }


    // 5. Design Circular Deque - Leetcode #641
    static class MyCircularDeque {
        int[] q;
        int front, rear, size, capacity;

        public MyCircularDeque(int k) { // Constructor
            q = new int[k];
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
        }

        public boolean insertFront(int value) { // O(1)
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            q[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) { // O(1)
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % capacity;
            q[rear] = value;
            size++;
            return true;
        }

        public boolean deleteFront() { // O(1)
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public boolean deleteLast() { // O(1)
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

        public int getFront() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return q[front];
        }

        public int getRear() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return q[(rear + capacity) % capacity];
        }

        public boolean isEmpty() { // O(1)
            return size == 0;
        }

        public boolean isFull() { // O(1)
            return size == capacity;
        }
    }

    // 6. First negative integer in every window of size k - GFG
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] ans = new long[N - K + 1];
        int i = 0, j = 0, idx = 0;
        Queue<Long> q = new LinkedList<>();

        while (j < N) {
            if (A[j] < 0) {
                q.add(A[j]);
            }

            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (q.isEmpty()) {
                    ans[idx++] = 0;
                } else {
                    ans[idx++] = q.peek();
                    if (A[i] == q.peek()) {
                        q.poll();
                    }
                }
                i++;
                j++;
            }
        }

        return ans;
    }


    // 7. Interleave the First Half of the Queue with Second Half - GFG
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        int half = N / 2;

        // Push the first half elements into a stack
        for (int i = 0; i < half; i++) {
            st.push(q.poll());
        }

        // Add the first half elements to the queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // Add the first half elements to the rear of the queue
        for (int i = 0; i < half; i++) {
            q.add(q.poll());
        }

        // Add the first half elements to the rear of the queue
        for (int i = 0; i < half; i++) {
            st.push(q.poll());
        }

        // Interleave the elements of the stack and queue
        while (!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.poll());
        }

        // Add the elements of the queue to the list
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    
    }


    public static void main(String[] args) {

        // 1. Reverse first k elements of a queue - GFG
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;
        Queue<Integer> ans = modifyQueue(q, k);
        System.out.println(ans); // Output: [3, 2, 1, 4, 5]


        // 2. Implement a Stack using Queues - Leetcode #225
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.top()); // Output: 3
        System.out.println(st.pop()); // Output: 3
        System.out.println(st.top()); // Output: 2
        System.out.println(st.empty()); // Output: false


        // 3. Implement a Queue using Stacks - Leetcode #232
        MyQueue q1 = new MyQueue();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        System.out.println(q1.peek()); // Output: 1
        System.out.println(q1.pop()); // Output: 1
        System.out.println(q1.peek()); // Output: 2
        System.out.println(q1.empty()); // Output: false


        // 4. Design Circular Queue - Leetcode #622
        MyCircularQueue cq = new MyCircularQueue(3);
        System.out.println(cq.enQueue(1)); // Output: true
        System.out.println(cq.enQueue(2)); // Output: true
        System.out.println(cq.enQueue(3)); // Output: true
        System.out.println(cq.enQueue(4)); // Output: false
        System.out.println(cq.Rear()); // Output: 3
        System.out.println(cq.isFull()); // Output: true
        System.out.println(cq.deQueue()); // Output: true
        System.out.println(cq.enQueue(4)); // Output: true
        System.out.println(cq.Rear()); // Output: 4


        // 5. Design Circular Deque - Leetcode #641
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertLast(1)); // Output: true
        System.out.println(cd.insertLast(2)); // Output: true
        System.out.println(cd.insertFront(3)); // Output: true
        System.out.println(cd.insertFront(4)); // Output: false
        System.out.println(cd.getRear()); // Output: 2
        System.out.println(cd.isFull()); // Output: true
        System.out.println(cd.deleteLast()); // Output: true
        System.out.println(cd.insertFront(4)); // Output: true
        System.out.println(cd.getRear()); // Output: 2


        // 6. First negative integer in every window of size k - GFG
        long[] A = {12, -1, -7, 8, -15, 30, 16, 28};
        int N = A.length;
        int K = 3;
        long[] res = printFirstNegativeInteger(A, N, K);
        System.out.println(Arrays.toString(res)); // Output: [-1, -1, -7, -15, -15, 0]


        // 7. Interleave the First Half of the Queue with Second Half - GFG
        Queue<Integer> qr = new LinkedList<>(); // 3 7 5 6 8 9
        qr.add(3);
        qr.add(7);
        qr.add(5);
        qr.add(6);
        qr.add(8);
        qr.add(9);
        ArrayList<Integer> res1 = rearrangeQueue(6, qr);
        System.out.println(res1); // Output: [3, 6, 7, 8, 5, 9]
        
        

    }
}

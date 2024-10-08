// 1. Implement Queue using Array (GFG) - [https://www.geeksforgeeks.org/problems/implement-queue-using-array/1]
// 2. Implement Queue using Stack (LeetCode 232) - [https://leetcode.com/problems/implement-queue-using-stacks/]
// 3. Implement Queue using Linked List (GFG) - [https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1]

public class i_QueueProblems {

    // 1. Implement Queue using Array (GFG)
    class MyQueue {

        int front, rear;
        int arr[] = new int[100005];

        MyQueue() {
            front = 0;
            rear = 0;
        }

        // Function to push an element x in a queue.
        void push(int x) {
            rear++;
            arr[rear] = x;
        }

        // Function to pop an element from queue and return that element.
        int pop() {
            if (front == rear) return -1;
            front++;
            return arr[front];
        }
    }

    // 2. Implement Queue using Stack (LeetCode 232)
    class MyQueue {
        Stack<Integer> s1; // main stack to enqueue elements
        Stack<Integer> s2; // auxiliary stack to dequeue elements
        
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    // 3. Implement Queue using Linked List (GFG)
    class MyQueue {
        QueueNode front, rear;

        // Function to push an element into the queue.
        void push(int a) {
            QueueNode newNode = new QueueNode(a);
            if (front == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        // Function to pop front element from the queue.
        int pop() {
            if (front == null) return -1;
            int value = front.data;
            front = front.next;
            return value;
        }
    }

    

}

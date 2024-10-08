// Implementation of Simple Queue using a Stack

// Stack works like a queue when we reverse the order of elements. 
// The elements are added at the top and removed from the top. 
// To implement a queue using a stack, we need two stacks. 
// The first stack is used to enqueue elements and the second stack is used to dequeue elements.

import java.util.Stack;

public class d_StackImplementationOfQueue {

    // Class for the queue
    public static class MyQueue {
        private Stack<Integer> s1; // Main Stack to enqueue elements
        private Stack<Integer> s2; // Auxiliary Stack to dequeue elements

        // Constructor for the queue
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // Enqueue elements into the queue
        public void push(int x) {
            s1.push(x);
        }

        // Dequeue elements from the queue
        public int pop() {
            // transfer elements from s1 to s2
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        // Peek the front element of the queue
        public int peek() {
            // transfer elements from s1 to s2
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }

        // Check if the queue is empty
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop()); // 1
        System.out.println(queue.pop()); // 2
        System.out.println(queue.pop()); // 3
        System.out.println(queue.empty()); // true
    }

}

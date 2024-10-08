// Implementation of Simple Queue using an Array

public class b_ArrayImplementationOfQueue {

    // Class for the queue
    public static class Queue {
        private int maxSize; // Maximum size of the queue
        private int[] arr; // Array to store the elements of the queue
        private int front; // Index of the front element of the queue
        private int rear; // Index of the rear element of the queue
        private int currentSize; // Current size of the queue

        // Constructor for the queue
        public Queue(int size) {
            maxSize = size;
            arr = new int[maxSize];
            front = 0;
            rear = -1;
            currentSize = 0;
        }

        // Enqueue elements into the queue - add elements to the rear
        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                rear++;
                arr[rear] = value;
                currentSize++;
            }
        }

        // Dequeue elements from the queue - remove elements from the front
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];
            front++;
            currentSize--;
            return result;
        }

        // Peek the front element of the queue - get the front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }

        // Check if the queue is full
        public boolean isFull() {
            return currentSize == maxSize;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return currentSize == 0;
        }

        // Get the current size of the queue
        public int getSize() {
            return currentSize;
            // return rear - front + 1;
        }

        // Print the queue
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            for (int i = front; i <= rear; i++) 
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // Create a queue with a maximum size of 100
        Queue q = new Queue(100);

        // Enqueue elements to the queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Print the queue
        q.printQueue(); // 10 20 30 40 50

        // Dequeue elements from the queue
        q.dequeue();
        q.dequeue();

        q.printQueue(); // 30 40 50

        // Peek the front element of the queue
        System.out.println("Front element: " + q.peek()); // 30

        // Get the size of the queue
        System.out.println("Size of the queue: " + q.getSize()); // 3

        // Check if the queue is empty
        System.out.println("Is queue empty: " + q.isEmpty()); // false

        // Check if the queue is full
        System.out.println("Is queue full: " + q.isFull()); // false


    }
}

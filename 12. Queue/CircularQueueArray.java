// Implementation of Circular Queue using Array

public class CircularQueueArray{

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
                rear = (rear + 1) % maxSize;
                // Above line means if rear reaches the end of the array, it will wrap around to the beginning
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
            front = (front + 1) % maxSize;
            // Above line means if front reaches the end of the array, it will wrap around to the beginning
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
        public int size() {
            return currentSize;
            // return (rear + maxSize - front + 1) % maxSize;
        }

        // Print the queue
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            int count = 0;
            int i = front;
            while (count < currentSize) {
                System.out.print(arr[i] + " ");
                i = (i + 1) % maxSize;
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create a queue of size 5
        Queue q = new Queue(5);

        // Enqueue elements into the queue
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
        System.out.println(q.peek()); // 30


        // Get the current size of the queue
        System.out.println(q.size()); // 3

        // Check if the queue is full
        System.out.println(q.isFull()); // false

        // Check if the queue is empty
        System.out.println(q.isEmpty()); // false
        
        
    }
}
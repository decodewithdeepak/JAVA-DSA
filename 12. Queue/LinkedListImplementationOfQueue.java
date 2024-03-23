// Implementation of Simple Queue using a linked list

// Linked List works like a queue. The elements are added at the tail (rear) and removed from the head (front).

public class LinkedListImplementationOfQueue {
    
    // Queue Class Node
    public static class Node {
        int data; // Data to be stored in the node
        Node next; // Pointer to the next node

        // Constructor for the node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Class for the queue
    public static class Queue {
        private Node front = null; // Pointer to the front (head) of the queue
        private Node rear = null; // Pointer to the rear (tail) of the queue
        private int size = 0; // Size of the queue

        // Enqueue elements into the queue - add elements to the rear (tail)
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (front == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        // Dequeue elements from the queue - remove elements from the front (head)
        public void dequeue() {
            if (front == null) {
                System.out.println("Queue is empty");
            } else {
                front = front.next;
                size--;
            }
        }

        // Peek the front of the queue - get the front element (head)
        public void peek() {
            if (front == null) {
                System.out.println("Queue is empty");
            } else {
                System.out.println("Front element: " + front.data);
            }
        }

        // Print the queue
        public void printQueue() {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Get the size of the queue
        public int getSize() {
            return size;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return (front == null);
        }

    }

    public static void main(String[] args) {

        // Create a queue object
        Queue queue = new Queue();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Print the queue
        queue.printQueue(); // 10 20 30 40 50

        // Dequeue elements from the queue
        queue.dequeue();
        queue.dequeue();

        queue.printQueue(); // 30 40 50

        // Peek the front element of the queue
        queue.peek(); // 30

        // Get the size of the queue
        System.out.println("Size of the queue: " + queue.getSize()); // 3

        // Check if the queue is empty
        System.out.println("Is the queue empty: " + queue.isEmpty()); // false


    }

}

// Implement a Circular Queue using Linked List

public class f_CircularQueueLinkedList {

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
        private Node rear = null; // Pointer to the rear of the queue
        // Only rear pointer is needed for circular queue
        private int size = 0; // Size of the queue

        // Enqueue elements into the queue - add elements to the rear
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (rear == null) {
                rear = newNode;
                rear.next = rear;
            } else {
                newNode.next = rear.next;
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        // Dequeue elements from the queue - remove elements from the front
        public void dequeue() {
            if (rear == null) {
                System.out.println("Queue is empty");
            } else {
                if (rear.next == rear) {
                    rear = null;
                } else {
                    rear.next = rear.next.next;
                }
                size--;
            }
        }

        // Peek the front of the queue - get the front element
        public void peek() {
            if (rear == null) {
                System.out.println("Queue is empty");
            } else {
                System.out.println("Front element: " + rear.next.data);
            }
        }

        // Print the queue
        public void printQueue() {
            if (rear == null) {
                System.out.println("Queue is empty");
            } else {
                Node temp = rear.next;
                do {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != rear.next);
                System.out.println();
            }
        }

        // Get the size of the queue
        public int getSize() {
            return size;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return rear == null;
        }
    }
    

    public static void main(String[] args) {

        // Create a queue object
        Queue q = new Queue();

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
        q.peek(); // 30

        // Get the current size of the queue
        System.out.println(q.getSize()); // 3

        // Check if the queue is empty
        System.out.println(q.isEmpty()); // false

        
    }
}

// Queue - FIFO (First In First Out) linear data structure

// Operations: enqueue, dequeue, peek, isEmpty, isFull
// 1. Enqueue - Add an element to the end of the queue - add(), offer()
// 2. Dequeue - Remove an element from the front of the queue - remove(), poll()
// 3. Peek - Get the front element of the queue - peek()

// 4. isEmpty - Check if the queue is empty
// 5. isFull - Check if the queue is full - Not applicable for dynamic queue
// 6. Size - Get the number of elements in the queue

// Types of Queues:- Simple Queue, Circular Queue, Priority Queue, Deque (Double Ended Queue), etc.

import java.util.LinkedList; // Class
import java.util.Queue; // Interface
import java.util.Scanner;

public class BasicsOfQueue {
    public static void main(String[] args) {
    
        // Create a queue using the Queue class
        // Queue<Integer> q = new Queue<>(); // Error: Cannot instantiate the type Queue<Integer>
        // Queue is an interface and cannot be instantiated directly

        // Create a queue using LinkedList class
        Queue<Integer> q = new LinkedList<>(); // LinkedList class implements the Queue interface

        // Check if the queue is empty
        System.out.println("Is queue empty: " + q.isEmpty()); // true

        // Size of the queue
        System.out.println("Size of the queue: " + q.size()); // 0

        // Enqueue elements to the queue
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.offer(50);
        // add vs offer: add() throws an exception if the queue is full, offer() returns false

        // Print the queue
        System.out.println("Queue: " + q); // [10, 20, 30, 40, 50]

        // Dequeue elements from the queue
        q.remove();
        q.poll();
        // remove vs poll: remove() throws an exception if the queue is empty, poll() returns null

        // Print the queue
        System.out.println("Queue: " + q); // [30, 40, 50]

        // Peek the front element of the queue
        System.out.println("Front element: " + q.peek()); // 30

        // Check if the queue is empty
        System.out.println("Is queue empty: " + q.isEmpty()); // false

        // Check if the queue is full
        // System.out.println("Is queue full: " + q.isFull()); // Not applicable for dynamic queue

        // Size of the queue
        System.out.println("Size of the queue: " + q.size()); // 3

        
        // Queue Underflow - queue.remove() or queue.peek() on an empty queue
        q.remove(); // [40, 50]
        q.remove(); // [50]
        q.remove(); // []
        System.out.println("Is queue empty: " + q.isEmpty()); // true
        // q.peek(); // Error: Exception in thread "main" java.util.NoSuchElementException
        // q.remove(); // Error: Exception in thread "main" java.util.NoSuchElementException

        // Queue Overflow - When we try to add an element to a full queue
        // Only applicable for fixed-size queue (array implementation)
        // Not applicable for dynamic queue (linked list implementation)

        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>(); // Reset the queue
        int n;
        System.out.println("Enter the number of elements:");
        n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        // Print the queue
        System.out.println("Queue: " + q);


        sc.close();

    }
}

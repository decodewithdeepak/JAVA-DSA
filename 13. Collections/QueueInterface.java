// Queue Interface - Ordered collection of objects
// Implementation Classes - LinkedList, PriorityQueue, ArrayDeque
// Sub-Interfaces - Deque -> ArrayDeque

// Methods of Queue Interface - add(), offer(), remove(), poll(), element(), peek(), clear(), contains(), isEmpty(), size(), etc.

// LinkedList Class - Doubly linked list (implements both List and Queue interfaces)
// PriorityQueue Class - Priority based queue where elements are ordered based on their priority (default min or custom by using Comparator)
// ArrayDeque Class - Double-ended queue (Deque) which supports both FIFO and LIFO operations

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueInterface {

    // LinkedList Class
    static void queueInterface() {
        LinkedList<Integer> ll = new LinkedList<>();
        
        ll.offer(10); // add
        ll.offer(20);
        ll.offer(30);

        System.out.println(ll); // [10, 20, 30]

        System.out.println(ll.poll()); // 10 (will remove from queue)
        System.out.println(ll.peek()); // 20
        System.out.println(ll.isEmpty()); // false
        System.out.println(ll.size()); // 2
    }

    // PriorityQueue Class
    static void priorityQueueClass() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // By default, min Priority Queue

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println(pq.peek()); // 10 (min element) - smallest element has highest priority
        System.out.println(pq); // [10, 30, 20] - Only the min element is guaranteed to be the first element
        System.out.println(pq.poll()); // 10 (will remove from queue)

        System.out.println(pq.peek()); // 20 (min element)
        System.out.println(pq); // [20, 30]
        
        // Max Priority Queue
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());

        pqMax.offer(30);
        pqMax.offer(10);
        pqMax.offer(20);

        System.out.println(pqMax.peek()); // 30 (max element) - largest element has highest priority
        System.out.println(pqMax); // [30, 10, 20] - Only the max element is guaranteed to be the first element
        System.out.println(pqMax.poll()); // 30 (will remove from queue)

        System.out.println(pqMax.peek()); // 20 (max element)
        System.out.println(pqMax); // [20, 10]
    }

    // ArrayDeque Class
    static void arrayDequeClass() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.offer(10); // add
        dq.offer(20);
        dq.offer(30);

        System.out.println(dq); // [10, 20, 30]

        System.out.println(dq.poll()); // 10 (will remove from queue)
        System.out.println(dq.peek()); // 20
        System.out.println(dq.isEmpty()); // false
        System.out.println(dq.size()); // 2

        dq.offerFirst(5); // addFirst
        dq.offerLast(35); // addLast

        System.out.println(dq); // [5, 20, 30, 35]

        System.out.println(dq.pollFirst()); // 5 (will remove from queue)
        System.out.println(dq.pollLast()); // 35 (will remove from queue)

        System.out.println(dq); // [20, 30]
    }

    
    public static void main(String[] args) {
        System.out.println("LinkedList Class");
        queueInterface();

        System.out.println("\nPriorityQueue Class");
        priorityQueueClass();

        System.out.println("\nArrayDeque Class");
        arrayDequeClass();
    }
}

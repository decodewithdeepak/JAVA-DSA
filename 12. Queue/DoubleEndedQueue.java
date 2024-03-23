// Double Ended Queue (Dequeue) - Java Collections

// HW - Implement Deque using Array and LinkedList

import java.util.Deque;
import java.util.LinkedList;

public class DoubleEndedQueue {

    public static void main(String[] args) {
        Deque <Integer> dq = new LinkedList<>();

        // Add elements to the deque
        dq.addLast(10); // Add element at the end
        dq.add(20); // add() is equivalent to addLast()

        dq.addFirst(30); // Add element at the front
        dq.addFirst(40);
        dq.addFirst(50);

        System.out.println("Deque: " + dq); // [50, 40, 30, 10, 20]

        // Remove elements from the deque
        dq.removeFirst(); // Remove element from the front
        dq.removeLast(); // Remove element from the end

        System.out.println("Deque: " + dq); // [40, 30, 10]

        // Get the front element of the deque
        // System.out.println("Front element: " + dq.getFirst()); // 40
        System.out.println("Front element: " + dq.peekFirst()); // 40

        // Get the last element of the deque
        System.out.println("Last element: " + dq.getLast()); // 10

        // Size of the deque
        System.out.println("Size of the deque: " + dq.size()); // 3

        // Check if the deque is empty
        System.out.println("Is deque empty: " + dq.isEmpty()); // false

        // Check if the deque contains an element
        System.out.println("Deque contains 30: " + dq.contains(30)); // true

        // Clear the deque
        dq.clear();

        System.out.println("Deque: " + dq); // []


    }
}

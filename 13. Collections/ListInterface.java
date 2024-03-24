// Collection Interface -> List Interface | Queue Interface | Set Interface | Deque Interface

// List Interface - Ordered collection of objects
// Implementation Classes - ArrayList, LinkedList, Stack, Vector

// Methods of List Interface - add(), addAll(), get(), set(), remove(), removeAll(), retainAll(), clear(), contains(), containsAll(), isEmpty(), size(), etc.

// ArrayList Class - Dynamic array which can grow and shrink in size
// LinkedList Class - Doubly linked list
// Stack Class - LIFO (Last In First Out) data structure
// Vector Class - Similar to ArrayList but it is synchronized (thread-safe) and slow

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ListInterface {
            
    // ArrayList Class
    static void arrayListClass() {
        ArrayList<Integer> l = new ArrayList<>();

        l.add(10);
        l.add(20);
        l.add(30);

        System.out.println(l); // [10, 20, 30]

        System.out.println(l.get(1)); // 20

        l.set(1, 40); // Replace 20 with 40
        System.out.println(l); // [10, 40, 30]

        l.remove(1); // Remove 40
        System.out.println(l); // [10, 30]

        System.out.println(l.contains(10)); // true

    }

    // LinkedList Class
    static void linkedListClass() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(10);
        ll.add(20);
        ll.add(30);

        System.out.println(ll); // [10, 20, 30]

        ll.addFirst(5);
        ll.addLast(35);

        System.out.println(ll); // [5, 10, 20, 30, 35]

        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll); // [10, 20, 30]

        System.out.println(ll.get(1)); // 20

        System.out.println(ll.contains(30)); // true
    }

    // Stack Class
    public static void stackClass() {
        Stack<String> s = new Stack<>();
        
        s.push("Deepak");
        s.push("Modi");

        System.out.println(s); // [Deepak, Modi]
        System.out.println(s.peek()); // Modi
        System.out.println(s.pop()); // Modi (will remove from stack)
        System.out.println(s.size()); // 1
        System.out.println(s.empty()); // false
    }

    // Vector Class
    public static void vectorClass() {
        Vector<Integer> v = new Vector<>();

        v.add(10);
        v.add(20);
        v.add(30);

        System.out.println(v); // [10, 20, 30]

        v.add(1, 15); // Add 15 at index 1
        System.out.println(v); // [10, 15, 20, 30]

        v.remove(1); // Remove 15
        System.out.println(v); // [10, 20, 30]

        System.out.println(v.contains(20)); // true

    }

    public static void main(String[] args) {
        System.out.println("ArrayList Class");
        arrayListClass();

        System.out.println("\nLinkedList Class");
        linkedListClass();

        System.out.println("\nStack Class");
        stackClass();

        System.out.println("\nVector Class");
        vectorClass();
    }
}

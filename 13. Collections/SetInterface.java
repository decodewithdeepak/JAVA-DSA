// Set Interface - Collection of unique objects (no duplicates)
// Implementation Classes - HashSet, LinkedHashSet, TreeSet
// Sub-Interfaces - SortedSet -> TreeSet

// Methods of Set Interface - add(), addAll(), remove(), removeAll(), retainAll(), clear(), contains(), containsAll(), isEmpty(), size(), etc.

// HashSet Class - Unordered collection of unique objects (uses hashing internally)
// LinkedHashSet Class - Insertion Ordered collection of unique objects (uses linked list and hash table)
// TreeSet Class - Sorted collection of unique objects (maintains ascending order by default or custom by using Comparator) (uses Red-Black tree - self-balancing binary search tree)

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterface {

    // HashSet Class
    static void hashSetClass() {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(10);
        hs.add(20);
        hs.add(30);

        System.out.println(hs); // [20, 10, 30] => Random order

        hs.add(20); // Duplicate element
        System.out.println(hs); // [20, 10, 30] => No duplicates

        hs.remove(20);
        System.out.println(hs.contains(20)); // false
        System.out.println(hs.isEmpty()); // false
 
    }

    // LinkedHashSet Class
    static void linkedHashSetClass() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        lhs.add(20);
        lhs.add(30);
        lhs.add(10);

        System.out.println(lhs); // [20, 30, 10] => Insertion order

        lhs.add(20); // Duplicate element
        System.out.println(lhs); // [20, 30, 10] => No duplicates

        lhs.remove(20);
        System.out.println(lhs.contains(20)); // false
        System.out.println(lhs.isEmpty()); // false
    }

    // TreeSet Class
    static void treeSetClass() {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(30);
        ts.add(10);
        ts.add(20);

        System.out.println(ts); // [10, 20, 30] => Ascending order

        ts.add(20); // Duplicate element
        System.out.println(ts); // [10, 20, 30] => No duplicates

        ts.remove(20);
        System.out.println(ts.contains(20)); // false
        System.out.println(ts.isEmpty()); // false
    }

    public static void main(String[] args) {
        System.out.println("\nHashSet Class");
        hashSetClass();

        System.out.println("\nLinkedHashSet Class");
        linkedHashSetClass();

        System.out.println("\nTreeSet Class");
        treeSetClass();
    }
}

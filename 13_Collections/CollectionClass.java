// Collections class in Java
// Methods of Collections class:
// 1. min() and max() - Returns the minimum and maximum element in the collection
// 2. frequency() - Returns the number of occurrences of a specific element in the collection
// 3. sort() - Sorts the collection in ascending order
// 4. reverse() - Reverses the order of elements in the collection
// 5. shuffle() - Randomly permutes the elements in the collection
// 6. copy() - Copies all elements from one collection to another
// 7. binarySearch() - Searches for an element in the collection using binary search
// 8. swap() - Swaps the elements at the specified positions in the collection
// 9. fill() - Replaces all elements in the collection with the specified element
// 10. addAll() - Adds all elements from an array to the collection
// 11. disjoint() - Returns true if two collections have no elements in common

// import java.util.Collections;
import java.util.*;

public class CollectionClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);

        // Display original list
        System.out.println("Original List: " + list); // [10, 20, 5, 15]

        // min() and max()
        System.out.println("Minimum: " + Collections.min(list)); // 5
        System.out.println("Maximum: " + Collections.max(list)); // 20

        // frequency() (count occurrences of a specific element)
        System.out.println("Frequency of 10: " + Collections.frequency(list, 10)); // 1

        // sort()
        Collections.sort(list);
        System.out.println("Sorted List: " + list); // [5, 10, 15, 20]

        // reverse()
        Collections.reverse(list);
        System.out.println("Reversed List: " + list); // [20, 15, 10, 5]

        // shuffle()
        // Collections.shuffle(list);
        // System.out.println("Shuffled List: " + list); // Random order

        // copy()
        List<Integer> copyList = new ArrayList<>(list);
        System.out.println("Copied List: " + copyList); // [20, 15, 10, 5]

        // binarySearch()
        Collections.sort(list); // Binary search needs the list to be sorted first => [5, 10, 15, 20]
        int index = Collections.binarySearch(list, 15);
        System.out.println("Index of 15: " + index); // 2 (0-based index)

        // swap()
        Collections.swap(list, 0, 1);
        System.out.println("List after swap: " + list); // [10, 5, 15, 20]

        // fill()
        Collections.fill(list, 50);
        System.out.println("List after fill: " + list); // [50, 50, 50, 50]

        // addAll()
        Collections.addAll(list, 5, 10, 15);
        System.out.println("List after addAll: " + list); // [50, 50, 50, 50, 5, 10, 15]

        // disjoint()
        List<Integer> list2 = Arrays.asList(100, 200, 300);
        System.out.println("Are the two lists disjoint? " + Collections.disjoint(list, list2));
    }
}

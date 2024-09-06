// Map Interface - Key-Value pair collection (No duplicate keys allowed, but values can be duplicate)
// Implementation Classes - HashMap, LinkedHashMap, TreeMap
// Sub-Interfaces - SortedMap -> TreeMap

// Methods of Map Interface - put(), putAll(), get(), remove(), clear(), containsKey(), containsValue(), keySet(), values(), entrySet(), isEmpty(), size(), etc.

// HashMap Class - Unordered collection of key-value pairs (uses hashing internally)
// LinkedHashMap Class - Insertion Ordered collection of key-value pairs (uses linked list and hash table)
// TreeMap Class - Sorted collection of key-value pairs based on keys (maintains ascending order by default or custom by using Comparator) (uses Red-Black tree - self-balancing binary search tree)

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapInterface {

    // HashMap Class - Unordered
    static void hashMapClass() {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "Deepak");
        mp.put(2, "Divya");
        mp.put(3, "Sapna");

        System.out.println(mp); // {1=Deepak, 2=Divya, 3=Sapna} => Random order
        
        System.out.println(mp.get(2)); // Divya

        System.out.println(mp.containsKey(4)); // false

        System.out.println(mp.containsValue("Sapna")); // true

        System.out.println(mp.size()); // 3

        mp.remove(3); // Removes key 3
        
        mp.put(1, "Ritvik"); // Overwrites value of key 1
        System.out.println(mp); // {1=Ritvik, 2=Divya}

        mp.putIfAbsent(2, "Sumit"); // To avoid overwriting
        System.out.println(mp); // {1=Ritvik, 2=Divya}

        System.out.println(mp.keySet()); // [1, 2]

        System.out.println(mp.values()); // [Ritvik, Divya]

        System.out.println(mp.entrySet()); // [1=Ritvik, 2=Divya]

        // Iterating over keys in map
        for (Integer key : mp.keySet()) {
            System.out.println(key);
        }
        // Iterating over values in map
        for (String value : mp.values()) {
            System.out.println(value);
        }
        // Iterating over key-value pairs in map
        for (Map.Entry<Integer, String> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }

        mp.clear(); // Removes all key-value pairs
        System.out.println(mp); // {}
    }

    // LinkedHashMap Class - Insertion Ordered
    static void linkedHashMapClass() {
        LinkedHashMap<Integer, String> lmp = new LinkedHashMap<>();
        lmp.put(1, "Deepak");
        lmp.put(2, "Divya");
        lmp.put(3, "Sapna");

        System.out.println(lmp); // {1=Deepak, 2=Divya, 3=Sapna} => Insertion order

        lmp.put(4, "Ritvik");
        lmp.put(5, "Sumit");

        System.out.println(lmp); // {1=Deepak, 2=Divya, 3=Sapna, 4=Ritvik, 5=Sumit}

        lmp.remove(3); // Removes key 3
        System.out.println(lmp); // {1=Deepak, 2=Divya, 4=Ritvik, 5=Sumit}
    }

    // TreeMap Class - Sorted by keys
    static void treeMapClass() {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "Deepak");
        tm.put(1, "Divya");
        tm.put(2, "Sapna");

        System.out.println(tm); // {1=Divya, 2=Sapna, 3=Deepak} => Sorted by keys
        
        tm.put(5, "Sumit");
        tm.put(4, "Ritvik");

        System.out.println(tm); // {1=Divya, 2=Sapna, 3=Deepak, 4=Ritvik, 5=Sumit}

        tm.remove(3); // Removes key 3
        System.out.println(tm); // {1=Divya, 2=Sapna, 4=Ritvik, 5=Sumit}
    }
    

    public static void main(String[] args) {

        System.out.println("HashMap Class");
        hashMapClass();

        System.out.println("\nLinkedHashMap Class");
        linkedHashMapClass();

        System.out.println("\nTreeMap Class");
        treeMapClass();
        
    }
}

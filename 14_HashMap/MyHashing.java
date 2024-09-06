// Internal Working of HashMap - Hashing

// Hashing is a technique to convert a range of key values into a range of indexes of an array where the values are to be stored.

// Key --> Hash Function --> Hash Code --> Index --> Bucket --> Key-Value Pair --> Hash Table

// Hashing - Converting a key into a hash code using a hash function.
// Hash Function - A function that converts a key into a hash code.
// Hash Code - A unique integer value assigned to a key by the hash function.
// Index - The position in the array where the key-value pair is stored.
// Bucket - A collection of key-value pairs stored at the same index in the hash table.
// Hash Table - An array of linked-list nodes where each node contains a key-value pair.

// Load Factor - The ratio of the number of keys to the size of the hash table.
// Rehashing - The process of increasing the size of the hash table and reinserting all the key-value pairs.
// Threshold - The maximum load factor allowed before rehashing is performed.

// Generally used hash functions:
// 1. Division Method - h(k) = k % M (M is the size of the hash table)
// 2. Mid-Square Method - h(k) = (k^2) % 1000 
// 3. Digit Folding Method - h(k) = (k1 + k2 + k3 + k4) % M
// 4. Multiplication Method - h(k) = [M * (kA mod 1)] (A is a constant, 0 < A < 1)

// Perfect Hash Function - A hash function that assigns a unique hash code to each key.
// Non-Perfect Hash Function - A hash function that assigns the same hash code to multiple keys.
// Collision - When two keys have the same hash code, in case of a non-perfect hash function.

// Collision Resolution - The process of handling collisions that occur when two keys have the same hash code.
// Collision Resolution Techniques -> 1. Open Hashing (Separate Chaining) | 2. Closed Hashing (Open Addressing)
// 1. Open Hashing (Separate Chaining) - If a collision occurs, the key-value pair is stored in a linked list at the same index in the hash table.

// 2. Closed Hashing (Open Addressing) - If a collision occurs, the key-value pair is stored in the next available empty slot in the hash table.
// Techniques of Closed Hashing -> a. Linear Probing | b. Quadratic Probing | c. Double Hashing

// a. Linear Probing - If a collision occurs, the key-value pair is stored in the next available empty slot in the hash table.
// b. Quadratic Probing - If a collision occurs, the key-value pair is stored in the next available slot by using a quadratic function.
// c. Double Hashing - If a collision occurs, the key-value pair is stored in the next available slot by using a second hash function.

// hashCode() - A method in Java that returns the hash code of an object.

// Custom Hash Map Implementation with put, get, size, remove methods.
// Both key and value can be of any type.
import java.util.LinkedList;

public class MyHashing {

    // Custom HashMap class
    static class MyHashMap<K, V> {
        private LinkedList<Entry<K, V>>[] buckets;
        private int capacity;
        private int size;

        // Entry class to store key-value pairs
        static class Entry<K, V> {
            K key;
            V value;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // Constructor to initialize the HashMap
        @SuppressWarnings("unchecked")
        public MyHashMap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.buckets = new LinkedList[capacity];
        }

        // Helper method to get the bucket index for a key
        private int getBucketIndex(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % capacity;
        }

        // Helper method to find an entry in a bucket
        private Entry<K, V> findEntry(LinkedList<Entry<K, V>> bucket, K key) {
            if (bucket == null)
                return null;
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key))
                    return entry;
            }
            return null;
        }

        // size() -> Return the number of entries (key-value pairs) in the hash map
        public int size() {
            return size;
        }

        // put(key, value) -> Insert a key-value pair into the hash map and return void
        //                 -> If the key already exists, update the value and return void
        public void put(K key, V value) {
            int index = getBucketIndex(key);
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            LinkedList<Entry<K, V>> bucket = buckets[index];
            Entry<K, V> entry = findEntry(bucket, key);
            if (entry != null) {
                entry.value = value; // Update existing value
            } else {
                bucket.add(new Entry<>(key, value)); // Add new entry
                size++;
            }
        }

        // get(key) -> Return the value associated with the key
        //          -> If the key does not exist, return null
        public V get(K key) {
            int index = getBucketIndex(key);
            LinkedList<Entry<K, V>> bucket = buckets[index];
            Entry<K, V> entry = findEntry(bucket, key);
            return entry != null ? entry.value : null;
        }

        // remove(key) -> Remove the key-value pair from the hash map and return the value
        //             -> If the key does not exist, return null
        public V remove(K key) {
            int index = getBucketIndex(key);
            LinkedList<Entry<K, V>> bucket = buckets[index];
            if (bucket != null) {
                Entry<K, V> entryToRemove = findEntry(bucket, key);
                if (entryToRemove != null) {
                    bucket.remove(entryToRemove);
                    size--;
                    return entryToRemove.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        MyHashMap<String, Integer> hm = new MyHashMap<>(10);
        hm.put("Apple", 10); // Insert new key-value pair
        hm.put("Banana", 20);
        hm.put("Orange", 30);

        hm.put("Banana", 25); // Update existing value
        
        // Get the value associated with the key
        System.out.println(hm.get("Banana")); // 25
        System.out.println(hm.get("Mango")); // null

        // Remove the key-value pair
        System.out.println(hm.remove("Orange")); // 30
        System.out.println(hm.remove("Grapes")); // null

        // Get the number of entries in the hash map
        System.out.println(hm.size()); // 2
    }
}

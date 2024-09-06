// Notes : https://drive.google.com/file/d/130FJlYVEuYcz2Sgm1h19J4G6PIaJ21Sj/view

// Set Interface -> HashSet | LinkedHashSet | TreeSet

// HashSet is a unorderd collection of unique elements.
// It does not allow duplicate elements.
// It internally uses a HashMap (Hashing) to store elements.
// It allows only one null element.

// Methods of HashSet : add(), addAll(), remove(), removeAll(), contains(), containsAll(), clear(), size(), isEmpty(), etc.

// Time Complexity: O(1) for insertion, deletion, contains , size, etc.

import java.util.*;

public class BasicsOfHashSet {

    // HashSet Methods
    static void hashSetMethod() {

        // Declare a HashSet
        HashSet<Integer> hs = new HashSet<>();

        // Add elements to the HashSet -> add(element)
        hs.add(10);
        hs.add(20);
        hs.add(30);

        // Print the HashSet
        System.out.println(hs); // [20, 10, 30] => Random order

        // Traverse the HashSet
        for (int i : hs) {
            System.out.print(i + " "); // 20 10 30 => Random order
        }

        System.out.println();

        // Add a duplicate element
        hs.add(20); // Duplicate element
        System.out.println(hs); // [20, 10, 30] => No duplicates

        // Get the size of the HashSet -> size()
        System.out.println(hs.size()); // 3

        // Check if an element exists -> contains(element)
        System.out.println(hs.contains(20)); // true

        // Remove an element -> remove(element)
        hs.remove(20);
        System.out.println(hs.contains(20)); // false

        // Check if the HashSet is empty -> isEmpty()
        System.out.println(hs.isEmpty()); // false

        // Clear the HashSet -> clear()
        hs.clear();
        

    }

    // Q. Longest Consecutive Sequence - LeetCode 128 (https://leetcode.com/problems/longest-consecutive-sequence/)
    public static int longestConsecutive(int[] nums) {

        // Bruteforce Approach : Sort the array and find the longest consecutive sequence
        // Time Complexity : O(nlogn) + O(n) = O(nlogn)

        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak ++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
        
        // Optimized Approach : Using HashSet
        // Time Complexity : O(n) + O(n) = O(n)

        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);

        int longestStreak = 0;

        for (int num : nums) {
            if (!hs.contains(num - 1)) { // num is starting point of a sequence
                int currentNum = num;
                int currentStreak = 1; // length of current consecutive sequence

                while (hs.contains(currentNum + 1)) { // check for next consecutive elements
                    currentStreak ++;
                    currentNum ++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }


    // Q. Andryusha and Socks - Codeforces 780A (https://codeforces.com/problemset/problem/780/A)

    public static void main(String[] args) {

        // HashSet Method
        // hashSetMethod();

        // Longest Consecutive Sequence - LeetCode 128
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums)); // 4 => 1, 2, 3, 4
        
    }
}

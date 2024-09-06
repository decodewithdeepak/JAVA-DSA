// 1. Group Anagrams (LeetCode 49) - [https://leetcode.com/problems/group-anagrams/]
// 2. Sort Characters By Frequency (LeetCode 451) - [https://leetcode.com/problems/sort-characters-by-frequency/]
// 3. Maximum Nesting Depth of the Parentheses (LeetCode 1614) - [https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/]
// 4. Roman to Integer (LeetCode 13) - [https://leetcode.com/problems/roman-to-integer/]
// 5. Integer to Roman (LeetCode 12) - [https://leetcode.com/problems/integer-to-roman/]
// 6. String to Integer (atoi) (LeetCode 8) - [https://leetcode.com/problems/string-to-integer-atoi/]
// 7. Count number of substrings (GFG) - [https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1]
// 8. Longest Palindromic Substring (LeetCode 5) - [https://leetcode.com/problems/longest-palindromic-substring/]
// 9. Sum of Beauty of All Substrings (LeetCode 1781) - [https://leetcode.com/problems/sum-of-beauty-of-all-substrings/]


import java.util.*;

public class e_MediumStringProblems {

    // 1. Group Anagrams (LeetCode 49)
    public List<List<String>> groupAnagrams(String[] strs) {
        // Approach Using HashMap - TC: O(n*m*logm) | SC: O(n*m) - n is the number of strings and m is the length of the longest string
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr); // sort the characters of the string
            String key = new String(arr); // create a key from the sorted characters 
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 2. Sort Characters By Frequency (LeetCode 451)


    // 3. Maximum Nesting Depth of the Parentheses (LeetCode 1614)
    public int maxDepth(String s) {
        // Approach Using Stack - TC: O(n) | SC: O(n)
        int maxDepth = 0;
        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                maxDepth = Math.max(maxDepth, open);
            } else if (ch == ')') {
                open--;
            }
        }
        return maxDepth;
    }

    // 4. Roman to Integer (LeetCode 13)
    public int romanToInt(String s) {
        // TC: O(n) | SC: O(1)
        int n = s.length();
        int sum = 0;
    
        for (int i = 0; i < n; i++) {
            int currVal = getValue(s.charAt(i));
            // next value is greater
            if (i + 1 < n && currVal < getValue(s.charAt(i + 1))) {
                sum -= currVal;
            }
            // next value is smaller or equal
            else {
                sum += currVal;
            }
        }
    
        return sum;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000; // case 'M'
        }
    }

    // 5. Integer to Roman (LeetCode 12)
    public String intToRoman(int num) {
        // TC: O(1) | SC: O(1)
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
    
        return sb.toString();
    }

    // 6. String to Integer (atoi) (LeetCode 8)

    // 7. Count number of substrings (GFG)
    
    // 8. Longest Palindromic Substring (LeetCode 5)

    // 9. Sum of Beauty of All Substrings (LeetCode 1781)

    

    
}

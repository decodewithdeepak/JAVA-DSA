// 1. Reverse String (LeetCode 344) - [https://leetcode.com/problems/reverse-string/]
// 2. Reverse Words in a String (LeetCode 151) - [https://leetcode.com/problems/reverse-words-in-a-string/]
// 3. Remove Outermost Parentheses (LeetCode 1021) - [https://leetcode.com/problems/remove-outermost-parentheses/]
// 4. Largest Odd Number in String (LeetCode 1903) - [https://leetcode.com/problems/largest-odd-number-in-string/]
// 5. Longest Common Prefix (LeetCode 14) - [https://leetcode.com/problems/longest-common-prefix/]
// 6. Isomorphic Strings (LeetCode 205) - [https://leetcode.com/problems/isomorphic-strings/]
// 7. Rotate String (LeetCode 796) - [https://leetcode.com/problems/rotate-string/]
// 8. Valid Anagram (LeetCode 242) - [https://leetcode.com/problems/valid-anagram/]
// 9. Valid Palindrome (LeetCode 125) - [https://leetcode.com/problems/valid-palindrome/]
// 10. Length of Last Word (LeetCode 58) - [https://leetcode.com/problems/length-of-last-word/]

// 11. Find the Index of the First Occurrence in a String (LeetCode 28) - [https://leetcode.com/problems/implement-strstr/]
// 12. Excel Sheet Column Number (LeetCode 171) - [https://leetcode.com/problems/excel-sheet-column-number/]
// 13. Excel Sheet Column Title (LeetCode 168) - [https://leetcode.com/problems/excel-sheet-column-title/]
// 14. Fizz Buzz (LeetCode 412) - [https://leetcode.com/problems/fizz-buzz/]
// 15. Count the Number of Consistent Strings (LeetCode 1684) - [https://leetcode.com/problems/count-the-number-of-consistent-strings/]

import java.util.*;

public class d_BasicStringProblems {

    // 1. Reverse String (LeetCode 344)
    public void reverseString(char[] s) {
        // Two Pointer Approach - TC: O(n) | SC: O(1)
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    // 2. Reverse Words in a String (LeetCode 151)
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        // trim() removes leading and trailing whitespaces
        // split("\\s+") splits the string by one or more whitespaces
        // "\\s+" is a regex pattern that matches one or more whitespaces (spaces, tab, line break)
        // "\\s" is a regex pattern that matches a single whitespace character

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" "); // add space between words except for the last word
        }

        return reversed.toString();
    }

    // 3. Remove Outermost Parentheses (LeetCode 1021)
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0; // count of open parentheses
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0)
                    ans.append(c);
                count++;
            } else {
                count--;
                if (count > 0)
                    ans.append(c);
            }
        }
        return ans.toString();
    }


    // 4. Largest Odd Number in String (LeetCode 1903)
    public String largestOddNumber(String num) {
        // traverse from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            int dig = num.charAt(i) - '0'; // convert char to int
            if (dig % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    // 5. Longest Common Prefix (LeetCode 14)
    public String longestCommonPrefix(String[] strs) {
        // // Sorting-Based Approach - TC: O(n*m*logn) | SC: O(1) - n is the number of strings and m is the length of the longest string
        // Arrays.sort(strs); // sort the array of strings
        // String first = strs[0];
        // String last = strs[strs.length - 1];
        // int i = 0;

        // // find the common prefix between the first and last string
        // while (i < first.length() && i < last.length()) {
        //     if (first.charAt(i) == last.charAt(i)) {
        //         i++;
        //     } else {
        //         break;
        //     }
        // }

        // return i == 0 ? "" : first.substring(0, i);

        // Horizontal Scanning Approach - TC: O(n*m) | SC: O(1)
        if (strs.length == 0) return "";
        String prefix = strs[0]; // take the first string as prefix
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // reduce the prefix
                if (prefix.isEmpty()) return ""; // early exit
            }
        }
        return prefix;
    }

    // 6. Isomorphic Strings (LeetCode 205)
    public boolean isIsomorphic(String s, String t) {
        // Approach Using HashMap - TC: O(n) | SC: O(n) - n is the length of the strings
        HashMap<Character, Character> map = new HashMap<>(); 
        // Key: character from s, Value: character from t
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (map.containsKey(sCh)) { // check if sCh is already mapped
                if (map.get(sCh) != tCh) return false;
            } else if (map.containsValue(tCh)) { // check if tCh is already mapped
                return false;
            } else {
                map.put(sCh, tCh); // add mapping of sCh and tCh
            }
        }
        return true;

        // Optimal Approach Using Two Arrays - TC: O(n) | SC: O(1)
        // if (s.length() != t.length()) return false;
        // int[] sMap = new int[256]; // mapping of characters from s
        // int[] tMap = new int[256]; // mapping of characters from t

        // for (int i = 0; i < s.length(); i++) {
        //     char sCh = s.charAt(i);
        //     char tCh = t.charAt(i);
        //     if (sMap[sCh] != tMap[tCh]) return false;
        //     sMap[sCh] = i + 1; // store the index of the character
        //     tMap[tCh] = i + 1; // store the index of the character
        // }
        // return true;

    }

    // 7. Rotate String (LeetCode 796)
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
        // Worst Case TC: O(n^2) | SC: O(n) - n is the length of the string
    }

    // 8. Valid Anagram (LeetCode 242)
    public boolean isAnagram(String s, String t) {

        // Naive Approach Using Sorting - TC: O(nlogn) | SC: O(n)
        // if (s.length() != t.length()) return false;
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // return Arrays.equals(sArr, tArr);

        // Optimal Approach Using Frequency Array - TC: O(n) | SC: O(1)
        if (s.length() != t.length()) return false;
        int[] freq = new int[26]; // frequency array

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; // a => 97...z => 122
        }
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    // 9. Valid Palindrome (LeetCode 125)
    public boolean isPalindrome(String s) {
        // Two Pointer Approach - TC: O(n) | SC: O(1)
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lCh = s.charAt(left);
            char rCh = s.charAt(right);
            // if lCh is not a letter or digit, move left pointer to the right
            if (!Character.isLetterOrDigit(lCh)) {
                left++;
            } 
            // if rCh is not a letter or digit, move right pointer to the left
            else if (!Character.isLetterOrDigit(rCh)) {
                right--;
            }
            // if both lCh and rCh are letters or digits
            else {
                // if lCh and rCh are not equal, return false
                if (Character.toLowerCase(lCh) != Character.toLowerCase(rCh)) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    // 10. Length of Last Word (LeetCode 58)
    public int lengthOfLastWord(String s) {
        // TC: O(n) | SC: O(1)
        String str = s.trim(); // remove leading and trailing whitespaces
        int len = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') break; // break if space is found
            len++;
        }
        return len;
    }

    // 11. Find the Index of the First Occurrence in a String (LeetCode 28)
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // TC: O(n*m) | SC: O(1)
    }

    // 12. Excel Sheet Column Number (LeetCode 171)
    public int titleToNumber(String columnTitle) {
        // TC: O(n) | SC: O(1) - n is the length of the string
        int sum = 0, pos = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 64; // A=>65
            sum = sum + (int) Math.pow(26, pos) * num;
            pos++;
        }
        return sum;
    }

    // 13. Excel Sheet Column Title (LeetCode 168)
    public String convertToTitle(int columnNumber) {
        // TC: O(logn) | SC: O(1) - n is the column number
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int rem = (columnNumber - 1) % 26; // get the remainder
            sb.append((char) (rem + 'A')); // convert remainder to character
            columnNumber = (columnNumber - 1) / 26; // update column number
        }
        return sb.reverse().toString();
    }

    // 14. Fizz Buzz (LeetCode 412)
    public List<String> fizzBuzz(int n) {
        // TC: O(n) | SC: O(1)
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i)); // or res.add(Integer.toString(i));
        }
        return res;
    }

    // 15. Count the Number of Consistent Strings (LeetCode 1684)
    public int countConsistentStrings(String allowed, String[] words) {
        // TC: O(n*m)
        int count = 0;
        for (String word : words) {
            boolean consistent = true;
            for (char ch : word.toCharArray()) {
                if (!allowed.contains(String.valueOf(ch))) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) count++;
        }
        return count;
    }

}

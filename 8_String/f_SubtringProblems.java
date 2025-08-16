// Substring Problems
// 1. Repeated Substring Pattern (LC: 459) - https://leetcode.com/problems/repeated-substring-pattern/
// 2. Substring Matching Pattern (LC: 3407) - https://leetcode.com/problems/substring-matching-pattern/
// 3. Longest Substring Without Repeating Characters (LC: 3) - https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 4. Number of Substrings Containing All Three Characters (LC: 1358) - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// 5. Count of Substrings Containing Every Vowel and K Consonants I (LC: 3305) - https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/
// 6. Count of Substrings Containing Every Vowel and K Consonants II (LC: 3306) - https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/
// 7. Vowels of All Substrings (LC: 2063) - https://leetcode.com/problems/vowels-of-all-substrings/

import java.util.*;

public class f_SubtringProblems {
    
    // 1. Repeated Substring Pattern (LC: 459) 

    // 2. Substring Matching Pattern (LC: 3407)

    // 3. Longest Substring Without Repeating Characters (LC: 3)

    // 4. Number of Substrings Containing All Three Characters (LC: 1358)
    public int numberOfSubstrings(String s) {
        // // naive solution - check all substrings - O(n^2)
        // int n = s.length();
        // int count = 0;
        // for(int i=0; i<n; i++){
        //     int[] freq = new int [3]; // a b c
        //     for(int j=i; j<n; j++){
        //         char c = s.charAt(j);
        //         freq[c - 'a']++;
        //         if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) count++;
        //     }
        // }
        // return count;

        // optimized solution - two pointers and sliding window - O(n)
        int n = s.length();
        int count = 0;
        int[] freq = new int[3]; // a b c
        int i = 0, j = 0;

        while(j < n){
            freq[s.charAt(j) - 'a']++;  // expand window
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){ // valid substring
                count += n - j; // add all substrings from j to n
                freq[s.charAt(i) - 'a']--; // shrink window
                i++;
            }
            j++;
        }
        return count;
    }

    // 5. Count of Substrings Containing Every Vowel and K Consonants I (LC: 3305)
    public int countOfSubstrings(String word, int k) {
        // brute-foce => checking all substrings and then checking if it contains all vowels and k consonants
        // TC: O(n^2) | SC: O(1)
        int n = word.length();
        int count = 0;
        for(int i=0; i<n; i++){
            HashSet<Character> vowel = new HashSet<>();
            int consonants = 0;
            for(int j=i; j<n; j++){
                char c = word.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowel.add(c);
                else consonants++;
                if(vowel.size() == 5 && consonants == k) count++;
            }
        }
        return count;
    }

    // 6. Count of Substrings Containing Every Vowel and K Consonants II (LC: 3306)
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        long count = 0;
        int left = 0, right = 0;
        int consonants = 0;
        HashMap<Character, Integer> vowelFreq = new HashMap<>();

        // Precompute next consonant positions
        int[] nextConsonant = new int[n];
        int nextConsonantIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        while (right < n) {
            char rightChar = word.charAt(right);

            // Track vowels in the frequency map
            if (isVowel(rightChar)) {
                vowelFreq.put(rightChar, vowelFreq.getOrDefault(rightChar, 0) + 1);
            } else {
                consonants++;
            }

            // Shrink window if consonants exceed k
            while (consonants > k) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelFreq.put(leftChar, vowelFreq.get(leftChar) - 1);
                    if (vowelFreq.get(leftChar) == 0) vowelFreq.remove(leftChar);
                } else {
                    consonants--;
                }
                left++;
            }

            // Count valid substrings when all vowels are present at least once and exactly k consonants
            if (vowelFreq.size() == 5 && consonants == k) {
                count += nextConsonant[right] - right; // Correct counting logic
            }

            right++;
        }

        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // 7. Vowels of All Substrings (LC: 2063)
    public long countVowels(String word) {
        // brute-force => O(n^2) solution
        int n = word.length();
        long count = 0;
        for(int i=0; i<n; i++){
            int vowCount = 0;
            for(int j=i; j<n; j++){
                if(isVowel(word.charAt(j))) vowCount++;
                count += vowCount;
            }
        }
        return count;
    }

    // optimized solution
    public long countVowels(String word) {
        // optimized O(n) solution - combinatorics
        int n = word.length();
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                // no of choices = i+1 for starting index and n-i for ending index
                count += (long) (i + 1) * (n - i);
            }
        }
        return count;
    }

    public int maximumCandies(int[] candies, long k) {
        int largest = 0;
        for (int c : candies) {
            largest = Math.max(largest, c);
        }

        int left = 1, right = largest, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalChild = 0;

            for (int c : candies) {
                totalChild += c / mid;
            }

            if (totalChild >= k) {
                ans = mid;
                left = mid + 1; // search for larger value in right
            } else {
                right = mid - 1; // search for smaller value in left
            }
        }
        
        return ans;
    }

}

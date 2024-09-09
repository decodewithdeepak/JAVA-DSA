// 1. Sqaure root of a given number - Leetcode 69 (https://leetcode.com/problems/sqrtx/)
// 2. Nth root of a number M - GFG (https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1)
// 3. Koko Eating Bananas - Leetcode 875 (https://leetcode.com/problems/koko-eating-bananas/)
// 4. Minimum Days to Make M Bouquets - Leetcode 1482 (https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)
// 5. Find the Smallest Divisor Given a Threshold - Leetcode 1283 (https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)
// 6. Capacity To Ship Packages Within D Days - Leetcode 1011 (https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
// 7. Kth Missing Positive Number - Leetcode 1539 (https://leetcode.com/problems/kth-missing-positive-number/)

public class e_BinarySearchOnAnswers {
    // 1. Sqaure root of a given number - Leetcode 69
    public int mySqrt(int x) {
        // // Linear Search - O(sqrt(x))
        // int ans = 0;
        // for (int i = 1; i <= x/i; i++) {
        //     ans = i;
        // }
        // return ans;

        // Binary Search - O(log x)
        int start = 1, end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid; // To avoid integer overflow

            if (square == x) {
                return mid;
            } else if (square < x) {
                start = mid + 1;
            } else { // square > x
                end = mid - 1;
            }
        }
        return end; // If no integer square root is found, return the floor value
    }

    // 2. Nth root of a number M - GFG
    public int NthRoot(int n, int m) {
        // Linear Search - O(m)
        // int ans = -1;
        // for (int i = 1; i <= m; i++) {
        //     if (Math.pow(i, n) == m) {
        //         ans = i;
        //         break;
        //     }
        //     else if (Math.pow(i, n) > m) break; // To optimize and prevent TLE
        // }
        // return ans;

        // Binary Search - O(log m)
        int start = 1, end = m;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long power = (long) Math.pow(mid, n); // To avoid integer overflow

            if (power == m) {
                return mid;
            } else if (power < m) {
                start = mid + 1;
            } else { // power > m
                end = mid - 1;
            }
        }
        return -1; // If no integer nth root is found
    }

    // 3. Koko Eating Bananas - Leetcode 875
    public int minEatingSpeedBrute(int[] piles, int h) {
        // Brute Force - O(n * m), where n = number of piles, m = max bananas in a pile
        int maxPile = 0; // max bananas in a pile
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        // range of eating speeds = 1 to maxPile
    
        for (int k = 1; k <= maxPile; k++) {
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / k);
            }
            if (hours <= h) {
                return k;
            }
        }
        return maxPile; // max eating speed
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Binary Search - O(n * log m), where n = number of piles, m = max bananas in a pile
        // We will apply binary search on range of eating speeds: 
        // 1 2 3 4 5 6 7 8 9 10 11 ... maxPile
        
        int maxPile = 0; // max bananas in a pile
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1, high = maxPile;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int hours = 0;
            
            for (int pile : piles) {
                // hours += Math.ceil((double) pile / mid); // slower
                hours += (pile + mid - 1) / mid; // faster
                if (hours > h) break; // early exit if hours exceed h to optimize
            }

            if (hours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 4. Minimum Days to Make M Bouquets - Leetcode 1482

    // 5. Find the Smallest Divisor Given a Threshold - Leetcode 1283

    // 6. Capacity To Ship Packages Within D Days - Leetcode 1011

    // 7. Kth Missing Positive Number - Leetcode 1539

    public int findKthPositive(int[] arr, int k) {
        // Binary Search - O(log n)
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + k;
    }

}

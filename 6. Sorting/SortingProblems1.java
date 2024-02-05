// Notes: https://drive.google.com/file/d/1om5pKYS081mJv3HvEW2WAI50-ZzIyZNp/view

// Problems on Sorting
// 1. Given an array where all its elements are sorted in increasing order except two swapped elements, sort the array in linear time.
// Example: Input: 3 8 6 7 5 9 10  -> Output: 3 5 6 7 8 9 10

// 2. Print all negative numbers followed by all positive Numbers.
// Example: Input: -13 20 7 0 -4 -13 11 -5 -13 -> Output: -13 -4 -13 -13 20 7 0 11

// 3. Sort an array of 0s, 1s, and 2s in ascending order.
// Example: Input: 0 2 1 2 0 0 -> Output: 0 0 0 1 2 2

public class SortingProblems1 {

    // 1. Sort in linear time.
    static void sortArr(int[] num){
        int n = num.length;
        int x = -1, y = -1;
        if(n <= 1){ // corner case, edge case
            return;
        }
        // process all adjacent elements
        for(int i = 1; i < n; i++){ // TC = O(n)
            if(num[i-1] > num[i]){
                if(x == -1){ // first conflict
                    x = i-1;
                    y = i;
                } else { // 2nd conflict
                    y = i;
                }
            }
        }
        // swap x, y in num
        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }

    // 2. Print all negative numbers followed by all positive Numbers.
    static void SortPosNeg(int[] num){ // Partitioning as in QuickSort
        int l = 0, r = num.length-1;
        while(l < r){
            while(num[l] < 0) l++;
            while (num[r] >= 0) r--;
            if(l < r){
                int temp = num[l];
                num[l] = num[r];
                num[r] = temp;
                l++;
                r--;
            }
        }
    }

    // 3. Sort an array of 0s, 1s, and 2s in ascending order.
    static void sort012(int[] a){
        int lo = 0, mid = 0, hi = a.length-1;
        //explore the unknown region
        while(mid <= hi){
            if(a[mid] == 0){
                swap(a, mid, lo);
                mid++;
                lo++;
            } else if(a[mid] == 1){
                mid++;
            } else {
                swap(a, mid, hi);
                hi--;
            }
        }
    }

    static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    public static void main(String[] args) {
        // int[] num = {3, 8, 6, 7, 5, 9, 10};
        // sortArr(num);

        // int[] num = {-13, 20, 7, 0, -4, -13, 11, -5, -13};
        // SortPosNeg(num);

        int[] num = {2, 2, 0, 0, 1, 1, 2, 0, 1, 0};
        sort012(num);

        for(int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
    }

}

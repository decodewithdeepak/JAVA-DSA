// Notes: https://drive.google.com/file/d/1IRcxFd_toV2HBs0s5eT6lR8P4MAjdgAA/view

// Search in Rotated Sorted Array -

// 1. Find the index of minimum element in array.
// Example: Input: [3, 4, 5, 1, 2] -> Output: 3

// 2. Return the index of the target integer.
// Example: Input: [3, 4, 5, 1, 2], target = 4 -> Output: 1

// 3. Check for an element in a rotated sorted array.
// Example: Input: [4, 5, 6, 7, 0, 1, 2], target = 0 -> Output: true

public class BinSearchRotArray {

    // 1. Find the index of minimum element in array.
    static int findMin(int[] arr) { // O(log n)
        int n = arr.length;
        int start = 0, end = n - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= arr[n - 1]) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // 2. Return the index of the target integer.
    static int search(int[] a, int target){
        int st = 0, end = a.length-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(a[mid] == target){
                return mid;
            }
            else if (a[mid] < a[end]){ // mid to end is sorted
                if(target > a[mid] && target <= a[end]){
                    st = mid+1;
                } else {
                    end = mid-1;
                }
            } else { // st to mid is sorted
                if(target >= a[st] && target < a[mid]){
                    end = mid-1;
                } else {
                    st = mid+1;
                }
            }
        }
        return -1;
    }

    // 3. Check for an element in a rotated sorted array.
    // duplicate elements
    static int search_(int[] a, int target){
        int st = 0, end = a.length-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(a[mid] == target){
                return mid;
            }
            else if(a[st] == a[mid] && a[end] == mid){
                st++;
                end--;
            }
            else if (a[mid] <= a[end]){ // mid to end is sorted
                if(target > a[mid] && target <= a[end]){
                    st = mid+1;
                } else {
                    end = mid-1;
                }
            } else { // st to mid is sorted
                if(target >= a[st] && target < a[mid]){
                    end = mid-1;
                } else {
                    st = mid+1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(arr)); // Output: 3

        int target = 4;
        System.out.println(search(arr, target)); // Output: 1
        
        int[] arr_ = {4, 5, 6, 7, 0, 1, 2};
        target = 0;
        System.out.println(search_(arr_, target)); // Output: 4

    }
}

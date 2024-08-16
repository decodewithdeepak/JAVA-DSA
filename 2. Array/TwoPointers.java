// Notes 16 : https://drive.google.com/file/d/1vR6tOK8h0EZhPCr7maqYA3GmbBusihDQ/view

// Problems based on two-pointer approach
// 1. Sort an array consisting of only 0s and 1s
// 2. Move all the integers at the beginning of the array followed by all the odd integers
// 3. Squares of a Sorted Array (leetcode 977)
// 4. Move Zeroes (leetcode 283)
// 5. Remove Duplicates from Sorted Array (leetcode 26)
// 6. Remove Element (leetcode 27)
// 7. Merge Sorted Array (leetcode 88)
// 8. Remove Duplicates from Sorted Array II (leetcode 80)

public class TwoPointers {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 1. Sort an array consisting of only 0s and 1s
    static void sortZeroesAndOnes(int[] arr) {
        // int n = arr.length;
        // int zeroes = 0;
        // // Count the number of zeroes
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 0) {
        //         zeroes++;
        //     }
        // }

        // // 0 to zeroes-1 : 0s, zeroes to n-1 : 1s
        // for (int i = 0; i < n; i++) {
        //     if (i < zeroes) {
        //         arr[i] = 0;
        //     } 
        //     else {
        //         arr[i] = 1;
        //     }

        // }

        // Two-pointer approach
        int i = 0; // left pointer
        int j = arr.length - 1; // right pointer

        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            } 
            else if (arr[i] == 0) {
                i++;
            } 
            else if (arr[j] == 1) {
                j--;
            }
        }

    }

    // 2. Move all the integers at the beginning of the array followed by all the odd integers
    static void sortArrayByParity(int[] arr) {
        int i = 0; // left pointer
        int j = arr.length - 1; // right pointer

        while (i < j) {
            if (arr[i] % 2 == 1 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            } 
            else if (arr[i] % 2 == 0) {
                i++;
            } 
            else if (arr[j] % 2 == 1) {
                j--;
            }
        }
    }

    // 3. Squares of a Sorted Array (leetcode 977)
    static int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int i = 0; // left pointer
        int j = n - 1; // right pointer
        int k = n - 1; // squares array pointer

        while (i <= j) {
            if (arr[i] * arr[i] > arr[j] * arr[j]) {
                squares[k] = arr[i] * arr[i];
                i++;
            } 
            else {
                squares[k] = arr[j] * arr[j];
                j--;
            }
            k--;
        }

        return squares;
    }

    // 4. Move Zeroes (leetcode 283)
    static void moveZeroes(int[] arr) {
        int n = arr.length;
        int i = 0; // left pointer
        int j = 0; // right pointer

        while (j < n) {
            if (arr[j] != 0) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
            j++;
        }    
    }

    // 5. Remove Duplicates from Sorted Array (leetcode 26)
    static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0; // left pointer
        int j = 1; // right pointer

        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }

    // 6. Remove Element (leetcode 27)
    static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0; // left pointer
        int j = 0; // right pointer

        while (j < n) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }

    // 7. Merge Sorted Array (leetcode 88)
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // left pointer
        int j = n - 1; // right pointer
        int k = m + n - 1; // merged array pointer

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } 
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // 8. Remove Duplicates from Sorted Array II (leetcode 80)
    static int removeDuplicatesII(int[] nums) {
        int n = nums.length;
        int i = 0; // left pointer
        int j = 1; // right pointer
        int count = 1; // count of the current element

        while (j < n) {
            if (nums[i] == nums[j]) {
                count++;
            } 
            else {
                count = 1;
            }

            if (count <= 2) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }


    public static void main(String[] args) {

        // Sort an array consisting of only 0s and 1s
        int[] arr = { 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 };
        sortZeroesAndOnes(arr);
        printArray(arr);


        // Given an array of integers, move all the integers at the beginning of the array followed by all the odd integers. The relative order of odd or even integers doesn't matter. Return an array that satisfies this condition.
        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        sortArrayByParity(arr);
        printArray(arr);


        // Given an array sorted in non-decreasing order, return an array of squares of each number sorted in non-decreasing order.
        arr = new int[] { -4, -2, -1, 0, 3, 5 };
        int[] squares = sortedSquares(arr);
        printArray(squares);

        // Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. (leetcode 283)
        arr = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(arr);
        printArray(arr);

        //Remove Duplicates from Sorted Array (leetcode 26)
        //Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
        int nums [] = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len); // 5

        // 27. Remove Element (leetcode)
        // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
        nums = new int[] {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val)); // 5

        // 88. Merge Sorted Array (leetcode)
        // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        printArray(nums1);


        // 80. Remove Duplicates from Sorted Array II (leetcode)
        // Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
        nums = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicatesII(nums)); // 7


    }
}

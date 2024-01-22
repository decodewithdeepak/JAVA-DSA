// Notes : https://drive.google.com/file/d/1VstKUuzM2FWFrtoimkY3fc9eNsB-QmIw/view

// Program to find sum of digits of a number using recursion
// Program to find count of digits of a number using recursion

import java.util.Scanner;

public class CountAndSumOfDigits {

    static int sumOfDigits(int n) {
        // base case - halting condition
        if (n >= 0 && n <= 9) return n;

        // // smaller subproblem - recursive call
        // // recursion relation -> sumOfDigits(n) = sumOfDigits(n/10) + n % 10
        // int smallAns = sumOfDigits(n / 10);

        // // big problem - self work
        // int ans = smallAns + n % 10; // sumOfDigits(n/10) + n % 10

        // return ans;

        return sumOfDigits(n / 10) + n % 10; // one liner
    }

    static int countDigits(int n) {
        // base case - halting condition
        if (n >= 0 && n <= 9) return 1;

        // // smaller subproblem - recursive call
        // // recursion relation -> countDigits(n) = countDigits(n/10) + 1
        // int smallAns = countDigits(n / 10);

        // // big problem - self work
        // int ans = smallAns + 1; // countDigits(n/10) + 1

        // return ans;

        return countDigits(n / 10) + 1; // one liner
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
       
        System.out.println("Sum of digits : " + sumOfDigits(n));
        System.out.println("Count of digits : " + countDigits(n));

        // Time Complexity = No of recursive calls * Time taken in each recursive call
        // No of recursive calls = No of digits in the number = d
        // Time taken in each recursive call = constant
        // T(n) = d * c = O(d) - Linear Time Complexity

        // Space Complexity = No of stack frames * Space taken by each stack frame
        // No of stack frames = No of recursive calls = d
        // Space taken by each stack frame = constant
        // S(n) = d * c = O(d) - Linear Space Complexity
      
        sc.close();
    }

}
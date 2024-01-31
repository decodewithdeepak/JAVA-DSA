// Notes : https://drive.google.com/file/d/1UsZcVB5pGFzzdoovm8YlHHAHsTtnTckn/view

// Problems on Recursion

import java.util.Scanner;

public class ProblemsOnRecursion {

    // 1. Given a number num and a value k, print first k multiples of num
    // Example for num = 5, k = 3 -> 5 10 15

    static void printMultiples(int num, int k) { // O(k)
        // base case - halting condition
        // if (k == 1) {
        // System.out.print(num + " ");
        // return;
        // }

        if (k == 0)
            return;

        // smaller subproblem - recursive call
        // recursion relation -> printMultiples(num, k) = printMultiples(num, k - 1) + num
        printMultiples(num, k - 1);

        // self work
        System.out.print(num * k + " ");
    }

    // 2. Given a number n, find the sum of natural numbers till n
    // Example for n = 5 -> 1 + 2 + 3 + 4 + 5 = 15

    static int seriesSum(int n) { // O(n)
        // base case
        if (n == 1)
            return 1;

        // recursion relation -> seriesSum(n) = seriesSum(n - 1) + n

        return seriesSum(n - 1) + n;
    }

    // 3. Given a number n, find the sum of natural numbers till n but with alternate signs
    // Example for n = 5 -> 1 - 2 + 3 - 4 + 5 = 3

    static int seriesSumAlternate(int n) { // O(n)
        // base case
        if (n == 1)
            return 1;

        // recursion relation -> even n (positive) -> seriesSumAlternate(n) = seriesSumAlternate(n - 1) - n
        // odd n (negative) -> seriesSumAlternate(n) = seriesSumAlternate(n - 1) + n

        if (n % 2 == 0)
            return seriesSumAlternate(n - 1) - n; // even
        else
            return seriesSumAlternate(n - 1) + n; // odd
    }

    // 4. Multiply two numbers using recursion
    // Example for a = 5, b = 3 -> 5 * 3 = 15

    static int multiply(int a, int b) { // O(min(a, b))
        // base case
        if (b == 1)
            return a;

        // recursion relation -> multiply(a, b) = multiply(a, b - 1) + a

        return multiply(a, b - 1) + a;
    }

    // 5. Check Armstrong Number using recursion
    // Example for n = 153 -> 1^3 + 5^3 + 3^3 = 153 -> True
    
    static int power(int n, int r) {
        if (r == 0) return 1;
        return n * power(n, r - 1);
    }

    static int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    static boolean isArmstrong(int n) {
        int temp = n, sum = 0;
        int digits = countDigits(n);
        while (temp != 0) {
            int lastDigit = temp % 10;
            sum += power(lastDigit, digits);
            temp = temp / 10;
        }
        return sum == n;
    }

    // 6. Check if a number is palindrome or not using recursion
    // Example for n = 12321 -> True

    static int reverse(int n) { // O(n)
        if (n < 10) return n; // base case

        // recursion relation -> reverse(n) = reverse(n / 10) + (n % 10) * 10 ^ (no. of digits - 1)

        int smallAns = reverse(n / 10); // smaller subproblem
        int lastDigit = n % 10; // self work
        int noOfDigits = (int) Math.log10(n); // self work
        return smallAns + lastDigit * (int) Math.pow(10, noOfDigits); // return statement
    }

    static boolean isPalindrome(int n) { // recursive function
        if (n < 10) return true; // base case
        int rev = reverse(n); // self work
        return n == rev; // return statement
    }
    
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // int k = sc.nextInt();
        // printMultiples(num, k);

        // int n = sc.nextInt();
        // System.out.println(seriesSum(n));
        // System.out.println(seriesSumAlternate(n));

        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println(multiply(a, b));

        // int n = sc.nextInt();
        // System.out.println(isArmstrong(n));

        int n = sc.nextInt();
        System.out.println(isPalindrome(n));

        sc.close();

    }

}

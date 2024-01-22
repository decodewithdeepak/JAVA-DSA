// Notes : https://drive.google.com/file/d/1JF-UzGW8VxP4kQ15LJs6RyfpVlt621iP/view
// https://learn.pwskills.com/lesson/GCD-and-Euclid's-Algorithm-using-Recursion/63b65e54334640a68e714a04/course/Cracking-the-Coding-Interview-in-Java---Foundation/63a0ad31ff94e14fb832b423#
// Find GCD of two numbers using recursion

import java.util.Scanner;

public class GCD {

    // Brute Force Approach
    static int gcdB(int a, int b) { // O(min(a, b))
        int res = Math.min(a, b);
        while (res > 0) {
            if (a%res == 0 && b%res == 0) {
                break;
            }
            res--;
        }
        return res;
    }

    // Long Division Method
    static int gcdL(int a, int b) { // O(min(a, b))
        while (a%b != 0) {
            int rem = a%b;
            a = b;
            b = rem;
        }
        return b;
    }

    // Euclid's Algorithm - Recursive Approach
    // GCD(a, b) = GCD(b, a%b) - recurrence relation
    // GCD(a, 0) = a - base condition
    static int gcd(int a, int b) { // O(log(min(a, b)))
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    // LCM * GCD = a * b
    static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        int a = sc.nextInt();
        int b  = sc.nextInt();

        System.out.println("GCD : " + gcd(a, b));
        System.out.println("LCM : " + lcm(a, b));


        sc.close();
    }

}

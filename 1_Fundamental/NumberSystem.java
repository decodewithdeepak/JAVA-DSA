// Decimal Number System: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
// Binary Number System: 0, 1
// Octal Number System: 0, 1, 2, 3, 4, 5, 6, 7
// Hexadecimal Number System: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A(10), B(11), C(12), D(13), E(14), F(15)

// Binary to Decimal: 
// 1011 (Binary) => 1*2^0 + 1*2^1 + 0*2^2 + 1*2^3 = 1 + 2 + 0 + 8 = 11 (Decimal)

// Decimal to Binary:
// 11 (Decimal) => 1011 (Binary)

import java.util.Scanner;

public class NumberSystem {
    
    public static int binaryToDecimal(int binary) { // O(log2 n)
        int decimal = 0;
        int pow = 0; // power of 2

        while (binary > 0) {
            int digit = binary % 10; // last digit
            decimal += digit * Math.pow(2, pow);
            binary /= 10; // remove last digit
            pow++;
        }

        return decimal;
    }

    public static int decimalToBinary(int decimal) { // O(log2 n)
        int binary = 0;
        int pow = 0; // power of 10

        while (decimal > 0) {
            int rem = decimal % 2; // remainder (parity)
            binary += rem * Math.pow(10, pow);
            decimal /= 2; // quotient
            pow++;
        }

        return binary;
    }

    
    // Question: Nth natural number in base 9 - GFG (https://www.geeksforgeeks.org/problems/nth-natural-number/1)
    // Base 9 number system: 0, 1, 2, 3, 4, 5, 6, 7, 8
    public static long findNth(long n) { // O(log9 n)
        // n (base 10) => ans (base 9)
        long ans = 0;
        long pow = 0; // power of 10

        while (n > 0) {
            long rem = n % 9;
            ans += rem * Math.pow(10, pow);
            n /= 9;
            pow++;
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // // Binary to Decimal
        // System.out.print("Enter a binary number: ");
        // int binary = sc.nextInt();
        // int decimal = binaryToDecimal(binary);
        // System.out.println("Decimal: " + decimal);

        // // Decimal to Binary
        // System.out.print("Enter a decimal number: ");
        // decimal = sc.nextInt();
        // int convertedBinary = decimalToBinary(decimal);
        // System.out.println("Binary: " + convertedBinary);


        // Question: Nth natural number in base 9
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        long nthNatural = findNth(n);
        System.out.println("Nth natural number in base 9: " + nthNatural);

        sc.close();

    }

}

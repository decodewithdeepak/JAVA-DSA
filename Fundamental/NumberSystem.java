// Number Sytem Conversion

import java.util.Scanner;

public class NumberSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Binary to Decimal
        System.out.print("Enter a binary number: ");
        int binary = sc.nextInt();
        int decimal = 0;
        int pow = 1; // 2^0 = 1 power of 2
        while (binary != 0) {
            int digit = binary % 10;
            decimal = decimal + digit * pow;
            binary = binary / 10;
            pow = pow * 2;
        }
        System.out.println("Decimal: " + decimal);

        // Decimal to Binary
        System.out.print("Enter a decimal number: ");
        decimal = sc.nextInt();
        binary = 0;
        pow = 1; // 10^0 = 1 power of 10
        while (decimal != 0) {
            int parity = decimal % 2;
            binary = binary + parity * pow;
            decimal = decimal / 2;
            pow = pow * 10;
        }
        System.out.println("Binary: " + binary);

    }
}

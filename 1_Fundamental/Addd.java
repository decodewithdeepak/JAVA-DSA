// Add two numbers without using arithmetic operators
// Algorithm:
// 1. Take two numbers a and b as input
// 2. Repeat until b becomes 0
//     a. carry = a AND b (common set bits of a and b)
//     b. a = a XOR b (sum of a and b without considering carry)
//     c. b = carry shifted left by 1 (carry is shifted by one so that adding it to a gives the required sum)
// 3. Return a
public class Addd {
    public static void main(String[] args) {
        int a = 5, b = 7;
        System.out.println("Sum of " + a + " and " + b + " is " + add(a, b));
    }

    static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

// Bit Manipulation - Technique to manipulate bits of a number using bitwise operators.

class a_BasicsOfBitMan {
    public static void main(String[] args) {
        // 1. Bitwise AND (Both bits should be 1 to get 1)
        // 0 & 0 = 0
        // 0 & 1 = 0
        // 1 & 0 = 0
        // 1 & 1 = 1
        System.out.println("Bitwise AND: " + (5 & 7)); // 5

        // 2. Bitwise OR (Any one bit should be 1 to get 1)
        // 0 | 0 = 0
        // 0 | 1 = 1
        // 1 | 0 = 1
        // 1 | 1 = 1
        System.out.println("Bitwise OR: " + (5 | 7)); // 7

        // 3. Bitwise XOR (Both bits should be different to get 1)
        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 0 = 1
        // 1 ^ 1 = 0
        System.out.println("Bitwise XOR: " + (5 ^ 7)); // 2

        // 4. Bitwise NOT (Inverts the bits)
        // ~0 = 1
        // ~1 = 0
        System.out.println("Bitwise NOT: " + (~5)); // -6

        // 5. Left Shift (Shifts the bits to the left)
        // 5 << 1 = 10
        // 5 << 2 = 20
        System.out.println("Left Shift: " + (5 << 1)); // 10

        // 6. Right Shift (Shifts the bits to the right)
        // 5 >> 1 = 2
        // 5 >> 2 = 1
        System.out.println("Right Shift: " + (5 >> 1)); // 2

        // 7. Unsigned Right Shift (Shifts the bits to the right and fills 0)
        // 5 >>> 1 = 2
        // 5 >>> 2 = 1
        System.out.println("Unsigned Right Shift: " + (5 >>> 1)); // 2
    }
}
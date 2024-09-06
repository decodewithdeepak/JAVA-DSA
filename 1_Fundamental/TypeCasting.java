public class TypeCasting {
    public static void main(String[] args) {
        
        // Implicit type casting - Widening conversion/ Automatic type conversion / Lossless conversion
        // Smaller data type to larger data type - No data loss - Automatically done by JVM
        // byte -> short -> int -> long -> float -> double

        int i = 100;
        long l = i; // int to long
        System.out.println(l); // 100

        float f = l; // long to float
        System.out.println(f); // 100.0


        // Explicit type casting - Narrowing conversion / Manual type conversion / Lossy conversion
        // Larger data type to smaller data type - Data loss - Manually done by the programmer
        // double -> float -> long -> int -> short -> byte

        double d = 10.2;
        int j = (int) d; // double to int
        System.out.println(j); // 10

        // Type casting in expressions
        int x = 10;
        int y = 3;
        float z = (float) x / y; // int to float
        System.out.println(z); // 3.3333333


        // Overflow and Underflow in Type Casting
        // Overflow: When the value exceeds the range of the target data type
        // Underflow: When the value is smaller than the range of the target data type

        // Overflow Example
        // byte b = 130; // Error - Type mismatch: cannot convert from int to byte
        byte b = (byte) 130; // int to byte
        System.out.println(b); // -128 to 127 -> 130 % 256 = -126
        // why divide by 256? - byte is 8 bits - 2^8 = 256
        // why -126? -> byte is signed -> 2's complement -> 130 - 256 = -126
        
        // Underflow Example
        b = (byte) -130; // int to byte
        System.out.println(b); // -130 % 256 = 126
        // why 126? -> byte is signed -> 2's complement - -130 + 256 = 126
        
        
    }
}

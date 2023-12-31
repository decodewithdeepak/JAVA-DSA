// Notes 4 : https://drive.google.com/file/d/1JriBlCMbjnTjbyDbJ996Z2lkJcmbBJsq/view

// Operators are used to perform operations on operands (variables and values).
// Operators in Java:
// 1. Arithmetic Operators
// 2. Relational Operators
// 3. Logical Operators
// 4. Assignment Operators
// 5. Bitwise Operators
// 6. Unary Operators
// 7. Ternary Operator

public class Operators {
    public static void main(String[] args) {

        int a = 20, b = 7;

        System.out.println("Arithmetic Operators");
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));


        System.out.println("\nRelational Operators");
        a = 10;
        b = 15;
        System.out.println("Equal to: " + (a == b));
        System.out.println("Not equal to: " + (a != b));
        System.out.println("Greater than: " + (a > b));
        System.out.println("Less than: " + (a < b));
        System.out.println("Greater than or equal to: " + (a >= b));
        System.out.println("Less than or equal to: " + (a <= b));


        System.out.println("\nLogical Operators");
        int p = 15, q = 10, r = 5;
        System.out.println("Logical AND: " + ((p > q) && (p > r)));
        System.out.println("Logical OR: " + ((p > q) || (p < r)));
        System.out.println("Logical NOT: " + (!(p > q)));


        System.out.println("\nAssignment Operators");
        a = 10;
        b = 15;
        System.out.println("Simple Assignment: " + (a = b));
        System.out.println("Add and Assign: " + (a += b));
        System.out.println("Subtract and Assign: " + (a -= b));
        System.out.println("Multiply and Assign: " + (a *= b));
        System.out.println("Divide and Assign: " + (a /= b));
        System.out.println("Modulus and Assign: " + (a %= b));

        System.out.println("\nBitwise Operators");
        a = 9;
        b = 10;
        System.out.println("Bitwise AND: " + (a & b)); // 9 = 1001, 10 = 1010, 9 & 10 = 1000 = 8
        System.out.println("Bitwise OR: " + (a | b)); // 9 = 1001, 10 = 1010, 9 | 10 = 1011 = 11
        System.out.println("Bitwise XOR: " + (a ^ b)); // 9 = 1001, 10 = 1010, 9 ^ 10 = 0011 = 3
        System.out.println("Bitwise NOT: " + (~a)); // 9 = 1001, ~9 = 0110 = 6

        System.out.println("Left Shift: " + (a << 2)); // 9 = 1001, 9 << 2 = 100100 = 36
        System.out.println("Right Shift: " + (a >> 2)); // 9 = 1001, 9 >> 2 = 10 = 2


        System.out.println("\nUnary Operators");
        a = 10;
        System.out.println("Unary Plus: " + (+a));
        System.out.println("Unary Minus: " + (-a));

        System.out.println("Pre-increment: " + (++a)); // prints 11, a = 11
        System.out.println("Pre-decrement: " + (--a)); // prints 10, a = 10

        System.out.println("Post-increment: " + (a++)); // prints 10, a = 11
        System.out.println("Post-decrement: " + (a--)); // prints 11, a = 10

        System.out.println("\nTernary Operator");
        a = 20;
        b = 15;
        System.out.println("Ternary Operator: " + ((a > b) ? a : b));


        // Java Operators Precedence and Associativity
        // Precedence: Priority of operators
        // Associativity: Order of evaluation of operators
        // Notes: https://drive.google.com/file/d/1JriBlCMbjnTjbyDbJ996Z2lkJcmbBJsq/view

    }
}

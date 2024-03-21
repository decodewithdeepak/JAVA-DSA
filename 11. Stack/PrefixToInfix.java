// Prefix to Infix Conversion Using Stacks

// Example: Prefix: -9/*+5346 -> Infix: 9-(5+3)*4/6
// Example: Prefix: /*A+BCD -> Infix: A*(B+C)/D

import java.util.Stack;

public class PrefixToInfix {

    // Method to convert prefix expression to infix expression
    public static String prefixToInfix(String prefix) {
        // Create stack for operands
        Stack<String> stack = new Stack<>();

        // Iterate through each character of the prefix expression
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57, 'a'->97, 'z'->122, 'A'->65, 'Z'->90

            // If character is a digit, push it onto the stack
            if (ascii >= 48 && ascii <= 57 || ascii >= 97 && ascii <= 122 || ascii >= 65 && ascii <= 90) {
                stack.push(c + ""); // "" to convert char to string
            }
            // If character is an operator, pop two operands from the stack and push the result onto the stack
            else {
                String val1 = stack.pop();
                String val2 = stack.pop();
                stack.push("(" + val1 + c + val2 + ")");
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        System.out.println("Prefix: " + prefix);
        System.out.println("Infix: " + prefixToInfix(prefix)); // 9-(5+3)*4/6

        prefix = "/*A+BCD";
        System.out.println("\nPrefix: " + prefix);
        System.out.println("Infix: " + prefixToInfix(prefix)); // A*(B+C)/D
    }
}

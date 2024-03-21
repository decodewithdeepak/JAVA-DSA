// Prefix to Postfix Conversion Using Stacks

// Example: Prefix: -9/*+5346 -> Postfix: 953+4*6/-
// Example: Prefix: /*A+BCD -> Postfix: ABC+*D/

import java.util.Stack;

public class PrefixToPostfix {

    // Method to convert prefix expression to postfix expression
    public static String prefixToPostfix(String prefix) {
        // Create a stack for postfix expression
        Stack<String> val = new Stack<>(); // Postfix Value - Operand

        // Iterate through each character of the prefix expression in reverse
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57, 'a'->97, 'z'->122, 'A'->65, 'Z'->90

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the postfix stack
            if (ascii >= 48 && ascii <= 57 || ascii >= 97 && ascii <= 122 || ascii >= 65 && ascii <= 90) {
                val.push(c + ""); // "" to convert char to string
            }
            // If current character is an operator, perform operations
            else {
                String val1 = val.pop();
                String val2 = val.pop();
                val.push(val1 + val2 + c);
            }
        }

        // Return the result
        return val.pop();
    }

    public static void main(String[] args) {

        String prefix = "-9/*+5346";
        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + prefixToPostfix(prefix)); // 953+4*6/-

        prefix = "/*A+BCD";
        System.out.println("\nPrefix: " + prefix);
        System.out.println("Postfix: " + prefixToPostfix(prefix)); // ABC+*D/
    }
}

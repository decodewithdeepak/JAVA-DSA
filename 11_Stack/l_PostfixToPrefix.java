// Postfix to Prefix Conversion using Stack

// Example: Postfix: 953+4*6/- -> Prefix: -9/*+5346
// Example: Postfix: ABC+*D/ -> Prefix: /*A+BCD

import java.util.Stack;

public class l_PostfixToPrefix {

    // Method to convert postfix expression to prefix expression
    public static String postfixToPrefix(String postfix) {
        // Create a stack for prefix expression
        Stack<String> val = new Stack<>(); // Prefix Value - Operand

        // Iterate through each character of the postfix expression
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57, 'a'->97, 'z'->122, 'A'->65, 'Z'->90

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the prefix stack
            if (ascii >= 48 && ascii <= 57 || ascii >= 97 && ascii <= 122 || ascii >= 65 && ascii <= 90) {
                val.push(c + ""); // "" to convert char to string
            }
            // If current character is an operator, perform operations
            else {
                String val1 = val.pop();
                String val2 = val.pop();
                val.push(c + val2 + val1);
            }
        }

        // Return the result
        return val.pop();
    }
    
    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + postfixToPrefix(postfix)); // -9/*+5346

        postfix = "ABC+*D/";
        System.out.println("\nPostfix: " + postfix);
        System.out.println("Prefix: " + postfixToPrefix(postfix)); // /*A+BCD
    }

}

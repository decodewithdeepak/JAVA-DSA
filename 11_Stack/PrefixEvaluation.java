// Prefix Expression Evaluation Using Stacks

// Example: Prefix: -9/*+5346 -> Prefix Evaluation: 4

import java.util.Stack;

public class PrefixEvaluation {
   
    // Method to evaluate prefix expression
    public static int prefixEvaluation(String prefix) {
        // Create a stack for operands
        Stack<Integer> val = new Stack<>(); // Value - Operand

        // Iterate through each character of the prefix expression 
        // from right to left (reverse)
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the operand stack
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            }
            // If current character is an operator, perform operations
            else {
                int val1 = val.pop();
                int val2 = val.pop();
                if (c == '+') val.push(val1 + val2);
                if (c == '-') val.push(val1 - val2);
                if (c == '*') val.push(val1 * val2);
                if (c == '/') val.push(val1 / val2);
            }
        }

        // Return the result
        return val.pop();
    }

    public static void main(String[] args) {
        // Prefix Expression Evaluation Using Stacks
        String prefix = "-9/*+5346";
        System.out.println("Prefix: " + prefix);
        System.out.println("Result: " + prefixEvaluation(prefix)); // Output: 4
    }

}

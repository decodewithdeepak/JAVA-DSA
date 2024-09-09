// Stacks - Infix, Prefix & Postfix Expressions

// Infix: operator is between operands -> A + B -> Most common in human expressions -> Uses brackets
// Prefix: operator is before operands -> + A B -> Polish Notation -> No brackets required
// Postfix: operator is after operands -> A B + -> Reverse Polish Notation -> No brackets required

// Example: Infix: 9-(5+3)*4/6 -> Prefix: -9/*+5346 -> Postfix: 953+4*6/-
// Example: Infix: A*(B+C)/D -> Prefix: /*A+BCD -> Postfix: ABC+*D/

// Infix Expression Evaluation Using Stacks

// Example: Infix: 9-(5+3)*4/6 -> Infix Evaluation: 4

import java.util.Stack;

public class e_InfixEvaluation {

    // Method to return precedence of operator
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }

    // Method to perform operation
    public static int operation(int val2, int val1, char operator) {
        if (operator == '+') return val1 + val2;
        if (operator == '-') return val1 - val2;
        if (operator == '*') return val1 * val2;
        if (operator == '/') return val1 / val2;
        return 0;
    }

    // Method to evaluate infix expression
    public static int infixEvaluation(String infix) {
        // Create stacks for operands and operators
        Stack<Integer> val = new Stack<>(); // Value - Operand
        Stack<Character> op = new Stack<>(); // Operator

        // Iterate through each character of the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the operand stack
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            }
            // If operator stack is empty or current character is '(', push it onto the operator stack
            else if (op.isEmpty() || c == '(' || op.peek() == '(') {
                op.push(c);
            }
            // If current character is ')', perform operations until '(' is encountered
            else if (c == ')') {
                while (op.peek() != '(') {
                    int val2 = val.pop();
                    int val1 = val.pop();
                    char operator = op.pop();
                    val.push(operation(val2, val1, operator));
                }
                op.pop(); // Remove '('
            }
            // If current character is an operator, perform operations based on precedence
            else {
                while (!op.isEmpty() && precedence(c) <= precedence(op.peek())) {
                    int val2 = val.pop();
                    int val1 = val.pop();
                    char operator = op.pop();
                    val.push(operation(val2, val1, operator));
                }
                op.push(c);
            }
        }

        // Perform remaining operations
        while (!op.isEmpty()) {
            int val2 = val.pop();
            int val1 = val.pop();
            char operator = op.pop();
            val.push(operation(val2, val1, operator));
        }

        // Result is the top element of operand stack
        return val.pop();
    }


    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        System.out.println("Infix: " + infix);
        System.out.println("Infix Evaluation: " + infixEvaluation(infix)); // 4
    }
}

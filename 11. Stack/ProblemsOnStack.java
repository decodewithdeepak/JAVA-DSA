// 1. Move contents of one stack to another stack in same order
// 2. Insert an element at the bottom of the stack
// 3. Insert an element at any index in the stack
// 4. Display the stack without the inbuilt method
// 5. Remove from bottom of the stack
// 6. Remove from any index of the stack
// 7. Reverse the stack

import java.util.Stack;

public class ProblemsOnStack {

    // 1. Move contents of one stack to another stack in same order
    public static void moveContents(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>(); // Auxiliary stack - temporary stack
        while (s1.size() > 0) {
            temp.push(s1.pop());
        }
        while (temp.size() > 0) {
            s2.push(temp.pop());
        }
    }

    // 2. Insert an element at the bottom of the stack
    // Itertative approach
    public static void pushAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<>();
        while (st.size() > 0) {
            temp.push(st.pop());
        }
        st.push(x);
        while (temp.size() > 0) {
            st.push(temp.pop());
        }
    }

    // Recursive approach
    public static void pushAtBottomRec(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int top = st.pop();
        pushAtBottomRec(st, x);
        st.push(top);
    }

    // 3. Insert an element at any index in the stack
    public static void pushAtIndex(Stack<Integer> st, int x, int idx) {
        Stack<Integer> temp = new Stack<>();
        while (st.size() > idx) {
            temp.push(st.pop());
        }
        st.push(x);
        while (temp.size() > 0) {
            st.push(temp.pop());
        }
    }

    // 4. Display the stack without the inbuilt method
    // Iterative approach
    public static void display(Stack<Integer> st) {
        Stack <Integer> temp = new Stack<>();
        while (st.size() > 0) {
            temp.push(st.pop());
        }
        while (temp.size() > 0) {
            System.out.print(temp.peek() + " ");
            st.push(temp.pop());
        }
        System.out.println();
    }

    // Recursive approach
    public static void displayRec(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int top = st.pop();
        // System.out.print(top + " "); // For reverse order
        displayRec(st);
        System.out.print(top + " "); // For original order
        st.push(top);
    }

    // 5. Remove from bottom of the stack
    // Iterative approach
    public static void popFromBottom(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while (st.size() > 1) {
            temp.push(st.pop());
        }
        st.pop();
        while (temp.size() > 0) {
            st.push(temp.pop());
        }
    }

    // Recursive approach
    public static void popFromBottomRec(Stack<Integer> st) {
        if (st.size() == 1) {
            st.pop();
            return;
        }
        int top = st.pop();
        popFromBottomRec(st);
        st.push(top);
    }

    // 6. Remove from any index of the stack
    public static void popFromIndex(Stack<Integer> st, int idx) {
        Stack<Integer> temp = new Stack<>();
        while (st.size() > idx + 1) {
            temp.push(st.pop());
        }
        st.pop();
        while (temp.size() > 0) {
            st.push(temp.pop());
        }
    }

    // 7. Reverse the stack 
    // Iterative approach - Using two extra stacks
    public static void reverse(Stack<Integer> st) {
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        // Move the contents of the original stack to temp1
        while (st.size() > 0) {
            temp1.push(st.pop());
        }
        // Move the contents of temp1 to temp2
        while (temp1.size() > 0) {
            temp2.push(temp1.pop());
        }
        // Move the contents of temp2 to the original stack
        while (temp2.size() > 0) {
            st.push(temp2.pop());
        }
    }

    // Recursive approach
    public static void reverseRec(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int top = st.pop();
        reverseRec(st);
        pushAtBottomRec(st, top);
    }


    // Main method
    public static void main(String[] args) {
        
        // 1. Move contents of one stack to another stack in same order
        Stack<Integer> s1 = new Stack<>(); // Original Stack
        Stack<Integer> s2 = new Stack<>(); // New Stack

        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        System.out.println("Original Stack: " + s1);

        moveContents(s1, s2);
        System.out.println("New Stack: " + s2);

        System.out.println("Original Stack after moving: " + s1);

        // 2. Insert an element at the bottom of the stack
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println("\nOriginal Stack: " + st); // [10, 20, 30, 40, 50]

        pushAtBottom(st, 5);
        System.out.println(st); // [5, 10, 20, 30, 40, 50]

        pushAtBottomRec(st, 2);
        System.out.println(st); // [2, 5, 10, 20, 30, 40, 50]

        pushAtIndex(st, 15, 3);
        System.out.println(st); // [2, 5, 10, 15, 20, 30, 40, 50]

        // 4. Display the stack without the inbuilt method
        // display(st); // 2 5 10 15 20 30 40 50
        // displayRec(st);

        // 5. Remove from bottom of the stack
        popFromBottom(st);
        System.out.println(st); // [5, 10, 15, 20, 30, 40, 50]

        popFromBottomRec(st);
        System.out.println(st); // [10, 15, 20, 30, 40, 50]

        // 6. Remove from any index of the stack
        popFromIndex(st, 1);
        System.out.println(st); // [10, 20, 30, 40, 50]

        // 7. Reverse the stack
        reverse(st);
        System.out.println(st); // [50, 40, 30, 20, 10]

        reverseRec(st);
        System.out.println(st); // [10, 20, 30, 40, 50]

    }
}

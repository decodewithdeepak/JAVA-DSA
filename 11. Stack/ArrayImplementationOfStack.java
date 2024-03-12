// Implement a Stack using an Array

public class ArrayImplementationOfStack {

    // Create a class for the stack
    public static class Stack {
        private int maxSize; // Maximum size of the stack
        private int[] arr; // Array to store the elements of the stack
        private int top; // Index of the top element of the stack

        // Constructor for the stack
        public Stack(int size) {
            maxSize = size;
            arr = new int[maxSize];
            top = -1;
        }

        // Push elements into the stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("The stack is full");
            } else {
                top++;
                arr[top] = value;
            }
        }

        // Pop elements from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("The stack is empty");
                return -1;
            }

            int result = arr[top];
            top--;
            return result;
        }

        // Peek the top of the stack
        public int peek() {
            if (isEmpty()) {
                System.out.println("The stack is empty");
                return -1;
            }

            return arr[top];
        }

        // Check if the stack is full
        public boolean isFull() {
            return (maxSize - 1 == top);
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return (top == -1);
        }

        // Get the size of the stack
        public int getSize() {
            return top + 1;
        }

        // Print the stack
        public void printStack() {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack(5);

        // Push elements into the stack
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        // Print the stack
        st.printStack(); // 10 20 30 40 50

        // Pop elements from the stack
        st.pop();
        st.pop();

        st.printStack(); // 10 20 30

        // Peek the top of the stack
        System.out.println(st.peek()); // 30

        // Get the size of the stack
        System.out.println(st.getSize()); // 3

        // Check if the stack is full
        System.out.println(st.isFull());

        // Check if the stack is empty
        System.out.println(st.isEmpty());


    }
}

// Traversal of a binary tree - DFS and BFS
// Depth First Traversal (DFS) - Preorder, Inorder, Postorder
// Breadth First Traversal (BFS) - Level order traversal

// Preorder traversal - Root Left Right
// Inorder traversal - Left Root Right
// Postorder traversal - Left Right Root
// Level order traversal - Level by level from left to right

// Example:
//         1
//       /   \
//      2     3 
//     / \     \
//    4   5     6
//       /     / \
//      7     8   9

// Preorder traversal: 1 2 4 5 7 3 6 8 9
// Inorder traversal: 4 2 7 5 1 3 8 6 9
// Postorder traversal: 4 7 5 2 8 9 6 3 1
// Level order traversal: 1 2 3 4 5 6 7 8 9

import java.util.*;

public class BinaryTreeTraversal {

    // Node class of a binary tree
    public static class Node {
        int data; // Value
        Node left, right; // Address of left and right child

        Node (int data) { // Constructor
            this.data = data;
            left = right = null;
        }
    }

    // DFS using Recursion

    // Preorder traversal - Root Left Right
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " "); // Root
        preorder(root.left); // Left subtree
        preorder(root.right); // Right subtree
    }

    // Inorder traversal - Left Root Right
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left); // Left subtree
        System.out.print(root.data + " "); // Root
        inorder(root.right); // Right subtree
    }

    // Postorder traversal - Left Right Root
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left); // Left subtree
        postorder(root.right); // Right subtree
        System.out.print(root.data + " "); // Root
    }

    // BFS using Queue - Iterative

    // Level order traversal - Breadth First Traversal (BFS)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    // DFS using Stack - Iterative
    // Preorder traversal - Root Left Right
    public static void preorderIterative(Node root) {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
        }
    }

    // Inorder traversal - Left Root Right
    public static void inorderIterative(Node root) {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Postorder traversal - Left Right Root
    public static void postorderIterative(Node root) {
        if (root == null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Node temp = st1.pop();
            st2.push(temp);

            if (temp.left != null) st1.push(temp.left);
            if (temp.right != null) st1.push(temp.right);
        }

        while (!st2.isEmpty()) {
            Node temp = st2.pop();
            System.out.print(temp.data + " ");
        }
    }

    // Level order - Recursive
    public static void levelOrderRecursive(Node root) {
        int h = height(root);

        for (int i = 0; i <= h; i++) {
            printNthLevel(root, i);
        }
    }

    public static int height(Node root) {
        if (root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static void printNthLevel(Node root, int level) {
        if (root == null || level < 0 ) return;

        if (level == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printNthLevel(root.left, level - 1);
        printNthLevel(root.right, level - 1);
    }

    public static void main(String[] args) {

        Node root = new Node(1); // root node
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        //       /     / \
        //      7     8   9

        System.out.println("Preorder traversal:");
        preorder(root);

        System.out.println("\nInorder traversal:");
        inorder(root);

        System.out.println("\nPostorder traversal:");
        postorder(root);

        System.out.println("\nLevel order traversal:");
        levelOrder(root);

        System.out.println("\nPreorder traversal (Iterative):");
        preorderIterative(root);
        
        System.out.println("\nInorder traversal (Iterative):");
        inorderIterative(root);

        System.out.println("\nPostorder traversal (Iterative):");   
        postorderIterative(root);

        System.out.println("\nLevel order traversal (Recursive):");
        levelOrderRecursive(root);

    }
}

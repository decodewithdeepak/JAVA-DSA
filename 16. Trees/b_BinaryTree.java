// Notes : https://drive.google.com/file/d/14jWtFutt2WGUkHxC5_5vCUVGiutZ5fMn/view

// Binary Tree - A tree in which a node can have at most two children left and right.

// Types of Binary Trees:
// 1. Full Binary Tree - A binary tree in which every node has 0 or 2 children.
// 2. Complete Binary Tree - A binary tree in which all levels are completely filled except possibly the last level and the last level has all keys as left as possible.
// 3. Perfect Binary Tree - A binary tree in which all internal nodes have two children and all leaves are at the same level.
// 4. Balanced Binary Tree - A binary tree in which the depth of the left and right subtree of every node differ by at most 1.
// 5. Degenerate (or pathological) Tree - A tree in which every internal node has one child.
// 6. Skewed Binary Tree - A binary tree in which all nodes have only one child and the height of the tree is n-1.

// Traversal of a binary tree - DFS and BFS
// Depth First Traversal (DFS) - Preorder, Inorder, Postorder
// Breadth First Traversal (BFS) - Level order traversal

public class b_BinaryTree {
    
    // Node class of a binary tree
    public static class Node {
        int data; // Value
        Node left, right; // Address of left and right child

        Node (int data) { // Constructor
            this.data = data;
            left = right = null;
        }
    }

    // Display the binary tree
    public static void display(Node root) {
        if (root == null) return;

        String str = "";
        str += root.left == null ? "·" : root.left.data;
        str += " <- " + root.data + " -> ";
        str += root.right == null ? "·" : root.right.data;
        System.out.println(str);

        display(root.left); // Left subtree
        display(root.right); // Right subtree
    }

    // Size of the binary tree
    public static int size(Node root) {
        if (root == null) return 0;

        int left = size(root.left); // Left subtree
        int right = size(root.right); // Right subtree

        return left + right + 1; // Total size
    }

    // Find height of the binary tree
    // Assuming root is at level 0 and height of a tree with only root node is 0.
    public static int height(Node root) {
        if (root == null) return -1; // height of a empty tree is -1

        int left = height(root.left); // Left subtree
        int right = height(root.right); // Right subtree

        return Math.max(left, right) + 1; // Total height
    }

    // Find sum of the tree nodes
    public static int sum(Node root) {
        if (root == null) return 0;

        int left = sum(root.left); // Left subtree
        int right = sum(root.right); // Right subtree

        return left + right + root.data; // Total sum
    }

    // Find product of the tree nodes
    public static int product(Node root) {
        if (root == null) return 1;

        int left = product(root.left); // Left subtree
        int right = product(root.right); // Right subtree

        return left * right * root.data; // Total product
    }

    // Find node with maximum value
    public static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int left = max(root.left); // Left subtree
        int right = max(root.right); // Right subtree

        return Math.max(root.data, Math.max(left, right)); // Maximum value
    }

    // Find node with minimum value
    public static int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = min(root.left); // Left subtree
        int right = min(root.right); // Right subtree

        return Math.min(root.data, Math.min(left, right)); // Minimum value
    }

    // Print elements on nth level (assuming root is at level 0)
    public static void printNthLevel(Node root, int level) {
        if (root == null || level < 0) return;

        if (level == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printNthLevel(root.left, level - 1); // Left subtree
        printNthLevel(root.right, level - 1); // Right subtree
    }

    // Level order traversal (without using queue) - Recursive
    public static void levelOrder(Node root) {
        if (root == null) return;

        int h = height(root); // Height of the tree
        for (int i = 0; i <= h; i++) {
            printNthLevel(root, i); // Print elements on ith level
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // Node class object
        Node root = new Node(1); // root node
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        
        //         1 --> root (level 0)
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        //       /     / \
        //      7     8   9 --> Height of the tree = 3

        // Display the binary tree
        display(root);

        // Size of the binary tree
        System.out.println(size(root)); // 9

        // Height of the binary tree
        System.out.println(height(root)); // 3

        // Sum of the tree nodes
        System.out.println(sum(root)); // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45

        // Product of the tree nodes
        System.out.println(product(root)); // 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 = 362880

        // Maximum value of the tree nodes
        System.out.println(max(root)); // 9

        // Minimum value of the tree nodes
        System.out.println(min(root)); // 1

        // Print elements on nth level
        printNthLevel(root, 2); // 4 5 6
        System.out.println();

        // Level order traversal (without using queue)
        levelOrder(root); // 1
                          // 2 3
                          // 4 5 6
                          // 7 8 9


    }
}

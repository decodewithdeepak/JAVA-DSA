// Notes : https://drive.google.com/file/d/11pKv5Hr8T_W6FsInEJzBVqdpIfHLk3Ol/view
// Notes : https://drive.google.com/file/d/1N3q1TbWHiHFdD_5zce2GvjXvA77IGsGa/view
// Notes : https://drive.google.com/file/d/11mBIK8FYPcusOzt-jqKgdbIbPIqQIMxn/view
// Notes : https://drive.google.com/file/d/1DZM9qTDAA8vSAeZ0fGHPNXAHyHihR55P/view

// Binary Search Tree (BST) - A BST is a binary tree in which 
//   (i) Every node to the left of a node is smaller than the node.
//   (ii) Every node to the right of a node is greater than the node.

// Binary Search Tree (BST) = Binary Tree + Binary Search Property
// ★ Inorder traversal of BST gives elements in strictly increasing order.
// Searching, Insertion and Deletion in BST can be done in O(h) time where h is the height of the tree.
// Worst case - O(n) - Skewed tree | Best case - O(logn) - Balanced tree (n = number of nodes)
// Always - O(h) - Average case (h = height of the tree)

// Properties of BST:
// 1. Inorder traversal of BST gives elements in sorted order (strictly increasing).
// 2. The left subtree of a node contains only nodes with keys less than the node's key.
// 3. The right subtree of a node contains only nodes with keys greater than the node's key.
// 4. Both the left and right subtrees must also be BSTs.
// 5. There must be no duplicate nodes.
// 6. The maximum number of nodes at level 'L' of a BST is 2^L.
// 7. The maximum number of nodes in a BST of height 'h' is 2^(h+1) - 1.
// 8. Left lowermost node is the minimum node in the BST.
// 9. Right lowermost node is the maximum node in the BST.

// Example of BST:
//          5
//        /   \
//       3     7
//      / \   / \
//     2   4 6   8
//    /           \
//   1             9       

// Inorder traversal : 1 2 3 4 5 6 7 8 9 (sorted order)

public class g_BinarySearchTree {
    
    // Node class of a binary tree (BST)
    public static class Node {
        int data;
        Node left, right;

        Node (int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Inorder traversal of Binary Tree (BST)
    public static void inOrderTraversal(Node root) {
        if (root == null) return;

        inOrderTraversal(root.left); //Left
        System.out.print(root.data + " "); // Root
        inOrderTraversal(root.right); // Right
    }

    // Search in BST
    public static boolean search(Node root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;
        else if (root.data < key) return search(root.right, key); // search in right subtree
        else return search(root.left, key); // search in left subtree
    }

    // Insert in BST
    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        if (root.data < key) root.right = insert(root.right, key); // insert in right subtree
        else root.left = insert(root.left, key); // insert in left subtree

        return root;
    }
 

    public static void main(String[] args) {
        Node root = new Node(5); // root node
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.left = new Node(1);

        System.out.println("Inorder traversal:");
        inOrderTraversal(root);

        // Search in BST
        System.out.println(search(root, 3)); // true
        System.out.println(search(root, 9)); // false

        // Insert in BST
        insert(root, 9);
        System.out.println(search(root, 9)); // true
        System.out.println("Inorder traversal after insertion:");
        inOrderTraversal(root);

        
    }

}

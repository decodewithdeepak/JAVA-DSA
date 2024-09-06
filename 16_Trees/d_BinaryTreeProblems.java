// 1. Binary Tree Inorder Traversal - LeetCode #94 (https://leetcode.com/problems/binary-tree-inorder-traversal/)
// 2. Binary Tree Preorder Traversal - LeetCode #144 (https://leetcode.com/problems/binary-tree-preorder-traversal/)
// 3. Binary Tree Postorder Traversal - LeetCode #145 (https://leetcode.com/problems/binary-tree-postorder-traversal/)
// 4. Binary Tree Level Order Traversal - LeetCode #102 (https://leetcode.com/problems/binary-tree-level-order-traversal/)
// 5. Binary Tree Zigzag Level Order Traversal - LeetCode #103 (https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

// 6. Binary Tree Right Side View - LeetCode #199 (https://leetcode.com/problems/binary-tree-right-side-view/)
// 7. Find Largest Value in Each Tree Row - LeetCode #515 (https://leetcode.com/problems/find-largest-value-in-each-tree-row/)
// 8. Find Bottom Left Tree Value - LeetCode #513 (https://leetcode.com/problems/find-bottom-left-tree-value/)
// 9. Find Duplicate Subtrees - LeetCode #652 (https://leetcode.com/problems/find-duplicate-subtrees/)

// 10. Diagonal Traversal of Binary Tree - GFG (https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1)
// 11. Boundary Traversal of Binary Tree - GFG (https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1)

import java.util.*;

public class d_BinaryTreeProblems {

    // Node class of a binary tree
    public static class TreeNode {
        int val; // Value
        TreeNode left, right; // Address of left and right child

        TreeNode (int data) { // Constructor
            this.val = data;
            left = right = null;
        }
    }

    // 1. Binary Tree Inorder Traversal - LeetCode #94
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result); // Left subtree
        result.add(root.val); // Root
        inorder(root.right, result); // Right subtree
    }

    // 2. Binary Tree Preorder Traversal - LeetCode #144
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val); // Root
        preorder(root.left, result); // Left subtree
        preorder(root.right, result); // Right subtree
    }

    // 3. Binary Tree Postorder Traversal - LeetCode #145
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result); // Left subtree
        postorder(root.right, result); // Right subtree
        result.add(root.val); // Root
    }

    // 4. Binary Tree Level Order Traversal - LeetCode #102
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // 5. Binary Tree Zigzag Level Order Traversal - LeetCode #103
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zigzag = false; // to toggle the direction

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (zigzag == true) {
                    level.add(0, node.val); // Add at the beginning
                } else {
                    level.add(node.val); // Add at the end
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(level);
            zigzag = !zigzag;
        }

        return result;
    }

    // 6. Binary Tree Right Side View - LeetCode #199
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return result;
    }

    // 7. Find Largest Value in Each Tree Row - LeetCode #515
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(max);
        }

        return result;
    }

    // 8. Find Bottom Left Tree Value - LeetCode #513   
    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result = -1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result = node.val;

            if (node.right != null) q.add(node.right);
            if (node.left != null) q.add(node.left);
        }

        return result;
    }

    // 9. Find Duplicate Subtrees - LeetCode #652
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return null;
    }

    // 10. Diagonal Traversal of Binary Tree - GFG
    public static List<Integer> diagonalTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            while (node != null) {
                result.add(node.val);
                if (node.left != null) q.add(node.left);
                node = node.right;
            }
        }

        return result;
    }

    // 11. Boundary Traversal of Binary Tree - GFG


    public static void main(String[] args) {
        // Constructing a binary tree

        TreeNode root = new TreeNode(1); // root node
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        
        //         1 --> root
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        //       /     / \
        //      7     8   9

        System.out.println("Inorder Traversal: " + inorderTraversal(root));
        System.out.println("Preorder Traversal: " + preorderTraversal(root));
        System.out.println("Postorder Traversal: " + postorderTraversal(root));
        System.out.println("Level Order Traversal: " + levelOrder(root));
        System.out.println("Zigzag Level Order Traversal: " + zigzagLevelOrder(root));
        System.out.println("Right Side View: " + rightSideView(root));
        System.out.println("Largest Values in Each Tree Row: " + largestValues(root));
        System.out.println("Bottom Left Tree Value: " + findBottomLeftValue(root));
        System.out.println("Diagonal Traversal: " + diagonalTraversal(root));
        

    }


}

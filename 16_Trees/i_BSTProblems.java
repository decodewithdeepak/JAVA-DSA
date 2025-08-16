// 1. Validate Binary Search Tree - Leetcode 98 (https://leetcode.com/problems/validate-binary-search-tree/)

public class i_BSTProblems {
    public boolean isValidBST(TreeNode root) {
        // Inorder traversal of a BST is always sorted
        return inOrderTraversal(root, null, null);
    }
    private boolean inOrderTraversal(TreeNode node, Integer left, Integer right) {
        if (node == null) return true;

        if ((left != null && node.val <= left) || (right != null && node.val >= right)) {
            return false; // Violation of BST property
        }

        // Check left subtree with updated upper bound
        if (!inOrderTraversal(node.left, left, node.val)) return false;
        // Check right subtree with updated lower bound
        if (!inOrderTraversal(node.right, node.val, right)) return false;

        return true; // Valid BST
    }
}

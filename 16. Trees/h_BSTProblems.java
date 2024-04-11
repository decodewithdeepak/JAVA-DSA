// 1. Search in BST - Leetcode 700 (https://leetcode.com/problems/search-in-a-binary-search-tree/)
// 2. Insert in BST - Leetcode 701 (https://leetcode.com/problems/insert-into-a-binary-search-tree/)
// 3. Delete in BST - Leetcode 450 (https://leetcode.com/problems/delete-node-in-a-bst/)
// 4. Validate BST - Leetcode 98 (https://leetcode.com/problems/validate-binary-search-tree/)
// 5. Balanced BST - Leetcode 1099 (https://leetcode.com/problems/balance-a-binary-search-tree/)
// 6. Lowest Common Ancestor in BST - Leetcode 235 (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
// 7. Kth Smallest Element in BST - Leetcode 230 (https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
// 8. Range Sum of BST - Leetcode 938 (https://leetcode.com/problems/range-sum-of-bst/)
// 9. Convert Sorted Array to BST - Leetcode 108 (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
// 10. Convert Sorted List to BST - Leetcode 109 (https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
// 11. Covert BST to Greater Tree - Leetcode 538 (https://leetcode.com/problems/convert-bst-to-greater-tree/)
// 12. Minimum Difference in BST - Leetcode 783 (https://leetcode.com/problems/minimum-distance-between-bst-nodes/)
// 13. All Elements in Two BST - Leetcode 1305 (https://leetcode.com/problems/all-elements-in-two-binary-search-trees/)
// 14. Construct BST from Preorder Traversal - Leetcode 1008 (https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)
// 15. Trim a BST - Leetcode 669 (https://leetcode.com/problems/trim-a-binary-search-tree/)
// 16. Recover BST - Leetcode 99 (https://leetcode.com/problems/recover-binary-search-tree/)


public class h_BSTProblems {

    // Node class of a binary tree (BST)
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode (int data) {
            this.val = data;
            left = right = null;
        }
    }

    // 1. Search in BST - Leetcode 700
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (val == root.val) return root;
        else if (val < root.val) return searchBST(root.left, val); // search in left subtree
        else return searchBST(root.right, val); // search in right subtree
    }

    // 2. Insert in BST - Leetcode 701
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) root.left = insertIntoBST(root.left, val); // insert in left subtree
        else root.right = insertIntoBST(root.right, val); // insert in right subtree

        return root;
    }

    // 3. Delete in BST - Leetcode 450
    public TreeNode deleteNode(TreeNode root, int key) {
        // Three cases - O child, 1 child, 2 child
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key); // search in left subtree
        else if (key > root.val) root.right = deleteNode(root.right, key); // search in right subtree
        else { // key == root.val - found the node to delete

            // 0 child (leaf node)
            if (root.left == null && root.right == null) return null;
            
            // 1 child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            
            // 2 child
            TreeNode min = root.right; // minimum value in right subtree (inorder successor)
            while(min.left!=null) min = min.left;
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }

        return root;
    }
    
    // 4. Validate BST - Leetcode 98
    
}
